/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : backend1

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-10 17:36:00
*/

SET FOREIGN_KEY_CHECKS=0;

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
INSERT INTO `menu` VALUES ('companynews', '公司新闻', 'news', '/news/company', null, '0', '1', null, '1', null, '0', null, '0');
INSERT INTO `menu` VALUES ('contact', '联系我们', 'null', '/contact', null, '5', '0', null, '3', null, '0', null, '0');
INSERT INTO `menu` VALUES ('index', '首页', 'null', '/index', null, '0', '0', null, '3', null, '0', null, '0');
INSERT INTO `menu` VALUES ('industrynews', '行业动态', 'news', '/news/industry', null, '0', '1', null, '1', null, '0', null, '0');
INSERT INTO `menu` VALUES ('news', '新闻资讯', 'null', '/news', null, '2', '0', null, '3', null, '1', null, '0');
INSERT INTO `menu` VALUES ('product', '产品中心', 'null', '/product', null, '3', '0', null, '3', null, '0', null, '0');
INSERT INTO `menu` VALUES ('subAbout', '关于子菜单', 'about', '/subabout', null, '0', '1', null, '1', null, '0', null, '0');
