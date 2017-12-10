/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : backend1

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-10 15:30:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for simple_user
-- ----------------------------
DROP TABLE IF EXISTS `simple_user`;
CREATE TABLE `simple_user` (
  `id` varchar(64) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of simple_user
-- ----------------------------
INSERT INTO `simple_user` VALUES ('24b0eb413ad848b9b70ef54ceccc6edb', 'lul', '18');
INSERT INTO `simple_user` VALUES ('291c040e71c14203aed628e3bcc294b4', 'lul', '18');
INSERT INTO `simple_user` VALUES ('3065827952d04c4f98aafaa4e19bff53', 'faudds', '113');
INSERT INTO `simple_user` VALUES ('4a80a2e3cdd7431d8b07317b366a6bbf', 'luguo', '18');
INSERT INTO `simple_user` VALUES ('58f0ce1fb56844a19a828d9cafb4fe08', 'lul', '18');
INSERT INTO `simple_user` VALUES ('5a29c3b1f28144ecb8c3df17fc56698b', 'lul', '18');
INSERT INTO `simple_user` VALUES ('619869cde1bb42778f11f4dd74793dec', 'lul', '18');
INSERT INTO `simple_user` VALUES ('847ead0e987740b997b87b08d93ef624', 'lul', '18');
INSERT INTO `simple_user` VALUES ('8a8114ba39e4453ca33b999f3da8f471', 'luguo', '18');
INSERT INTO `simple_user` VALUES ('a2cff75763ed4546998cb5918159d44a', 'fa', '15');
INSERT INTO `simple_user` VALUES ('a3b529369a0a4ad38dbcf4fe0f23ef92', 'lul', '18');
INSERT INTO `simple_user` VALUES ('c2e7ebdd45c34f67a1b4d3832b8282f4', 'lul', '18');
INSERT INTO `simple_user` VALUES ('c8a9344d7ad245eca1aa9f1f0f112fad', 'lul', '18');
INSERT INTO `simple_user` VALUES ('eb7e3d294e7047a489cc314242abe98d', 'fa', '15');
