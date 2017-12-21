/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : backend1

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-21 08:28:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for backend_menu
-- ----------------------------
DROP TABLE IF EXISTS `backend_menu`;
CREATE TABLE `backend_menu` (
  `id` varchar(64) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pid` varchar(64) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `deep` int(11) DEFAULT NULL,
  `hasSub` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of backend_menu
-- ----------------------------
INSERT INTO `backend_menu` VALUES ('e-images', '图片管理', 'management', '/backend/e-images', 'fa fa-circle-o text-gray', '2', '1', '0');
INSERT INTO `backend_menu` VALUES ('e-menu', '菜单管理', 'management', '/backend/e-menu', 'fa fa-circle-o text-yellow', '1', '1', '0');
INSERT INTO `backend_menu` VALUES ('management', '管理', 'null', '/backend/management', 'fa fa-laptop', '3', '0', '1');
INSERT INTO `backend_menu` VALUES ('p-display', '展示页面制作', 'publish', '/backend/p-display', 'fa fa-circle-o text-blue', '2', '1', '0');
INSERT INTO `backend_menu` VALUES ('p-information', '信息发布', 'publish', '/backend/p-information', 'fa fa-circle-o text-red', '1', '1', '0');
INSERT INTO `backend_menu` VALUES ('publish', '发布', 'null', '/backend/publish', 'fa fa-edit', '4', '0', '1');
INSERT INTO `backend_menu` VALUES ('sysConfig', '系统配置', 'null', '/backend/sysConfig', 'fa fa-th', '1', '0', '0');
INSERT INTO `backend_menu` VALUES ('user', '用户', 'null', '/backend/user', 'fa fa-user', '2', '0', '0');

-- ----------------------------
-- Table structure for detail
-- ----------------------------
DROP TABLE IF EXISTS `detail`;
CREATE TABLE `detail` (
  `id` varchar(64) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
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
INSERT INTO `detail` VALUES ('eadf', 'easdfea', 'feasfeasdfas', 'dsfefasfas', '0', null, '0', '2017-12-12 14:21:22', null, null, null, 'news', 'industry', null);
INSERT INTO `detail` VALUES ('fedad', '新闻标题1', 'fefasdf', '<h3>新闻内容</h3>', '0', null, '0', '2017-12-21 14:21:11', null, null, null, 'news', 'company', null);
INSERT INTO `detail` VALUES ('qwer', 'others', 'dfjeijdoijfo', 'djfoiejkdsfjoi', '0', null, '0', '2017-12-12 16:18:50', null, null, null, 'contact', 'unknow', null);
INSERT INTO `detail` VALUES ('zas', '新闻23', 'fesafeasfddafeasdfsa', '<h3>dfjidaoa</h3>', '9', null, '0', '2017-11-28 14:21:16', null, null, null, 'news', 'company', null);

-- ----------------------------
-- Table structure for images
-- ----------------------------
DROP TABLE IF EXISTS `images`;
CREATE TABLE `images` (
  `id` varchar(64) NOT NULL COMMENT '图片id',
  `name` varchar(255) DEFAULT NULL COMMENT '图片名字',
  `originName` varchar(255) DEFAULT NULL COMMENT '原始名字',
  `alt` varchar(255) DEFAULT NULL COMMENT '未加载图片信息',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `url` varchar(255) DEFAULT NULL COMMENT '图片url',
  `type` varchar(255) DEFAULT NULL COMMENT '图片类型',
  `relativePath` varchar(255) DEFAULT NULL COMMENT '相对路径',
  `absolutePath` varchar(255) DEFAULT '' COMMENT '绝对路径',
  `height` int(11) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `class1` varchar(255) DEFAULT NULL,
  `class2` varchar(255) DEFAULT NULL,
  `class3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of images
-- ----------------------------
INSERT INTO `images` VALUES ('0f2a1426f2ca4f0488d64340b3759182', null, 'logo.png', 'good', 'morning', '/upload-files//images/system/logo.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('11088058f0a347ac8091cea5c976f3ae', null, 'QQ图片20170919163710.jpg', 'what', 'the', '/upload-files//images/system/QQ图片20170919163710.jpg', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('46e98410248e430d9559243012010ca8', null, 'alert.png', '', '', '/upload-files//images/ckEditor/alert.png', null, '/upload-files//images/ckEditor/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/ckEditor/', '0', '0', 'ckEditor', null, null);
INSERT INTO `images` VALUES ('5d4fa0e897aa4696b56c6ef8ce81b9df', null, 'android-add-contact.png', '', '', '/upload-files//images/system/android-add-contact.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('63dd9ec756fa4d998e00e2aa7186674e', null, '00368.jpg', 'good', 'morning', '/upload-files//images/system/00368.jpg', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('941c8efc9cb04398a9c70a6a7e129d3f', null, 'QQ图片20170919163710.jpg', 'good', 'morning', '/upload-files//images/system/QQ图片20170919163710.jpg', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('9836ff5b9ae244ae894e3d27f63156fc', null, 'icon-social-google-plus.png', 'what', 'the', '/upload-files//images/system/icon-social-google-plus.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('b37286494d3d4761b669295dd2ddb8e1', null, 'android-checkmark.png', '', '', '/upload-files//images/ckEditor/android-checkmark.png', null, '/upload-files//images/ckEditor/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/ckEditor/', '0', '0', 'ckEditor', null, null);
INSERT INTO `images` VALUES ('d053c849b90648119ce6e5ce41292d00', null, 'logo.png', 'good', 'morning', '/upload-files//images/system/logo.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('e16aa2531cd4429fa6231d8c70c6e6f5', null, 'android-book.png', '', '', '/upload-files//images/system/android-book.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('f28ed6581025418793fa11baf5b22ffe', null, 'android-share.png', '', '', '/upload-files//images/system/android-share.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);

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
  `contentType` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('about', '关于我们', 'null', '/about', 'fa-fw fa-sun-o', '1', '0', null, '3', null, '1', '/images/banner1.jpg', '0', 'display');
INSERT INTO `menu` VALUES ('case', '成功案例', 'null', '/case', 'fa-fw fa-sun-o', '4', '0', null, '3', null, '0', null, '0', 'display');
INSERT INTO `menu` VALUES ('company', '公司新闻', 'news', '/news/company', null, '0', '1', null, '1', null, '0', null, '0', 'info');
INSERT INTO `menu` VALUES ('contact', '联系我们', 'null', '/contact', 'fa-fw fa-sun-o', '5', '0', null, '3', null, '0', null, '0', 'display');
INSERT INTO `menu` VALUES ('index', '首  页', 'null', '/index', 'fa-fw fa-sun-o', '0', '0', null, '3', null, '0', null, '0', null);
INSERT INTO `menu` VALUES ('industry', '行业动态', 'news', '/news/industry', null, '0', '1', null, '1', null, '0', null, '0', 'info');
INSERT INTO `menu` VALUES ('news', '新闻资讯', 'null', '/news', 'fa-fw fa-sun-o', '2', '0', null, '3', null, '1', null, '0', 'info');
INSERT INTO `menu` VALUES ('product', '产品中心', 'null', '/product', 'fa-fw fa-sun-o', '3', '0', null, '3', null, '0', null, '0', 'display');
INSERT INTO `menu` VALUES ('subAbout', '关于子菜单', 'about', '/about/subAbout', null, '0', '1', null, '1', null, '0', '/images/banner2.jpg', '0', 'display');
INSERT INTO `menu` VALUES ('subAbout2', '子菜单2', 'about', '/about/subAbout2', null, '1', '1', null, '1', null, '0', null, '0', 'display');

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
INSERT INTO `seo` VALUES ('system', '', '蜀旺新能源', '蜀旺,太阳能电池板,太阳能发电,太阳能路灯,太阳能热水器,838456', '四川蜀旺新能源股份有限公司 股票代码：838456 创建于2006年，地址位于享誉中外的“西部硅谷”、“中国科技城”──四川绵阳国家级经济技术开发区，是一家专业从事光伏、光热研发及产业化的高新技术企业.的高新技术企业', '蜀旺新能源');

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
INSERT INTO `simple_user` VALUES ('abc', 'fdfedik', '32');
INSERT INTO `simple_user` VALUES ('c2e7ebdd45c34f67a1b4d3832b8282f4', 'lul', '18');
INSERT INTO `simple_user` VALUES ('c8a9344d7ad245eca1aa9f1f0f112fad', 'lul', '18');
INSERT INTO `simple_user` VALUES ('eb7e3d294e7047a489cc314242abe98d', 'fa', '15');

-- ----------------------------
-- Table structure for spl_content
-- ----------------------------
DROP TABLE IF EXISTS `spl_content`;
CREATE TABLE `spl_content` (
  `id` varchar(64) NOT NULL,
  `pid` varchar(64) DEFAULT NULL,
  `content` longtext,
  `iframeUrl` varchar(255) DEFAULT NULL,
  `bannerImg` varchar(255) DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `state` tinyint(1) DEFAULT '0',
  `updateTime` datetime DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of spl_content
-- ----------------------------
INSERT INTO `spl_content` VALUES ('0a94bb6e6fb347a9b4f8c39dc7e6bb39', 'subAbout', '<p>start</p>\n\n<p>&nbsp;</p>\n\n<p>&nbsp;</p>\n\n<p>dfasfkdsjfkds&nbsp; asfdsfeiosdjafklsadf;</p>\n', '', '/upload-files//images/system/android-share.png', 'qays', '1', null, null);
INSERT INTO `spl_content` VALUES ('5ec0ca20fbdf41099d9224caab550cfc', 'subAbout2', '<p>start</p>\n\n<p>&nbsp;</p>\n\n<p>what fu d&nbsp; &nbsp; asfsdf</p>\n', '', '/upload-files//images/system/android-add-contact.png', 'luguo ', '1', null, null);
INSERT INTO `spl_content` VALUES ('832dbccab2f5455f9dd1087b1c5a44b7', 'subAbout', '<p>start</p>\n\n<p>&nbsp;</p>\n\n<p>what fu d&nbsp; &nbsp; asfsdf</p>\n', '', '/upload-files//images/system/android-add-contact.png', 'luguo ', '0', null, null);
INSERT INTO `spl_content` VALUES ('aaee6d78e78944308c1455ea68e31335', 'subAbout', '<p>start</p>\n\n<p>&nbsp;</p>\n\n<p>what fu d&nbsp; &nbsp; asfsdf</p>\n', '', '/upload-files//images/system/android-add-contact.png', 'luguo ', '0', null, null);
INSERT INTO `spl_content` VALUES ('fdsafesdafe', 'subAbout2', '<h1>w the ??<h1>', null, null, 'shuwang', '1', null, null);
INSERT INTO `spl_content` VALUES ('fdsafiedskl', 'subAbout', null, '/iframe/aboutus-phone/jsmo.html', null, 'shuwa nbg', '1', null, null);

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `id` varchar(64) NOT NULL,
  `webName` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `sharesName` varchar(255) DEFAULT NULL,
  `sharesCode` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `licensing` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('sdfsdafesdfa', '蜀旺新能源', '/upload-files//images/system/icon-social-google-plus.png', '/upload-files//images/system/logo.png', '蜀旺能源', '838456', 'sales@swpv.net', '0816-230237', '蜀ICP备17040681');
