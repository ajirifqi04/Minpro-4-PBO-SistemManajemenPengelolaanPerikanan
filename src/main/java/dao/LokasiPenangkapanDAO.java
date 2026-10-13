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
import model.LokasiPenangkapan;
/**
 *
 * @author AjiHowhow
 */
public class LokasiPenangkapanDAO {

    public boolean tambah(LokasiPenangkapan data) {
        String sql = "INSERT INTO lokasi_penangkapan "
                + "(id_lokasi, id_ikan, nama_lokasi, wilayah) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection conn = Koneksi.getConnection()) {
            if (!idIkanTerdaftar(data.getIdIkan())) {
                System.out.println(
                        "ID ikan tidak ditemukan. "
                        + "Tambahkan data ikan terlebih dahulu.");
                return false;
            }

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, data.getIdLokasi());
                ps.setString(2, data.getIdIkan());
                ps.setString(3, data.getNamaLokasi());
                ps.setString(4, data.getWilayah());
                ps.executeUpdate();
            }

            System.out.println(
                    "Data lokasi berhasil ditambahkan.");
            return true;

        } catch (SQLException e) {
            System.out.println(
                    "Gagal menambahkan lokasi: " + e.getMessage());
            return false;
        }
    }

    public void tampilkanSemua() {
        String sql = "SELECT * FROM lokasi_penangkapan "
                + "ORDER BY id_lokasi";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n=== DATA LOKASI PENANGKAPAN ===");
            boolean adaData = false;

            while (rs.next()) {
                adaData = true;
                System.out.println("------------------------------");
                System.out.println("ID Lokasi: "
                        + rs.getString("id_lokasi"));
                System.out.println("ID Ikan: "
                        + rs.getString("id_ikan"));
                System.out.println("Nama Lokasi: "
                        + rs.getString("nama_lokasi"));
                System.out.println("Wilayah: "
                        + rs.getString("wilayah"));
            }

            if (!adaData) {
                System.out.println(
                        "Belum ada data lokasi penangkapan.");
            }

        } catch (SQLException e) {
            System.out.println(
                    "Gagal menampilkan lokasi: " + e.getMessage());
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
