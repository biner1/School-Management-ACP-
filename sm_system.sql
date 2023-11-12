-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 29, 2022 at 02:41 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sm_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `exam`
--

CREATE TABLE `exam` (
  `id` int(8) NOT NULL,
  `subjectID` int(8) NOT NULL,
  `examDesc` varchar(300) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `exammark`
--

CREATE TABLE `exammark` (
  `id` int(8) NOT NULL,
  `studentID` int(8) NOT NULL,
  `examID` int(8) NOT NULL,
  `mark` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `grade`
--

CREATE TABLE `grade` (
  `id` int(8) NOT NULL,
  `name` varchar(10) NOT NULL,
  `year` year(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `grade`
--

INSERT INTO `grade` (`id`, `name`, `year`) VALUES
(1, '1a', 2000),
(3, '1b', 2000);

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `id` int(8) NOT NULL,
  `subjectID` int(8) NOT NULL,
  `gradeID` int(8) NOT NULL,
  `teacherID` int(8) NOT NULL,
  `time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `id` int(8) NOT NULL,
  `username` varchar(255) NOT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `gender` enum('male','female') NOT NULL,
  `birthdate` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `address` varchar(400) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `password` varchar(30) DEFAULT NULL,
  `salary` int(10) NOT NULL,
  `role` enum('ADMIN','TEACHER','ACCOUNTANT') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`id`, `username`, `fullname`, `gender`, `birthdate`, `email`, `address`, `phone`, `password`, `salary`, `role`) VALUES
(2, 'biner', 'biner omer', 'male', '2000-01-01', 'biner@biner.com', 'halabja', '7501111111', 'password', 900000, 'ADMIN'),
(3, 'accountant', 'accountant', 'male', '2000-11-10', 'acc@acc.com', 'erbil', '7501111111', 'password', 90000, 'ACCOUNTANT'),
(5, 'admin', NULL, 'male', '2000-03-03', 'admin', 'admin', '07501111111', 'admin', 900000, 'ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `staffattendance`
--

CREATE TABLE `staffattendance` (
  `id` int(8) NOT NULL,
  `date` date NOT NULL,
  `status` enum('present','absent','permitted') NOT NULL,
  `staffID` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `staffpayment`
--

CREATE TABLE `staffpayment` (
  `id` int(8) NOT NULL,
  `staffID` int(8) NOT NULL,
  `salary` int(10) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` int(8) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `gender` enum('male','female') NOT NULL,
  `birthdate` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `address` varchar(400) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `password` varchar(30) DEFAULT NULL,
  `gradeID` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `username`, `fullname`, `gender`, `birthdate`, `email`, `address`, `phone`, `password`, `gradeID`) VALUES
(3, 'hama', NULL, 'male', '2000-11-11', 'hama', 'hama', 'hama', 'password', 1),
(7, 'ali', 'hama hama', 'male', '2222-11-11', 'hama@hama.com', 'slemani', '11111111', 'password', 1),
(9, NULL, 'reba reba', 'male', '2222-11-11', 'rebabab', 'eeeeee', '867867867', 'password', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `studentattendance`
--

CREATE TABLE `studentattendance` (
  `id` int(8) NOT NULL,
  `date` date NOT NULL,
  `status` enum('present','absent','permitted') NOT NULL,
  `studentID` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `studentpayment`
--

CREATE TABLE `studentpayment` (
  `id` int(8) NOT NULL,
  `studentID` int(8) NOT NULL,
  `amount` int(10) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `id` int(8) NOT NULL,
  `name` varchar(255) NOT NULL,
  `teacherID` int(8) NOT NULL,
  `gradeID` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `exam`
--
ALTER TABLE `exam`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `subjectID` (`subjectID`);

--
-- Indexes for table `exammark`
--
ALTER TABLE `exammark`
  ADD PRIMARY KEY (`id`),
  ADD KEY `studentID` (`studentID`),
  ADD KEY `examID` (`examID`);

--
-- Indexes for table `grade`
--
ALTER TABLE `grade`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`id`),
  ADD KEY `gradeID` (`gradeID`),
  ADD KEY `subjectID` (`subjectID`),
  ADD KEY `teacherID` (`teacherID`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `staffattendance`
--
ALTER TABLE `staffattendance`
  ADD PRIMARY KEY (`id`),
  ADD KEY `staffID` (`staffID`);

--
-- Indexes for table `staffpayment`
--
ALTER TABLE `staffpayment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `staffID` (`staffID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD KEY `gradeID` (`gradeID`);

--
-- Indexes for table `studentattendance`
--
ALTER TABLE `studentattendance`
  ADD PRIMARY KEY (`id`),
  ADD KEY `studentID` (`studentID`);

--
-- Indexes for table `studentpayment`
--
ALTER TABLE `studentpayment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `studentID` (`studentID`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `gradeID` (`gradeID`) USING BTREE,
  ADD UNIQUE KEY `teacherID` (`teacherID`) USING BTREE;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `exam`
--
ALTER TABLE `exam`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `exammark`
--
ALTER TABLE `exammark`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `grade`
--
ALTER TABLE `grade`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `schedule`
--
ALTER TABLE `schedule`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `staffattendance`
--
ALTER TABLE `staffattendance`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `staffpayment`
--
ALTER TABLE `staffpayment`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `studentattendance`
--
ALTER TABLE `studentattendance`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `studentpayment`
--
ALTER TABLE `studentpayment`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `exam`
--
ALTER TABLE `exam`
  ADD CONSTRAINT `exam_ibfk_1` FOREIGN KEY (`subjectID`) REFERENCES `subject` (`id`);

--
-- Constraints for table `exammark`
--
ALTER TABLE `exammark`
  ADD CONSTRAINT `exammark_ibfk_1` FOREIGN KEY (`examID`) REFERENCES `exam` (`id`),
  ADD CONSTRAINT `exammark_ibfk_2` FOREIGN KEY (`studentID`) REFERENCES `student` (`id`);

--
-- Constraints for table `schedule`
--
ALTER TABLE `schedule`
  ADD CONSTRAINT `schedule_ibfk_1` FOREIGN KEY (`subjectID`) REFERENCES `subject` (`id`),
  ADD CONSTRAINT `schedule_ibfk_2` FOREIGN KEY (`gradeID`) REFERENCES `grade` (`id`),
  ADD CONSTRAINT `schedule_ibfk_3` FOREIGN KEY (`teacherID`) REFERENCES `staff` (`id`);

--
-- Constraints for table `staffattendance`
--
ALTER TABLE `staffattendance`
  ADD CONSTRAINT `staffattendance_ibfk_1` FOREIGN KEY (`staffID`) REFERENCES `staff` (`id`);

--
-- Constraints for table `staffpayment`
--
ALTER TABLE `staffpayment`
  ADD CONSTRAINT `staffpayment_ibfk_1` FOREIGN KEY (`staffID`) REFERENCES `staff` (`id`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`gradeID`) REFERENCES `grade` (`id`) ON DELETE SET NULL;

--
-- Constraints for table `studentattendance`
--
ALTER TABLE `studentattendance`
  ADD CONSTRAINT `studentattendance_ibfk_1` FOREIGN KEY (`studentID`) REFERENCES `student` (`id`);

--
-- Constraints for table `studentpayment`
--
ALTER TABLE `studentpayment`
  ADD CONSTRAINT `studentpayment_ibfk_1` FOREIGN KEY (`studentID`) REFERENCES `student` (`id`);

--
-- Constraints for table `subject`
--
ALTER TABLE `subject`
  ADD CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`teacherID`) REFERENCES `staff` (`id`),
  ADD CONSTRAINT `subject_ibfk_2` FOREIGN KEY (`gradeID`) REFERENCES `grade` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
