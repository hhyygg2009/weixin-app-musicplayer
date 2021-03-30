/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : localhost:3306
 Source Schema         : musicplayer

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 30/03/2021 18:01:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for favormusic
-- ----------------------------
DROP TABLE IF EXISTS `favormusic`;
CREATE TABLE `favormusic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `songid` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of favormusic
-- ----------------------------
INSERT INTO `favormusic` VALUES (1, 'admin', 0);

-- ----------------------------
-- Table structure for music
-- ----------------------------
DROP TABLE IF EXISTS `music`;
CREATE TABLE `music`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `singer` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `src` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `coverImgUrl` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of music
-- ----------------------------
INSERT INTO `music` VALUES (1, '最美的光', '尚琪祺', 'http://music.163.com/song/media/outer/url?id=27908100.mp3', 'https://y.gtimg.cn/music/photo_new/T002R300x300M000002UVhvw0piHPf_5.jpg?max_age=2592000');
INSERT INTO `music` VALUES (2, '成都', '赵雷', 'http://music.163.com/song/media/outer/url?id=436514312.mp3', 'https://y.gtimg.cn/music/photo_new/T001R300x300M000001Lr98T0yEWAk.jpg?max_age=2592000');
INSERT INTO `music` VALUES (3, '归来', '满江', 'http://music.163.com/song/media/outer/url?id=403710591.mp3', 'https://y.gtimg.cn/music/photo_new/T001R300x300M000002Fr8pA1oo1vd.jpg?max_age=2592000');
INSERT INTO `music` VALUES (4, '下雨的杭州', '解忧邵帅', 'http://music.163.com/song/media/outer/url?id=1391433967.mp3', 'http://p2.music.126.net/aKts3SZtKFRAOccJgqOCDg==/109951164369935111.jpg?param=300x300');
INSERT INTO `music` VALUES (5, '会不会（吉他版）', '刘大壮', 'http://music.163.com/song/media/outer/url?id=1481164987', 'http://p1.music.126.net/SFXsIYI3hCCedvbqrvVytA==/109951165335411992.jpg');
INSERT INTO `music` VALUES (6, '囍（女生版）', '等什么君', 'http://music.163.com/song/media/outer/url?id=1496822949', 'http://p2.music.126.net/m4zo-ZytE82l_Mdw3tUrQA==/109951165483970109.jpg?param=130y130');
INSERT INTO `music` VALUES (7, '鲸溺', '聂香_Yuki', 'http://music.163.com/song/media/outer/url?id=1396382563', 'http://p2.music.126.net/1Aog2lXVGERQ__d-EeiSEg==/109951164421522461.jpg?param=130y130');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` smallint(6) NULL DEFAULT NULL,
  `gender` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `education` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `interesting` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('admin', 'admin', 20, '男', 'admin@qq.com', '本科', '音乐');

SET FOREIGN_KEY_CHECKS = 1;
