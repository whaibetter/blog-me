/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : blogme

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 09/07/2020 18:35:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `article_id` int(10) NOT NULL AUTO_INCREMENT,
  `article_user_id` int(10) DEFAULT NULL,
  `article_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `article_content` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `article_date` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`article_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(10) NOT NULL AUTO_INCREMENT,
  `comment_pid` int(10) DEFAULT NULL,
  `comment_article_id` int(10) DEFAULT NULL,
  `comment_content` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `comment_date` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for frienduser
-- ----------------------------
DROP TABLE IF EXISTS `frienduser`;
CREATE TABLE `frienduser`  (
  `user_id` int(10) NOT NULL,
  `friend_userid` int(10) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of frienduser
-- ----------------------------
INSERT INTO `frienduser` VALUES (1, 2);
INSERT INTO `frienduser` VALUES (1, 3);
INSERT INTO `frienduser` VALUES (2, 1);
INSERT INTO `frienduser` VALUES (5, 1);
INSERT INTO `frienduser` VALUES (5, 2);
INSERT INTO `frienduser` VALUES (1, 6);
INSERT INTO `frienduser` VALUES (6, 1);

-- ----------------------------
-- Table structure for lookuser
-- ----------------------------
DROP TABLE IF EXISTS `lookuser`;
CREATE TABLE `lookuser`  (
  `user_id` int(10) DEFAULT NULL,
  `look_user_id` int(10) DEFAULT NULL,
  `look_date` datetime(0) DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lookuser
-- ----------------------------
INSERT INTO `lookuser` VALUES (1, 2, '2020-08-13 20:51:47');
INSERT INTO `lookuser` VALUES (1, 1, '2020-07-05 10:32:32');
INSERT INTO `lookuser` VALUES (1, 2, '2020-07-06 05:01:22');
INSERT INTO `lookuser` VALUES (1, 2, '2020-07-06 06:12:15');
INSERT INTO `lookuser` VALUES (2, 1, '2020-07-06 06:17:36');
INSERT INTO `lookuser` VALUES (2, 1, '2020-07-06 06:18:40');
INSERT INTO `lookuser` VALUES (2, 1, '2020-07-06 06:21:53');
INSERT INTO `lookuser` VALUES (2, 5, '2020-07-06 08:42:44');
INSERT INTO `lookuser` VALUES (2, 5, '2020-07-06 08:42:53');
INSERT INTO `lookuser` VALUES (1, 6, '2020-07-06 11:41:34');
INSERT INTO `lookuser` VALUES (2, 1, '2020-07-07 02:39:09');
INSERT INTO `lookuser` VALUES (2, 1, '2020-07-07 05:21:28');
INSERT INTO `lookuser` VALUES (2, 1, '2020-07-07 05:21:33');
INSERT INTO `lookuser` VALUES (1, 2, '2020-07-07 05:24:29');
INSERT INTO `lookuser` VALUES (1, 2, '2020-07-07 05:24:34');
INSERT INTO `lookuser` VALUES (3, 1, '2020-07-08 13:57:05');
INSERT INTO `lookuser` VALUES (6, 1, '2020-07-09 07:08:01');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `user_pass` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `user_email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`  (
  `video_id` int(11) NOT NULL AUTO_INCREMENT,
  `video_title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `video_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`video_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;


SET FOREIGN_KEY_CHECKS = 1;
