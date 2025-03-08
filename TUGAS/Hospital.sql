CREATE DATABASE SistemRumahSakit;
USE SistemRumahSakit;

-- Tabel Pasien
CREATE TABLE Pasien (
    ID_Pasien INT AUTO_INCREMENT PRIMARY KEY,
    Nama_Pasien VARCHAR(100) NOT NULL,
    Alamat TEXT,
    Tanggal_Lahir DATE,
    Jenis_Kelamin ENUM('L', 'P'),
    No_Telepon VARCHAR(15)
);

-- Tabel Dokter
CREATE TABLE Dokter (
    ID_Dokter INT AUTO_INCREMENT PRIMARY KEY,
    Nama_Dokter VARCHAR(100) NOT NULL,
    Spesialisasi VARCHAR(100),
    No_Telepon VARCHAR(15)
);

-- Tabel Rekam Medis
CREATE TABLE Rekam_Medis (
    ID_Rekam_Medis INT AUTO_INCREMENT PRIMARY KEY,
    ID_Pasien INT NOT NULL,
    Tanggal_Catatan DATE NOT NULL,
    Diagnosa TEXT,
    Riwayat_Penyakit TEXT,
    FOREIGN KEY (ID_Pasien) REFERENCES Pasien(ID_Pasien)
);

-- Tabel Jadwal Praktik
CREATE TABLE Jadwal_Praktik (
    ID_Jadwal INT AUTO_INCREMENT PRIMARY KEY,
    ID_Dokter INT NOT NULL,
    Hari ENUM('Senin', 'Selasa', 'Rabu', 'Kamis', 'Jumat', 'Sabtu', 'Minggu'),
    Jam_Mulai TIME,
    Jam_Selesai TIME,
    FOREIGN KEY (ID_Dokter) REFERENCES Dokter(ID_Dokter)
);

-- Tabel Perawat
CREATE TABLE Perawat (
    ID_Perawat INT AUTO_INCREMENT PRIMARY KEY,
    Nama_Perawat VARCHAR(100) NOT NULL,
    No_Telepon VARCHAR(15)
);

-- Tabel Perawat_Rekam (Relasi Many-to-Many)
CREATE TABLE Perawat_Rekam (
    ID_Perawat INT NOT NULL,
    ID_Rekam_Medis INT NOT NULL,
    PRIMARY KEY (ID_Perawat, ID_Rekam_Medis),
    FOREIGN KEY (ID_Perawat) REFERENCES Perawat(ID_Perawat),
    FOREIGN KEY (ID_Rekam_Medis) REFERENCES Rekam_Medis(ID_Rekam_Medis)
);