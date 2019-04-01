/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.15-log : Database - book_manage
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`book_manage` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `book_manage`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` varchar(20) DEFAULT NULL COMMENT '管理员Id',
  `passwd` varchar(100) DEFAULT NULL COMMENT '管理员密码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `admin` */

insert  into `admin`(`id`,`passwd`) values ('20180001',' admin');

/*Table structure for table `book_info` */

DROP TABLE IF EXISTS `book_info`;

CREATE TABLE `book_info` (
  `book_num` varchar(20) NOT NULL COMMENT '图书编号',
  `book_name` varchar(30) NOT NULL COMMENT '图书名',
  `book_cla` varchar(20) DEFAULT NULL COMMENT '图书分类',
  `book_pre` varchar(30) DEFAULT NULL COMMENT '图书出版社',
  `book_all_quan` int(11) DEFAULT '0' COMMENT '图书总数目',
  `book_quan` int(11) DEFAULT '0' COMMENT '可借数目',
  `book_time` datetime DEFAULT NULL COMMENT '出版时间',
  PRIMARY KEY (`book_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `book_info` */

/*Table structure for table `br_stu_info` */

DROP TABLE IF EXISTS `br_stu_info`;

CREATE TABLE `br_stu_info` (
  `lib_card` bigint(20) NOT NULL DEFAULT '0' COMMENT '借书证',
  `book_num` varchar(20) NOT NULL DEFAULT '' COMMENT '图书编号',
  `bro_time` datetime DEFAULT NULL COMMENT '借书时间',
  `rn_deadline` datetime DEFAULT NULL COMMENT '归还期限',
  `rn_time` datetime DEFAULT NULL COMMENT '归还时间',
  PRIMARY KEY (`lib_card`,`book_num`),
  KEY `book_num` (`book_num`),
  CONSTRAINT `br_stu_info_ibfk_1` FOREIGN KEY (`lib_card`) REFERENCES `log_stu_info` (`lib_card`),
  CONSTRAINT `br_stu_info_ibfk_2` FOREIGN KEY (`book_num`) REFERENCES `book_info` (`book_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `br_stu_info` */

/*Table structure for table `br_tea_info` */

DROP TABLE IF EXISTS `br_tea_info`;

CREATE TABLE `br_tea_info` (
  `lib_card` bigint(20) NOT NULL DEFAULT '0' COMMENT '借书证',
  `book_num` varchar(20) NOT NULL DEFAULT '' COMMENT '图书编号',
  `bro_time` datetime DEFAULT NULL COMMENT '借书时间',
  `rn_deadline` datetime DEFAULT NULL COMMENT '归还期限',
  `rn_time` datetime DEFAULT NULL COMMENT '归还时间',
  PRIMARY KEY (`lib_card`,`book_num`),
  KEY `book_num` (`book_num`),
  CONSTRAINT `br_tea_info_ibfk_1` FOREIGN KEY (`lib_card`) REFERENCES `log_tea_info` (`lib_card`),
  CONSTRAINT `br_tea_info_ibfk_2` FOREIGN KEY (`book_num`) REFERENCES `book_info` (`book_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `br_tea_info` */

/*Table structure for table `log_stu_info` */

DROP TABLE IF EXISTS `log_stu_info`;

CREATE TABLE `log_stu_info` (
  `lib_card` bigint(20) NOT NULL COMMENT '借书证号',
  `stu_num` varchar(10) NOT NULL COMMENT '学号',
  `stu_pass` varchar(20) NOT NULL COMMENT '密码',
  PRIMARY KEY (`lib_card`),
  KEY `stu_num` (`stu_num`),
  CONSTRAINT `log_stu_info_ibfk_1` FOREIGN KEY (`stu_num`) REFERENCES `stu_info` (`stu_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `log_stu_info` */

/*Table structure for table `log_tea_info` */

DROP TABLE IF EXISTS `log_tea_info`;

CREATE TABLE `log_tea_info` (
  `lib_card` bigint(20) NOT NULL COMMENT '借书证号',
  `tea_num` varchar(10) NOT NULL COMMENT '职工号',
  `tea_pass` varchar(20) NOT NULL COMMENT '密码',
  PRIMARY KEY (`lib_card`),
  KEY `tea_num` (`tea_num`),
  CONSTRAINT `log_tea_info_ibfk_1` FOREIGN KEY (`tea_num`) REFERENCES `teacher_info` (`tea_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `log_tea_info` */

/*Table structure for table `stu_info` */

DROP TABLE IF EXISTS `stu_info`;

CREATE TABLE `stu_info` (
  `stu_num` varchar(20) NOT NULL COMMENT '学号',
  `stu_name` varchar(12) NOT NULL COMMENT '姓名',
  `stu_college` varchar(20) DEFAULT NULL COMMENT '学院',
  `stu_grade` int(10) DEFAULT NULL COMMENT '年级',
  `stu_delete` tinyint(4) DEFAULT NULL COMMENT '逻辑删除',
  `stu_brnum` varchar(10) DEFAULT NULL COMMENT '已借数量',
  PRIMARY KEY (`stu_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `stu_info` */

/*Table structure for table `sym_man_info` */

DROP TABLE IF EXISTS `sym_man_info`;

CREATE TABLE `sym_man_info` (
  `sym_num` varchar(20) NOT NULL COMMENT '管理员账户',
  `sym_name` varchar(10) NOT NULL COMMENT '管理员名字',
  `sym_pass` varchar(10) NOT NULL DEFAULT '123456' COMMENT '管理员密码',
  PRIMARY KEY (`sym_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `sym_man_info` */

/*Table structure for table `teacher_info` */

DROP TABLE IF EXISTS `teacher_info`;

CREATE TABLE `teacher_info` (
  `tea_num` varchar(20) NOT NULL COMMENT '职工号',
  `tea_name` varchar(12) NOT NULL COMMENT '职工名',
  `tea_college` varchar(20) DEFAULT NULL COMMENT '职工所在学院',
  `tea_delete` tinyint(4) DEFAULT NULL COMMENT '逻辑删除职工',
  PRIMARY KEY (`tea_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `teacher_info` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
