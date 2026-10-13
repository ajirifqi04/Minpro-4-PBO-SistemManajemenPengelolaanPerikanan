/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author AjiHowhow
 */
public abstract class Ikan implements DataPerikanan {
    private final String idIkan;
    private String namaIkan;
    private String jenisIkan;
    private int jumlahStok;

    public Ikan(String idIkan, String namaIkan,
            String jenisIkan, int jumlahStok) {
        if (idIkan == null || !idIkan.matches("I\\d{3,}")) {
            throw new IllegalArgumentException(
                    "Format ID ikan tidak valid. Contoh: I001.");
        }

        this.idIkan = idIkan;
        setNamaIkan(namaIkan);
        setJenisIkan(jenisIkan);
        setJumlahStok(jumlahStok);
    }

    public String getIdIkan() {
        return idIkan;
    }

    public String getNamaIkan() {
        return namaIkan;
    }

    public String getJenisIkan() {
        return jenisIkan;
    }

    public int getJumlahStok() {
        return jumlahStok;
    }

    public void setNamaIkan(String namaIkan) {
        if (namaIkan == null || namaIkan.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Nama ikan tidak boleh kosong.");
        }

        this.namaIkan = namaIkan.trim();
    }

    public void setJenisIkan(String jenisIkan) {
        if (jenisIkan == null
                || (!jenisIkan.equalsIgnoreCase("Konsumsi")
                && !jenisIkan.equalsIgnoreCase("Budidaya"))) {
            throw new IllegalArgumentException(
                    "Jenis ikan harus Konsumsi atau Budidaya.");
        }

        this.jenisIkan = jenisIkan;
    }

    public void setJumlahStok(int jumlahStok) {
        if (jumlahStok <= 0) {
            throw new IllegalArgumentException(
                    "Jumlah stok harus lebih dari 0.");
        }

        this.jumlahStok = jumlahStok;
    }

    public abstract void tampilkanDetail();

    public void tampilkanDetail(String judul) {
        System.out.println("\n" + judul);
        tampilkanDetail();
    }

    @Override
    public final void tampilkanData() {
        tampilkanDetail();
    }
}