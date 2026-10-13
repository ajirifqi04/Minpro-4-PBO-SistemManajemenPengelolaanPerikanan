/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.IkanDAO;
import dao.LokasiPenangkapanDAO;
import dao.HasilPenangkapanDAO;
import model.Ikan;
import model.LokasiPenangkapan;
import model.HasilPenangkapan;
import view.IkanView;

/**
 *
 * @author AjiHowhow
 */
public class IkanController {
    private final IkanView view;
    private final IkanDAO ikanDAO;
    private final LokasiPenangkapanDAO lokasiDAO;
    private final HasilPenangkapanDAO hasilDAO;

    public IkanController() {
        view = new IkanView();
        ikanDAO = new IkanDAO();
        lokasiDAO = new LokasiPenangkapanDAO();
        hasilDAO = new HasilPenangkapanDAO();
    }

    public void start() {
        boolean berjalan = true;

        while (berjalan) {
            switch (view.tampilkanMenu()) {
                case 1:
                    menuIkan();
                    break;
                case 2:
                    menuLokasi();
                    break;
                case 3:
                    menuHasil();
                    break;
                case 4:
                    view.tampilkanPesan("Program selesai.");
                    berjalan = false;
                    break;
                default:
                    view.tampilkanPesan("Pilihan tidak tersedia.");
            }
        }
    }

    private void menuIkan() {
        boolean kembali = false;

        while (!kembali) {
            switch (view.tampilkanMenuIkan()) {
                case 1:
                    tambahIkan();
                    break;
                case 2:
                    ikanDAO.tampilkanSemua();
                    break;
                case 3:
                    ubahIkan();
                    break;
                case 4:
                    hapusIkan();
                    break;
                case 5:
                    kembali = true;
                    break;
                default:
                    view.tampilkanPesan("Pilihan tidak tersedia.");
            }
        }
    }

    private void tambahIkan() {
        try {
            String nama = view.inputNamaIkan();
            String jenis = view.inputJenisIkan();
            int stok = view.inputJumlahStok();
            int tipe = view.pilihJenisIkan();

            int kedalaman = 0;
            String perairan = "";

            if (tipe == 1) {
                kedalaman = view.inputKedalamanHabitat();
            } else {
                perairan = view.inputJenisPerairan();
            }

            ikanDAO.tambah(
                    nama, jenis, stok, tipe, kedalaman, perairan);

        } catch (IllegalArgumentException e) {
            view.tampilkanPesan(
                    "Input tidak valid: " + e.getMessage());
        }
    }

    private void ubahIkan() {
        String id = view.inputIdIkan();

        if (!ikanDAO.idTerdaftar(id)) {
            view.tampilkanPesan("ID ikan tidak ditemukan.");
            return;
        }

        try {
            String nama = view.inputNamaIkan();
            String jenis = view.inputJenisIkan();
            int stok = view.inputJumlahStok();
            int tipe = view.pilihJenisIkan();

            int kedalaman = 0;
            String perairan = "";

            if (tipe == 1) {
                kedalaman = view.inputKedalamanHabitat();
            } else {
                perairan = view.inputJenisPerairan();
            }

            ikanDAO.ubah(
                    id, nama, jenis, stok, tipe, kedalaman, perairan);

        } catch (IllegalArgumentException e) {
            view.tampilkanPesan(
                    "Input tidak valid: " + e.getMessage());
        }
    }

    private void hapusIkan() {
        String id = view.inputIdIkan();

        if (!ikanDAO.idTerdaftar(id)) {
            view.tampilkanPesan("ID ikan tidak ditemukan.");
            return;
        }

        view.tampilkanPesan(
                "Data lokasi dan hasil penangkapan yang terkait "
                + "juga akan dihapus.");

        int konfirmasi = view.tampilkanMenuKonfirmasiHapus();

        if (konfirmasi == 1) {
            ikanDAO.hapus(id);
        } else {
            view.tampilkanPesan("Penghapusan dibatalkan.");
        }
    }

    private void menuLokasi() {
        boolean kembali = false;

        while (!kembali) {
            switch (view.tampilkanMenuLokasi()) {
                case 1:
                    tambahLokasi();
                    break;
                case 2:
                    lokasiDAO.tampilkanSemua();
                    break;
                case 3:
                    kembali = true;
                    break;
                default:
                    view.tampilkanPesan("Pilihan tidak tersedia.");
            }
        }
    }

    private void tambahLokasi() {
        try {
            LokasiPenangkapan data = view.inputLokasi();
            lokasiDAO.tambah(data);

        } catch (IllegalArgumentException e) {
            view.tampilkanPesan(
                    "Input tidak valid: " + e.getMessage());
        }
    }

    private void menuHasil() {
        boolean kembali = false;

        while (!kembali) {
            switch (view.tampilkanMenuHasil()) {
                case 1:
                    tambahHasil();
                    break;
                case 2:
                    hasilDAO.tampilkanSemua();
                    break;
                case 3:
                    kembali = true;
                    break;
                default:
                    view.tampilkanPesan("Pilihan tidak tersedia.");
            }
        }
    }

    private void tambahHasil() {
        try {
            HasilPenangkapan data = view.inputHasil();
            hasilDAO.tambah(data);

        } catch (IllegalArgumentException e) {
            view.tampilkanPesan(
                    "Input tidak valid: " + e.getMessage());
        }
    }
}
