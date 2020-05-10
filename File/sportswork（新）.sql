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

 Date: 11/05/2020 02:12:05
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
INSERT INTO `course` VALUES ('1', '游泳课', '40', '0001');
INSERT INTO `course` VALUES ('10', '篮球课', '40', '0002');
INSERT INTO `course` VALUES ('11', '登山跑', '40', '0003');
INSERT INTO `course` VALUES ('12', '骑行', '40', '0004');
INSERT INTO `course` VALUES ('13', '足球课', '40', '0005');
INSERT INTO `course` VALUES ('14', '网球课', '40', '0006');
INSERT INTO `course` VALUES ('15', '乒乓球课', '40', '0007');
INSERT INTO `course` VALUES ('16', '排球课', '40', '0008');
INSERT INTO `course` VALUES ('17', '投掷类课程', '40', '0009');
INSERT INTO `course` VALUES ('18', '田径类课程', '40', '0010');
INSERT INTO `course` VALUES ('19', '健身理论课', '40', '0011');
INSERT INTO `course` VALUES ('2', '人体研究', '40', '0012');
INSERT INTO `course` VALUES ('3', '体能训练课', '40', '0013');
INSERT INTO `course` VALUES ('4', '力量训练课', '40', '0014');
INSERT INTO `course` VALUES ('5', '技巧训练课', '40', '0015');
INSERT INTO `course` VALUES ('6', '羽毛球课', '40', '0016');
INSERT INTO `course` VALUES ('7', '太极课', '40', '0017');
INSERT INTO `course` VALUES ('8', '拳击课', '40', '0018');
INSERT INTO `course` VALUES ('9', '女子防身术', '40', '0019');

-- ----------------------------
-- Table structure for elective
-- ----------------------------
DROP TABLE IF EXISTS `elective`;
CREATE TABLE `elective`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `student_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `teaching_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `score` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE,
  INDEX `teaching_id`(`teaching_id`) USING BTREE,
  INDEX `student_id`(`student_id`) USING BTREE,
  CONSTRAINT `student_id` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `teaching_id` FOREIGN KEY (`teaching_id`) REFERENCES `teaching` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of elective
-- ----------------------------
INSERT INTO `elective` VALUES ('9443aade68c411ea9d5954e1ad23325a', '231', '2', NULL);

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
INSERT INTO `equipment` VALUES ('1', '乒乓球拍', 5, 0);
INSERT INTO `equipment` VALUES ('2', '篮球', 5, 0);

-- ----------------------------
-- Table structure for equipment_lease
-- ----------------------------
DROP TABLE IF EXISTS `equipment_lease`;
CREATE TABLE `equipment_lease`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `student_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `equipment_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `number` int(16) NULL DEFAULT NULL,
  `borrow_time` bigint(255) NULL DEFAULT NULL,
  `return_time` bigint(255) NULL DEFAULT NULL,
  `state` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of equipment_lease
-- ----------------------------
INSERT INTO `equipment_lease` VALUES ('02011cbc605611eab33154e1ad23325a', '1', '1', 4, 1583573307962, 1583574462224, 1);
INSERT INTO `equipment_lease` VALUES ('1', '1', '1', 1, 1583127245335, 1583574476508, 1);
INSERT INTO `equipment_lease` VALUES ('18c4dd4f605911eab33154e1ad23325a', '1', '1', 4, 1583574634649, 1583574703323, 1);
INSERT INTO `equipment_lease` VALUES ('2', '2', '2', 2, 1583127245335, 1583127233335, 1);

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
INSERT INTO `field` VALUES ('1', '9号篮球场', '1');
INSERT INTO `field` VALUES ('2', '3号号网球场', '0');

-- ----------------------------
-- Table structure for field_lease
-- ----------------------------
DROP TABLE IF EXISTS `field_lease`;
CREATE TABLE `field_lease`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `student_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `field_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `borrow_time` bigint(255) NULL DEFAULT NULL,
  `lending_time` double(16, 8) NULL DEFAULT NULL,
  `expire` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of field_lease
-- ----------------------------
INSERT INTO `field_lease` VALUES ('1', '1', '1', 1583127245335, 1.00000000, 1);
INSERT INTO `field_lease` VALUES ('2', '2', '2', 1583127245335, 2.00000000, 1);
INSERT INTO `field_lease` VALUES ('36a155bb604911eab33154e1ad23325a', '1', '1', 1583567812802, 2.00000000, 1);
INSERT INTO `field_lease` VALUES ('6c6327ca604d11eab33154e1ad23325a', '1', '1', 1583569620979, 0.00000000, 1);
INSERT INTO `field_lease` VALUES ('99d83c66604c11eab33154e1ad23325a', '1', '2', 1583569267745, 0.00000000, 1);
INSERT INTO `field_lease` VALUES ('99e44d7b604f11eab33154e1ad23325a', '2', '2', 1583570556307, 0.01000000, 1);
INSERT INTO `field_lease` VALUES ('a83a5791927f11eaaf6954e1ad23325a', '2', '1', 1589088756017, 1.00000000, 0);
INSERT INTO `field_lease` VALUES ('bdc2c7f4604e11eab33154e1ad23325a', '1', '1', 1583570186997, 0.01000000, 1);
INSERT INTO `field_lease` VALUES ('e2cd4a7c605011eab33154e1ad23325a', '231', '1', 1583571108135, 0.01000000, 1);

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
INSERT INTO `game` VALUES ('1', '2020年校运会男子2000米', '2020-04-11', '1号田径场');

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
INSERT INTO `menu` VALUES ('12', '器材管理', '3', 2, 'javascript;', 2, NULL);
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
INSERT INTO `menu` VALUES ('e_a1', '场地管理', '0', 1, 'javascript;', 1, NULL);
INSERT INTO `menu` VALUES ('e_a2', '器材管理', '0', 1, 'javascript;', 2, NULL);
INSERT INTO `menu` VALUES ('e_a3', '场地租借', 'e_a1', 2, 'equipment_admin/field/list', 1, NULL);
INSERT INTO `menu` VALUES ('e_a4', '场地租借记录', 'e_a1', 2, 'equipment_admin/fieldLease/list', 2, NULL);
INSERT INTO `menu` VALUES ('e_a5', '器材出租', 'e_a2', 2, 'equipment_admin/equipment/list', 1, NULL);
INSERT INTO `menu` VALUES ('e_a6', '器材归还', 'e_a2', 2, 'equipment_admin/equipmentLease/list', 2, NULL);
INSERT INTO `menu` VALUES ('s_1', '选课管理', '0', 1, 'javascript;', 1, NULL);
INSERT INTO `menu` VALUES ('s_2', '课程列表', 's_1', 2, 'student/teaching/teachingList', 1, NULL);
INSERT INTO `menu` VALUES ('s_3', '已选课程', 's_1', 2, 'student/elective/electiveList', 2, NULL);
INSERT INTO `menu` VALUES ('s_4', '场地信息', 's_1', 2, 'student/equipment/list', 3, NULL);
INSERT INTO `menu` VALUES ('s_5', '器材信息', 's_1', 2, 'student/field/list', 4, NULL);
INSERT INTO `menu` VALUES ('t_1', '授课管理', '0', 1, 'javascript;', 1, NULL);
INSERT INTO `menu` VALUES ('t_2', '我的授课', 't_1', 2, 'teacher/teaching/teachingList', 1, NULL);

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
INSERT INTO `role_menu` VALUES ('20', '5', 'e_a1');
INSERT INTO `role_menu` VALUES ('21', '5', 'e_a2');
INSERT INTO `role_menu` VALUES ('22', '5', 'e_a3');
INSERT INTO `role_menu` VALUES ('23', '5', 'e_a4');
INSERT INTO `role_menu` VALUES ('24', '5', 'e_a5');
INSERT INTO `role_menu` VALUES ('25', '5', 'e_a6');
INSERT INTO `role_menu` VALUES ('26', '3', 's_1');
INSERT INTO `role_menu` VALUES ('27', '3', 's_2');
INSERT INTO `role_menu` VALUES ('28', '3', 's_3');
INSERT INTO `role_menu` VALUES ('29', '4', 't_1');
INSERT INTO `role_menu` VALUES ('3', '1', '3');
INSERT INTO `role_menu` VALUES ('30', '4', 't_2');
INSERT INTO `role_menu` VALUES ('31', '3', 's_4');
INSERT INTO `role_menu` VALUES ('32', '3', 's_5');
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
INSERT INTO `sports_test` VALUES ('1', '2016级学生2020年2400米跑步测试', '12分钟优秀，13分钟及格');

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
INSERT INTO `student` VALUES ('1', '杨小怪', '男', '010001', '美术');
INSERT INTO `student` VALUES ('2', '李四喜', '男', '020001', '体育');
INSERT INTO `student` VALUES ('231', '李喜东', '男', '030001', '计算机');
INSERT INTO `student` VALUES ('232', '张狗蛋', '男', '040001', '机械工程');
INSERT INTO `student` VALUES ('47e827a6667f11eabb1754e1ad23325a', NULL, NULL, '999999999999', NULL);
INSERT INTO `student` VALUES ('8af7f1365d4a11eab33154e1ad23325a', '王老五', '男', '040001', '机械工程');
INSERT INTO `student` VALUES ('cff9e0ab5d4d11eab33154e1ad23325a', '凤傲天', '女', '050001', '文史学院');

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
INSERT INTO `teacher` VALUES ('1', '灵魂教练杨老师', '男', '0001');
INSERT INTO `teacher` VALUES ('2', '小苍老师', '女', '0002');
INSERT INTO `teacher` VALUES ('3', '波老师', '女', '0003');

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
  `week` int(2) NULL DEFAULT NULL,
  `time_arrange` int(2) NULL DEFAULT NULL,
  `field_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `course_id`(`course_id`) USING BTREE,
  INDEX `teacher_id`(`teacher_id`) USING BTREE,
  CONSTRAINT `course_id` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teaching
-- ----------------------------
INSERT INTO `teaching` VALUES ('1', '3', '1', '2019前半年', 1, 1, 1, '1');
INSERT INTO `teaching` VALUES ('2', '1', '8', '2019后半年', 0, 4, 4, '2');
INSERT INTO `teaching` VALUES ('3', '1', '3', '2018后半年', 1, 2, 2, '1');
INSERT INTO `teaching` VALUES ('e4ca75965e1711eab33154e1ad23325a', '2', '2', '2018前半年', 0, 6, 3, '2');

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
INSERT INTO `test_record` VALUES ('1', '1', '1', '85', '2019前半年');

-- ----------------------------
-- Table structure for time_axis
-- ----------------------------
DROP TABLE IF EXISTS `time_axis`;
CREATE TABLE `time_axis`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `start_time` bigint(255) NULL DEFAULT NULL,
  `end_time` bigint(255) NULL DEFAULT NULL,
  `field_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `field_lease_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of time_axis
-- ----------------------------
INSERT INTO `time_axis` VALUES ('083db84992ac11eaaf6954e1ad23325a', 20200511025014, 20200511045014, '1', NULL);
INSERT INTO `time_axis` VALUES ('7832db1d92e711eaaf6954e1ad23325a', 20200511120539, 20200511140539, '1', NULL);
INSERT INTO `time_axis` VALUES ('a83b587e927f11eaaf6954e1ad23325a', 1589088756017, 1589092356017, '1', 'a83a5791927f11eaaf6954e1ad23325a');

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
INSERT INTO `user` VALUES ('1', '1', 'student', 'student', '18673515332', 0, 0, '231');
INSERT INTO `user` VALUES ('15680b3a5c4811eab33154e1ad23325a', NULL, '4444444', '4444444', '18673515333', 0, 1583127523046, NULL);
INSERT INTO `user` VALUES ('227cafc25c4811eab33154e1ad23325a', NULL, '5555555', '5555555', '18673515432', 0, 1583127544993, NULL);
INSERT INTO `user` VALUES ('3', '3', 'teacher', 'teacher', '18673515332', 0, 0, '1');
INSERT INTO `user` VALUES ('3488180b5c4711eab33154e1ad23325a', NULL, '222222222', '222222222', '18673515332', 0, 1583127145769, NULL);
INSERT INTO `user` VALUES ('47e59c73667f11eabb1754e1ad23325a', NULL, '999999999999', '999999999999', '12345556666', 0, 1584250744116, NULL);
INSERT INTO `user` VALUES ('6fe0afdf5c4711eab33154e1ad23325a', NULL, '3333333', '3333333', '18673515332', 0, 1583127245335, NULL);
INSERT INTO `user` VALUES ('77e6d7665a2e11eab41754e1ad23325a', NULL, '5', '5', '18673515332', 0, 1582896621473, NULL);
INSERT INTO `user` VALUES ('83ba75d55c4a11eab33154e1ad23325a', NULL, '9999999', '9999999', '18673515332', 1, 1583128567129, NULL);
INSERT INTO `user` VALUES ('85cb79455d1d11eab33154e1ad23325a', NULL, 'kkkkkkkkkkk', 'kkkkkkkkkkk', '18673515332', 1, 1583219194390, NULL);
INSERT INTO `user` VALUES ('8b69be525c4511eab33154e1ad23325a', NULL, '123456', '123456', '18673515332', 0, 1583126426183, NULL);
INSERT INTO `user` VALUES ('ae4d520c5c4611eab33154e1ad23325a', NULL, '1111111111', '1111111111', '18673515332', 0, 1583126920569, NULL);
INSERT INTO `user` VALUES ('ae5216585d1a11eab33154e1ad23325a', NULL, 'roleCode', 'roleCode', '18673515332', 0, 1583217973891, NULL);
INSERT INTO `user` VALUES ('af1ed2f85d1e11eab33154e1ad23325a', NULL, 'ppppppppp', 'ppppppppp', '18673515332', 1, 1583219693219, NULL);
INSERT INTO `user` VALUES ('b499fd565c4811eab33154e1ad23325a', NULL, '6666666', '6666666', '18673515332', 0, 1583127790132, NULL);
INSERT INTO `user` VALUES ('bc33b1d95c8111eab33154e1ad23325a', NULL, 'tttttttttttttt', 'cccccccccccccc', '18673515332', 0, 1583152284188, NULL);
INSERT INTO `user` VALUES ('c2477c4e5c4511eab33154e1ad23325a', NULL, '1234567', '1234567', '18673515332', 0, 1583126524589, NULL);
INSERT INTO `user` VALUES ('equipment_admin', 'equipment_admin', 'equipment_admin', 'equipment_admin', '18673515332', 0, 0, NULL);
INSERT INTO `user` VALUES ('fccf1a025a2d11eab41754e1ad23325a', NULL, '4', '4', '18673515332', 0, 1582896414958, NULL);
INSERT INTO `user` VALUES ('root', 'root', 'root', 'root', '18673515332', 0, 0, '');

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
INSERT INTO `user_role` VALUES ('4', 'equipment_admin', '5');
INSERT INTO `user_role` VALUES ('47e77998667f11eabb1754e1ad23325a', '47e59c73667f11eabb1754e1ad23325a', '3');
INSERT INTO `user_role` VALUES ('77e7e4ba5a2e11eab41754e1ad23325a', '77e6d7665a2e11eab41754e1ad23325a', '2');
INSERT INTO `user_role` VALUES ('85cdc2285d1d11eab33154e1ad23325a', '85cb79455d1d11eab33154e1ad23325a', '4');
INSERT INTO `user_role` VALUES ('b8082f8665e811eabb1754e1ad23325a', 'b8075c9465e811eabb1754e1ad23325a', '3');
INSERT INTO `user_role` VALUES ('be356c1b5d3211eab33154e1ad23325a', 'af1ed2f85d1e11eab33154e1ad23325a', '1');
INSERT INTO `user_role` VALUES ('fcd0422d5a2d11eab41754e1ad23325a', 'fccf1a025a2d11eab41754e1ad23325a', '2');

-- ----------------------------
-- Procedure structure for UpdateTimeAxis
-- ----------------------------
DROP PROCEDURE IF EXISTS `UpdateTimeAxis`;
delimiter ;;
CREATE DEFINER=`root`@`%` PROCEDURE `UpdateTimeAxis`()
BEGIN
		# 声明变量
		declare field_id varchar(255);
    declare time_arrange int;
    declare flag int default 0;
		declare t_start_s varchar(255);
		declare t_end_s varchar(255);
		
		# 这是重点，定义一个游标来记录sql查询的结果
		declare t_list cursor for
			select teaching.field_id,
			(CASE teaching.time_arrange
							WHEN 1 THEN '08:00:00' 
							WHEN 2 THEN '10:10:00'
							WHEN 3 THEN '14:00:00'
							WHEN 4 THEN '16:10:00'	
							ELSE '00:00:00' 
						END) AS t_start_s,
			(CASE teaching.time_arrange
							WHEN 1 THEN '10:00:00' 
							WHEN 2 THEN '12:10:00'
							WHEN 3 THEN '15:00:00'
							WHEN 4 THEN '18:10:00'	
							ELSE '00:00:00' 
						END) AS t_end_s
			from teaching
			where teaching.state = 1 and teaching.week = dayofweek(now());
			
		# 为下面while循环建立一个退出标志，当游标遍历完后将flag的值设置为1
    declare continue handler for not found set flag=1;
		# 打开游标
		open t_list;
				# 将游标中的值赋给定义好的变量，实现for循环的要点
				fetch t_list into field_id, t_start_s, t_end_s;
				
			  while flag <> 1 do
						INSERT INTO time_axis(id, start_time, end_time, field_id) 
							VALUES(REPLACE(UUID(),"-",""),timestamp(now(), t_start_s),timestamp(now(), t_end_s),field_id);
						
            # 游标往后移（此处的游标是不是让你想起了C里面的指针）
            fetch t_list into field_id, time_arrange;
        end while;
				
		# 关闭游标
    close t_list;
END
;;
delimiter ;

-- ----------------------------
-- Event structure for UpdataTime
-- ----------------------------
DROP EVENT IF EXISTS `UpdataTime`;
delimiter ;;
CREATE DEFINER = `root`@`%` EVENT `UpdataTime`
ON SCHEDULE
EVERY '1' DAY STARTS '2020-05-10 00:00:00'
DO call UpdateTimeAxis()
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
