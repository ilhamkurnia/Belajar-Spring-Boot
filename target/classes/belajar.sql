-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 09, 2019 at 06:17 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `belajar`
--

-- --------------------------------------------------------

--
-- Table structure for table `table_dosen`
--

CREATE TABLE `table_dosen` (
  `idDosen` int(11) NOT NULL,
  `nameDosen` varchar(200) NOT NULL,
  `addressDosen` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `table_dosen`
--

INSERT INTO `table_dosen` (`idDosen`, `nameDosen`, `addressDosen`) VALUES
(10023295, 'mas kenda', 'jalan cempaka'),
(10023297, 'sad', 'sdas'),
(10023298, 'sad', 'sdsad');

-- --------------------------------------------------------

--
-- Table structure for table `table_krs`
--

CREATE TABLE `table_krs` (
  `idKrs` int(11) NOT NULL,
  `nameJurusan` varchar(200) NOT NULL,
  `nameFakultas` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `table_krs`
--

INSERT INTO `table_krs` (`idKrs`, `nameJurusan`, `nameFakultas`) VALUES
(121217, 'ekonomi', 'fipps');

-- --------------------------------------------------------

--
-- Table structure for table `table_profile`
--

CREATE TABLE `table_profile` (
  `namaLengkap` varchar(200) DEFAULT NULL,
  `alamat` varchar(200) DEFAULT NULL,
  `umur` varchar(200) DEFAULT NULL,
  `jk` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `table_profile`
--

INSERT INTO `table_profile` (`namaLengkap`, `alamat`, `umur`, `jk`) VALUES
('ilham kurnia', 'sad', '20', 'Pria');

-- --------------------------------------------------------

--
-- Table structure for table `table_student`
--

CREATE TABLE `table_student` (
  `idStudent` int(11) NOT NULL,
  `nameStudent` varchar(200) DEFAULT NULL,
  `addressStudent` varchar(200) DEFAULT NULL,
  `namaJurusan` varchar(200) DEFAULT NULL,
  `fakultas` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `id` int(11) NOT NULL,
  `username` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `profile_name` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`id`, `username`, `password`, `email`, `profile_name`) VALUES
(3, 'ilham', 'cintafina', 'sadas', NULL),
(4, 'sadassada', 'sadas', 'asdas', 'asdas'),
(5, 'sadassada', 'sadas', 'asdas', 'asdas'),
(6, 'tes', 'tes', 'tes', 'tes'),
(7, 'ikurnia97', 'adsasa', 'sad', 'sad'),
(8, 'rio', 'asd', 'sdsd', 'sad');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `table_dosen`
--
ALTER TABLE `table_dosen`
  ADD PRIMARY KEY (`idDosen`);

--
-- Indexes for table `table_krs`
--
ALTER TABLE `table_krs`
  ADD PRIMARY KEY (`idKrs`);

--
-- Indexes for table `table_student`
--
ALTER TABLE `table_student`
  ADD PRIMARY KEY (`idStudent`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `table_dosen`
--
ALTER TABLE `table_dosen`
  MODIFY `idDosen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10023299;

--
-- AUTO_INCREMENT for table `table_krs`
--
ALTER TABLE `table_krs`
  MODIFY `idKrs` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=121218;

--
-- AUTO_INCREMENT for table `table_student`
--
ALTER TABLE `table_student`
  MODIFY `idStudent` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
