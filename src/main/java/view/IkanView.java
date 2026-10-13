/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.time.LocalDate;
import java.time.DateTimeException;
import java.util.Scanner;
import model.Ikan;
import model.IkanLaut;
import model.IkanAirTawar;
import model.LokasiPenangkapan;
import model.HasilPenangkapan;

/**
 *
 * @author AjiHowhow
 */
public class IkanView {
    private final Scanner input = new Scanner(System.in);

    public int tampilkanMenu() {
        System.out.println("\n=== SISTEM PENGELOLAAN PERIKANAN ===");
        System.out.println("1. Kelola Data Ikan");
        System.out.println("2. Kelola Lokasi Penangkapan");
        System.out.println("3. Kelola Hasil Penangkapan");
        System.out.println("4. Keluar");

        return bacaPilihan("Pilih menu: ", 1, 4);
    }

    public int tampilkanMenuIkan() {
        System.out.println("\n=== KELOLA DATA IKAN ===");
        System.out.println("1. Tambah Ikan");
        System.out.println("2. Tampilkan Ikan");
        System.out.println("3. Ubah Ikan");
        System.out.println("4. Hapus Ikan");
        System.out.println("5. Kembali");

        return bacaPilihan("Pilih menu: ", 1, 5);
    }

    public int tampilkanMenuLokasi() {
        System.out.println("\n=== KELOLA LOKASI PENANGKAPAN ===");
        System.out.println("1. Tambah Lokasi");
        System.out.println("2. Tampilkan Lokasi");
        System.out.println("3. Kembali");

        return bacaPilihan("Pilih menu: ", 1, 3);
    }

    public int tampilkanMenuHasil() {
        System.out.println("\n=== KELOLA HASIL PENANGKAPAN ===");
        System.out.println("1. Tambah Hasil");
        System.out.println("2. Tampilkan Hasil");
        System.out.println("3. Kembali");

        return bacaPilihan("Pilih menu: ", 1, 3);
    }

    public String inputIdIkan() {
        return inputId(
                "ID Ikan (contoh: I001): ",
                "I\\d{3,}",
                "Format ID ikan salah. Contoh: I001.");
    }

    public String inputNamaIkan() {
        return inputTeks("Nama Ikan (contoh: Bandeng): ");
    }

    public String inputJenisIkan() {
        while (true) {
            String jenis = inputTeks(
                    "Jenis Ikan (Konsumsi/Budidaya): ");

            if (jenis.equalsIgnoreCase("Konsumsi")) {
                return "Konsumsi";
            }

            if (jenis.equalsIgnoreCase("Budidaya")) {
                return "Budidaya";
            }

            System.out.println(
                    "Jenis hanya boleh Konsumsi atau Budidaya.");
        }
    }

    public int inputJumlahStok() {
        return bacaBilangan(
                "Jumlah Stok dalam kg (contoh: 25): ",
                1, Integer.MAX_VALUE);
    }

    public int pilihJenisIkan() {
        System.out.println("1. Ikan Laut");
        System.out.println("2. Ikan Air Tawar");

        return bacaPilihan("Pilih kategori ikan: ", 1, 2);
    }

    public int inputKedalamanHabitat() {
        return bacaBilangan(
                "Kedalaman Habitat dalam meter (contoh: 20): ",
                1, Integer.MAX_VALUE);
    }

    public String inputJenisPerairan() {
        while (true) {
            String perairan = inputTeks(
                    "Jenis Perairan (Sungai/Danau/Waduk): ");

            if (perairan.equalsIgnoreCase("Sungai")) {
                return "Sungai";
            }

            if (perairan.equalsIgnoreCase("Danau")) {
                return "Danau";
            }

            if (perairan.equalsIgnoreCase("Waduk")) {
                return "Waduk";
            }

            System.out.println(
                    "Jenis perairan harus Sungai, Danau, atau Waduk.");
        }
    }

    public String inputIdLokasi() {
        return inputId(
                "ID Lokasi (contoh: LK001): ",
                "LK\\d{3,}",
                "Format ID lokasi salah. Contoh: LK001.");
    }

    public String inputIdHasil() {
        return inputId(
                "ID Hasil (contoh: HP001): ",
                "HP\\d{3,}",
                "Format ID hasil salah. Contoh: HP001.");
    }

    public LokasiPenangkapan inputLokasi() {
        String idLokasi = inputIdLokasi();
        String idIkan = inputIdIkan();
        String namaLokasi = inputTeks(
                "Nama Lokasi (contoh: Muara Badak): ");
        String wilayah = inputTeks(
                "Wilayah (contoh: Kutai Kartanegara): ");

        return new LokasiPenangkapan(
                idLokasi, idIkan, namaLokasi, wilayah);
    }

    public HasilPenangkapan inputHasil() {
        String idHasil = inputIdHasil();
        String idIkan = inputIdIkan();
        String tanggal = inputTanggal();
        String kondisi = inputTeks(
                "Kondisi Hasil (contoh: Segar): ");

        return new HasilPenangkapan(
                idHasil, idIkan, tanggal, kondisi);
    }

    public int tampilkanMenuKonfirmasiHapus() {
        return bacaPilihan(
                "Lanjutkan hapus? (1. Ya, 2. Tidak): ", 1, 2);
    }

    public void tampilkanPesan(String pesan) {
        System.out.println(pesan);
    }

    public void tampilkanIkan(String data) {
        System.out.println(data);
    }

    public void tampilkanLokasi(String data) {
        System.out.println(data);
    }

    public void tampilkanHasil(String data) {
        System.out.println(data);
    }

    private String inputTeks(String pesan) {
        while (true) {
            System.out.print(pesan);
            String nilai = input.nextLine().trim();

            if (!nilai.isEmpty()) {
                return nilai;
            }

            System.out.println(
                    "Input tidak boleh kosong. Silakan coba lagi.");
        }
    }

    private String inputId(
            String pesan, String pola, String pesanSalah) {
        while (true) {
            System.out.print(pesan);
            String nilai = input.nextLine().trim().toUpperCase();

            if (nilai.matches(pola)) {
                return nilai;
            }

            System.out.println(pesanSalah);
        }
    }

    private int bacaPilihan(String pesan, int min, int max) {
        return bacaBilangan(pesan, min, max);
    }

    private int bacaBilangan(String pesan, int min, int max) {
        while (true) {
            System.out.print(pesan);
            String nilai = input.nextLine().trim();

            try {
                int angka = Integer.parseInt(nilai);

                if (angka >= min && angka <= max) {
                    return angka;
                }

                System.out.println(
                        "Angka harus berada antara "
                        + min + " sampai " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println(
                        "Input harus berupa bilangan bulat. "
                        + "Silakan coba lagi.");
            }
        }
    }

    private String inputTanggal() {
        while (true) {
            String tanggal = inputTeks(
                    "Tanggal Penangkapan (YYYY-MM-DD, "
                    + "contoh: 2026-10-13): ");

            try {
                LocalDate.parse(tanggal);
                return tanggal;
            } catch (DateTimeException e) {
                System.out.println(
                        "Tanggal tidak valid. Gunakan format YYYY-MM-DD.");
            }
        }
    }

    public Ikan inputIkan(String idIkan) {
        String nama = inputNamaIkan();
        String jenis = inputJenisIkan();
        int stok = inputJumlahStok();
        int tipe = pilihJenisIkan();

        if (tipe == 1) {
            int kedalaman = inputKedalamanHabitat();

            return new IkanLaut(
                    idIkan, nama, jenis, stok, kedalaman);
        }

        String perairan = inputJenisPerairan();

        return new IkanAirTawar(
                idIkan, nama, jenis, stok, perairan);
    }
}
