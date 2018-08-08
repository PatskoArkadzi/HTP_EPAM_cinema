-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               10.1.10-MariaDB - mariadb.org binary distribution
-- Операционная система:         Win32
-- HeidiSQL Версия:              9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Дамп структуры базы данных cinema_v2.0
CREATE DATABASE IF NOT EXISTS `cinema_v2.0` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cinema_v2.0`;

-- Дамп структуры для таблица cinema_v2.0.films
CREATE TABLE IF NOT EXISTS `films` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `filmName` varchar(50) NOT NULL,
  `description` varchar(2000) NOT NULL,
  `posterUrl` varchar(100) NOT NULL,
  `youTubeVideoId` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы cinema_v2.0.films: ~6 rows (приблизительно)
DELETE FROM `films`;
/*!40000 ALTER TABLE `films` DISABLE KEYS */;
INSERT INTO `films` (`id`, `filmName`, `description`, `posterUrl`, `youTubeVideoId`) VALUES
	(1, 'Папа-мама Гусь', 'Пэнг - ничем не ограниченный молодой гусь-холостяк, который сделал бы все что угодно, лишь бы не готовиться к предстоящему перелету. Он считает себя лучше всех и проводит время, пытаясь выполнить сумасшедшие трюки на еще более сумасшедших скоростях. Выполняя один из таких трюков, Пэнг подлетает слишком близко к земле, сталкивается со стаей утят и разлучает брата и сестру, Чао и Чи, с остальными. С этой маловероятной встречи начнется невероятное путешествие Пэнга, в котором он сломает крыло... и едва не разобьет сердце... когда он поймет силу бескорыстной любви на примере двух утят, которые в свою очередь увидят в нем лучшего отца, которого они когда-либо могли иметь. ', 'https://drive.google.com/uc?id=1yaASb0xLUE-SfgFLzzKj7qJf13ix3W0f', '34ClfQttSLA'),
	(2, 'Пчeлка Майя и Кубок мёда', 'Продолжение приключений энергичной и весёлой пчёлки Майя.   На этот раз весь улей взволнован: Императрица послала своего посланника с будоражащей новостью - отныне пчёлам макового луга разрешено принимать участие в Кубке мёда. Однако радость вскоре превращается в разочарование: чтобы состязаться за Кубок, пчёлы должны отдать половину урожая мёда. Решительная Майя вместе со своим другом Вилли отправилась в Шумтрополис, чтобы доказать Императрице её неправоту: близится зима и сёстры Майи очень нуждаются в сладких запасах. Непослушание вызвало гнев повелительницы и она решает дать маленькой пчёлке урок... Единственный способ сохранить весь мед и заслужить императорскую милость - одержать победу в грандиозном спортивном состязании «Медовые игры». Но в команде Майи нет сильных участников, зато противники готовы на всё ради успеха.   ', 'https://drive.google.com/uc?id=15xvAl0DFKpr-HU7qEpwvcGoxREHBbhxj', 'tCNTJid5uKQ'),
	(3, 'Дэдпул 2', 'Выжив после смертоносной атаки быков, изуродованный шеф-повар кафетерия пытается исполнить свою мечту - стать самым горячим барменом в Мэйберри - и в то же время справиться с потерянными вкусовыми ощущениями. Чтобы восстановить остроту чувств, а еще и потоковый накопитель, Уэйд должен будет сразиться с ниндзями, якудзой и стаей сексуально агрессивных собачек, в то время как он объедет весь земной шар и поймет важность семьи, дружбы и вкуса - а заодно обнаружит новую тягу к приключениям и заработает желанную надпись на кружке «Лучший любовник в мире». ', 'https://drive.google.com/uc?id=1maOTPBqT9QP6sLjPj2kEjlwrx5WT6Av3', 'D86RtevtfrA'),
	(4, 'Хан Соло: Звёздные Войны. Истории', 'Фильм расскажет о похождениях юного космического сорвиголовы Хана Соло и его верного напарника Чубакки и о том, как они стали самыми быстрыми пилотами и самыми хитрыми контрабандистами далёкой Галактики. ', 'https://drive.google.com/uc?id=1TSxzzvfLv79bsS4dAh5-5nqCMmj3rKp1', 'jPEYpryMp2s'),
	(5, 'Проект Cinemascope: Огни большого города', 'Маленький Бродяга встречает красивую слепую девушку, торгующую цветами на улице, которая по ошибке принимает его за богатого герцога. Узнав о том, что операция может вернуть ей зрение, маленький Бродяга пускается на поиски денег. ', 'https://drive.google.com/uc?id=1R-jX0IsxiZlgXRpodm2H5RMqrkSmCfq6', 'b2NTUnujk1I'),
	(8, 'Мстители: Война бесконечности', 'Пока Мстители и их союзники продолжают защищать мир от различных опасностей, с которыми не смог бы справиться один супергерой, новая угроза возникает из космоса: Танос. Межгалактический тиран преследует цель собрать все шесть Камней Бесконечности -  артефакты невероятной силы, с помощью которых можно менять реальность по своему желанию. Всё, с чем Мстители сталкивались ранее, вело к этому моменту -  судьба Земли никогда ещё не была столь неопределённой. ', 'https://drive.google.com/uc?id=157z5PWXbBEzKjd09-cbfZup-4HWeZ3Kf', 'QwievZ1Tx-8');
/*!40000 ALTER TABLE `films` ENABLE KEYS */;

-- Дамп структуры для таблица cinema_v2.0.films_genres
CREATE TABLE IF NOT EXISTS `films_genres` (
  `film_id` int(11) NOT NULL,
  `genre_id` int(11) NOT NULL,
  KEY `film_id` (`film_id`),
  KEY `genre_id` (`genre_id`),
  CONSTRAINT `FK_films_genres_films` FOREIGN KEY (`film_id`) REFERENCES `films` (`id`),
  CONSTRAINT `FK_films_genres_genres` FOREIGN KEY (`genre_id`) REFERENCES `genres` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы cinema_v2.0.films_genres: ~22 rows (приблизительно)
DELETE FROM `films_genres`;
/*!40000 ALTER TABLE `films_genres` DISABLE KEYS */;
INSERT INTO `films_genres` (`film_id`, `genre_id`) VALUES
	(1, 2),
	(1, 3),
	(1, 1),
	(1, 4),
	(2, 2),
	(2, 3),
	(2, 4),
	(3, 5),
	(3, 6),
	(3, 7),
	(3, 1),
	(4, 5),
	(4, 6),
	(4, 7),
	(4, 1),
	(5, 9),
	(5, 4),
	(5, 8),
	(8, 5),
	(8, 6),
	(8, 7),
	(8, 1);
/*!40000 ALTER TABLE `films_genres` ENABLE KEYS */;

-- Дамп структуры для таблица cinema_v2.0.genres
CREATE TABLE IF NOT EXISTS `genres` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `genreName` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы cinema_v2.0.genres: ~9 rows (приблизительно)
DELETE FROM `genres`;
/*!40000 ALTER TABLE `genres` DISABLE KEYS */;
INSERT INTO `genres` (`id`, `genreName`) VALUES
	(1, 'Приключения'),
	(2, 'Семейный'),
	(3, 'Мультфильм'),
	(4, 'Комедия'),
	(5, 'Фэнтези'),
	(6, 'Фантастика'),
	(7, 'Боевик'),
	(8, 'Немое кино'),
	(9, 'Мелодрама');
/*!40000 ALTER TABLE `genres` ENABLE KEYS */;

-- Дамп структуры для таблица cinema_v2.0.orders
CREATE TABLE IF NOT EXISTS `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderNumber` int(10) NOT NULL COMMENT 'trigger-generated column',
  `user_id` int(11) NOT NULL,
  `isPaid` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `orderNumber` (`orderNumber`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK_orders_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы cinema_v2.0.orders: ~6 rows (приблизительно)
DELETE FROM `orders`;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` (`id`, `orderNumber`, `user_id`, `isPaid`) VALUES
	(1, 776170, 2, b'0'),
	(2, 745287, 1, b'1'),
	(3, 397928, 4, b'0'),
	(4, 553779, 3, b'1'),
	(13, 300850, 1, b'1'),
	(14, 933849, 1, b'1');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

-- Дамп структуры для таблица cinema_v2.0.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы cinema_v2.0.roles: ~2 rows (приблизительно)
DELETE FROM `roles`;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`id`, `roleName`) VALUES
	(1, 'ROLE_ADMIN'),
	(2, 'ROLE_USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;

-- Дамп структуры для таблица cinema_v2.0.seats
CREATE TABLE IF NOT EXISTS `seats` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `row` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=252 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы cinema_v2.0.seats: ~251 rows (приблизительно)
DELETE FROM `seats`;
/*!40000 ALTER TABLE `seats` DISABLE KEYS */;
INSERT INTO `seats` (`id`, `row`, `number`) VALUES
	(1, 1, 1),
	(2, 1, 2),
	(3, 1, 3),
	(4, 1, 4),
	(5, 1, 5),
	(6, 1, 6),
	(7, 1, 7),
	(8, 1, 8),
	(9, 1, 9),
	(10, 1, 10),
	(11, 1, 11),
	(12, 1, 12),
	(13, 1, 13),
	(14, 1, 14),
	(15, 1, 15),
	(16, 1, 16),
	(17, 1, 17),
	(18, 1, 18),
	(19, 1, 19),
	(20, 1, 20),
	(21, 1, 21),
	(22, 1, 22),
	(23, 1, 23),
	(24, 1, 24),
	(25, 1, 25),
	(26, 2, 1),
	(27, 2, 2),
	(28, 2, 3),
	(29, 2, 4),
	(30, 2, 5),
	(31, 2, 6),
	(32, 2, 7),
	(33, 2, 8),
	(34, 2, 9),
	(35, 2, 10),
	(36, 2, 11),
	(37, 2, 12),
	(38, 2, 13),
	(39, 2, 14),
	(40, 2, 15),
	(41, 2, 16),
	(42, 2, 17),
	(43, 2, 18),
	(44, 2, 19),
	(45, 2, 20),
	(46, 2, 21),
	(47, 2, 22),
	(48, 2, 23),
	(49, 2, 24),
	(50, 2, 25),
	(51, 3, 1),
	(52, 3, 2),
	(53, 3, 3),
	(54, 3, 4),
	(55, 3, 5),
	(56, 3, 6),
	(57, 3, 7),
	(58, 3, 8),
	(59, 3, 9),
	(60, 3, 10),
	(61, 3, 11),
	(62, 3, 12),
	(63, 3, 13),
	(64, 3, 14),
	(65, 3, 15),
	(66, 3, 16),
	(67, 3, 17),
	(68, 3, 18),
	(69, 3, 19),
	(70, 3, 20),
	(71, 3, 21),
	(72, 3, 22),
	(73, 3, 23),
	(74, 3, 24),
	(75, 3, 25),
	(76, 4, 1),
	(77, 4, 2),
	(78, 4, 3),
	(79, 4, 4),
	(80, 4, 5),
	(81, 4, 6),
	(82, 4, 7),
	(83, 4, 8),
	(84, 4, 9),
	(85, 4, 10),
	(86, 4, 11),
	(87, 4, 12),
	(88, 4, 13),
	(89, 4, 14),
	(90, 4, 15),
	(91, 4, 16),
	(92, 4, 17),
	(93, 4, 18),
	(94, 4, 19),
	(95, 4, 20),
	(96, 4, 21),
	(97, 4, 22),
	(98, 4, 23),
	(99, 4, 24),
	(100, 4, 25),
	(101, 5, 1),
	(102, 5, 2),
	(103, 5, 3),
	(104, 5, 4),
	(105, 5, 5),
	(106, 5, 6),
	(107, 5, 7),
	(108, 5, 8),
	(109, 5, 9),
	(110, 5, 10),
	(111, 5, 11),
	(112, 5, 12),
	(113, 5, 13),
	(114, 5, 14),
	(115, 5, 15),
	(116, 5, 16),
	(117, 5, 17),
	(118, 5, 18),
	(119, 5, 19),
	(120, 5, 20),
	(121, 5, 21),
	(122, 5, 22),
	(123, 5, 23),
	(124, 5, 24),
	(125, 5, 25),
	(126, 6, 1),
	(127, 6, 2),
	(128, 6, 3),
	(129, 6, 4),
	(130, 6, 5),
	(131, 6, 6),
	(132, 6, 7),
	(133, 6, 8),
	(134, 6, 9),
	(135, 6, 10),
	(136, 6, 11),
	(137, 6, 12),
	(138, 6, 13),
	(139, 6, 14),
	(140, 6, 15),
	(141, 6, 16),
	(142, 6, 17),
	(143, 6, 18),
	(144, 6, 19),
	(145, 6, 20),
	(146, 6, 21),
	(147, 6, 22),
	(148, 6, 23),
	(149, 6, 24),
	(150, 6, 25),
	(151, 7, 1),
	(152, 7, 2),
	(153, 7, 3),
	(154, 7, 4),
	(155, 7, 5),
	(156, 7, 6),
	(157, 7, 7),
	(158, 7, 8),
	(159, 7, 9),
	(160, 7, 10),
	(161, 7, 11),
	(162, 7, 12),
	(163, 7, 13),
	(164, 7, 14),
	(165, 7, 15),
	(166, 7, 16),
	(167, 7, 17),
	(168, 7, 18),
	(169, 7, 19),
	(170, 7, 20),
	(171, 7, 21),
	(172, 7, 22),
	(173, 7, 23),
	(174, 7, 24),
	(175, 7, 25),
	(176, 8, 1),
	(177, 8, 2),
	(178, 8, 3),
	(179, 8, 4),
	(180, 8, 5),
	(181, 8, 6),
	(182, 8, 7),
	(183, 8, 8),
	(184, 8, 9),
	(185, 8, 10),
	(186, 8, 11),
	(187, 8, 12),
	(188, 8, 13),
	(189, 8, 14),
	(190, 8, 15),
	(191, 8, 16),
	(192, 8, 17),
	(193, 8, 18),
	(194, 8, 19),
	(195, 8, 20),
	(196, 8, 21),
	(197, 8, 22),
	(198, 8, 23),
	(199, 8, 24),
	(200, 8, 25),
	(201, 9, 1),
	(202, 9, 2),
	(203, 9, 3),
	(204, 9, 4),
	(205, 9, 5),
	(206, 9, 6),
	(207, 9, 7),
	(208, 9, 8),
	(209, 9, 9),
	(210, 9, 10),
	(211, 9, 11),
	(212, 9, 12),
	(213, 9, 13),
	(214, 9, 14),
	(215, 9, 15),
	(216, 9, 16),
	(217, 9, 17),
	(218, 9, 18),
	(219, 9, 19),
	(220, 9, 20),
	(221, 9, 21),
	(222, 9, 22),
	(223, 9, 23),
	(224, 9, 24),
	(225, 9, 25),
	(226, 10, 1),
	(227, 10, 2),
	(228, 10, 3),
	(229, 10, 4),
	(230, 10, 5),
	(231, 10, 6),
	(232, 10, 7),
	(233, 10, 8),
	(234, 10, 9),
	(235, 10, 10),
	(236, 10, 11),
	(237, 10, 12),
	(238, 10, 13),
	(239, 10, 14),
	(240, 10, 15),
	(241, 10, 16),
	(242, 10, 17),
	(243, 10, 18),
	(244, 10, 19),
	(245, 10, 20),
	(246, 10, 21),
	(247, 10, 22),
	(248, 10, 23),
	(249, 10, 24),
	(250, 10, 25),
	(251, 12, 10);
/*!40000 ALTER TABLE `seats` ENABLE KEYS */;

-- Дамп структуры для таблица cinema_v2.0.sessions
CREATE TABLE IF NOT EXISTS `sessions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `film_id` int(11) NOT NULL,
  `date` varchar(50) NOT NULL,
  `time` varchar(50) NOT NULL,
  `ticketPrice` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `film_id` (`film_id`),
  CONSTRAINT `FK_film_sessions_films` FOREIGN KEY (`film_id`) REFERENCES `films` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='киносеансы';

-- Дамп данных таблицы cinema_v2.0.sessions: ~7 rows (приблизительно)
DELETE FROM `sessions`;
/*!40000 ALTER TABLE `sessions` DISABLE KEYS */;
INSERT INTO `sessions` (`id`, `film_id`, `date`, `time`, `ticketPrice`) VALUES
	(1, 1, '2018-07-06', '11:00', 5.20),
	(2, 1, '2018-07-07', '11:00', 5.00),
	(3, 1, '2018-07-08', '11:00', 5.00),
	(4, 1, '2018-07-09', '11:00', 5.00),
	(5, 1, '2018-07-12', '11:20', 5.20),
	(6, 1, '2018-07-13', '11:20', 5.20),
	(7, 2, '2018-07-10', '12:00', 5.00);
/*!40000 ALTER TABLE `sessions` ENABLE KEYS */;

-- Дамп структуры для таблица cinema_v2.0.tickets
CREATE TABLE IF NOT EXISTS `tickets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `session_id` int(11) NOT NULL,
  `seat_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `seat_id` (`seat_id`),
  KEY `session_id` (`session_id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `FK_tickets_orders` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_tickets_seats` FOREIGN KEY (`seat_id`) REFERENCES `seats` (`id`),
  CONSTRAINT `FK_tickets_sessions` FOREIGN KEY (`session_id`) REFERENCES `sessions` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы cinema_v2.0.tickets: ~11 rows (приблизительно)
DELETE FROM `tickets`;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
INSERT INTO `tickets` (`id`, `session_id`, `seat_id`, `order_id`) VALUES
	(3, 2, 5, 2),
	(25, 6, 1, 3),
	(26, 6, 2, 3),
	(27, 6, 3, 4),
	(28, 6, 4, 4),
	(29, 6, 251, 2),
	(31, 6, 5, 4),
	(32, 6, 6, 3),
	(51, 6, 250, 13),
	(52, 6, 249, 14),
	(53, 6, 248, 14);
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;

-- Дамп структуры для таблица cinema_v2.0.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login`),
  KEY `roles_id` (`role_id`),
  CONSTRAINT `FK_users_roles` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы cinema_v2.0.users: ~4 rows (приблизительно)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `login`, `email`, `password`, `role_id`) VALUES
	(1, 'admin', 'admin@admin.com', 'password', 1),
	(2, 'user1', 'user1@user.com', 'qwerty', 2),
	(3, 'user2', 'user2@user.com', '12345', 2),
	(4, 'user3', 'user3@user.com', '54321', 2);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Дамп структуры для триггер cinema_v2.0.generate orderNumber
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';
DELIMITER //
CREATE TRIGGER `generate orderNumber` BEFORE INSERT ON `orders` FOR EACH ROW BEGIN
	SET NEW.orderNumber = (RAND()*(999999-100000)+100000);
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;