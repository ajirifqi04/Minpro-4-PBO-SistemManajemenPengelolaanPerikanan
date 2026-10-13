/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author AjiHowhow
 */
public class LokasiPenangkapan implements DataPerikanan {
    private String idLokasi;
    private String idIkan;
    private String namaLokasi;
    private String wilayah;

    public LokasiPenangkapan(String idLokasi, String idIkan,
            String namaLokasi, String wilayah) {
        setIdLokasi(idLokasi);
        setIdIkan(idIkan);
        setNamaLokasi(namaLokasi);
        setWilayah(wilayah);
    }

    public String getIdLokasi() {
        return idLokasi;
    }

    public String getIdIkan() {
        return idIkan;
    }

    public String getNamaLokasi() {
        return namaLokasi;
    }

    public String getWilayah() {
        return wilayah;
    }

    public void setIdLokasi(String idLokasi) {
        if (idLokasi == null
                || !idLokasi.trim().matches("LK\\d{3,}")) {
            throw new IllegalArgumentException(
                    "Format ID lokasi salah. Contoh: LK001.");
        }

        this.idLokasi = idLokasi.trim().toUpperCase();
    }

    public void setIdIkan(String idIkan) {
        if (idIkan == null
                || !idIkan.trim().matches("I\\d{3,}")) {
            throw new IllegalArgumentException(
                    "Format ID ikan salah. Contoh: I001.");
        }

        this.idIkan = idIkan.trim().toUpperCase();
    }

    public void setNamaLokasi(String namaLokasi) {
        if (namaLokasi == null || namaLokasi.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Nama lokasi tidak boleh kosong.");
        }

        this.namaLokasi = namaLokasi.trim();
    }

    public void setWilayah(String wilayah) {
        if (wilayah == null || wilayah.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Wilayah tidak boleh kosong.");
        }

        this.wilayah = wilayah.trim();
    }

    @Override
    public void tampilkanData() {
        System.out.println("ID Lokasi: " + idLokasi);
        System.out.println("ID Ikan: " + idIkan);
        System.out.println("Nama Lokasi: " + namaLokasi);
        System.out.println("Wilayah: " + wilayah);
    }
}
