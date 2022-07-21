-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 20, 2018 at 06:58 AM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cinema`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `idadmin` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `beli`
--

CREATE TABLE `beli` (
  `idpembelian` int(11) NOT NULL,
  `id_studio` int(11) NOT NULL,
  `kodekursi` varchar(3) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `beli`
--

INSERT INTO `beli` (`idpembelian`, `id_studio`, `kodekursi`, `status`) VALUES
(2, 6, 'A1', 'book'),
(3, 6, 'F7', 'book'),
(4, 6, 'F5', 'book'),
(5, 6, 'D8', 'book'),
(6, 6, 'D7', 'book'),
(19, 6, 'D4', 'book'),
(20, 6, 'D5', 'book'),
(21, 6, 'D6', 'book'),
(22, 6, 'E5', 'book'),
(23, 6, 'E6', 'book'),
(26, 6, 'D2', 'book'),
(27, 6, 'F1', 'book'),
(28, 6, 'F1', 'book'),
(29, 6, 'E1', 'book'),
(31, 6, 'D1', 'book'),
(32, 6, 'D1', 'book'),
(37, 8, 'F6', ''),
(38, 9, 'D5', ''),
(39, 10, 'B5', ''),
(40, 7, 'G1', ''),
(41, 10, 'F4', 'book'),
(42, 10, 'B5', 'book'),
(44, 8, 'D6', 'book'),
(45, 8, 'D8', 'book'),
(47, 12, 'A0', 'book'),
(48, 12, 'D8', 'book');

-- --------------------------------------------------------

--
-- Table structure for table `film`
--

CREATE TABLE `film` (
  `idfilm` int(11) NOT NULL,
  `judul` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `film`
--

INSERT INTO `film` (`idfilm`, `judul`) VALUES
(1, 'A Star is Born'),
(2, 'Bohemian Rhapsody'),
(3, 'Spider-Man: into spider-verse'),
(4, 'Bumblebee');

-- --------------------------------------------------------

--
-- Table structure for table `studio`
--

CREATE TABLE `studio` (
  `id_studio` int(11) NOT NULL,
  `Studio` varchar(255) NOT NULL,
  `idfilm` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studio`
--

INSERT INTO `studio` (`id_studio`, `Studio`, `idfilm`) VALUES
(6, 'Reguler', 1),
(7, 'Deluxe', 1),
(8, 'Reguler', 3),
(9, 'Reguler', 2),
(10, 'Deluxe', 4),
(11, 'Reguler', 4),
(12, 'Deluxe', 2);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `kodetransaksi` int(11) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `Studio` varchar(100) NOT NULL,
  `kodekursi` varchar(100) NOT NULL,
  `totalharga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`kodetransaksi`, `judul`, `Studio`, `kodekursi`, `totalharga`) VALUES
(3, 'Spider-Man: into spider-verse', 'Reguler', ' B6', 35000),
(4, 'Bohemian Rhapsody', 'Reguler', ' F1 F2', 90000),
(5, 'Bumblebee', 'Reguler', ' F1', 35000),
(6, 'A Star is Born', 'Reguler', ' F1', 35000),
(7, 'A Star is Born', 'Reguler', ' F1', 35000),
(8, 'A Star is Born', 'Reguler', ' E1', 35000),
(9, 'Bumblebee', 'Reguler', ' D1', 35000),
(10, 'A Star is Born', 'Reguler', ' D1', 35000),
(11, 'A Star is Born', 'Reguler', ' D1', 35000),
(12, 'Bumblebee', 'Deluxe', ' E5', 35000),
(13, 'Bumblebee', 'Deluxe', ' E8', 35000),
(14, 'Spider-Man: into spider-verse', 'Reguler', ' D6 D8', 70000),
(15, 'Bumblebee', 'Reguler', ' D8', 35000),
(16, 'Bohemian Rhapsody', 'Deluxe', ' D8', 35000);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `iduser` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `uname` varchar(100) NOT NULL,
  `pwd` varchar(100) NOT NULL,
  `no_hp` int(12) NOT NULL,
  `gender` enum('L','P') NOT NULL,
  `tanggal` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`iduser`, `nama`, `uname`, `pwd`, `no_hp`, `gender`, `tanggal`) VALUES
(1, 'soyid', 'soyid', 'admin', 888888888, 'L', 240899);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`idadmin`);

--
-- Indexes for table `beli`
--
ALTER TABLE `beli`
  ADD PRIMARY KEY (`idpembelian`),
  ADD KEY `id_studio` (`id_studio`);

--
-- Indexes for table `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`idfilm`);

--
-- Indexes for table `studio`
--
ALTER TABLE `studio`
  ADD PRIMARY KEY (`id_studio`),
  ADD KEY `id_film` (`idfilm`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`kodetransaksi`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`iduser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `idadmin` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `beli`
--
ALTER TABLE `beli`
  MODIFY `idpembelian` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT for table `film`
--
ALTER TABLE `film`
  MODIFY `idfilm` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `studio`
--
ALTER TABLE `studio`
  MODIFY `id_studio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `kodetransaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `beli`
--
ALTER TABLE `beli`
  ADD CONSTRAINT `beli_ibfk_1` FOREIGN KEY (`id_studio`) REFERENCES `studio` (`id_studio`);

--
-- Constraints for table `studio`
--
ALTER TABLE `studio`
  ADD CONSTRAINT `studio_ibfk_1` FOREIGN KEY (`idfilm`) REFERENCES `film` (`idfilm`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
