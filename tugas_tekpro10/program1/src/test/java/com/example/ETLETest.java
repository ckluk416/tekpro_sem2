package com.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.Mobil;
import main.Motor;

class KendaraanTest {
    private Mobil mobil;
    private Motor motor;

    @BeforeEach
    void setUp() {
        mobil = new Mobil("AB 1234 XYZ", "Hitam");
        motor = new Motor("Z 5678 ABC", "Merah");
    }

    @Test
    void testNomorPlat() {
        assertEquals("AB 1234 XYZ", mobil.getNomorPlat());
        assertEquals("Z 5678 ABC", motor.getNomorPlat());
    }

    @Test
    void testPelanggaran() {
        mobil.catatPelanggaran("Melanggar lampu merah");
        motor.catatPelanggaran("Tidak memakai helm");

        assertFalse(mobil.getPelanggaran().isEmpty());
        assertFalse(motor.getPelanggaran().isEmpty());
    }
}

