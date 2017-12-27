/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : backend1

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-27 17:50:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for authorities
-- ----------------------------
DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `id` varchar(64) NOT NULL,
  `authName` varchar(255) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authorities
-- ----------------------------

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
INSERT INTO `backend_menu` VALUES ('e-display', '展示页面修改', 'management', '/backend/e-display', 'fa fa-circle-o text-orange', '3', '1', '0');
INSERT INTO `backend_menu` VALUES ('e-images', '图片管理', 'management', '/backend/e-images', 'fa fa-circle-o text-gray', '2', '1', '0');
INSERT INTO `backend_menu` VALUES ('e-info', '信息条目修改', 'management', '/backend/e-info', 'fa fa-circle-o text-green', '4', '1', '0');
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
  `updateDate` date DEFAULT NULL,
  `createDate` date DEFAULT NULL,
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
INSERT INTO `detail` VALUES ('2652191b5b5c42b2bf5b2f6fc67ae1f2', 'dsfa e fsdf afds 的范德萨', '分发撒地方符合规范 ', '<p>等如图衣服的光伏规范化光伏广泛覆盖返回韩国巨亏两套房地瓜粉try6ytjhgj</p>\n', '462', '收到货过后', '1', '2017-12-27', '2017-12-27', '', '/upload-files//images/system/android-developer.png', 'testinfotop', 'sbuinfo2', null);
INSERT INTO `detail` VALUES ('2892dc29a1434779a363fc05c76f6096', '信息想 阿道夫 地方', '挺好 的发送 发大安市', '<p>是打发 第三方啊阿萨德范德萨发第三方das</p>\n\n<p>地方ds发</p>\n\n<p>sda发</p>\n\n<p>sdaf sad发</p>\n\n<p>sadf是</p>\n\n<p>fds</p>\n', '12', '牢固', '1', '2017-12-25', '2017-12-25', '', '', 'testinfotop', 'sbuinfo2', null);
INSERT INTO `detail` VALUES ('659f5138389d4d6298d10b0e19da1423', 'fdsa', 'fea', '<p>fdsfae</p>\n', '23', 'fesa', '1', '2017-12-30', '2017-12-28', '', '', 'news', 'company', null);
INSERT INTO `detail` VALUES ('8f77d9a40a074eeba30127ce1a5ef5aa', 'feadfasfe', 'dfeadsfsa', '<p>ead</p>\n\n<p>feia</p>\n\n<p>&nbsp;</p>\n\n<p>feadfas<img alt=\"\" src=\"/upload-files//images/system/logo.png\" style=\"height:100px; width:200px\" /></p>\n', '2', 'eaaa', '1', '2017-12-22', '2017-12-22', '', '', 'news', 'company', null);
INSERT INTO `detail` VALUES ('ae029227b9bd4472babb301ee50dca77', '第三方而', '宏观环境讲话稿', '<p>大多数二房东分的定时东方大厦发奋发生大</p>\n\n<p>第三方</p>\n\n<p>dsf dsfdsa发dsafesd发</p>\n\n<p>&nbsp;</p>\n\n<p>f是dfds发</p>\n\n<p>dsfdsf fd&nbsp;</p>\n\n<p>ds f</p>\n\n<p>&nbsp;</p>\n\n<p>ds&nbsp;</p>\n\n<p>fd&nbsp;</p>\n\n<p>dsa</p>\n', '4', '5人的身份', '1', '2017-12-27', '2017-12-27', '', '', 'testtopmenu', 'open', null);
INSERT INTO `detail` VALUES ('b83194132e3045969d54940a5a457ff4', '定时', '哇哈他', '<p>地方撒旦 的士费撒的士费大定时飞碟说大</p>\n', '34', '阿达', '1', '2017-12-25', '2017-12-25', '', '', 'testinfotop', 'infosub', null);
INSERT INTO `detail` VALUES ('c9ddfe61fd6b4a57b79ad62f163b713b', 'feafdsafsefsaf', 'fesadfase', '<p>sdfeadfsafesadfsafdsad</p>\n', '43', 'feafsafe', '1', '2017-12-31', '2017-12-21', '', '', 'news', 'industry', null);
INSERT INTO `detail` VALUES ('eadf', 'easdfea', 'feasfeasdfas', '<p>dsfefasfas</p>\n\n<p>&nbsp;</p>\n\n<p>feadsfsef</p>\n\n<p>&nbsp;</p>\n\n<p>fesa</p>\n', '10', 'luguo', '1', '2017-12-12', '2017-12-21', '', '', 'news', 'company', null);
INSERT INTO `detail` VALUES ('fedad', '新闻标题1', 'fefasdf', '<h3>新闻内容</h3>', '0', 'fdas', '1', '2017-12-21', null, null, null, 'news', 'company', null);
INSERT INTO `detail` VALUES ('zas', '新闻23', 'fesafeasfddafeasdfsa', '<h3>dfjidaoa</h3>', '9', 'fea', '1', '2017-11-28', null, null, null, 'news', 'company', null);
INSERT INTO `detail` VALUES ('zz', 'fdfghsjgfjgfjgfjgfsgfjsgfsgfssgjfjgfjgfgfjs', 'gfjsgfhgfsgfsgf', '<p>gfdjgfhgfsfhshgfshsshfsfhsfgsgfssgfsh</p>\n', '40', 'gfhjgfjhgstsssgf', '1', '2017-12-23', '2017-12-23', '', '', 'news', 'company', null);
INSERT INTO `detail` VALUES ('zzz', 'lyuytdttdgh', 'ghdgdggdhjjhgdjghddjgdgj', '<p>hgfgfhgfhdjhggftrgfdhgffgssgfhgfsgf</p>\n', '60', 'gfdghjjhgdsf', '1', '2017-12-23', '2017-12-23', '', '', 'news', 'company', null);
INSERT INTO `detail` VALUES ('zzzz', 'zxzxxccxvxczvxc', 'cxdsdsdsvdsvjuyj', '<p>ghfgfhfghjh</p>\n', '50', 'gf6utjhgj', '1', '2017-12-23', '2017-12-23', '', '', 'news', 'company', null);
INSERT INTO `detail` VALUES ('zzzzz', 'fea', 'fs', '<p>fsaeas</p>\n', '4320', 'dfsae', '1', '2017-12-23', '2017-12-23', '', '', 'news', 'company', null);
INSERT INTO `detail` VALUES ('zzzzzds', 'fdsa', 'fea', '<p>fse</p>\n', '20', 'fe', '1', '2017-12-23', '2017-12-23', '', '', 'news', 'company', null);
INSERT INTO `detail` VALUES ('zzzzzzzz', 'fea', 'dfea', '<p>fdsafesdf</p>\n', '20', 'fdsa', '1', '2017-12-23', '2017-12-23', '', '', 'news', 'company', null);

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
INSERT INTO `images` VALUES ('042a026184a547dca663399f7b395f44', null, 'android-hand.png', 'ea', 'dfas', '/upload-files//images/system/android-hand.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('08410b4865124d08ad6661717fcf8b3b', null, 'android-social-user.png', '', '', '/upload-files//images/system/android-social-user.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('0f2a1426f2ca4f0488d64340b3759182', null, 'logo.png', 'good', 'morning', '/upload-files//images/system/logo.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('11088058f0a347ac8091cea5c976f3ae', null, 'QQ图片20170919163710.jpg', 'what', 'the', '/upload-files//images/system/QQ图片20170919163710.jpg', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('1991caac9447455385ea2e86eb2a52d3', null, 'beaker.png', '', '', '/upload-files//images/system/beaker.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('21a7f5238ca44042b1644814cfa5e459', null, 'android-chat.png', '', '', '/upload-files//images/system/android-chat.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('242d153b133b47308c7be00c65328970', null, 'android-developer.png', '', '', '/upload-files//images/system/android-developer.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('25ff22a14e794d55a46f7f4902f23d11', null, 'android-dropdown.png', '', '', '/upload-files//images/info/android-dropdown.png', null, '/upload-files//images/info/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/info/', '512', '512', 'info', null, null);
INSERT INTO `images` VALUES ('29440fab063944ad880b87eff58a12a3', null, 'xbox.png', '', '', '/upload-files//images/system/xbox.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('41dabcca651f4016876b6612a0c5f239', null, 'android-display.png', '', '', '/upload-files//images/system/android-display.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('45d0973da464435181e291cbba50078b', null, 'android-data.png', '', '', '/upload-files//images/system/android-data.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('46e98410248e430d9559243012010ca8', null, 'alert.png', '', '', '/upload-files//images/ckEditor/alert.png', null, '/upload-files//images/ckEditor/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/ckEditor/', '0', '0', 'ckEditor', null, null);
INSERT INTO `images` VALUES ('491039a307854ee0ad2878705f4c1031', null, 'android-camera.png', '', '', '/upload-files//images/system/android-camera.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '512', '512', 'system', null, null);
INSERT INTO `images` VALUES ('5d4fa0e897aa4696b56c6ef8ce81b9df', null, 'android-add-contact.png', '', '', '/upload-files//images/system/android-add-contact.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('63dd9ec756fa4d998e00e2aa7186674e', null, '00368.jpg', 'good', 'morning', '/upload-files//images/system/00368.jpg', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('7bb6b1d0b8bb44d2bfafea57681d929a', null, 'android-location.png', '', '', '/upload-files//images/system/android-location.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('7f2440f3896d42d0b8bf977e843e9930', null, 'android-search.png', '范德萨', '范德萨 ', '/upload-files//images/system/android-search.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '512', '512', 'system', null, null);
INSERT INTO `images` VALUES ('808a211999c84cecb6ed206888a50791', null, 'alert-circled.png', '', '', '/upload-files//images/system/alert-circled.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '512', '512', 'system', null, null);
INSERT INTO `images` VALUES ('845778fec53646dcab82ba6495388c51', null, 'android-archive.png', '', '', '/upload-files//images/system/android-archive.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('863f61ee88664ddfa18e5993c452fc34', null, 'android-camera.png', '', '', '/upload-files//images/system/android-camera.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '512', '512', 'system', null, null);
INSERT INTO `images` VALUES ('8ad72a3e245f42fc9cded397a1d114bb', null, 'android-call.png', '', '', '/upload-files//images/system/android-call.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '512', '512', 'system', null, null);
INSERT INTO `images` VALUES ('91f17c32fae046788e2b61bbb8e2b37e', null, 'android-add.png', '', '', '/upload-files//images/system/android-add.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('968074f2fc984327adc251e80d858310', null, 'android-arrow-forward.png', '', '', '/upload-files//images/system/android-arrow-forward.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('970f5eb2283549dbb771c388a0e04304', null, 'android-forums.png', '大方', '饿啊', '/upload-files//images/system/android-forums.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('9836ff5b9ae244ae894e3d27f63156fc', null, 'icon-social-google-plus.png', 'what', 'the', '/upload-files//images/system/icon-social-google-plus.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('a4264e076c074880aadc0c3ecb281f0e', null, 'android-friends.png', '', '', '/upload-files//images/system/android-friends.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('a6d61e6d6cd9432a86eab9c192a67ffb', null, 'android-keypad.png', '', '', '/upload-files//images/system/android-keypad.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '512', '512', 'system', null, null);
INSERT INTO `images` VALUES ('a9bd6d15bc8f4ccfb8a4650fab4cdebd', null, 'android-calendar.png', '', '', '/upload-files//images/info/android-calendar.png', null, '/upload-files//images/info/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/info/', '512', '512', 'info', null, null);
INSERT INTO `images` VALUES ('ac83da4ad715473cb61ebb06661d4770', null, 'android-arrow-down-right.png', '', '', '/upload-files//images/system/android-arrow-down-right.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('b37286494d3d4761b669295dd2ddb8e1', null, 'android-checkmark.png', '', '', '/upload-files//images/ckEditor/android-checkmark.png', null, '/upload-files//images/ckEditor/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/ckEditor/', '0', '0', 'ckEditor', null, null);
INSERT INTO `images` VALUES ('b372a6a0cbd3418b8442b9dd94091be2', null, 'android-alarm.png', '', '', '/upload-files//images/system/android-alarm.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('b89982e7b75449e0a7383de055377ec5', null, 'android-settings.png', 'afdsfe', 'feadfsad', '/upload-files//images/system/android-settings.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('bb12125063cc4fc5ae99769887888e3c', null, 'android-battery.png', '', '', '/upload-files//images/system/android-battery.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('bf23284219d841dd9d52898685c712a0', null, 'android-earth.png', '', '', '/upload-files//images/system/android-earth.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('dec229f715dd422bafee6ea89c201b20', null, 'android-more.png', '', '', '/upload-files//images/ckEditor/android-more.png', null, '/upload-files//images/ckEditor/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/ckEditor/', '0', '0', 'ckEditor', null, null);
INSERT INTO `images` VALUES ('e16aa2531cd4429fa6231d8c70c6e6f5', null, 'android-book.png', '', '', '/upload-files//images/system/android-book.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('ec71916f02794e7fb73ce463a605456f', null, 'android-sort.png', '', '', '/upload-files//images/info/android-sort.png', null, '/upload-files//images/info/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/info/', '0', '0', 'info', null, null);
INSERT INTO `images` VALUES ('f28ed6581025418793fa11baf5b22ffe', null, 'android-share.png', '', '', '/upload-files//images/system/android-share.png', null, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', '0', '0', 'system', null, null);
INSERT INTO `images` VALUES ('f517734fd0524e2988dc5f5201781f6f', null, 'android-arrow-up-left.png', 'arraw ', 'arrow', '/upload-files//images/info/android-arrow-up-left.png', null, '/upload-files//images/info/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/info/', '0', '0', 'info', null, null);

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
INSERT INTO `menu` VALUES ('adf', '好滴', 'about', '/about/adf', '', '5', '1', null, '1', null, '0', '/upload-files//images/system/QQ图片20170919163710.jpg', '0', 'display');
INSERT INTO `menu` VALUES ('adfaaaefdas', '地方', 'case', '/case/adfaaaefdas', '', '5', '1', null, '1', null, '0', '/upload-files//images/info/android-dropdown.png', '0', 'info');
INSERT INTO `menu` VALUES ('afdeae', '测试2', 'testtopmenu', '/testtopmenu/afdeae', '', '2', '1', null, '1', null, '0', '/images/banner1.jpg', '0', 'display');
INSERT INTO `menu` VALUES ('bb7bfe771dfc488d86e751ceffbdea60', '测试菜单sub', 'testtopmenu', '/testtopmenu/bb7bfe771dfc488d86e751ceffbdea60', '', '0', '1', null, '3', null, '0', '/images/banner1.jpg', '0', 'display');
INSERT INTO `menu` VALUES ('case', '成功案例', '', '/case', 'fa-fw fa-sun-o', '4', '0', null, '3', null, '0', '/images/banner1.jpg', '0', 'display');
INSERT INTO `menu` VALUES ('company', '公司新闻', 'news', '/news/company', null, '0', '1', null, '1', null, '0', null, '0', 'info');
INSERT INTO `menu` VALUES ('contact', '联系我们', 'null', '/contact', 'fa-fw fa-sun-o', '5', '0', null, '3', null, '0', null, '0', 'display');
INSERT INTO `menu` VALUES ('index', '首  页', 'null', '/index', 'fa-fw fa-sun-o', '0', '0', null, '3', null, '0', null, '0', null);
INSERT INTO `menu` VALUES ('industry', '行业动态', 'news', '/news/industry', null, '0', '1', null, '1', null, '0', null, '0', 'info');
INSERT INTO `menu` VALUES ('infosub', '信息子', 'testinfotop', '/testinfotop/infosub', '', '0', '1', null, '1', null, '0', '', '0', 'info');
INSERT INTO `menu` VALUES ('news', '新闻资讯', 'null', '/news', 'fa-fw fa-sun-o', '2', '0', null, '3', null, '1', null, '0', 'info');
INSERT INTO `menu` VALUES ('open', '打开', 'testtopmenu', '/testtopmenu/open', '', '4', '1', null, '1', null, '0', '/upload-files//images/system/android-location.png', '0', 'info');
INSERT INTO `menu` VALUES ('product', '产品中心', 'null', '/product', 'fa-fw fa-sun-o', '3', '0', null, '3', null, '0', null, '0', 'display');
INSERT INTO `menu` VALUES ('sbuinfo2', '信息2', 'testinfotop', '/testinfotop/sbuinfo2', '', '2', '1', null, '1', null, '0', '', '0', 'info');
INSERT INTO `menu` VALUES ('subAbout', '关于子菜单', 'about', '/about/subAbout', null, '0', '1', null, '1', null, '0', '/images/banner2.jpg', '0', 'display');
INSERT INTO `menu` VALUES ('subAbout2', '子菜单2', 'about', '/about/subAbout2', null, '1', '1', null, '1', null, '0', null, '0', 'display');
INSERT INTO `menu` VALUES ('test', '测试3', 'testtopmenu', '/testtopmenu/test', '', '5', '1', null, '1', null, '0', '', '0', 'display');
INSERT INTO `menu` VALUES ('testinfotop', '信息 顶部', '', '/testinfotop', '', '6', '0', null, '3', null, '1', '', '0', 'info');
INSERT INTO `menu` VALUES ('testtopmenu', '这是个顶部测试菜单', '', '/testtopmenu', '', '7', '0', null, '3', null, '1', '/upload-files//images/system/android-hand.png', '0', 'display');

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` varchar(64) NOT NULL,
  `roleName` varchar(255) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles
-- ----------------------------

-- ----------------------------
-- Table structure for role_auth
-- ----------------------------
DROP TABLE IF EXISTS `role_auth`;
CREATE TABLE `role_auth` (
  `id` varchar(64) NOT NULL,
  `roleId` varchar(64) DEFAULT NULL,
  `authId` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_auth
-- ----------------------------

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
  `updateDate` date DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of spl_content
-- ----------------------------
INSERT INTO `spl_content` VALUES ('2d4ff786ae064f9d8f77cf2968469e90', 'product', '<p>start</p>\n\n<p>&nbsp;</p>\n\n<p><span style=\"font-family:Georgia,serif\"><em><strong>这是一个</strong></em></span></p>\n\n<p>&nbsp;</p>\n\n<h2><span style=\"font-family:Georgia,serif\"><em><strong>what ？</strong></em></span></h2>\n', '', '', 'luguo', '1', null, null);
INSERT INTO `spl_content` VALUES ('4c97a30d43e94bc390883eaf27eb4858', 'subAbout', '<p>start</p>\n\n<p>dsfsa</p>\n\n<p>fs</p>\n\n<p>dfasfkdsjfkds&nbsp; asfdsfeiosdjafklsadf;</p>\n\n<p>fesdfsa</p>\n\n<p>feadfasfesafasfesafdsdaf</p>\n\n<p>fdsafd</p>\n\n<p>fdsfesaf</p>\n\n<p>sfesafsadfdsa</p>\n', '', '/upload-files//images/system/android-share.png', 'qays', '1', null, null);
INSERT INTO `spl_content` VALUES ('5ec0ca20fbdf41099d9224caab550cfc', 'subAbout2', '<p>start</p>\n\n<p>&nbsp;</p>\n\n<p>what fu d&nbsp; &nbsp; asfsdf</p>\n', '', '/upload-files//images/system/android-add-contact.png', 'luguo ', '1', null, '2017-12-21');
INSERT INTO `spl_content` VALUES ('832dbccab2f5455f9dd1087b1c5a44b7', 'subAbout', '<p>start</p>\n\n<p>&nbsp;</p>\n\n<p>what fu d&nbsp; &nbsp; asfsdf</p>\n', '', '/upload-files//images/system/android-add-contact.png', 'luguo ', '1', null, '2017-12-21');
INSERT INTO `spl_content` VALUES ('8dbe82fee1e241b1bdb3d9201aed059f', 'testtopmenu', '<p><span style=\"font-size:10px\">fdsa</span><span style=\"font-size:12px\">fdsfadsafsasdfa<span style=\"font-family:Lucida Sans Unicode,Lucida Grande,sans-serif\">fdsafasfdsaf</span></span></p>\n\n<p>&nbsp;</p>\n\n<p><span style=\"font-family:Comic Sans MS,cursive\"><em><strong>waht the fu</strong></em></span></p>\n\n<p><span style=\"font-family:Comic Sans MS,cursive\"><em><strong>sdsfasdsfsafes</strong></em></span></p>\n\n<p><span style=\"font-family:Comic Sans MS,cursive\"><em><strong>dsasdaedfa</strong></em></span></p>\n\n<p>&nbsp;</p>\n\n<p><span style=\"font-family:Comic Sans MS,cursive\"><em><strong><img alt=\"\" src=\"/upload-files//images/system/android-book.png\" style=\"height:512px; width:512px\" /></strong></em></span></p>\n', '', '', 'fasdfas luguo ', '1', null, null);
INSERT INTO `spl_content` VALUES ('aaee6d78e78944308c1455ea68e31335', 'subAbout', '<p>start</p>\n\n<p>&nbsp;</p>\n\n<p>what fu d&nbsp; &nbsp; asfsdf</p>\n', '', '/upload-files//images/system/android-add-contact.png', 'luguo ', '0', null, '2017-12-21');
INSERT INTO `spl_content` VALUES ('abbdfcd78c5c45fbb5a192574f0614f0', 'bb7bfe771dfc488d86e751ceffbdea60', '<p>start</p>\n\n<p>fea</p>\n\n<p>dfea</p>\n\n<p>&nbsp;</p>\n\n<p>dfa</p>\n\n<p>&nbsp;</p>\n\n<p>aaafde</p>\n\n<p>a</p>\n', '', '', 'fdsa', '1', null, null);
INSERT INTO `spl_content` VALUES ('b09f03b63cd64117b34504debf81699a', 'subAbout2', '<h2 style=\"font-style:italic\"><strong>hello world</strong></h2>\n\n<p>&nbsp;</p>\n\n<p><strong><span style=\"font-family:Comic Sans MS,cursive\">fasdfe aaaaaaafdeafd</span></strong></p>\n', '', '', 'qays', '1', null, '2017-12-21');
INSERT INTO `spl_content` VALUES ('c4e1516ec01d437d8588503ad450e264', 'afdeae', '<p>start</p>\n\n<p>&nbsp;</p>\n\n<p>哇哈他</p>\n', '', '/upload-files//images/system/android-location.png', '都是分散', '1', null, null);
INSERT INTO `spl_content` VALUES ('caaf46db934048f2aef06045252e8da7', 'case', '', 'http://www.swkj.net.cn/map4case.html', '', 'luguo', '1', null, null);
INSERT INTO `spl_content` VALUES ('f5a6a220361a49ca93ca74fd03eb3f63', 'contact', '<p>start</p>\n\n<p>&nbsp;</p>\n\n<h2><span style=\"font-family:Comic Sans MS,cursive\"><span style=\"color:#f39c12\">范德萨的啊啊</span></span></h2>\n', '', '/upload-files//images/system/android-data.png', '的说法', '1', null, null);
INSERT INTO `spl_content` VALUES ('fdsafesdafe', 'subAbout2', '<h1>w the ??<h1>', '', '', 'shuwang', '1', null, '2017-12-21');
INSERT INTO `spl_content` VALUES ('fdsafiedskl', 'subAbout', '', '/iframe/aboutus-phone/jsmo.html', '', 'shuwa nbg', '1', null, '2017-12-21');

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

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` varchar(64) NOT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `avadar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` varchar(64) NOT NULL,
  `userId` varchar(64) DEFAULT NULL,
  `roleId` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
