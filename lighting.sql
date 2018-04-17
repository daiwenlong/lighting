/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : lighting

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-04-17 13:25:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_record_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_record_info`;
CREATE TABLE `t_record_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `weight` double DEFAULT NULL,
  `date` date DEFAULT NULL,
  `user_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_record_info
-- ----------------------------
INSERT INTO `t_record_info` VALUES ('3', '69.2', '2018-04-01', '1001');
INSERT INTO `t_record_info` VALUES ('4', '68.58', '2018-04-02', '1001');
INSERT INTO `t_record_info` VALUES ('5', '68.84', '2018-04-03', '1001');
INSERT INTO `t_record_info` VALUES ('6', '68.93', '2018-04-04', '1001');
INSERT INTO `t_record_info` VALUES ('7', '68.57', '2018-04-05', '1001');
INSERT INTO `t_record_info` VALUES ('8', '68.47', '2018-04-06', '1001');
INSERT INTO `t_record_info` VALUES ('9', '67.99', '2018-04-07', '1001');
INSERT INTO `t_record_info` VALUES ('10', '67.91', '2018-04-08', '1001');
INSERT INTO `t_record_info` VALUES ('11', '69.04', '2018-04-09', '1001');
INSERT INTO `t_record_info` VALUES ('12', '69.39', '2018-04-10', '1001');
INSERT INTO `t_record_info` VALUES ('13', '68.89', '2018-04-11', '1001');
INSERT INTO `t_record_info` VALUES ('14', '68.79', '2018-04-12', '1001');
INSERT INTO `t_record_info` VALUES ('15', '68.57', '2018-04-13', '1001');
INSERT INTO `t_record_info` VALUES ('16', '68.06', '2018-04-14', '1001');
INSERT INTO `t_record_info` VALUES ('19', '67.79', '2018-04-15', '1001');

-- ----------------------------
-- Table structure for `t_user_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info` (
  `user_id` int(11) NOT NULL DEFAULT '0',
  `user_name` varchar(20) DEFAULT NULL,
  `user_pwd` varchar(30) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_info
-- ----------------------------
INSERT INTO `t_user_info` VALUES ('1001', 'daiwenlong', '123456', 's ', 's');
