/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.DateTimeException;

/**
 *
 * @author AjiHowhow
 */
public class HasilPenangkapan implements DataPerikanan {
    private String idHasil;
    private String idIkan;
    private String tanggal;
    private String kondisi;

    public HasilPenangkapan(String idHasil, String idIkan,
            String tanggal, String kondisi) {
        setIdHasil(idHasil);
        setIdIkan(idIkan);
        setTanggal(tanggal);
        setKondisi(kondisi);
    }

    public String getIdHasil() {
        return idHasil;
    }

    public String getIdIkan() {
        return idIkan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getKondisi() {
        return kondisi;
    }

    public void setIdHasil(String idHasil) {
        if (idHasil == null
                || !idHasil.trim().matches("HP\\d{3,}")) {
            throw new IllegalArgumentException(
                    "Format ID hasil salah. Contoh: HP001.");
        }

        this.idHasil = idHasil.trim().toUpperCase();
    }

    public void setIdIkan(String idIkan) {
        if (idIkan == null
                || !idIkan.trim().matches("I\\d{3,}")) {
            throw new IllegalArgumentException(
                    "Format ID ikan salah. Contoh: I001.");
        }

        this.idIkan = idIkan.trim().toUpperCase();
    }

    public void setTanggal(String tanggal) {
        if (tanggal == null || tanggal.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Tanggal tidak boleh kosong.");
        }

        try {
            LocalDate.parse(tanggal.trim());
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(
                    "Tanggal harus menggunakan format YYYY-MM-DD.");
        }

        this.tanggal = tanggal.trim();
    }

    public void setKondisi(String kondisi) {
        if (kondisi == null || kondisi.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Kondisi hasil penangkapan tidak boleh kosong.");
        }

        this.kondisi = kondisi.trim();
    }

    @Override
    public void tampilkanData() {
        System.out.println("ID Hasil: " + idHasil);
        System.out.println("ID Ikan: " + idIkan);
        System.out.println("Tanggal: " + tanggal);
        System.out.println("Kondisi: " + kondisi);
    }
}