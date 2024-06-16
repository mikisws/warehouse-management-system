/*
 Navicat Premium Data Transfer

 Source Server         : 麦礼屋
 Source Server Type    : MySQL
 Source Server Version : 80024
 Source Host           : 47.104.16.104:3669
 Source Schema         : mywarehouse

 Target Server Type    : MySQL
 Target Server Version : 80024
 File Encoding         : 65001

 Date: 23/11/2023 21:47:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `customer_id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `address` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `manager` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `tale_phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`customer_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, '普通超市', 'XX省XX市XX区xxxx', '渣渣灰', '1805512512');
INSERT INTO `customer` VALUES (2, '京东商城', 'XX省XX市XX区xxxx', '细致', '180545451');
INSERT INTO `customer` VALUES (3, '天猫超市', 'XX省XX市xxxx', '里斯', '11541124520');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goods_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '货物id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '货物名',
  `provider_id` int(0) NULL DEFAULT NULL COMMENT '供货商id',
  `price` int(0) NULL DEFAULT NULL COMMENT '价格',
  `size` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '规格',
  `packages` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '包装',
  PRIMARY KEY (`goods_id`, `name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '可口可乐', 1, 43, '330ml/瓶', '24瓶/箱');
INSERT INTO `goods` VALUES (2, '百事可乐', 1, 42, '330ml/瓶', '24瓶/箱');
INSERT INTO `goods` VALUES (3, '雪碧', 2, 44, '330ml/瓶', '24瓶/箱');
INSERT INTO `goods` VALUES (4, '美年达', 4, 42, '330ml/瓶', '24瓶/箱');
INSERT INTO `goods` VALUES (5, '百威啤酒', 2, 88, '330ml/瓶', '24瓶/箱');
INSERT INTO `goods` VALUES (6, '碧泉', 3, 66, '330ml/瓶', '24瓶/箱');
INSERT INTO `goods` VALUES (7, '酷儿', 3, 60, '330ml/瓶', '24瓶/箱');
INSERT INTO `goods` VALUES (8, '芬达', 3, 44, '330ml/瓶', '24瓶/箱');

-- ----------------------------
-- Table structure for input_form
-- ----------------------------
DROP TABLE IF EXISTS `input_form`;
CREATE TABLE `input_form`  (
  `form_id` int(0) NOT NULL AUTO_INCREMENT,
  `provider_id` int(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `goods_id` int(0) NULL DEFAULT NULL,
  `house_id` int(0) NULL DEFAULT NULL,
  `change_number` int(0) NULL DEFAULT NULL,
  `user_id` int(0) NULL DEFAULT NULL COMMENT '负责人',
  PRIMARY KEY (`form_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of input_form
-- ----------------------------
INSERT INTO `input_form` VALUES (1, 1, '2020-07-02 00:00:00', 1, 1, 1, 1);
INSERT INTO `input_form` VALUES (3, 1, '2020-07-02 08:08:05', 1, 2, 1000, 2);
INSERT INTO `input_form` VALUES (4, 3, '2020-07-02 08:08:57', 5, 3, 123, 2);
INSERT INTO `input_form` VALUES (5, 3, '2020-07-02 08:10:09', 8, 2, 123, 2);
INSERT INTO `input_form` VALUES (6, 1, '2020-07-02 08:10:19', 3, 3, 555, 2);
INSERT INTO `input_form` VALUES (7, 2, '2020-07-02 08:10:27', 7, 2, 444, 2);
INSERT INTO `input_form` VALUES (8, 3, '2020-07-02 08:10:35', 6, 3, 444, 2);
INSERT INTO `input_form` VALUES (10, 3, '2020-07-02 08:10:52', 7, 3, 5555, 2);
INSERT INTO `input_form` VALUES (12, 1, '2020-07-02 08:17:33', 2, 2, 50, 2);
INSERT INTO `input_form` VALUES (13, 1, '2020-07-02 08:18:34', 2, 2, 555, 2);
INSERT INTO `input_form` VALUES (14, 3, '2020-07-02 15:38:50', 7, 3, 2000, 2);
INSERT INTO `input_form` VALUES (15, 3, '2020-07-02 15:43:55', 7, 3, 2000, 2);
INSERT INTO `input_form` VALUES (16, 1, '2020-07-03 14:29:33', 4, 4, 20, 2);
INSERT INTO `input_form` VALUES (17, 4, '2020-07-03 15:05:52', 4, 3, 20, 2);
INSERT INTO `input_form` VALUES (18, 1, '2020-07-03 15:06:46', 1, 1, 500, 2);

-- ----------------------------
-- Table structure for leftmenu
-- ----------------------------
DROP TABLE IF EXISTS `leftmenu`;
CREATE TABLE `leftmenu`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `pid` int(0) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `href` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `open` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 128 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of leftmenu
-- ----------------------------
INSERT INTO `leftmenu` VALUES (1, 0, '仓储管理系统', '&#xe68e;', '', 1);
INSERT INTO `leftmenu` VALUES (2, 1, '供应信息管理', '&#xe857;', '', 0);
INSERT INTO `leftmenu` VALUES (3, 1, '仓储管理', '&#xe645;', '', 1);
INSERT INTO `leftmenu` VALUES (5, 1, '系统管理', '&#xe614;', '', 0);
INSERT INTO `leftmenu` VALUES (6, 2, '供应商信息', '&#xe698;', '/sys/toProviderManager', 0);
INSERT INTO `leftmenu` VALUES (8, 3, '商品入库', '&#xe65b;', '/sys/toInputManager', 0);
INSERT INTO `leftmenu` VALUES (9, 3, '商品出库', '&#xe65a;', '/sys/toOutputManager', 0);
INSERT INTO `leftmenu` VALUES (10, 2, '客户信息', '&#xe66f;', '/sys/toCustomerManager', 0);
INSERT INTO `leftmenu` VALUES (17, 5, '角色管理', '&#xe650;', '/sys/toRoleManager', 0);
INSERT INTO `leftmenu` VALUES (18, 5, '用户管理', '&#xe612;', '/sys/toUserManager', 0);
INSERT INTO `leftmenu` VALUES (126, 2, '商品信息', '&#xe658;', '/sys/toGoodsManager', 0);
INSERT INTO `leftmenu` VALUES (127, 3, '基础设置', '&#xe716;', '/sys/toWarehouseManager', 0);

-- ----------------------------
-- Table structure for output_form
-- ----------------------------
DROP TABLE IF EXISTS `output_form`;
CREATE TABLE `output_form`  (
  `form_id` int(0) NOT NULL AUTO_INCREMENT,
  `customer_id` int(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `goods_id` int(0) NULL DEFAULT NULL,
  `house_id` int(0) NULL DEFAULT NULL,
  `change_number` int(0) NULL DEFAULT NULL,
  `user_id` int(0) NULL DEFAULT NULL COMMENT '负责人',
  PRIMARY KEY (`form_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of output_form
-- ----------------------------
INSERT INTO `output_form` VALUES (1, 1, '2020-07-02 00:00:00', 1, 1, 1000, 1);
INSERT INTO `output_form` VALUES (2, 2, '2020-07-03 02:51:18', 4, 2, 2000, 2);
INSERT INTO `output_form` VALUES (3, 2, '2020-07-03 04:48:39', 4, 1, 1, 2);
INSERT INTO `output_form` VALUES (4, 3, '2020-07-03 04:53:47', 4, 1, 20, 2);
INSERT INTO `output_form` VALUES (5, 2, '2020-07-03 04:54:05', 4, 1, 20, 2);
INSERT INTO `output_form` VALUES (6, 2, '2020-07-03 04:54:59', 6, 2, 20, 2);
INSERT INTO `output_form` VALUES (7, 2, '2020-07-03 04:55:09', 7, 3, 20, 2);
INSERT INTO `output_form` VALUES (8, 3, '2020-07-03 04:55:22', 6, 3, 20, 2);
INSERT INTO `output_form` VALUES (9, 2, '2020-07-03 09:50:33', 2, 2, 20, 7);
INSERT INTO `output_form` VALUES (10, 3, '2020-07-03 11:29:53', 6, 2, 20, 7);

-- ----------------------------
-- Table structure for provider
-- ----------------------------
DROP TABLE IF EXISTS `provider`;
CREATE TABLE `provider`  (
  `provider_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '供货商id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '供货商名称',
  `address` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  `manager` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `tale_phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '负责人电话',
  PRIMARY KEY (`provider_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of provider
-- ----------------------------
INSERT INTO `provider` VALUES (1, 'A饮料供应商', '广东省惠州市惠城区xxx', '张三', '13533331234');
INSERT INTO `provider` VALUES (2, 'V饮料供应商', '广东省广州市天河区xxxx', '李四', '13522221234');
INSERT INTO `provider` VALUES (3, 'B饮料供应商', '广东省东莞市xxx', '王五', '13511111234');
INSERT INTO `provider` VALUES (4, 'C供应商', '河北省圣地亚哥', '我到河北省来', '13512345678');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` int(0) NOT NULL COMMENT '角色编号',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `remark` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `available` int(0) NULL DEFAULT NULL,
  `createtime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (0, '超级管理员', '拥有所有菜单权限', 1, '2020-06-29 00:00:00');
INSERT INTO `role` VALUES (1, 'A仓库管理员', '能够操作1号仓库', 1, '2020-06-29 00:00:00');
INSERT INTO `role` VALUES (2, 'B仓库管理员', '能够操作2号仓库', 1, '2020-06-29 00:00:00');
INSERT INTO `role` VALUES (3, 'BV仓库管理员', '能够操作3号仓库', 1, '2020-06-29 00:00:00');
INSERT INTO `role` VALUES (4, 'D仓库管理员', '4号仓库管理员', 0, '2020-07-02 14:50:14');
INSERT INTO `role` VALUES (5, 'E仓库管理员', '能够操作5号仓库', 0, '2020-06-29 00:00:00');

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock`  (
  `goods_id` int(0) NOT NULL,
  `house_id` int(0) NOT NULL,
  `number` int(0) NULL DEFAULT NULL,
  `upper_alert` int(0) NULL DEFAULT NULL,
  `under_alert` int(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO `stock` VALUES (5, 1, 5000, 10000, 3000);
INSERT INTO `stock` VALUES (2, 3, 5000, 6000, 3000);
INSERT INTO `stock` VALUES (3, 3, 5000, 10000, 3000);
INSERT INTO `stock` VALUES (1, 1, 5520, 10000, 3000);
INSERT INTO `stock` VALUES (6, 3, 4980, 10000, 3000);
INSERT INTO `stock` VALUES (7, 3, 4980, 10000, 3000);
INSERT INTO `stock` VALUES (5, 2, 5000, 10000, 3000);
INSERT INTO `stock` VALUES (6, 2, 4960, 10000, 3000);
INSERT INTO `stock` VALUES (2, 2, 4980, 10000, 3000);
INSERT INTO `stock` VALUES (4, 1, 4959, 10000, 3000);
INSERT INTO `stock` VALUES (0, 4, 0, 10000, 0);
INSERT INTO `stock` VALUES (0, 5, 0, 10000, 0);
INSERT INTO `stock` VALUES (0, 1, 0, 10000, 0);
INSERT INTO `stock` VALUES (0, 2, 0, 10000, 0);
INSERT INTO `stock` VALUES (0, 3, 0, 10000, 0);
INSERT INTO `stock` VALUES (4, 4, 20, 10000, 0);
INSERT INTO `stock` VALUES (4, 5, 20, 10000, 0);
INSERT INTO `stock` VALUES (4, 3, 20, 10000, 0);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT,
  `role_id` int(0) NULL DEFAULT NULL,
  `account` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `age` int(0) NULL DEFAULT NULL,
  `sex` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `salt` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 0, '576078726', '532ac00e86893901af5f0be6b704dbc7', '许多多', 22, '男', '04A93C74C8294AA09A8B974FD1F4ECBB');
INSERT INTO `tb_user` VALUES (2, 0, '钱多多', '532ac00e86893901af5f0be6b704dbc7', '钱多多', 30, '男', '04A93C74C8294AA09A8B974FD1F4ECBB');
INSERT INTO `tb_user` VALUES (3, 1, 'zqw', '532ac00e86893901af5f0be6b704dbc7', 'zqw', 22, '男', '04A93C74C8294AA09A8B974FD1F4ECBB');
INSERT INTO `tb_user` VALUES (4, 2, 'lx', '532ac00e86893901af5f0be6b704dbc7', 'lx', 22, '男', '04A93C74C8294AA09A8B974FD1F4ECBB');

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse`  (
  `house_id` int(0) NOT NULL,
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `address` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`house_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of warehouse
-- ----------------------------
INSERT INTO `warehouse` VALUES (1, 'A仓库', '北京XXX区');
INSERT INTO `warehouse` VALUES (2, '贵州仓库', '贵州省云南市飓风街');
INSERT INTO `warehouse` VALUES (3, '贵州仓库', '贵州省云南市xxx仓库');
INSERT INTO `warehouse` VALUES (4, '隆安仓库', '河北省5级分部');
INSERT INTO `warehouse` VALUES (5, '河池仓库', '河北省6级分部');

SET FOREIGN_KEY_CHECKS = 1;
