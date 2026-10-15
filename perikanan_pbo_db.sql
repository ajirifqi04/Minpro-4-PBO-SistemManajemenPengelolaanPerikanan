-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Oct 13, 2026 at 08:53 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perikanan_pbo_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `hasil_penangkapan`
--

CREATE TABLE `hasil_penangkapan` (
  `id_hasil` varchar(10) NOT NULL,
  `id_ikan` int NOT NULL,
  `tanggal` varchar(20) NOT NULL,
  `kondisi` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `hasil_penangkapan`
--

INSERT INTO `hasil_penangkapan` (`id_hasil`, `id_ikan`, `tanggal`, `kondisi`) VALUES
('HP001', 1, '20-09-2026', 'Hasil baik'),
('HP002', 2, '21-09-2026', 'Hasil baik');

-- --------------------------------------------------------

--
-- Table structure for table `ikan`
--

CREATE TABLE `ikan` (
  `id_ikan` int NOT NULL,
  `nama_ikan` varchar(100) NOT NULL,
  `jenis_ikan` varchar(30) NOT NULL,
  `jumlah_stok` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `ikan`
--

INSERT INTO `ikan` (`id_ikan`, `nama_ikan`, `jenis_ikan`, `jumlah_stok`) VALUES
(1, 'Ikan Tuna', 'Konsumsi', 50),
(2, 'Ikan Lele', 'Budidaya', 30);

-- --------------------------------------------------------

--
-- Table structure for table `ikan_air_tawar`
--

CREATE TABLE `ikan_air_tawar` (
  `id_ikan` int NOT NULL,
  `nama_ikan` varchar(100) NOT NULL,
  `jenis_ikan` varchar(30) NOT NULL,
  `jumlah_stok` int NOT NULL,
  `jenis_perairan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `ikan_air_tawar`
--

INSERT INTO `ikan_air_tawar` (`id_ikan`, `nama_ikan`, `jenis_ikan`, `jumlah_stok`, `jenis_perairan`) VALUES
(2, 'Ikan Lele', 'Budidaya', 30, 'Air Tawar');

-- --------------------------------------------------------

--
-- Table structure for table `ikan_laut`
--

CREATE TABLE `ikan_laut` (
  `id_ikan` int NOT NULL,
  `nama_ikan` varchar(100) NOT NULL,
  `jenis_ikan` varchar(30) NOT NULL,
  `jumlah_stok` int NOT NULL,
  `kedalaman_habitat` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `ikan_laut`
--

INSERT INTO `ikan_laut` (`id_ikan`, `nama_ikan`, `jenis_ikan`, `jumlah_stok`, `kedalaman_habitat`) VALUES
(1, 'Ikan Tuna', 'Konsumsi', 50, 100);

-- --------------------------------------------------------

--
-- Table structure for table `lokasi_penangkapan`
--

CREATE TABLE `lokasi_penangkapan` (
  `id_lokasi` varchar(10) NOT NULL,
  `id_ikan` int NOT NULL,
  `nama_lokasi` varchar(100) NOT NULL,
  `wilayah` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `lokasi_penangkapan`
--

INSERT INTO `lokasi_penangkapan` (`id_lokasi`, `id_ikan`, `nama_lokasi`, `wilayah`) VALUES
('LK001', 1, 'Laut Samarinda', 'Kalimantan Timur'),
('LK002', 2, 'Kolam Budidaya Lele', 'Kalimantan Timur');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hasil_penangkapan`
--
ALTER TABLE `hasil_penangkapan`
  ADD PRIMARY KEY (`id_hasil`),
  ADD KEY `id_ikan` (`id_ikan`);

--
-- Indexes for table `ikan`
--
ALTER TABLE `ikan`
  ADD PRIMARY KEY (`id_ikan`);

--
-- Indexes for table `ikan_air_tawar`
--
ALTER TABLE `ikan_air_tawar`
  ADD PRIMARY KEY (`id_ikan`);

--
-- Indexes for table `ikan_laut`
--
ALTER TABLE `ikan_laut`
  ADD PRIMARY KEY (`id_ikan`);

--
-- Indexes for table `lokasi_penangkapan`
--
ALTER TABLE `lokasi_penangkapan`
  ADD PRIMARY KEY (`id_lokasi`),
  ADD KEY `id_ikan` (`id_ikan`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `hasil_penangkapan`
--
ALTER TABLE `hasil_penangkapan`
  ADD CONSTRAINT `hasil_penangkapan_ibfk_1` FOREIGN KEY (`id_ikan`) REFERENCES `ikan` (`id_ikan`);

--
-- Constraints for table `ikan_air_tawar`
--
ALTER TABLE `ikan_air_tawar`
  ADD CONSTRAINT `ikan_air_tawar_ibfk_1` FOREIGN KEY (`id_ikan`) REFERENCES `ikan` (`id_ikan`);

--
-- Constraints for table `ikan_laut`
--
ALTER TABLE `ikan_laut`
  ADD CONSTRAINT `ikan_laut_ibfk_1` FOREIGN KEY (`id_ikan`) REFERENCES `ikan` (`id_ikan`);

--
-- Constraints for table `lokasi_penangkapan`
--
ALTER TABLE `lokasi_penangkapan`
  ADD CONSTRAINT `lokasi_penangkapan_ibfk_1` FOREIGN KEY (`id_ikan`) REFERENCES `ikan` (`id_ikan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
