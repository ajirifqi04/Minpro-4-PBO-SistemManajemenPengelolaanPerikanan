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
public class IkanLautDAO {

    public void tambah(String idIkan, String namaIkan,
            String jenisIkan, int jumlahStok,
            int kedalamanHabitat) {
        String sql = "INSERT INTO ikan_laut "
                + "(id_ikan, nama_ikan, jenis_ikan, jumlah_stok, "
                + "kedalaman_habitat) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, idIkan);
            ps.setString(2, namaIkan);
            ps.setString(3, jenisIkan);
            ps.setInt(4, jumlahStok);
            ps.setInt(5, kedalamanHabitat);
            ps.executeUpdate();

            System.out.println(
                    "Data ikan laut berhasil ditambahkan.");
        } catch (SQLException e) {
            System.out.println(
                    "Gagal menambah ikan laut: " + e.getMessage());
        }
    }

    public void tampilkanSemua() {
        String sql = "SELECT * FROM ikan_laut ORDER BY id_ikan";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            System.out.println("\n=== DATA IKAN LAUT ===");
            boolean adaData = false;

            while (rs.next()) {
                adaData = true;
                System.out.println("------------------------------");
                System.out.println("ID: " + rs.getString("id_ikan"));
                System.out.println("Nama: " + rs.getString("nama_ikan"));
                System.out.println("Jenis: " + rs.getString("jenis_ikan"));
                System.out.println("Stok: "
                        + rs.getInt("jumlah_stok") + " kg");
                System.out.println("Kedalaman: "
                        + rs.getInt("kedalaman_habitat") + " meter");
            }

            if (!adaData) {
                System.out.println("Belum ada data ikan laut.");
            }
        } catch (SQLException e) {
            System.out.println(
                    "Gagal menampilkan ikan laut: " + e.getMessage());
        }
    }

    public void ubah(String idIkan, String namaIkan,
            String jenisIkan, int jumlahStok,
            int kedalamanHabitat) {
        String sql = "UPDATE ikan_laut SET nama_ikan = ?, "
                + "jenis_ikan = ?, jumlah_stok = ?, "
                + "kedalaman_habitat = ? WHERE id_ikan = ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, namaIkan);
            ps.setString(2, jenisIkan);
            ps.setInt(3, jumlahStok);
            ps.setInt(4, kedalamanHabitat);
            ps.setString(5, idIkan);

            if (ps.executeUpdate() > 0) {
                System.out.println("Data ikan laut berhasil diubah.");
            } else {
                System.out.println("Data ikan laut tidak ditemukan.");
            }
        } catch (SQLException e) {
            System.out.println(
                    "Gagal mengubah ikan laut: " + e.getMessage());
        }
    }

    public void hapus(String idIkan) {
        String sql = "DELETE FROM ikan_laut WHERE id_ikan = ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, idIkan);

            if (ps.executeUpdate() > 0) {
                System.out.println("Data ikan laut berhasil dihapus.");
            } else {
                System.out.println("Data ikan laut tidak ditemukan.");
            }
        } catch (SQLException e) {
            System.out.println(
                    "Gagal menghapus ikan laut: " + e.getMessage());
        }
    }
}
