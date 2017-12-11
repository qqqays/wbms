/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : backend1

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-11 13:39:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for detail
-- ----------------------------
DROP TABLE IF EXISTS `detail`;
CREATE TABLE `detail` (
  `id` varchar(64) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` longtext,
  `clicks` int(11) DEFAULT '0',
  `publisher` varchar(255) DEFAULT NULL,
  `state` tinyint(1) DEFAULT '0',
  `updateTime` datetime DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `bannerImg` varchar(255) DEFAULT NULL,
  `coverImg` varchar(255) DEFAULT NULL,
  `class1` varchar(255) DEFAULT NULL,
  `class2` varchar(255) DEFAULT NULL,
  `class3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of detail
-- ----------------------------

-- ----------------------------
-- Table structure for iframe
-- ----------------------------
DROP TABLE IF EXISTS `iframe`;
CREATE TABLE `iframe` (
  `id` varchar(64) NOT NULL,
  `pid` varchar(64) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `bannerImg` varchar(255) DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `state` tinyint(1) DEFAULT '0',
  `updateTime` datetime DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iframe
-- ----------------------------

-- ----------------------------
-- Table structure for images
-- ----------------------------
DROP TABLE IF EXISTS `images`;
CREATE TABLE `images` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '图片id',
  `name` varchar(255) DEFAULT NULL COMMENT '图片名字',
  `originName` varchar(255) DEFAULT NULL COMMENT '原始名字',
  `alt` varchar(255) DEFAULT NULL COMMENT '未加载图片信息',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `url` varchar(255) DEFAULT NULL COMMENT '图片url',
  `type` varchar(255) DEFAULT NULL COMMENT '图片类型',
  `relativePath` varchar(255) DEFAULT NULL COMMENT '相对路径',
  `absolutePath` varchar(255) DEFAULT '' COMMENT '绝对路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of images
-- ----------------------------

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `menuName` varchar(50) NOT NULL COMMENT '菜单名称',
  `pid` varchar(50) NOT NULL COMMENT '父级菜单ID',
  `url` varchar(255) DEFAULT NULL COMMENT '连接地址',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `deep` int(11) DEFAULT NULL COMMENT '深度',
  `code` varchar(50) DEFAULT NULL COMMENT '编码',
  `display` int(11) DEFAULT NULL COMMENT '展示位置',
  `resource` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `hasSub` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否有子菜单',
  `bannerImg` varchar(255) DEFAULT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('about', '关于我们', 'null', '/about', null, '1', '0', null, '3', null, '1', null, '0');
INSERT INTO `menu` VALUES ('case', '成功案例', 'null', '/case', null, '4', '0', null, '3', null, '0', null, '0');
INSERT INTO `menu` VALUES ('company', '公司新闻', 'news', '/news/company', null, '0', '1', null, '1', null, '0', null, '0');
INSERT INTO `menu` VALUES ('contact', '联系我们', 'null', '/contact', null, '5', '0', null, '3', null, '0', null, '0');
INSERT INTO `menu` VALUES ('foot', '底部菜单', 'null', '/foot', null, '0', '0', null, '2', null, '0', null, '0');
INSERT INTO `menu` VALUES ('index', '首页', 'null', '/index', null, '0', '0', null, '3', null, '0', null, '0');
INSERT INTO `menu` VALUES ('industry', '行业动态', 'news', '/news/industry', null, '0', '1', null, '1', null, '0', null, '0');
INSERT INTO `menu` VALUES ('news', '新闻资讯', 'null', '/news', null, '2', '0', null, '3', null, '1', null, '0');
INSERT INTO `menu` VALUES ('product', '产品中心', 'null', '/product', null, '3', '0', null, '3', null, '0', null, '0');
INSERT INTO `menu` VALUES ('subAbout', '关于子菜单', 'about', '/about/subAbout', null, '0', '1', null, '1', null, '0', null, '0');

-- ----------------------------
-- Table structure for seo
-- ----------------------------
DROP TABLE IF EXISTS `seo`;
CREATE TABLE `seo` (
  `id` varchar(64) NOT NULL,
  `pid` varchar(64) DEFAULT NULL,
  `pageTitle` varchar(255) DEFAULT NULL,
  `keywords` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seo
-- ----------------------------

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
