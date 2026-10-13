/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author AjiHowhow
 */
public class IkanAirTawar extends Ikan {
    private String jenisPerairan;

    public IkanAirTawar(String idIkan, String namaIkan,
            String jenisIkan, int jumlahStok,
            String jenisPerairan) {
        super(idIkan, namaIkan, jenisIkan, jumlahStok);
        setJenisPerairan(jenisPerairan);
    }

    public String getJenisPerairan() {
        return jenisPerairan;
    }

    public void setJenisPerairan(String jenisPerairan) {
        if (jenisPerairan == null
                || (!jenisPerairan.equalsIgnoreCase("Sungai")
                && !jenisPerairan.equalsIgnoreCase("Danau")
                && !jenisPerairan.equalsIgnoreCase("Waduk"))) {
            throw new IllegalArgumentException(
                    "Jenis perairan harus Sungai, Danau, atau Waduk.");
        }

        this.jenisPerairan = jenisPerairan;
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("ID Ikan: " + getIdIkan());
        System.out.println("Nama Ikan: " + getNamaIkan());
        System.out.println("Jenis Ikan: " + getJenisIkan());
        System.out.println("Jumlah Stok: " + getJumlahStok() + " kg");
        System.out.println("Jenis Perairan: " + jenisPerairan);
    }
}
