-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 03, 2023 at 06:27 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `chatbot`
--

-- --------------------------------------------------------

--
-- Table structure for table `chats`
--

CREATE TABLE `chats` (
  `id` char(7) NOT NULL,
  `category` char(1) NOT NULL,
  `sender` varchar(16) NOT NULL,
  `message` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chats`
--

INSERT INTO `chats` (`id`, `category`, `sender`, `message`, `created_at`) VALUES
('AKS070F', 'I', 'mikamikazuki', 'Halo', '2023-07-03 03:35:13'),
('BKP709V', 'I', 'mikamikazuki', 'I', '2023-07-03 03:35:31'),
('BLU219C', 'O', 'Wahyu Bagus', 'Maaf, Keyword tidak terdaftar', '2023-07-03 03:35:32'),
('DGN759G', 'I', 'mikamikazuki', '/register', '2023-06-25 12:26:24'),
('DIG438Z', 'B', 'admin', 'tes', '2023-06-25 12:28:40'),
('DPN279Q', 'O', 'admin', 'Maaf, Keyword tidak terdaftar', '2023-06-25 12:27:55'),
('DWA932Z', 'O', 'admin', 'Kamu sudah terdaftar, ga usah daftar lagi !', '2023-06-25 12:38:45'),
('EPU003Y', 'I', 'mikamikazuki', 'hallo', '2023-06-25 12:27:39'),
('FCB388C', 'I', 'mikamikazuki', '/start', '2023-06-25 12:26:17'),
('FGT608P', 'I', 'mikamikazuki', 'Tes', '2023-07-03 03:38:09'),
('GLK277N', 'O', 'admin', 'Register gagal gan, maap :(', '2023-06-25 12:26:25'),
('GVG872J', 'O', 'admin', '/register dulu gan !', '2023-06-25 12:26:16'),
('IHA182Z', 'I', 'mikamikazuki', 'Ping', '2023-06-25 12:47:40'),
('IWZ360G', 'O', 'admin', '/register dulu gan !', '2023-06-25 12:26:15'),
('JKI308P', 'O', 'admin', 'Maaf, Keyword tidak terdaftar', '2023-06-25 12:35:54'),
('JKX430I', 'I', 'mikamikazuki', 'Tes', '2023-07-03 03:33:52'),
('JOH002B', 'I', 'mikamikazuki', '/register', '2023-07-03 03:38:05'),
('KHC723W', 'O', 'Wahyu Bagus', 'Maaf, Keyword tidak terdaftar', '2023-07-03 03:35:06'),
('LOZ120B', 'O', 'Wahyu Bagus', 'tes diterima', '2023-07-03 03:38:10'),
('LSG085D', 'O', 'admin', 'Sending Hug', '2023-06-25 12:47:41'),
('MKI246B', 'I', 'mikamikazuki', 'Hallo', '2023-07-03 03:35:16'),
('MXA767A', 'I', 'mikamikazuki', '/member', '2023-06-25 12:27:54'),
('MZD512T', 'O', 'admin', 'hi', '2023-06-25 12:27:39'),
('NFF309I', 'O', 'admin', 'response sudah diupdate', '2023-06-25 12:27:24'),
('NZH609A', 'O', 'Wahyu Bagus', 'tes diterima', '2023-07-03 03:33:53'),
('ONY096R', 'O', 'admin', 'Register berhasil gan, selamat!', '2023-06-25 12:27:09'),
('OUX411Z', 'B', 'Wahyu Bagus', 'Tes broadcast chat', '2023-07-03 03:32:56'),
('PCX001D', 'O', 'admin', '/register dulu gan !', '2023-06-25 12:26:18'),
('PFD414J', 'I', 'mikamikazuki', '/start', '2023-06-25 12:26:16'),
('PUC697A', 'O', 'Wahyu Bagus', 'tes diterima', '2023-07-03 03:35:29'),
('PWE805O', 'I', 'mikamikazuki', '/register', '2023-06-25 12:38:44'),
('QJY971F', 'I', 'mikamikazuki', '/register', '2023-06-25 12:27:07'),
('RMJ853B', 'O', 'admin', 'Kamu sudah terdaftar, ga usah daftar lagi !', '2023-06-25 12:36:04'),
('RQG976M', 'O', 'Wahyu Bagus', 'Maaf, Keyword tidak terdaftar', '2023-07-03 03:34:51'),
('SJJ677Z', 'O', 'admin', 'response sudah diupdate', '2023-06-25 12:27:17'),
('SRA466V', 'I', 'mikamikazuki', '/start', '2023-07-03 03:34:51'),
('TGU879A', 'I', 'mikamikazuki', 'hi', '2023-06-25 12:27:16'),
('TRV599F', 'I', 'mikamikazuki', '/start', '2023-07-03 03:38:00'),
('TWW173H', 'O', 'admin', 'Kamu sudah terdaftar, ga usah daftar lagi !', '2023-06-25 12:40:47'),
('TZZ583M', 'O', 'Wahyu Bagus', 'Maaf, Keyword tidak terdaftar', '2023-07-03 03:35:13'),
('UGA480Y', 'O', 'Wahyu Bagus', 'Register berhasil!', '2023-07-03 03:38:05'),
('UXA800V', 'I', 'mikamikazuki', '/start', '2023-07-03 03:35:05'),
('VVW946Z', 'O', 'admin', '/register dulu gan !', '2023-06-25 12:26:18'),
('WTA860L', 'O', 'Wahyu Bagus', 'Hallo', '2023-07-03 03:35:16'),
('XEP826H', 'O', 'Wahyu Bagus', 'Silahkan /register dulu !', '2023-07-03 03:38:01'),
('XIP656L', 'I', 'mikamikazuki', '/start', '2023-06-25 12:35:53'),
('XLH753Y', 'I', 'mikamikazuki', '/start', '2023-06-25 12:26:14'),
('YDD566K', 'I', 'mikamikazuki', '/register', '2023-06-25 12:40:46'),
('YFH240R', 'I', 'mikamikazuki', '/register', '2023-06-25 12:36:04'),
('YZQ512K', 'I', 'mikamikazuki', 'Hi', '2023-06-25 12:26:18'),
('ZCC252R', 'I', 'mikamikazuki', 'Tes', '2023-07-03 03:35:29'),
('ZVI126W', 'I', 'mikamikazuki', 'hi', '2023-06-25 12:27:23');

-- --------------------------------------------------------

--
-- Table structure for table `keywords`
--

CREATE TABLE `keywords` (
  `id` char(7) NOT NULL,
  `keyword` varchar(50) NOT NULL,
  `response` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `keywords`
--

INSERT INTO `keywords` (`id`, `keyword`, `response`) VALUES
('AZT633O', 'Tes', 'tes diterima'),
('BKW046M', 'hallo', 'Hallo'),
('OTF334R', 'hi', 'Hi'),
('PXN300E', 'Ping', 'Sending Hug');

-- --------------------------------------------------------

--
-- Table structure for table `members`
--

CREATE TABLE `members` (
  `id` char(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `members`
--

INSERT INTO `members` (`id`, `name`, `username`) VALUES
('1051877448', 'mika mika', 'mikamikazuki');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` char(7) NOT NULL,
  `name` varchar(50) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `username`, `password`) VALUES
('12JKDFR', 'Admin', 'admin', '123'),
('ADT774U', 'Wahyu Bagus', 'Wahyu Bagus', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chats`
--
ALTER TABLE `chats`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `keywords`
--
ALTER TABLE `keywords`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `keyword` (`keyword`);

--
-- Indexes for table `members`
--
ALTER TABLE `members`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
