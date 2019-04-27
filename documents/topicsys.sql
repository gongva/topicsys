/*
 Navicat Premium Data Transfer

 Source Server         : topicsys
 Source Server Type    : MySQL
 Source Server Version : 50538
 Source Host           : localhost:3306
 Source Schema         : topicsys

 Target Server Type    : MySQL
 Target Server Version : 50538
 File Encoding         : 65001

 Date: 19/04/2019 00:41:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `department_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `department_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_delete` int(255) NOT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`department_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('7ab20b644c0e4978be083834e0a753ff', '医学院', 0, '2019-04-14 22:49:04', '2019-04-14 22:49:04');
INSERT INTO `department` VALUES ('ad00f57cd2e24200b79164c60f5a0266', '经济与管理学院', 0, '2019-04-16 15:34:53', '2019-04-16 15:34:53');
INSERT INTO `department` VALUES ('d111', '数学与计算机学院', 0, '2019-04-14 14:23:36', '2019-04-14 14:23:38');
INSERT INTO `department` VALUES ('f706a7d28ca04c669afd8c2fd1d14f42', '人文社科学院', 0, '2019-04-16 14:12:58', '2019-04-16 14:12:58');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `student_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `department_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_delete` int(255) NOT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('7f1d7ad962dd4478a91e36575effcdf4', '5145ccf7166a42bbbbb7281e8fd64e62', '15884591555', 'd111', 0, '2019-04-17 17:03:34', '2019-04-17 17:03:34');
INSERT INTO `student` VALUES ('s111', 'u333', '15884591555', 'd111', 0, '2019-04-14 14:32:05', '2019-04-17 17:02:40');

-- ----------------------------
-- Table structure for system_config
-- ----------------------------
DROP TABLE IF EXISTS `system_config`;
CREATE TABLE `system_config`  (
  `config_id` int(255) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `value` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`config_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of system_config
-- ----------------------------
INSERT INTO `system_config` VALUES (1, 'role', 'role_admin', '超级管理员', '登录角色');
INSERT INTO `system_config` VALUES (2, 'role', 'role_m', '管理员', '登录角色');
INSERT INTO `system_config` VALUES (3, 'role', 'role_t', '导师', '登录角色');
INSERT INTO `system_config` VALUES (4, 'role', 'role_s', '学生', '登录角色');
INSERT INTO `system_config` VALUES (5, 'job_title', 'job_title_pro', '教授', '导师职称');
INSERT INTO `system_config` VALUES (6, 'job_title', 'job_title_ass', '副教授', '导师职称');
INSERT INTO `system_config` VALUES (7, 'job_title', 'job_title_lec', '讲师', '导师职称');
INSERT INTO `system_config` VALUES (8, 'paper_time', 'paper_time_start', '2019-04-01 00:00:01', '选题开始时间');
INSERT INTO `system_config` VALUES (9, 'paper_time', 'paper_time_end', '2019-08-01 09:00:00', '选题结束时间');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `teacher_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `job_title_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `department_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_delete` int(255) NOT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`teacher_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('484aac7f2e174216997992ae3c6d386f', 'fc6', '14765324567', 'job_title_ass', 'd111', 0, '2019-04-17 20:48:57', '2019-04-17 20:48:57');
INSERT INTO `teacher` VALUES ('4a50451e328a46e8b08a610a34128193', 'd4f09057a379412d8de7ceb347ade44b', '15082387686', 'job_title_pro', 'ad00f57cd2e24200b79164c60f5a0266', 0, '2019-04-17 15:56:01', '2019-04-17 20:52:14');
INSERT INTO `teacher` VALUES ('b4e3f568aed3404cb5362d7de5c4ca07', 'c35347e1af92485588be4021ae3efdd7', '15884591555', 'job_title_ass', 'd111', 0, '2019-04-16 22:28:43', '2019-04-17 19:11:54');
INSERT INTO `teacher` VALUES ('be5a697d5b4141659c2a5d9e55d2f942', '1c90d4406d764a419d843162ce6b8ea8', '15067324567', 'job_title_pro', 'd111', 0, '2019-04-17 17:55:45', '2019-04-17 19:07:20');
INSERT INTO `teacher` VALUES ('d7e662160a6d41f1bb0ad7c7860a0ed7', 'eff346e6853e46ddb5a183b8f0eb705a', '15082456784', 'job_title_pro', '7ab20b644c0e4978be083834e0a753ff', 0, '2019-04-17 20:48:11', '2019-04-17 20:48:11');
INSERT INTO `teacher` VALUES ('d93d60d1032e4b20836d0c104f0ef461', '7f154b966a1740ccb469c3c346fa1143', '14723456780', 'job_title_pro', '7ab20b644c0e4978be083834e0a753ff', 0, '2019-04-17 15:56:56', '2019-04-17 15:56:56');
INSERT INTO `teacher` VALUES ('t111', 'u222', '15884591555', 'job_title_ass', 'd111', 0, '2019-04-14 14:23:11', '2019-04-17 19:07:33');

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic`  (
  `topic_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `topic_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `t_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `s_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(255) NOT NULL,
  `paper_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_delete` int(255) NOT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`topic_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES ('5936e8dd14dd41b8a6311b74af45309b', '新课题', '新描述', 'fc6', NULL, 1, NULL, 0, '2019-04-19 00:37:05', '2019-04-19 00:37:05');
INSERT INTO `topic` VALUES ('t111', '选题系统', '要做好哦', 'u222', 'u333', 2, NULL, 0, '2019-04-17 18:26:49', '2019-04-17 18:26:52');
INSERT INTO `topic` VALUES ('t222', '哈哈系统', '好复杂啊', '7f154b966a1740ccb469c3c346fa1143', '', 1, NULL, 0, '2019-04-17 20:34:49', '2019-04-17 20:34:51');
INSERT INTO `topic` VALUES ('t333', 'nnn', 'dddd', 'fc6', NULL, 1, NULL, 0, '2019-04-18 23:03:57', '2019-04-18 23:04:00');
INSERT INTO `topic` VALUES ('t444', 'qqq', 'uuu', 'u222', '', 1, '', 0, '2019-04-19 00:05:17', '2019-04-19 00:05:20');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_delete` int(255) NOT NULL DEFAULT 0,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1c90d4406d764a419d843162ce6b8ea8', '667788', 'e10adc3949ba59abbe56e057f20f883e', '海底神', 'role_t', 0, '2019-04-17 17:55:45', '2019-04-17 19:07:20');
INSERT INTO `user` VALUES ('300595e378834371be483c7f001317ef', '12343', 'e10adc3949ba59abbe56e057f20f883e', '12345', 'role_m', 9, '2019-04-16 11:52:54', '2019-04-16 11:53:27');
INSERT INTO `user` VALUES ('309c33d006674558831aef8d089c6dc7', '12', 'e10adc3949ba59abbe56e057f20f883e', '12', 'role_m', 9, '2019-04-16 10:13:15', '2019-04-16 10:20:59');
INSERT INTO `user` VALUES ('49171425514346f3bb57b3dc9d066eef', '666', 'e10adc3949ba59abbe56e057f20f883e', '745324', 'role_m', 0, '2019-04-16 11:53:01', '2019-04-16 11:53:01');
INSERT INTO `user` VALUES ('4a3ac37a6b78427bb849e92728e665ed', '1234', 'e10adc3949ba59abbe56e057f20f883e', '1234', 'role_m', 9, '2019-04-16 11:52:29', '2019-04-16 11:53:25');
INSERT INTO `user` VALUES ('4ef36ecd45e24a87b2496daabea16488', '111', 'e10adc3949ba59abbe56e057f20f883e', '111', 'role_m', 9, '2019-04-15 20:19:00', '2019-04-15 20:21:56');
INSERT INTO `user` VALUES ('5145ccf7166a42bbbbb7281e8fd64e62', 'hujiaxing1', 'hujiaxing', '胡哥', 'role_s', 0, '2019-04-17 17:03:34', '2019-04-17 17:03:34');
INSERT INTO `user` VALUES ('640b5f999dd3463ab983a3a98b72ec08', 'xiongweimin', 'e10adc3949ba59abbe56e057f20f883e', 'xiong', 'role_m', 0, '2019-04-14 21:02:29', '2019-04-15 20:30:28');
INSERT INTO `user` VALUES ('6b5e089306814bc59d00104e71af15cb', '123', 'e10adc3949ba59abbe56e057f20f883e', '123', 'role_m', 9, '2019-04-16 10:20:55', '2019-04-16 11:53:23');
INSERT INTO `user` VALUES ('7f154b966a1740ccb469c3c346fa1143', '789', 'e10adc3949ba59abbe56e057f20f883e', '湖骨与', 'role_t', 9, '2019-04-17 15:56:56', '2019-04-17 16:00:35');
INSERT INTO `user` VALUES ('9cf13ffb3ba24323b2a5c7934982bb01', '12', 'e10adc3949ba59abbe56e057f20f883e', '12', 'role_m', 9, '2019-04-15 20:05:57', '2019-04-15 20:19:04');
INSERT INTO `user` VALUES ('ba032a2e116d4168a9492637894ed34d', '123', '123456', '123', 'role_m', 9, '2019-04-15 20:01:13', '2019-04-15 20:23:51');
INSERT INTO `user` VALUES ('c35347e1af92485588be4021ae3efdd7', 'gongweidada', 'e10adc3949ba59abbe56e057f20f883e', '大爷', 'role_t', 0, '2019-04-16 22:28:43', '2019-04-17 19:11:54');
INSERT INTO `user` VALUES ('c999f927571c4030bce9224b67144384', '12345', 'e10adc3949ba59abbe56e057f20f883e', '121', 'role_m', 0, '2019-04-16 11:52:38', '2019-04-16 11:52:38');
INSERT INTO `user` VALUES ('d4f09057a379412d8de7ceb347ade44b', '123', 'e10adc3949ba59abbe56e057f20f883e', '胡66', 'role_t', 0, '2019-04-17 15:56:01', '2019-04-17 20:52:14');
INSERT INTO `user` VALUES ('eb740d3009e94c548f8a924421954949', 'moubangkai', 'moubangkai', 'moubang', 'role_m', 0, '2019-04-14 18:44:16', '2019-04-14 18:44:16');
INSERT INTO `user` VALUES ('eff346e6853e46ddb5a183b8f0eb705a', '21213', 'e10adc3949ba59abbe56e057f20f883e', '胡汉三', 'role_t', 0, '2019-04-17 20:48:11', '2019-04-17 20:48:11');
INSERT INTO `user` VALUES ('fc6', '3212312', 'e10adc3949ba59abbe56e057f20f883e', '成秀', 'role_t', 0, '2019-04-17 20:48:57', '2019-04-17 20:48:57');
INSERT INTO `user` VALUES ('u111', 'admin', 'd60ac76ab04f02258b6e5cbcd5b79e3a', '超级管理员', 'role_admin', 0, '2019-04-13 01:11:13', '2019-04-13 01:11:18');
INSERT INTO `user` VALUES ('u222', 'gongwei', 'gongwei', '大爷', 'role_t', 0, '2019-04-14 14:16:40', '2019-04-17 19:07:33');
INSERT INTO `user` VALUES ('u333', 'hujiaxing', 'hujiaxing', '胡哥', 'role_s', 0, '2019-04-14 14:33:18', '2019-04-17 17:02:40');
INSERT INTO `user` VALUES ('u444', 'xiongweimin1', 'e10adc3949ba59abbe56e057f20f883e', '熊伟闵', 'role_m', 0, '2019-04-14 14:34:57', '2019-04-15 20:29:36');
INSERT INTO `user` VALUES ('u555', 'xiongweimin2', 'xiongweimin2', '熊伟名', 'role_m', 0, '2019-04-14 14:34:57', '2019-04-14 14:35:00');
INSERT INTO `user` VALUES ('u666', 'xiongweimin3', 'e10adc3949ba59abbe56e057f20f883e', '熊伟', 'role_m', 0, '2019-04-14 14:34:57', '2019-04-15 20:30:58');
INSERT INTO `user` VALUES ('u777', 'xiongweimin4', 'xiongweimin4', '熊伟', 'role_m', 0, '2019-04-14 14:34:57', '2019-04-14 14:35:00');

SET FOREIGN_KEY_CHECKS = 1;
