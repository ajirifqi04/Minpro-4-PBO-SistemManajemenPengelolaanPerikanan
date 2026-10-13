/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author AjiHowhow
 */
public class IkanLaut extends Ikan {
    private int kedalamanHabitat;

    public IkanLaut(String idIkan, String namaIkan,
            String jenisIkan, int jumlahStok,
            int kedalamanHabitat) {
        super(idIkan, namaIkan, jenisIkan, jumlahStok);
        setKedalamanHabitat(kedalamanHabitat);
    }

    public int getKedalamanHabitat() {
        return kedalamanHabitat;
    }

    public void setKedalamanHabitat(int kedalamanHabitat) {
        if (kedalamanHabitat <= 0) {
            throw new IllegalArgumentException(
                    "Kedalaman habitat harus lebih dari 0.");
        }

        this.kedalamanHabitat = kedalamanHabitat;
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("ID Ikan: " + getIdIkan());
        System.out.println("Nama Ikan: " + getNamaIkan());
        System.out.println("Jenis Ikan: " + getJenisIkan());
        System.out.println("Jumlah Stok: " + getJumlahStok() + " kg");
        System.out.println(
                "Kedalaman Habitat: " + kedalamanHabitat + " meter");
    }
}
