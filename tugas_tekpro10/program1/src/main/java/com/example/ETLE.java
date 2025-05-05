package com.example;

import java.util.ArrayList;
import java.util.logging.Logger;

// Kelas abstrak Kendaraan dengan implementasi tampilan info
abstract class Kendaraan {
    private String nomorPlat;
    private String jenis;
    private String warna;

    protected Kendaraan(String nomorPlat, String jenis, String warna) {
        this.nomorPlat = nomorPlat;
        this.jenis = jenis;
        this.warna = warna;
    }

    public String getNomorPlat() { return nomorPlat; }
    public String getJenis() { return jenis; }
    public String getWarna() { return warna; }

    void tampilkanInfo(Logger logger) {
        LoggerUtil.logInfo(logger, "Nomor Plat: " + nomorPlat);
        LoggerUtil.logInfo(logger, "Jenis: " + jenis);
        LoggerUtil.logInfo(logger, "Warna: " + warna);
    }
}

// Interface Pelanggaran
interface Pelanggaran {
    void catatPelanggaran(String pelanggaran);
    void tampilkanPelanggaran();
}

// Utility class untuk logging
class LoggerUtil {
    private LoggerUtil() {
        // Private constructor untuk mencegah instansiasi
        throw new UnsupportedOperationException("LoggerUtil is a utility class and cannot be instantiated.");
    }

    public static void logInfo(Logger logger, String message) {
        if (logger.isLoggable(java.util.logging.Level.INFO)) {
            logger.info(message);
        }
    }
}

// Kelas abstrak KendaraanPelanggar untuk mengurangi duplikasi
abstract class KendaraanPelanggar extends Kendaraan implements Pelanggaran {
    private final Logger logger;
    private final ArrayList<String> daftarPelanggaran;

    protected KendaraanPelanggar(String nomorPlat, String jenis, String warna, Logger logger) {
        super(nomorPlat, jenis, warna);
        this.logger = logger;
        this.daftarPelanggaran = new ArrayList<>();
    }

    @Override
    public void catatPelanggaran(String pelanggaran) {
        daftarPelanggaran.add(pelanggaran);
    }

    @Override
    public void tampilkanPelanggaran() {
        LoggerUtil.logInfo(logger, "Pelanggaran " + getJenis() + ":");
        for (String pelanggaran : daftarPelanggaran) {
            LoggerUtil.logInfo(logger, "- " + pelanggaran);
        }
    }
}

// Kelas Mobil
class Mobil extends KendaraanPelanggar {
    private static final Logger LOGGER = Logger.getLogger(Mobil.class.getName());

    public Mobil(String nomorPlat, String warna) {
        super(nomorPlat, "Mobil", warna, LOGGER);
    }
}

// Kelas Motor
class Motor extends KendaraanPelanggar {
    private static final Logger LOGGER = Logger.getLogger(Motor.class.getName());

    public Motor(String nomorPlat, String warna) {
        super(nomorPlat, "Motor", warna, LOGGER);
    }
}

// Kelas utama ETLE untuk mencatat pelanggaran
public class ETLE {
    private static final Logger LOGGER = Logger.getLogger(ETLE.class.getName());
    private final ArrayList<KendaraanPelanggar> daftarPelanggar;

    public ETLE() {
        this.daftarPelanggar = new ArrayList<>();
    }

    public void tambahPelanggar(KendaraanPelanggar kendaraan) {
        daftarPelanggar.add(kendaraan);
        LoggerUtil.logInfo(LOGGER, "Menambahkan pelanggar baru: " + kendaraan.getNomorPlat());
    }

    public void tampilkanSemuaPelanggar() {
        LoggerUtil.logInfo(LOGGER, "Menampilkan daftar pelanggar:");
        for (KendaraanPelanggar kendaraan : daftarPelanggar) {
            kendaraan.tampilkanInfo(LOGGER);
            kendaraan.tampilkanPelanggaran();
            LoggerUtil.logInfo(LOGGER, "---------------------");
        }
    }

    public static void main(String[] args) {
        ETLE etle = new ETLE();
        KendaraanPelanggar mobil = new Mobil("AB 1234 XYZ", "Hitam");
        KendaraanPelanggar motor = new Motor("Z 5678 ABC", "Merah");

        mobil.catatPelanggaran("Melanggar lampu merah");
        motor.catatPelanggaran("Tidak memakai helm");

        etle.tambahPelanggar(mobil);
        etle.tambahPelanggar(motor);

        etle.tampilkanSemuaPelanggar();
    }
}