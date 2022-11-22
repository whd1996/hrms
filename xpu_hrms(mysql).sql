/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : xpu_hrms

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 22/11/2022 11:13:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for db_department
-- ----------------------------
DROP TABLE IF EXISTS `db_department`;
CREATE TABLE `db_department`
(
    `id`              char(32) CHARACTER SET utf8 COLLATE utf8_general_ci     NOT NULL,
    `department_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '部门名',
    `position`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '职位类型 职位名',
    `duty`            varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职责',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_department
-- ----------------------------
INSERT INTO `db_department`
VALUES ('0f589f2cf1b3478e88f812061d9c6134', '人事部', '分析员', '分析人事部业务');
INSERT INTO `db_department`
VALUES ('2700889d4b61439a925a842ee37bdc79', '技术部', '主管', '技术部主管  负责管理技术部员工');
INSERT INTO `db_department`
VALUES ('29e1843650de4002ba53e4e368e8aed2', '行政部', '经理', '行政部经理  负责管理行政部主管');
INSERT INTO `db_department`
VALUES ('2c88936b2b064c2782137c59295c808d', '销售部', '秘书', '陪老板吃饭');
INSERT INTO `db_department`
VALUES ('35ced4a9750b469aace5ed448e31a606', '财务部', '业务分析员', '分析财务部业务');
INSERT INTO `db_department`
VALUES ('4953f8f1fb0d47c9946f589586bdf70e', '销售部', '秘书', '我是秘书');
INSERT INTO `db_department`
VALUES ('4eefc4a866f94b30b93651468ba10581', '技术部', '业务分析员', '跑业务的小短腿');
INSERT INTO `db_department`
VALUES ('561f59cbdb9c4b31a042b4d7fcbb82c4', '技术部', '经理', '技术部经理');
INSERT INTO `db_department`
VALUES ('692e9481bdb749f1856a850b42cabaff', '财务部', '秘书', '财务部秘书');
INSERT INTO `db_department`
VALUES ('71241ca0a32446cd8611a97637353259', '销售部', '经理', '我是销售部经理');
INSERT INTO `db_department`
VALUES ('7dcd484374e244e8ad4ffcc450ee7181', '人事部', '员工', '人事部员工  负责人事部基础业务');
INSERT INTO `db_department`
VALUES ('8059592f61be400bb30ff2a374306c9d', '行政部', '业务分析员', '分析行政部业务');
INSERT INTO `db_department`
VALUES ('853cc43ee9094998b17ceeec8df77667', '行政部', '主管', '行政部主管  负责管理行政部员工');
INSERT INTO `db_department`
VALUES ('8661cc2a8fb24eacb97260ff922988d1', '人事部', '秘书', '人事部秘书');
INSERT INTO `db_department`
VALUES ('87b7ec5d000a4da8829cd2aed02ca2ba', '销售部', '销售', '我是一个销售');
INSERT INTO `db_department`
VALUES ('9e69bf1fcd2c410291815b2113673fa1', '技术部', '员工', '技术部员工  负责技术部基础业务');
INSERT INTO `db_department`
VALUES ('b64aaeb1700f446e99b014270ba45f52', '行政部', '秘书', '我是秘书');
INSERT INTO `db_department`
VALUES ('c4a1d7490473404bacb2d098c188af37', '人事部', '经理', '2222');
INSERT INTO `db_department`
VALUES ('c956d4f7beb84c8cb73a37f281bcb49c', '市场部', '经理', '市场部经理');
INSERT INTO `db_department`
VALUES ('c96b1807ff7f4394a0547276469458cd', '人事部', '主管', '人事部主管');
INSERT INTO `db_department`
VALUES ('d884789f1b404f8cafd7680b3251e0ac', '财务部', '经理', '财务部经理  负责管理财务部主管');
INSERT INTO `db_department`
VALUES ('f0effbff3fdf44f0baab916f6491cfad', '财务部', '员工', '财务部员工  负责财务部基础员工');
INSERT INTO `db_department`
VALUES ('f385cfce187c40b5ab15ec0ecf187572', '技术部', '秘书', '技术部秘书');
INSERT INTO `db_department`
VALUES ('f9caca3284704687ac3aa7fa3313be5e', '行政部', '员工', '行政部员工  负责行政部基础业务');
INSERT INTO `db_department`
VALUES ('fa8374f8bfd34ce4993cde4c0e69e388', '财务部', '主管', '财务部主管  负责管理财务部员工');

-- ----------------------------
-- Table structure for db_file
-- ----------------------------
DROP TABLE IF EXISTS `db_file`;
CREATE TABLE `db_file`
(
    `id`           char(32) CHARACTER SET utf8 COLLATE utf8_general_ci     NOT NULL,
    `file_name`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '制度文件名/公告名',
    `file_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件/公告内容',
    `post_time`    datetime                                                NOT NULL COMMENT '提交日期',
    `post_staff`   varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '提交者',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_file
-- ----------------------------
INSERT INTO `db_file`
VALUES ('1a8ddf84d1a94576bf9e6cee808ccf4c', '人事部主管说明', '大乔第一次当主管 有点紧张', '2022-06-29 15:57:31',
        '大乔');
INSERT INTO `db_file`
VALUES ('3e3d7ec7ee4448018c03a52460954ded', '人事部经理说明', '我-->貂蝉!不是第一次当领导，你们现在都归我管',
        '2022-06-29 16:03:40', '貂蝉');
INSERT INTO `db_file`
VALUES ('a7f90599be89411981843276765f4334', '制度文件一', '上班时不准打瞌睡', '2022-06-28 08:36:25', '管理员');
INSERT INTO `db_file`
VALUES ('cb3ca22f208a455eb9276bfab221f127', '制度文件二', '上班时不准吃东西', '2022-06-29 13:03:36', '管理员');

-- ----------------------------
-- Table structure for db_interviewee
-- ----------------------------
DROP TABLE IF EXISTS `db_interviewee`;
CREATE TABLE `db_interviewee`
(
    `id`                 char(32) CHARACTER SET utf8 COLLATE utf8_general_ci     NOT NULL,
    `name`               varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '面试者名字',
    `sex`                varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '性别',
    `age`                int                                                     NULL DEFAULT NULL COMMENT '年龄',
    `desired_position`   varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '期望职位',
    `desired_department` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '期望部门',
    `work_experience`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作经历',
    `work_grade`         varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '工作成绩',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_interviewee
-- ----------------------------
INSERT INTO `db_interviewee`
VALUES ('0027837d6e674acfae0e1b26518879d6', '瑶妹', '女', 16, '秘书', '销售部', '网易ceo的秘书', '年薪百万');
INSERT INTO `db_interviewee`
VALUES ('9e3bcfa80962475e8b31737e400083d3', '妲己', '女', 16, '经理', '行政部', '助纣为虐', '酒池肉林');

-- ----------------------------
-- Table structure for db_position
-- ----------------------------
DROP TABLE IF EXISTS `db_position`;
CREATE TABLE `db_position`
(
    `id`              char(32) CHARACTER SET utf8 COLLATE utf8_general_ci    NOT NULL,
    `position_level`  char(50) CHARACTER SET utf8 COLLATE utf8_general_ci    NOT NULL COMMENT '职位等级',
    `position_salary` float                                                  NOT NULL COMMENT '对应薪资',
    `position`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职位名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_position
-- ----------------------------
INSERT INTO `db_position`
VALUES ('207e034ed4ef4019abb7bf538f2b1ee9', '中级主管', 7000, '主管');
INSERT INTO `db_position`
VALUES ('25fd27ecb19947ec897aaab6e4ab041e', '中级分析员', 6500, '业务分析员');
INSERT INTO `db_position`
VALUES ('29d35d6b970a40fe87de44fe2c64c7d7', '中级经理', 10000, '经理');
INSERT INTO `db_position`
VALUES ('4eb03139a90c407ab9acc9e1b6fcaadb', '低级员工', 1000, '员工');
INSERT INTO `db_position`
VALUES ('50da491500c94f73b3d94dbf4c0763bf', '低级主管', 6000, '主管');
INSERT INTO `db_position`
VALUES ('5ab06defcb344ad29c0239bffa8f1888', '高级秘书', 15000, '秘书');
INSERT INTO `db_position`
VALUES ('9ba53feaffd946cab218dfc0ac2244ba', '中级员工', 2000, '员工');
INSERT INTO `db_position`
VALUES ('b15b050034274147ad4ad2fe3f1d55c1', '高级员工', 10000, '员工');
INSERT INTO `db_position`
VALUES ('b8d8bd03c0f049f6a535912e9ca869d3', '高级主管', 10000, '主管');
INSERT INTO `db_position`
VALUES ('e12f156218084d64856b9b3f1fdf5eee', '高级分析员', 7000, '业务分析员');
INSERT INTO `db_position`
VALUES ('e2064d43be584fff963cc866208f161e', '高级销售', 15000, '销售');
INSERT INTO `db_position`
VALUES ('f14b49ae18df43a29a16bf9ccf1f21a0', '低级业务分析员', 5500, '业务分析员');
INSERT INTO `db_position`
VALUES ('f852c1b4b1554bed9f978d383eae85eb', '高级经理', 30000, '经理');

-- ----------------------------
-- Table structure for db_staff
-- ----------------------------
DROP TABLE IF EXISTS `db_staff`;
CREATE TABLE `db_staff`
(
    `id`               char(32) CHARACTER SET utf8 COLLATE utf8_general_ci    NOT NULL,
    `name`             varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工姓名',
    `sex`              varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
    `age`              int                                                    NULL DEFAULT NULL COMMENT '年龄',
    `place`            varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '籍贯',
    `birth`            datetime                                               NULL DEFAULT NULL COMMENT '生日',
    `tel`              varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
    `staff_department` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门  依赖部门表的部门',
    `staff_position`   varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职位 依赖职位表的职位',
    `entry_time`       datetime                                               NOT NULL COMMENT '入职日期',
    `leave_time`       datetime                                               NULL DEFAULT NULL COMMENT '离职日期  未离职则为null',
    `isdelete`         varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否离职 离职标记为1',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_staff
-- ----------------------------
INSERT INTO `db_staff`
VALUES ('0bba9de8559d42bb8dacf0d917ba292d', '貂蝉', '女', 18, '陕西渭南', '2022-07-02 00:00:00', '16609321624',
        'c4a1d7490473404bacb2d098c188af37', 'f852c1b4b1554bed9f978d383eae85eb', '2022-06-29 12:23:58', NULL, '0');
INSERT INTO `db_staff`
VALUES ('38b52c68755149fcb40a3f8890324519', '王昭君', '女', 20, '甘肃兰州', '2022-06-14 00:00:00', '16609321656',
        '7dcd484374e244e8ad4ffcc450ee7181', 'b15b050034274147ad4ad2fe3f1d55c1', '2022-06-29 16:13:09', NULL, '0');
INSERT INTO `db_staff`
VALUES ('40cb03555e0949f9b273330235247d3f', '蔡文姬', '女', 16, '河南洛阳', '2022-06-09 00:00:00', '16609321656',
        'd884789f1b404f8cafd7680b3251e0ac', 'f852c1b4b1554bed9f978d383eae85eb', '2022-06-29 13:02:06', NULL, '0');
INSERT INTO `db_staff`
VALUES ('590af99f3d884cfc820c252b0711e91f', '孙策', '男', 26, '东吴', '2022-06-23 00:00:00', '16609321626',
        '9e69bf1fcd2c410291815b2113673fa1', '4eb03139a90c407ab9acc9e1b6fcaadb', '2022-06-29 12:40:57',
        '2022-06-29 12:42:50', '1');
INSERT INTO `db_staff`
VALUES ('5eb6550651434edcb1eeb8e4b8cdcc31', '小乔', '女', 16, '河南洛阳', '2022-06-10 00:00:00', '16609321626',
        '8661cc2a8fb24eacb97260ff922988d1', '5ab06defcb344ad29c0239bffa8f1888', '2022-06-29 15:43:20', NULL, '0');
INSERT INTO `db_staff`
VALUES ('6f8c36760bae4a7888eb3b31f7a3419f', '小花', '女', 16, '河南洛阳', '2022-07-22 00:00:00', '16609321624',
        '2700889d4b61439a925a842ee37bdc79', 'b8d8bd03c0f049f6a535912e9ca869d3', '2022-07-04 10:54:36',
        '2022-07-04 10:58:46', '1');
INSERT INTO `db_staff`
VALUES ('8273b454ca9b42b586a2b143b7b81092', '大乔', '女', 18, '河南洛阳', '2022-06-24 00:00:00', '16609321624',
        'c96b1807ff7f4394a0547276469458cd', 'b8d8bd03c0f049f6a535912e9ca869d3', '2022-06-29 15:45:43', NULL, '0');
INSERT INTO `db_staff`
VALUES ('953a9674b2b743ec94a37519409a85fd', '嫦娥', '女', 1089, '月球', '2022-07-08 00:00:00', '16609321622',
        '0f589f2cf1b3478e88f812061d9c6134', 'e12f156218084d64856b9b3f1fdf5eee', '2022-07-02 13:18:54', NULL, '0');
INSERT INTO `db_staff`
VALUES ('ec268f4b40cb4d899b94708c61e61759', '张良', '男', 25, '陕西西安', '2022-06-18 00:00:00', '16609321622',
        'c956d4f7beb84c8cb73a37f281bcb49c', 'f852c1b4b1554bed9f978d383eae85eb', '2022-06-29 15:48:05', NULL, '0');
INSERT INTO `db_staff`
VALUES ('f01c67db8c7f45cd8dc1f678ba9e86b2', '安琪拉', '女', 16, '河南洛阳', NULL, '16609321656',
        '87b7ec5d000a4da8829cd2aed02ca2ba', 'e2064d43be584fff963cc866208f161e', '2022-07-04 12:28:15', NULL, '0');

-- ----------------------------
-- Table structure for db_user
-- ----------------------------
DROP TABLE IF EXISTS `db_user`;
CREATE TABLE `db_user`
(
    `id`            char(32) CHARACTER SET utf8 COLLATE utf8_general_ci    NOT NULL,
    `staff_name`    varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号（员工）姓名',
    `user_account`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录用账号',
    `user_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录用密码',
    `creat_time`    datetime                                               NOT NULL COMMENT '账号创建日期',
    `role_id`       int                                                    NOT NULL COMMENT '账号权限等级 总经理-3 部门经理-2  部门主管-1 其他 -0',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_user
-- ----------------------------
INSERT INTO `db_user`
VALUES ('0027837d6e674acfae0e1b26518879d6', '瑶妹', '瑶', 'a206f2bb318c7bb746c47ecd865b2ef9', '2022-07-02 13:23:20', 0);
INSERT INTO `db_user`
VALUES ('0bba9de8559d42bb8dacf0d917ba292d', '貂蝉', '貂蝉', 'fbf45f034b7ad3e64518f3b45a4b04ab', '2022-06-29 12:22:21',
        2);
INSERT INTO `db_user`
VALUES ('10000', '管理员', 'admin', 'fbf45f034b7ad3e64518f3b45a4b04ab', '2022-06-15 12:13:59', 3);
INSERT INTO `db_user`
VALUES ('38b52c68755149fcb40a3f8890324519', '王昭君', '王昭君', 'fbf45f034b7ad3e64518f3b45a4b04ab',
        '2022-06-29 16:11:07', 0);
INSERT INTO `db_user`
VALUES ('40cb03555e0949f9b273330235247d3f', '蔡文姬', '蔡文姬', 'fbf45f034b7ad3e64518f3b45a4b04ab',
        '2022-06-29 12:27:37', 2);
INSERT INTO `db_user`
VALUES ('5eb6550651434edcb1eeb8e4b8cdcc31', '小乔', '小乔', 'fbf45f034b7ad3e64518f3b45a4b04ab', '2022-06-29 15:42:09',
        0);
INSERT INTO `db_user`
VALUES ('8273b454ca9b42b586a2b143b7b81092', '大乔', '大乔', '29d55954aa0de93054b2dfed0d3bb0ac', '2022-06-29 15:36:20',
        1);
INSERT INTO `db_user`
VALUES ('953a9674b2b743ec94a37519409a85fd', '嫦娥', '嫦娥', 'fbf45f034b7ad3e64518f3b45a4b04ab', '2022-06-29 17:00:19',
        0);
INSERT INTO `db_user`
VALUES ('ec268f4b40cb4d899b94708c61e61759', '张良', '张良', 'fbf45f034b7ad3e64518f3b45a4b04ab', '2022-06-29 15:47:25',
        2);
INSERT INTO `db_user`
VALUES ('f01c67db8c7f45cd8dc1f678ba9e86b2', '安琪拉', 'anqila', 'fbf45f034b7ad3e64518f3b45a4b04ab',
        '2022-06-29 15:48:55', 0);

SET FOREIGN_KEY_CHECKS = 1;
