/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : camdb

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-07-14 01:40:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for around_info
-- ----------------------------
DROP TABLE IF EXISTS `around_info`;
CREATE TABLE `around_info` (
  `aiid` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `type` varchar(30) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `picUrl` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`aiid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for campus_info
-- ----------------------------
DROP TABLE IF EXISTS `campus_info`;
CREATE TABLE `campus_info` (
  `ciid` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `title` varchar(40) NOT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `picUrl` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`ciid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for cooperation
-- ----------------------------
DROP TABLE IF EXISTS `cooperation`;
CREATE TABLE `cooperation` (
  `cooid` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `picUrl` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `solve` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`cooid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for evaluate
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate` (
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `score` int(1) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `evaPic` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for good
-- ----------------------------
DROP TABLE IF EXISTS `good`;
CREATE TABLE `good` (
  `gid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `userId` int(11) DEFAULT NULL,
  `goodName` varchar(50) NOT NULL,
  `goodDescription` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `goodPic` varchar(255) DEFAULT NULL,
  `goodType` varchar(30) NOT NULL,
  `goodPrice` decimal(5,1) NOT NULL DEFAULT '0.0',
  `goodStock` int(11) DEFAULT '1',
  `enable` tinyint(1) NOT NULL DEFAULT '1',
  `createTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for info_message
-- ----------------------------
DROP TABLE IF EXISTS `info_message`;
CREATE TABLE `info_message` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `cooid` int(11) DEFAULT NULL,
  `aiid` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for lost_property
-- ----------------------------
DROP TABLE IF EXISTS `lost_property`;
CREATE TABLE `lost_property` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `propertyName` varchar(255) NOT NULL,
  `propertyPicture` varchar(255) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `createTime` datetime NOT NULL,
  `findOrLost` tinyint(4) NOT NULL DEFAULT '0',
  `solve` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for orderinfo
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `suserId` int(11) DEFAULT NULL,
  `buserId` int(11) DEFAULT NULL,
  `gid` int(11) DEFAULT NULL,
  `quantity` varchar(255) DEFAULT NULL,
  `seriaNum` varchar(255) DEFAULT NULL,
  `aid` int(11) DEFAULT NULL,
  `total` float DEFAULT NULL,
  `createTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `evaluated` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `rid` int(3) NOT NULL AUTO_INCREMENT,
  `rname` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `loginName` varchar(40) NOT NULL,
  `password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `paypass` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '123456',
  `rid` int(11) NOT NULL DEFAULT '1',
  `sex` tinyint(1) DEFAULT '1',
  `nickName` varchar(40) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `mail` varchar(30) DEFAULT NULL,
  `picturePath` varchar(255) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `enable` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_shopping_address
-- ----------------------------
DROP TABLE IF EXISTS `user_shopping_address`;
CREATE TABLE `user_shopping_address` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `defaulted` tinyint(4) NOT NULL DEFAULT '0',
  `remark` varchar(255) DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
