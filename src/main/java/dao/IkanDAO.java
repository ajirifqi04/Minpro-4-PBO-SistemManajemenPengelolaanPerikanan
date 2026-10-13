/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author AjiHowhow
 */
public class IkanDAO {

    private String buatIdBerikutnya(Connection conn)
            throws SQLException {
        String sql = "SELECT id_ikan FROM ikan "
                + "ORDER BY CAST(SUBSTRING(id_ikan, 2) AS UNSIGNED) "
                + "DESC LIMIT 1";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int nomor = Integer.parseInt(
                        rs.getString("id_ikan").substring(1));
                return String.format("I%03d", nomor + 1);
            }
        }

        return "I001";
    }

    public boolean idTerdaftar(String id) {
        String sql = "SELECT id_ikan FROM ikan WHERE id_ikan = ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id.trim().toUpperCase());

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.out.println(
                    "Gagal memeriksa ID ikan: " + e.getMessage());
            return false;
        }
    }

    public void tampilkanSemua() {
        String sql = "SELECT i.id_ikan, i.nama_ikan, i.jenis_ikan, "
                + "i.jumlah_stok, l.kedalaman_habitat, "
                + "a.jenis_perairan "
                + "FROM ikan i "
                + "LEFT JOIN ikan_laut l ON i.id_ikan = l.id_ikan "
                + "LEFT JOIN ikan_air_tawar a ON i.id_ikan = a.id_ikan "
                + "ORDER BY CAST(SUBSTRING(i.id_ikan, 2) AS UNSIGNED)";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n=== DATA IKAN ===");
            boolean adaData = false;

            while (rs.next()) {
                adaData = true;

                System.out.println("----------------------------");
                System.out.println("ID Ikan: "
                        + rs.getString("id_ikan"));
                System.out.println("Nama Ikan: "
                        + rs.getString("nama_ikan"));
                System.out.println("Jenis Ikan: "
                        + rs.getString("jenis_ikan"));
                System.out.println("Jumlah Stok: "
                        + rs.getInt("jumlah_stok") + " kg");

                Object kedalaman =
                        rs.getObject("kedalaman_habitat");

                if (kedalaman != null) {
                    System.out.println("Kategori: Ikan Laut");
                    System.out.println("Kedalaman Habitat: "
                            + kedalaman + " meter");
                } else {
                    System.out.println("Kategori: Ikan Air Tawar");
                    System.out.println("Jenis Perairan: "
                            + rs.getString("jenis_perairan"));
                }
            }

            if (!adaData) {
                System.out.println("Belum ada data ikan.");
            }

        } catch (SQLException e) {
            System.out.println(
                    "Gagal menampilkan data ikan: " + e.getMessage());
        }
    }

    public void tambah(String nama, String jenis, int stok,
            int tipe, int kedalaman, String perairan) {

        String sqlIkan = "INSERT INTO ikan "
                + "(id_ikan, nama_ikan, jenis_ikan, jumlah_stok) "
                + "VALUES (?, ?, ?, ?)";

        String sqlLaut = "INSERT INTO ikan_laut "
                + "(id_ikan, nama_ikan, jenis_ikan, jumlah_stok, "
                + "kedalaman_habitat) VALUES (?, ?, ?, ?, ?)";

        String sqlAir = "INSERT INTO ikan_air_tawar "
                + "(id_ikan, nama_ikan, jenis_ikan, jumlah_stok, "
                + "jenis_perairan) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Koneksi.getConnection()) {
            conn.setAutoCommit(false);

            try {
                String id = buatIdBerikutnya(conn);

                try (PreparedStatement ps =
                        conn.prepareStatement(sqlIkan)) {
                    ps.setString(1, id);
                    ps.setString(2, nama.trim());
                    ps.setString(3, jenis);
                    ps.setInt(4, stok);
                    ps.executeUpdate();
                }

                if (tipe == 1) {
                    if (kedalaman <= 0) {
                        throw new SQLException(
                                "Kedalaman habitat harus lebih dari 0.");
                    }

                    try (PreparedStatement ps =
                            conn.prepareStatement(sqlLaut)) {
                        ps.setString(1, id);
                        ps.setString(2, nama.trim());
                        ps.setString(3, jenis);
                        ps.setInt(4, stok);
                        ps.setInt(5, kedalaman);
                        ps.executeUpdate();
                    }
                } else if (tipe == 2) {
                    if (perairan == null || perairan.trim().isEmpty()) {
                        throw new SQLException(
                                "Jenis perairan tidak boleh kosong.");
                    }

                    try (PreparedStatement ps =
                            conn.prepareStatement(sqlAir)) {
                        ps.setString(1, id);
                        ps.setString(2, nama.trim());
                        ps.setString(3, jenis);
                        ps.setInt(4, stok);
                        ps.setString(5, perairan);
                        ps.executeUpdate();
                    }
                } else {
                    throw new SQLException(
                            "Kategori ikan tidak valid.");
                }

                conn.commit();
                System.out.println(
                        "Data ikan berhasil ditambahkan.");
                System.out.println("ID Ikan: " + id);

            } catch (Exception e) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println(
                            "Rollback gagal: " + ex.getMessage());
                }

                System.out.println(
                        "Gagal menambahkan data ikan: "
                        + e.getMessage());
            } finally {
                try {
                    conn.setAutoCommit(true);
                } catch (SQLException e) {
                    System.out.println(
                            "Gagal mengatur transaksi: "
                            + e.getMessage());
                }
            }

        } catch (SQLException e) {
            System.out.println(
                    "Koneksi database gagal: " + e.getMessage());
        }
    }

    public void ubah(String id, String nama, String jenis, int stok,
            int tipe, int kedalaman, String perairan) {

        String idValid = id.trim().toUpperCase();

        String sqlUpdate = "UPDATE ikan SET nama_ikan = ?, "
                + "jenis_ikan = ?, jumlah_stok = ? WHERE id_ikan = ?";

        String sqlHapusLaut =
                "DELETE FROM ikan_laut WHERE id_ikan = ?";

        String sqlHapusAir =
                "DELETE FROM ikan_air_tawar WHERE id_ikan = ?";

        String sqlLaut = "INSERT INTO ikan_laut "
                + "(id_ikan, nama_ikan, jenis_ikan, jumlah_stok, "
                + "kedalaman_habitat) VALUES (?, ?, ?, ?, ?)";

        String sqlAir = "INSERT INTO ikan_air_tawar "
                + "(id_ikan, nama_ikan, jenis_ikan, jumlah_stok, "
                + "jenis_perairan) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Koneksi.getConnection()) {
            conn.setAutoCommit(false);

            try {
                if (!idValid.matches("I\\d{3,}")) {
                    throw new SQLException(
                            "Format ID ikan tidak valid.");
                }

                try (PreparedStatement ps = conn.prepareStatement(
                        "SELECT id_ikan FROM ikan WHERE id_ikan = ?")) {
                    ps.setString(1, idValid);

                    try (ResultSet rs = ps.executeQuery()) {
                        if (!rs.next()) {
                            conn.rollback();
                            System.out.println(
                                    "ID ikan tidak ditemukan.");
                            return;
                        }
                    }
                }

                try (PreparedStatement ps =
                        conn.prepareStatement(sqlUpdate)) {
                    ps.setString(1, nama.trim());
                    ps.setString(2, jenis);
                    ps.setInt(3, stok);
                    ps.setString(4, idValid);
                    ps.executeUpdate();
                }

                try (PreparedStatement ps =
                        conn.prepareStatement(sqlHapusLaut)) {
                    ps.setString(1, idValid);
                    ps.executeUpdate();
                }

                try (PreparedStatement ps =
                        conn.prepareStatement(sqlHapusAir)) {
                    ps.setString(1, idValid);
                    ps.executeUpdate();
                }

                if (tipe == 1) {
                    if (kedalaman <= 0) {
                        throw new SQLException(
                                "Kedalaman habitat harus lebih dari 0.");
                    }

                    try (PreparedStatement ps =
                            conn.prepareStatement(sqlLaut)) {
                        ps.setString(1, idValid);
                        ps.setString(2, nama.trim());
                        ps.setString(3, jenis);
                        ps.setInt(4, stok);
                        ps.setInt(5, kedalaman);
                        ps.executeUpdate();
                    }
                } else if (tipe == 2) {
                    if (perairan == null || perairan.trim().isEmpty()) {
                        throw new SQLException(
                                "Jenis perairan tidak boleh kosong.");
                    }

                    try (PreparedStatement ps =
                            conn.prepareStatement(sqlAir)) {
                        ps.setString(1, idValid);
                        ps.setString(2, nama.trim());
                        ps.setString(3, jenis);
                        ps.setInt(4, stok);
                        ps.setString(5, perairan);
                        ps.executeUpdate();
                    }
                } else {
                    throw new SQLException(
                            "Kategori ikan tidak valid.");
                }

                conn.commit();
                System.out.println("Data ikan berhasil diubah.");

            } catch (Exception e) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println(
                            "Rollback gagal: " + ex.getMessage());
                }

                System.out.println(
                        "Gagal mengubah data ikan: " + e.getMessage());
            } finally {
                try {
                    conn.setAutoCommit(true);
                } catch (SQLException e) {
                    System.out.println(
                            "Gagal mengatur transaksi: "
                            + e.getMessage());
                }
            }

        } catch (SQLException e) {
            System.out.println(
                    "Koneksi database gagal: " + e.getMessage());
        }
    }

    public void hapus(String id) {
        String idValid = id.trim().toUpperCase();

        String[] daftarSQL = {
            "DELETE FROM lokasi_penangkapan WHERE id_ikan = ?",
            "DELETE FROM hasil_penangkapan WHERE id_ikan = ?",
            "DELETE FROM ikan_laut WHERE id_ikan = ?",
            "DELETE FROM ikan_air_tawar WHERE id_ikan = ?",
            "DELETE FROM ikan WHERE id_ikan = ?"
        };

        try (Connection conn = Koneksi.getConnection()) {
            conn.setAutoCommit(false);

            try {
                int jumlahIkanTerhapus = 0;

                for (int i = 0; i < daftarSQL.length; i++) {
                    try (PreparedStatement ps =
                            conn.prepareStatement(daftarSQL[i])) {
                        ps.setString(1, idValid);
                        int hasil = ps.executeUpdate();

                        if (i == daftarSQL.length - 1) {
                            jumlahIkanTerhapus = hasil;
                        }
                    }
                }

                if (jumlahIkanTerhapus == 0) {
                    conn.rollback();
                    System.out.println("ID ikan tidak ditemukan.");
                    return;
                }

                conn.commit();
                System.out.println(
                        "Data ikan dan data terkait berhasil dihapus.");

            } catch (SQLException e) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println(
                            "Rollback gagal: " + ex.getMessage());
                }

                System.out.println(
                        "Gagal menghapus data ikan: " + e.getMessage());
            } finally {
                try {
                    conn.setAutoCommit(true);
                } catch (SQLException e) {
                    System.out.println(
                            "Gagal mengatur transaksi: "
                            + e.getMessage());
                }
            }

        } catch (SQLException e) {
            System.out.println(
                    "Koneksi database gagal: " + e.getMessage());
        }
    }
}
