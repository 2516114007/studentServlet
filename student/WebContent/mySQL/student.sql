/*
Navicat MySQL Data Transfer

Source Server         : mySql
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : student

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-01-10 20:42:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `stu`
-- ----------------------------
DROP TABLE IF EXISTS `stu`;
CREATE TABLE `stu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(255) NOT NULL,
  `gender` char(255) NOT NULL,
  `phone` char(255) DEFAULT NULL,
  `birthday` char(255) DEFAULT NULL,
  `hobby` char(255) DEFAULT NULL,
  `info` char(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu
-- ----------------------------
INSERT INTO `stu` VALUES ('1', 'ChaoJun', '男', '18328685560', '1996-07-02', '游泳', '111');
INSERT INTO `stu` VALUES ('2', 'Xia', '女', '18280420166', '1996-08-16', '吃', '222');
INSERT INTO `stu` VALUES ('18', '霞', '女', '182', '0816', '看书', '2货');
INSERT INTO `stu` VALUES ('19', '樊朝军', '男', '183', '0702', '游泳', '到达');
INSERT INTO `stu` VALUES ('20', '樊朝军', '男', '183', '0702', '游泳', 'dfdf');
