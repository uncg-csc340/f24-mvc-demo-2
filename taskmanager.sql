-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 10, 2024 at 01:15 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `taskmanager`
--

-- --------------------------------------------------------

--
-- Table structure for table `goals`
--

CREATE TABLE `goals` (
  `goal_id` int(11) NOT NULL,
  `details` varchar(255) DEFAULT NULL,
  `status` tinyint(4) NOT NULL,
  `target_date` date NOT NULL,
  `title` varchar(255) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `goals`
--

INSERT INTO `goals` (`goal_id`, `details`, `status`, `target_date`, `title`, `user_id`) VALUES
(1, 'Get it done', 1, '2024-11-30', 'Learn Frontend Dev', 1),
(2, 'You have 1 month', 1, '2024-11-10', 'Prepare for trip', 2),
(3, 'Due in a week', 0, '2024-10-17', 'Do Homework', 1);

-- --------------------------------------------------------

--
-- Table structure for table `goals_seq`
--

CREATE TABLE `goals_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `goals_seq`
--

INSERT INTO `goals_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Table structure for table `tasks`
--

CREATE TABLE `tasks` (
  `task_id` int(11) NOT NULL,
  `details` varchar(255) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `goal_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tasks`
--

INSERT INTO `tasks` (`task_id`, `details`, `status`, `title`, `goal_id`) VALUES
(1, 'Find tutorials', 2, 'Learn HTML', 1),
(2, 'Sign up for freecodeworld', 1, 'Learn CSS', 1),
(3, 'review notes', 0, 'Learn JS', 1),
(4, 'Do you know where it is?', 2, 'Locate passport', 2),
(5, 'Dust it off', 1, 'Luggage', 2),
(6, 'Book it', 0, 'Hotel', 2),
(7, 'Make reservations', 0, 'Pet Care', 2),
(8, 'Basic setup', 1, 'Steps 1 thru 4', 3);

-- --------------------------------------------------------

--
-- Table structure for table `tasks_seq`
--

CREATE TABLE `tasks_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tasks_seq`
--

INSERT INTO `tasks_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `role`, `user_name`) VALUES
(1, 'al@test.com', 'USER', 'alBeback'),
(2, 'pete@test.com', 'ADMIN', 'peteCzar'),
(3, 'sum@test.com', 'USER', 'sumTingWong'),
(4, 'rudy@test.com', 'VENDOR', 'rudy');

-- --------------------------------------------------------

--
-- Table structure for table `users_seq`
--

CREATE TABLE `users_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users_seq`
--

INSERT INTO `users_seq` (`next_val`) VALUES
(101);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `goals`
--
ALTER TABLE `goals`
  ADD PRIMARY KEY (`goal_id`),
  ADD KEY `FKb1mp6ulyqkpcw6bc1a2mr7v1g` (`user_id`);

--
-- Indexes for table `tasks`
--
ALTER TABLE `tasks`
  ADD PRIMARY KEY (`task_id`),
  ADD KEY `FKacjm73w3vfy4x7gj42hd1ltkb` (`goal_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `goals`
--
ALTER TABLE `goals`
  ADD CONSTRAINT `FKb1mp6ulyqkpcw6bc1a2mr7v1g` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `tasks`
--
ALTER TABLE `tasks`
  ADD CONSTRAINT `FKacjm73w3vfy4x7gj42hd1ltkb` FOREIGN KEY (`goal_id`) REFERENCES `goals` (`goal_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
