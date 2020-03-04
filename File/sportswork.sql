/*
 Navicat Premium Data Transfer

 Source Server         : me
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : sportswork

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 05/03/2020 00:27:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `classhour` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '1大学英语', '1', '1');
INSERT INTO `course` VALUES ('10', '10大学英语', '2', '10');
INSERT INTO `course` VALUES ('11', '11大学英语', '412', '11');
INSERT INTO `course` VALUES ('12', '12大学英语', '4342', '12');
INSERT INTO `course` VALUES ('13', '13大学英语', '1324', '13');
INSERT INTO `course` VALUES ('14', '14大学英语', '1432', '14');
INSERT INTO `course` VALUES ('15', '15大学英语', '4214', '15');
INSERT INTO `course` VALUES ('16', '16大学英语', '4324', '16');
INSERT INTO `course` VALUES ('17', '17大学英语', '4321', '17');
INSERT INTO `course` VALUES ('18', '18大学英语', 'test1', '18');
INSERT INTO `course` VALUES ('19', '19大学英语', 'cccccc', '19');
INSERT INTO `course` VALUES ('2', '2大学英语', '11', '2');
INSERT INTO `course` VALUES ('3', '3大学英语', '111', '3');
INSERT INTO `course` VALUES ('4', '4大学英语', '12', '4');
INSERT INTO `course` VALUES ('5', '5大学英语', '142', '5');
INSERT INTO `course` VALUES ('6', '6大学英语', '432', '6');
INSERT INTO `course` VALUES ('7', '7大学英语', '43214', '7');
INSERT INTO `course` VALUES ('8', '8大学英语', '4214', '8');
INSERT INTO `course` VALUES ('9', '9大学英语', '2142', '9');

-- ----------------------------
-- Table structure for elective
-- ----------------------------
DROP TABLE IF EXISTS `elective`;
CREATE TABLE `elective`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `student_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `teaching_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `score` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`, `teaching_id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE,
  INDEX `teaching_id`(`teaching_id`) USING BTREE,
  CONSTRAINT `student_id` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `teaching_id` FOREIGN KEY (`teaching_id`) REFERENCES `teaching` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of elective
-- ----------------------------
INSERT INTO `elective` VALUES ('232', '231', '1', '99');
INSERT INTO `elective` VALUES ('231', '231', '2', '50');

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `count` int(10) NULL DEFAULT NULL,
  `lend` int(10) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO `equipment` VALUES ('1', '1', 3, 1);

-- ----------------------------
-- Table structure for equipment_lease
-- ----------------------------
DROP TABLE IF EXISTS `equipment_lease`;
CREATE TABLE `equipment_lease`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `student_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `equipment_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `borrow_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `lending_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `return_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of equipment_lease
-- ----------------------------
INSERT INTO `equipment_lease` VALUES ('1', '1', '1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for field
-- ----------------------------
DROP TABLE IF EXISTS `field`;
CREATE TABLE `field`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of field
-- ----------------------------
INSERT INTO `field` VALUES ('1', 'd', '1');

-- ----------------------------
-- Table structure for field_lease
-- ----------------------------
DROP TABLE IF EXISTS `field_lease`;
CREATE TABLE `field_lease`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `student_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `field_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `borrow_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `lending_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of field_lease
-- ----------------------------
INSERT INTO `field_lease` VALUES ('1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for game
-- ----------------------------
DROP TABLE IF EXISTS `game`;
CREATE TABLE `game`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `area` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of game
-- ----------------------------
INSERT INTO `game` VALUES ('1', '1', '1', '1');

-- ----------------------------
-- Table structure for game_enroll
-- ----------------------------
DROP TABLE IF EXISTS `game_enroll`;
CREATE TABLE `game_enroll`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `student_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `game_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `score` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of game_enroll
-- ----------------------------
INSERT INTO `game_enroll` VALUES ('1', '1', '1', '1');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `parent_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `level` int(16) NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `order` int(16) NULL DEFAULT NULL,
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '用户信息管理', '0', 1, 'javascript;', 1, '');
INSERT INTO `menu` VALUES ('10', '授课管理', '2', 2, 'admin/teaching/list', 2, NULL);
INSERT INTO `menu` VALUES ('11', '场地管理', '3', 2, 'javascript;', 1, NULL);
INSERT INTO `menu` VALUES ('12', '器材管理', '3', 2, 'admin/equipment/list', 2, NULL);
INSERT INTO `menu` VALUES ('13', '体测管理', '4', 2, 'admin/sportsTest/list', 1, NULL);
INSERT INTO `menu` VALUES ('14', '比赛管理', '4', 2, 'admin/game/list', 2, NULL);
INSERT INTO `menu` VALUES ('15', '场地列表', '11', 3, 'admin/field/list', 1, NULL);
INSERT INTO `menu` VALUES ('16', '场地租借记录', '11', 3, 'admin/fieldLease/list', 2, NULL);
INSERT INTO `menu` VALUES ('17', '器材列表', '12', 3, 'admin/equipment/list', 1, NULL);
INSERT INTO `menu` VALUES ('18', '器材租借记录', '12', 3, 'admin/equipmentLease/list', 2, NULL);
INSERT INTO `menu` VALUES ('19', '菜单设置', '5', 2, 'admin/menu/list', 1, NULL);
INSERT INTO `menu` VALUES ('2', '课程管理', '0', 1, 'javascript;', 4, NULL);
INSERT INTO `menu` VALUES ('20', '学生选课管理', '2', 2, 'admin/elective/list', 3, NULL);
INSERT INTO `menu` VALUES ('3', '体育设施管理', '0', 1, 'javascript;', 5, NULL);
INSERT INTO `menu` VALUES ('4', '体育活动', '0', 1, 'javascript;', 7, NULL);
INSERT INTO `menu` VALUES ('5', '菜单管理', '0', 1, 'javascript;', 9, NULL);
INSERT INTO `menu` VALUES ('6', '账户管理', '1', 2, 'admin/user/list', 1, NULL);
INSERT INTO `menu` VALUES ('7', '学生管理', '1', 2, 'admin/student/list', 2, NULL);
INSERT INTO `menu` VALUES ('8', '教师管理', '1', 2, 'admin/teacher/list', 3, NULL);
INSERT INTO `menu` VALUES ('9', '课程表', '2', 2, 'admin/course/list', 1, NULL);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ROLE_admin', '管理员');
INSERT INTO `role` VALUES ('2', 'ROLE_user', '用户');
INSERT INTO `role` VALUES ('3', 'ROLE_student', '学生');
INSERT INTO `role` VALUES ('4', 'ROLE_teacher', '教师');
INSERT INTO `role` VALUES ('5', 'ROLE_equipment_admin', '设备管理员');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `role_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `menu_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('1', '1', '1');
INSERT INTO `role_menu` VALUES ('10', '1', '10');
INSERT INTO `role_menu` VALUES ('11', '1', '11');
INSERT INTO `role_menu` VALUES ('12', '1', '12');
INSERT INTO `role_menu` VALUES ('13', '1', '13');
INSERT INTO `role_menu` VALUES ('14', '1', '14');
INSERT INTO `role_menu` VALUES ('15', '1', '15');
INSERT INTO `role_menu` VALUES ('16', '1', '16');
INSERT INTO `role_menu` VALUES ('17', '1', '17');
INSERT INTO `role_menu` VALUES ('18', '1', '18');
INSERT INTO `role_menu` VALUES ('19', '1', '19');
INSERT INTO `role_menu` VALUES ('2', '1', '2');
INSERT INTO `role_menu` VALUES ('3', '1', '3');
INSERT INTO `role_menu` VALUES ('4', '1', '4');
INSERT INTO `role_menu` VALUES ('5', '1', '5');
INSERT INTO `role_menu` VALUES ('6', '1', '6');
INSERT INTO `role_menu` VALUES ('7', '1', '7');
INSERT INTO `role_menu` VALUES ('8', '1', '8');
INSERT INTO `role_menu` VALUES ('9', '1', '9');

-- ----------------------------
-- Table structure for sports_test
-- ----------------------------
DROP TABLE IF EXISTS `sports_test`;
CREATE TABLE `sports_test`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pass_mark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sports_test
-- ----------------------------
INSERT INTO `sports_test` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `profession` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('231', '李喜东', '男,女', '1246464', 'ccccc');
INSERT INTO `student` VALUES ('232', 'fd', '男', '3542145641', 'aaaaa');
INSERT INTO `student` VALUES ('8af7f1365d4a11eab33154e1ad23325a', 'fsdfa', '男', '21132546', 'agdsgfsdf');
INSERT INTO `student` VALUES ('aea15f7e5d4a11eab33154e1ad23325a', '灵魂健身杨老师', '男', '16545323131', '体育');
INSERT INTO `student` VALUES ('cff9e0ab5d4d11eab33154e1ad23325a', 'dsafafdsaf', '男', '14532134', 'adsgdas');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '1张一', '男', '1');
INSERT INTO `teacher` VALUES ('2', '2张二', '男', '2');
INSERT INTO `teacher` VALUES ('3', '3张三', '女', '3');

-- ----------------------------
-- Table structure for teaching
-- ----------------------------
DROP TABLE IF EXISTS `teaching`;
CREATE TABLE `teaching`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `teacher_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `course_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `semester` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `state` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `course_id`(`course_id`) USING BTREE,
  INDEX `teacher_id`(`teacher_id`) USING BTREE,
  CONSTRAINT `course_id` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teaching
-- ----------------------------
INSERT INTO `teaching` VALUES ('1', '3', '1', 'cc', 0);
INSERT INTO `teaching` VALUES ('2', '1', '8', 'dfs', 0);
INSERT INTO `teaching` VALUES ('3', '1', '3', '1111111', 1);
INSERT INTO `teaching` VALUES ('e4ca75965e1711eab33154e1ad23325a', '2', '2', '22222', 0);

-- ----------------------------
-- Table structure for test_record
-- ----------------------------
DROP TABLE IF EXISTS `test_record`;
CREATE TABLE `test_record`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `student_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sports_test_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `score` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `semester` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_record
-- ----------------------------
INSERT INTO `test_record` VALUES ('1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `open_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_del` int(1) NOT NULL DEFAULT 0,
  `register_time` bigint(20) NOT NULL DEFAULT 0,
  `role_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_user_account_uindex`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '1', '1', '1', 1, 0, '231');
INSERT INTO `user` VALUES ('15680b3a5c4811eab33154e1ad23325a', NULL, '4444444', '4444444', '4444444', 0, 1583127523046, NULL);
INSERT INTO `user` VALUES ('227cafc25c4811eab33154e1ad23325a', NULL, '5555555', '5555555', '5555555', 0, 1583127544993, NULL);
INSERT INTO `user` VALUES ('3', '3', '3', '3', '3', 0, 0, '231');
INSERT INTO `user` VALUES ('3488180b5c4711eab33154e1ad23325a', NULL, '222222222', '222222222', '222222222', 0, 1583127145769, NULL);
INSERT INTO `user` VALUES ('6fe0afdf5c4711eab33154e1ad23325a', NULL, '3333333', '3333333', '3333333', 0, 1583127245335, NULL);
INSERT INTO `user` VALUES ('77e6d7665a2e11eab41754e1ad23325a', NULL, '5', '5', '5', 0, 1582896621473, NULL);
INSERT INTO `user` VALUES ('83ba75d55c4a11eab33154e1ad23325a', NULL, '9999999', '9999999', '9999999', 1, 1583128567129, NULL);
INSERT INTO `user` VALUES ('85cb79455d1d11eab33154e1ad23325a', NULL, 'kkkkkkkkkkk', 'kkkkkkkkkkk', 'kkkkkkkkkkk', 1, 1583219194390, NULL);
INSERT INTO `user` VALUES ('8b69be525c4511eab33154e1ad23325a', NULL, '123456', '123456', '123456', 0, 1583126426183, NULL);
INSERT INTO `user` VALUES ('ae4d520c5c4611eab33154e1ad23325a', NULL, '1111111111', '1111111111', '1111111111', 0, 1583126920569, NULL);
INSERT INTO `user` VALUES ('ae5216585d1a11eab33154e1ad23325a', NULL, 'roleCode', 'roleCode', 'roleCode', 0, 1583217973891, NULL);
INSERT INTO `user` VALUES ('af1ed2f85d1e11eab33154e1ad23325a', NULL, 'ppppppppp', 'ppppppppp', 'ppppppppp', 1, 1583219693219, NULL);
INSERT INTO `user` VALUES ('b499fd565c4811eab33154e1ad23325a', NULL, '6666666', '6666666', '6666666', 0, 1583127790132, NULL);
INSERT INTO `user` VALUES ('bc33b1d95c8111eab33154e1ad23325a', NULL, 'tttttttttttttt', 'cccccccccccccc', 'tttttttttttttt', 0, 1583152284188, NULL);
INSERT INTO `user` VALUES ('c2477c4e5c4511eab33154e1ad23325a', NULL, '1234567', '1234567', '1234567', 0, 1583126524589, NULL);
INSERT INTO `user` VALUES ('fccf1a025a2d11eab41754e1ad23325a', NULL, '4', '4', '4', 0, 1582896414958, NULL);
INSERT INTO `user` VALUES ('root', 'root', 'root', 'root', 'root', 0, 0, '');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `role_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', 'root', '1');
INSERT INTO `user_role` VALUES ('2', '1', '3');
INSERT INTO `user_role` VALUES ('3', '3', '4');
INSERT INTO `user_role` VALUES ('38b1750f5df411eab33154e1ad23325a', 'ae5216585d1a11eab33154e1ad23325a', '1');
INSERT INTO `user_role` VALUES ('77e7e4ba5a2e11eab41754e1ad23325a', '77e6d7665a2e11eab41754e1ad23325a', '2');
INSERT INTO `user_role` VALUES ('85cdc2285d1d11eab33154e1ad23325a', '85cb79455d1d11eab33154e1ad23325a', '4');
INSERT INTO `user_role` VALUES ('be356c1b5d3211eab33154e1ad23325a', 'af1ed2f85d1e11eab33154e1ad23325a', '1');
INSERT INTO `user_role` VALUES ('fcd0422d5a2d11eab41754e1ad23325a', 'fccf1a025a2d11eab41754e1ad23325a', '2');

SET FOREIGN_KEY_CHECKS = 1;
