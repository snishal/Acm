-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 17, 2017 at 11:04 AM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `braingames`
--

-- --------------------------------------------------------

--
-- Table structure for table `game`
--

CREATE TABLE `game` (
  `id` varchar(50) NOT NULL,
  `sudoku_time` time NOT NULL,
  `hitori_time` time NOT NULL,
  `kakuro_time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `game`
--

INSERT INTO `game` (`id`, `sudoku_time`, `hitori_time`, `kakuro_time`) VALUES
('16HCS4446_riya', '00:09:45', '00:14:31', '01:05:12'),
('abhishek_16hcs4402', '00:26:47', '00:39:20', '00:00:00'),
('anjali_16hcs4406', '00:00:00', '00:00:00', '00:00:00'),
('ankit_4103', '00:34:56', '00:40:11', '00:00:00'),
('ankush_16hcs4409', '00:00:00', '00:00:00', '00:00:00'),
('arun_17hcs4104', '00:00:00', '00:00:00', '00:00:00'),
('aryan_4365', '00:00:00', '00:00:00', '00:00:00'),
('ashna_15hcs4309', '00:07:58', '00:17:55', '00:41:44'),
('ashutosh_15hcs4375', '00:00:00', '00:00:00', '00:00:00'),
('ayush_15hcs4370', '00:59:45', '00:00:00', '00:00:00'),
('ayush_16hcs4412', '00:54:07', '01:02:52', '00:00:00'),
('ayush_17hcs4106', '00:34:25', '00:44:47', '00:00:00'),
('deepak_56', '00:15:30', '00:23:37', '00:00:00'),
('deepeeka_1409', '00:00:00', '00:00:00', '00:00:00'),
('Dewansh_4110', '00:00:00', '00:00:00', '00:00:00'),
('divyanshu_16hcs4417', '00:28:40', '00:50:12', '00:00:00'),
('gopika_15hcs4323', '00:08:33', '00:14:01', '00:00:00'),
('jassa_53', '00:29:08', '00:32:25', '00:00:00'),
('kanishka_15hcs4326', '00:09:50', '00:17:21', '00:00:00'),
('lokesh_16hcs4425', '00:17:44', '00:26:50', '00:00:00'),
('manish_4150', '00:06:49', '00:28:53', '00:00:00'),
('mansi_15hcs4321', '00:19:34', '00:51:58', '00:00:00'),
('mayank_16hcs4429', '00:00:00', '00:00:00', '00:00:00'),
('mukul_4123', '00:37:37', '00:50:16', '00:00:00'),
('nikhil_16hcs4436', '00:00:00', '00:00:00', '00:00:00'),
('pooja_15HCS4366', '00:00:00', '00:00:00', '00:00:00'),
('priyanka@16HCS4440', '00:00:00', '00:00:00', '00:00:00'),
('puneet_15hcs4376', '00:00:00', '00:00:00', '00:00:00'),
('raman_16hcs4442', '00:15:40', '00:21:50', '00:00:00'),
('rashi_4157', '00:00:00', '00:00:00', '00:00:00'),
('rdk', '00:00:00', '00:00:00', '00:00:00'),
('Ritwick_16HCS4445', '00:00:00', '00:00:00', '00:00:00'),
('sachin_16hcs4449', '00:00:00', '00:00:00', '00:00:00'),
('sakshi_16hcs4450', '00:24:00', '00:28:27', '00:00:00'),
('saransh_17hcs4135', '00:05:43', '00:16:37', '00:00:00'),
('shivani15hcs4348', '00:00:00', '00:00:00', '00:00:00'),
('tarun_16hcs4460', '00:00:00', '00:00:00', '00:00:00'),
('vicky_16hcs4462', '00:13:46', '00:23:39', '00:00:00'),
('vipin_4043', '00:00:00', '00:00:00', '00:00:00'),
('vipin_4143', '00:09:28', '00:50:26', '00:00:00'),
('vishnu_4144', '00:00:00', '00:00:00', '00:00:00'),
('vivek_15hcs4367', '00:38:40', '00:00:00', '00:00:00'),
('yashdeep_15hcs4382', '00:29:05', '00:40:52', '00:00:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `game`
--
ALTER TABLE `game`
  ADD PRIMARY KEY (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
