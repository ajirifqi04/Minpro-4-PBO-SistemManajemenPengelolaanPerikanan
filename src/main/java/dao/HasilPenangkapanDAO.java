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
import model.HasilPenangkapan;
/**
 *
 * @author AjiHowhow
 */
public class HasilPenangkapanDAO {

    public boolean tambah(HasilPenangkapan data) {
        String sql = "INSERT INTO hasil_penangkapan "
                + "(id_hasil, id_ikan, tanggal, kondisi) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection conn = Koneksi.getConnection()) {
            if (!idIkanTerdaftar(data.getIdIkan())) {
                System.out.println(
                        "ID ikan tidak ditemukan. "
                        + "Tambahkan data ikan terlebih dahulu.");
                return false;
            }

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, data.getIdHasil());
                ps.setString(2, data.getIdIkan());
                ps.setString(3, data.getTanggal());
                ps.setString(4, data.getKondisi());
                ps.executeUpdate();
            }

            System.out.println(
                    "Data hasil penangkapan berhasil ditambahkan.");
            return true;

        } catch (SQLException e) {
            System.out.println(
                    "Gagal menambahkan hasil penangkapan: "
                    + e.getMessage());
            return false;
        }
    }

    public void tampilkanSemua() {
        String sql = "SELECT * FROM hasil_penangkapan "
                + "ORDER BY id_hasil";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n=== DATA HASIL PENANGKAPAN ===");
            boolean adaData = false;

            while (rs.next()) {
                adaData = true;
                System.out.println("------------------------------");
                System.out.println("ID Hasil: "
                        + rs.getString("id_hasil"));
                System.out.println("ID Ikan: "
                        + rs.getString("id_ikan"));
                System.out.println("Tanggal: "
                        + rs.getString("tanggal"));
                System.out.println("Kondisi: "
                        + rs.getString("kondisi"));
            }

            if (!adaData) {
                System.out.println(
                        "Belum ada data hasil penangkapan.");
            }

        } catch (SQLException e) {
            System.out.println(
                    "Gagal menampilkan hasil penangkapan: "
                    + e.getMessage());
        }
    }

    public boolean idIkanTerdaftar(String idIkan) {
        String sql = "SELECT id_ikan FROM ikan WHERE id_ikan = ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, idIkan);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            System.out.println(
                    "Gagal memeriksa ID ikan: " + e.getMessage());
            return false;
        }
    }
}
