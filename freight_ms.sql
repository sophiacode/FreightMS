/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : freight_ms

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-05-06 15:50:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '活动id',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `author_id` int(11) DEFAULT NULL COMMENT '发布用户的id',
  `banner` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '宣传图的地址',
  `status` int(11) NOT NULL COMMENT '状态（1：未开始，2：进行中，3：已结束）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `author_id` (`author_id`),
  CONSTRAINT `activity_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('1', '活动1', null, '16', null, '1', '2018-04-26 17:26:35', '2018-04-26 17:26:35');
INSERT INTO `activity` VALUES ('2', '活动2', null, '16', null, '2', '2018-04-26 17:32:04', '2018-04-26 17:32:04');

-- ----------------------------
-- Table structure for complaint
-- ----------------------------
DROP TABLE IF EXISTS `complaint`;
CREATE TABLE `complaint` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '投诉id',
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  `type` int(11) DEFAULT NULL COMMENT '投诉类型（1：货主投诉车主，2：车主投诉货主）',
  `reason` varchar(255) DEFAULT NULL COMMENT '投诉原因',
  `status` varchar(255) DEFAULT NULL COMMENT '处理状态（1：待处理，2：已处理）',
  `admin_id` int(11) DEFAULT NULL COMMENT '处理投诉的管理系统用户id',
  `process` varchar(255) DEFAULT NULL COMMENT '对该投诉的处理说明',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of complaint
-- ----------------------------

-- ----------------------------
-- Table structure for consignor
-- ----------------------------
DROP TABLE IF EXISTS `consignor`;
CREATE TABLE `consignor` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '货主用户id',
  `telephone` varchar(255) DEFAULT NULL COMMENT '电话号码',
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `salt` varchar(255) DEFAULT NULL COMMENT '加密盐',
  `profile_picture` varchar(255) DEFAULT NULL COMMENT '头像',
  `point` int(255) DEFAULT NULL COMMENT '积分',
  `evaluate_grade` float DEFAULT NULL COMMENT '评价等级',
  `status` int(255) DEFAULT NULL COMMENT '账号状态（1：正常，2：冻结）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of consignor
-- ----------------------------
INSERT INTO `consignor` VALUES ('1', '18610585588', '小张', 'e00fde26eff670784506dc6ad120fcbd', '8eb52c1f61e32979242abc6e4ea92dd8', null, '0', '0', '1', '2018-04-30 14:08:03', '2018-04-30 14:08:07');

-- ----------------------------
-- Table structure for coupon
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '优惠券id',
  `name` varchar(255) DEFAULT NULL COMMENT '优惠券名称',
  `active_time` int(11) DEFAULT NULL COMMENT '有效时间（单位：天）',
  `price` double DEFAULT NULL COMMENT '优惠价格',
  `start_price` double DEFAULT NULL COMMENT '可使用优惠券的起始价格',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coupon
-- ----------------------------
INSERT INTO `coupon` VALUES ('1', '10元优惠券', '10', '10', '5', '2018-04-26 17:33:33', '2018-04-26 17:33:43');

-- ----------------------------
-- Table structure for coupon_relation
-- ----------------------------
DROP TABLE IF EXISTS `coupon_relation`;
CREATE TABLE `coupon_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `consignor_id` int(11) DEFAULT NULL COMMENT '货主id',
  `coupon_id` int(11) DEFAULT NULL COMMENT '优惠券id',
  `status` int(11) DEFAULT NULL COMMENT '状态（1：未使用，2：已使用，3：已过期）',
  `order_id` int(11) DEFAULT NULL COMMENT '使用该优惠券的订单id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coupon_relation
-- ----------------------------

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典id',
  `code` int(11) DEFAULT NULL COMMENT '字典代码（数据库储存）',
  `description` varchar(255) DEFAULT NULL COMMENT '描述（前端显示）',
  `parent_id` int(11) DEFAULT NULL COMMENT '父编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dictionary
-- ----------------------------

-- ----------------------------
-- Table structure for driver
-- ----------------------------
DROP TABLE IF EXISTS `driver`;
CREATE TABLE `driver` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '车主用户id',
  `telephone` varchar(255) NOT NULL COMMENT '手机号码',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `salt` varchar(255) NOT NULL COMMENT '加密盐',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `status` int(11) DEFAULT '1' COMMENT '账号状态（0：正常，1：冻结）',
  `auth_state` int(11) DEFAULT '1' COMMENT '认证状态（1：未认证，2：认证申请中，3：认证通过，4：认证失败）',
  `online_state` int(11) DEFAULT '2' COMMENT '在线状态（1：在线，2：不在线）',
  `work_state` int(11) DEFAULT NULL COMMENT '接单状态（1：已接单，2：未接单）',
  `point` int(11) DEFAULT NULL COMMENT '积分',
  `evaluate_grade` float DEFAULT '0' COMMENT '评价等级',
  `idcard` varchar(255) DEFAULT NULL COMMENT '身份证号',
  `license_number` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `photo` varchar(255) DEFAULT '/static/image/driver/default.png' COMMENT '照片',
  `idcard_photo` varchar(255) DEFAULT '/static/image/driver/default.png' COMMENT '身份证照片',
  `license_photo` varchar(255) DEFAULT '/static/image/driver/default.png' COMMENT '车牌照片',
  `driver_license_photo` varchar(255) DEFAULT '/static/image/driver/default.png' COMMENT '驾驶证照片',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of driver
-- ----------------------------
INSERT INTO `driver` VALUES ('1', '18511111771', 'e00fde26eff670784506dc6ad120fcbd', '8eb52c1f61e32979242abc6e4ea92dd8', '张三', '0', '1', '2', '2', '0', '0', '440000197401223875', '粤K44444', '/static/image/driver/default.png', '/static/image/driver/default.png', '/static/image/driver/default.png', '/static/image/driver/default.png', '2018-04-28 15:17:08', '2018-04-30 15:53:10');
INSERT INTO `driver` VALUES ('2', '13251126666', '2346b0c656fba9a18abd0d91c0372e0f', '32dc4e97c0261d6c64f218adffd2ada7', '李四', '0', '3', '2', '1', '0', '0', '360733198504197526', '鲁HH9999', '/static/image/driver/default.png', '/static/image/driver/default.png', '/static/image/driver/default.png', '/static/image/driver/default.png', '2018-04-30 14:06:17', '2018-04-30 15:53:33');

-- ----------------------------
-- Table structure for evaluation
-- ----------------------------
DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE `evaluation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评价id',
  `driver_id` int(11) DEFAULT NULL COMMENT '车主id',
  `consignor_id` int(11) DEFAULT NULL COMMENT '货主id',
  `type` int(11) DEFAULT NULL COMMENT '类型（1：货主评价车主，2：车主评价货主）',
  `grade` varchar(255) DEFAULT NULL COMMENT '评价等级',
  `content` varchar(255) DEFAULT NULL COMMENT '评价内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of evaluation
-- ----------------------------

-- ----------------------------
-- Table structure for exchange
-- ----------------------------
DROP TABLE IF EXISTS `exchange`;
CREATE TABLE `exchange` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '积分兑换物品记录id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `user_type` int(11) DEFAULT NULL COMMENT '用户类型（1：车主，2：货主）',
  `goods_id` int(11) DEFAULT NULL COMMENT '物品id',
  `receiver_name` varchar(255) DEFAULT NULL COMMENT '收货人姓名',
  `receiver_telephone` varchar(255) DEFAULT NULL COMMENT '收货人电话',
  `receiver_address` varchar(255) DEFAULT NULL COMMENT '收货人地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exchange
-- ----------------------------
INSERT INTO `exchange` VALUES ('1', '1', '1', '3', '小红', '18500000126', '北京市海淀区中关村南大街5号', '2018-04-30 14:09:04');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '积分兑换物品id',
  `name` varchar(255) DEFAULT NULL COMMENT '物品名称',
  `point` int(11) DEFAULT NULL COMMENT '所需积分',
  `status` int(11) DEFAULT NULL COMMENT '状态（1：当前可兑换，2：当前不可兑换）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('3', '水杯', '100', '1', '2018-04-26 17:38:56', '2018-04-26 17:38:56');
INSERT INTO `goods` VALUES ('4', '毛巾', '50', '1', '2018-04-26 17:39:04', '2018-04-26 17:39:04');
INSERT INTO `goods` VALUES ('5', '电饭煲', '2000', '1', '2018-04-30 14:15:32', '2018-04-30 14:15:32');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `type` varchar(255) DEFAULT NULL COMMENT '日志类型（如登录日志、业务日志、异常日志）',
  `operation` varchar(255) DEFAULT NULL COMMENT '操作名称',
  `username` varchar(255) DEFAULT NULL COMMENT '产生日志的用户',
  `status` int(11) DEFAULT NULL COMMENT '操作状态（1：成功，2：失败）',
  `message` varchar(255) DEFAULT NULL COMMENT '消息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=301 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('21', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 15:08:21');
INSERT INTO `log` VALUES ('22', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 15:08:23');
INSERT INTO `log` VALUES ('23', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 15:10:37');
INSERT INTO `log` VALUES ('24', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 15:10:39');
INSERT INTO `log` VALUES ('25', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 15:11:16');
INSERT INTO `log` VALUES ('26', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 15:11:18');
INSERT INTO `log` VALUES ('27', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 15:12:26');
INSERT INTO `log` VALUES ('28', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 15:12:28');
INSERT INTO `log` VALUES ('29', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 15:21:53');
INSERT INTO `log` VALUES ('30', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 15:21:56');
INSERT INTO `log` VALUES ('31', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 15:21:58');
INSERT INTO `log` VALUES ('32', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 15:22:04');
INSERT INTO `log` VALUES ('33', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 15:22:06');
INSERT INTO `log` VALUES ('34', '业务日志', '查看货主用户列表', 'admin', '1', 'com.freight.ms.controller.ConsignorController:getList', '2018-04-26 15:22:09');
INSERT INTO `log` VALUES ('35', '业务日志', '查看车主用户列表', 'admin', '1', 'com.freight.ms.controller.DriverController:getList', '2018-04-26 15:22:13');
INSERT INTO `log` VALUES ('36', '业务日志', '查看车主用户列表', 'admin', '1', 'com.freight.ms.controller.DriverController:getList', '2018-04-26 15:22:38');
INSERT INTO `log` VALUES ('37', '业务日志', '查看车主用户列表', 'admin', '1', 'com.freight.ms.controller.DriverController:getList', '2018-04-26 15:22:56');
INSERT INTO `log` VALUES ('38', '业务日志', '查看活动列表', 'admin', '1', 'com.freight.ms.controller.ActivityController:getList', '2018-04-26 15:22:59');
INSERT INTO `log` VALUES ('39', '业务日志', '查看优惠券列表', 'admin', '1', 'com.freight.ms.controller.CouponController:getList', '2018-04-26 15:23:01');
INSERT INTO `log` VALUES ('40', '业务日志', '查看积分物品列表', 'admin', '1', 'com.freight.ms.controller.ExchangeController:getList', '2018-04-26 15:23:03');
INSERT INTO `log` VALUES ('41', '业务日志', '查看优惠券列表', 'admin', '1', 'com.freight.ms.controller.CouponController:getList', '2018-04-26 15:23:12');
INSERT INTO `log` VALUES ('42', '业务日志', '查看活动列表', 'admin', '1', 'com.freight.ms.controller.ActivityController:getList', '2018-04-26 15:23:16');
INSERT INTO `log` VALUES ('43', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 16:28:49');
INSERT INTO `log` VALUES ('44', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:28:51');
INSERT INTO `log` VALUES ('45', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:28:59');
INSERT INTO `log` VALUES ('46', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:29:03');
INSERT INTO `log` VALUES ('47', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:29:08');
INSERT INTO `log` VALUES ('48', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:29:09');
INSERT INTO `log` VALUES ('49', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:29:11');
INSERT INTO `log` VALUES ('50', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:29:13');
INSERT INTO `log` VALUES ('51', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:29:15');
INSERT INTO `log` VALUES ('52', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:29:16');
INSERT INTO `log` VALUES ('53', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:29:20');
INSERT INTO `log` VALUES ('54', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:29:22');
INSERT INTO `log` VALUES ('55', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 16:44:26');
INSERT INTO `log` VALUES ('56', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:44:29');
INSERT INTO `log` VALUES ('57', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:44:36');
INSERT INTO `log` VALUES ('58', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:44:38');
INSERT INTO `log` VALUES ('59', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:44:43');
INSERT INTO `log` VALUES ('60', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:44:45');
INSERT INTO `log` VALUES ('61', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:44:47');
INSERT INTO `log` VALUES ('62', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:44:48');
INSERT INTO `log` VALUES ('63', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:44:51');
INSERT INTO `log` VALUES ('64', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:44:55');
INSERT INTO `log` VALUES ('65', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:44:56');
INSERT INTO `log` VALUES ('66', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 16:58:24');
INSERT INTO `log` VALUES ('67', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:58:25');
INSERT INTO `log` VALUES ('68', '业务日志', '添加用户', 'admin', '1', 'com.freight.ms.controller.UserManageController:addUser', '2018-04-26 16:58:49');
INSERT INTO `log` VALUES ('69', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:58:49');
INSERT INTO `log` VALUES ('70', '业务日志', '修改用户资料', 'admin', '1', 'com.freight.ms.controller.UserManageController:editUser', '2018-04-26 16:58:56');
INSERT INTO `log` VALUES ('71', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:58:56');
INSERT INTO `log` VALUES ('72', '业务日志', '删除用户', 'admin', '1', 'com.freight.ms.controller.UserManageController:deleteUser', '2018-04-26 16:59:20');
INSERT INTO `log` VALUES ('73', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:59:20');
INSERT INTO `log` VALUES ('74', '业务日志', '修改用户状态', 'admin', '1', 'com.freight.ms.controller.UserManageController:changeStatus', '2018-04-26 16:59:23');
INSERT INTO `log` VALUES ('75', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:59:23');
INSERT INTO `log` VALUES ('76', '业务日志', '修改用户状态', 'admin', '1', 'com.freight.ms.controller.UserManageController:changeStatus', '2018-04-26 16:59:27');
INSERT INTO `log` VALUES ('77', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:59:27');
INSERT INTO `log` VALUES ('78', '业务日志', '修改用户状态', 'admin', '1', 'com.freight.ms.controller.UserManageController:changeStatus', '2018-04-26 16:59:32');
INSERT INTO `log` VALUES ('79', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:59:33');
INSERT INTO `log` VALUES ('80', '业务日志', '分配角色', 'admin', '1', 'com.freight.ms.controller.UserManageController:setRole', '2018-04-26 16:59:41');
INSERT INTO `log` VALUES ('81', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 16:59:41');
INSERT INTO `log` VALUES ('82', '业务日志', '修改用户状态', 'admin', '1', 'com.freight.ms.controller.UserManageController:changeStatus', '2018-04-26 17:00:00');
INSERT INTO `log` VALUES ('83', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 17:00:00');
INSERT INTO `log` VALUES ('84', '业务日志', '修改用户状态', 'admin', '1', 'com.freight.ms.controller.UserManageController:changeStatus', '2018-04-26 17:00:02');
INSERT INTO `log` VALUES ('85', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 17:00:02');
INSERT INTO `log` VALUES ('86', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:00:07');
INSERT INTO `log` VALUES ('87', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:00:17');
INSERT INTO `log` VALUES ('88', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:00:18');
INSERT INTO `log` VALUES ('89', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:00:22');
INSERT INTO `log` VALUES ('90', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:00:23');
INSERT INTO `log` VALUES ('91', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:00:26');
INSERT INTO `log` VALUES ('92', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:00:29');
INSERT INTO `log` VALUES ('93', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:00:33');
INSERT INTO `log` VALUES ('94', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:00:38');
INSERT INTO `log` VALUES ('95', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:00:38');
INSERT INTO `log` VALUES ('96', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:00:41');
INSERT INTO `log` VALUES ('97', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:00:43');
INSERT INTO `log` VALUES ('98', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:00:46');
INSERT INTO `log` VALUES ('99', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:00:47');
INSERT INTO `log` VALUES ('100', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:00:48');
INSERT INTO `log` VALUES ('101', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:00:49');
INSERT INTO `log` VALUES ('102', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:00:54');
INSERT INTO `log` VALUES ('103', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:00:54');
INSERT INTO `log` VALUES ('104', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:01:00');
INSERT INTO `log` VALUES ('105', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:01:00');
INSERT INTO `log` VALUES ('106', '业务日志', '添加角色', 'admin', '1', 'com.freight.ms.controller.RoleManageController:addUser', '2018-04-26 17:01:25');
INSERT INTO `log` VALUES ('107', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:01:25');
INSERT INTO `log` VALUES ('108', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 17:03:26');
INSERT INTO `log` VALUES ('109', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:03:29');
INSERT INTO `log` VALUES ('110', '业务日志', '修改角色', 'admin', '1', 'com.freight.ms.controller.RoleManageController:editRole', '2018-04-26 17:03:41');
INSERT INTO `log` VALUES ('111', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:03:41');
INSERT INTO `log` VALUES ('112', '业务日志', '删除角色', 'admin', '1', 'com.freight.ms.controller.RoleManageController:deleteRole', '2018-04-26 17:03:46');
INSERT INTO `log` VALUES ('113', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:03:46');
INSERT INTO `log` VALUES ('114', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:04:08');
INSERT INTO `log` VALUES ('115', '业务日志', '添加通知', 'admin', '1', 'com.freight.ms.controller.NotificationController:addUser', '2018-04-26 17:04:27');
INSERT INTO `log` VALUES ('116', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:04:27');
INSERT INTO `log` VALUES ('117', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:04:32');
INSERT INTO `log` VALUES ('118', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:04:33');
INSERT INTO `log` VALUES ('119', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:04:34');
INSERT INTO `log` VALUES ('120', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 17:06:43');
INSERT INTO `log` VALUES ('121', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:06:44');
INSERT INTO `log` VALUES ('122', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:06:50');
INSERT INTO `log` VALUES ('123', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:06:51');
INSERT INTO `log` VALUES ('124', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:07:52');
INSERT INTO `log` VALUES ('125', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:07:53');
INSERT INTO `log` VALUES ('126', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:07:59');
INSERT INTO `log` VALUES ('127', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:08:01');
INSERT INTO `log` VALUES ('128', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:08:05');
INSERT INTO `log` VALUES ('129', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:08:07');
INSERT INTO `log` VALUES ('130', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:08:12');
INSERT INTO `log` VALUES ('131', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:09:35');
INSERT INTO `log` VALUES ('132', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 17:11:42');
INSERT INTO `log` VALUES ('133', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:11:44');
INSERT INTO `log` VALUES ('134', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:11:47');
INSERT INTO `log` VALUES ('135', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:11:51');
INSERT INTO `log` VALUES ('136', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:12:03');
INSERT INTO `log` VALUES ('137', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:12:07');
INSERT INTO `log` VALUES ('138', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 17:12:43');
INSERT INTO `log` VALUES ('139', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 17:12:49');
INSERT INTO `log` VALUES ('140', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 17:12:50');
INSERT INTO `log` VALUES ('141', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 17:13:25');
INSERT INTO `log` VALUES ('142', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:13:32');
INSERT INTO `log` VALUES ('143', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 17:14:49');
INSERT INTO `log` VALUES ('144', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:14:51');
INSERT INTO `log` VALUES ('145', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:14:57');
INSERT INTO `log` VALUES ('146', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 17:15:54');
INSERT INTO `log` VALUES ('147', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:15:56');
INSERT INTO `log` VALUES ('148', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:16:06');
INSERT INTO `log` VALUES ('149', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:16:08');
INSERT INTO `log` VALUES ('150', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:16:36');
INSERT INTO `log` VALUES ('151', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:16:41');
INSERT INTO `log` VALUES ('152', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:16:43');
INSERT INTO `log` VALUES ('153', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:16:45');
INSERT INTO `log` VALUES ('154', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:16:47');
INSERT INTO `log` VALUES ('155', '业务日志', '修改通知', 'admin', '1', 'com.freight.ms.controller.NotificationController:editNotification', '2018-04-26 17:17:14');
INSERT INTO `log` VALUES ('156', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:17:14');
INSERT INTO `log` VALUES ('157', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:17:19');
INSERT INTO `log` VALUES ('158', '业务日志', '添加通知', 'admin', '1', 'com.freight.ms.controller.NotificationController:addUser', '2018-04-26 17:18:40');
INSERT INTO `log` VALUES ('159', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:18:40');
INSERT INTO `log` VALUES ('160', '业务日志', '修改通知', 'admin', '1', 'com.freight.ms.controller.NotificationController:editNotification', '2018-04-26 17:18:45');
INSERT INTO `log` VALUES ('161', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:18:45');
INSERT INTO `log` VALUES ('162', '业务日志', '添加通知', 'admin', '1', 'com.freight.ms.controller.NotificationController:addUser', '2018-04-26 17:18:48');
INSERT INTO `log` VALUES ('163', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:18:49');
INSERT INTO `log` VALUES ('164', '业务日志', '删除通知', 'admin', '1', 'com.freight.ms.controller.NotificationController:deleteNotification', '2018-04-26 17:19:37');
INSERT INTO `log` VALUES ('165', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:19:37');
INSERT INTO `log` VALUES ('166', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:19:45');
INSERT INTO `log` VALUES ('167', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:19:48');
INSERT INTO `log` VALUES ('168', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:19:51');
INSERT INTO `log` VALUES ('169', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:19:52');
INSERT INTO `log` VALUES ('170', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 17:23:30');
INSERT INTO `log` VALUES ('171', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:23:32');
INSERT INTO `log` VALUES ('172', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 17:24:04');
INSERT INTO `log` VALUES ('173', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 17:24:07');
INSERT INTO `log` VALUES ('174', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 17:24:09');
INSERT INTO `log` VALUES ('175', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 17:24:10');
INSERT INTO `log` VALUES ('176', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 17:24:12');
INSERT INTO `log` VALUES ('177', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 17:24:13');
INSERT INTO `log` VALUES ('178', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:24:18');
INSERT INTO `log` VALUES ('179', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:24:23');
INSERT INTO `log` VALUES ('180', '业务日志', '添加通知', 'admin', '1', 'com.freight.ms.controller.NotificationController:addNotification', '2018-04-26 17:24:34');
INSERT INTO `log` VALUES ('181', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:24:34');
INSERT INTO `log` VALUES ('182', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:24:35');
INSERT INTO `log` VALUES ('183', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:24:37');
INSERT INTO `log` VALUES ('184', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-26 17:24:52');
INSERT INTO `log` VALUES ('185', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:24:56');
INSERT INTO `log` VALUES ('186', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-26 17:24:58');
INSERT INTO `log` VALUES ('187', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 17:25:04');
INSERT INTO `log` VALUES ('188', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 17:25:16');
INSERT INTO `log` VALUES ('189', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 17:25:17');
INSERT INTO `log` VALUES ('190', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 17:25:21');
INSERT INTO `log` VALUES ('191', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 17:25:22');
INSERT INTO `log` VALUES ('192', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 17:25:34');
INSERT INTO `log` VALUES ('193', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 17:25:35');
INSERT INTO `log` VALUES ('194', '业务日志', '查看货主用户列表', 'admin', '1', 'com.freight.ms.controller.ConsignorController:getList', '2018-04-26 17:25:44');
INSERT INTO `log` VALUES ('195', '业务日志', '查看车主用户列表', 'admin', '1', 'com.freight.ms.controller.DriverController:getList', '2018-04-26 17:26:00');
INSERT INTO `log` VALUES ('196', '业务日志', '查看货主用户列表', 'admin', '1', 'com.freight.ms.controller.ConsignorController:getList', '2018-04-26 17:26:02');
INSERT INTO `log` VALUES ('197', '业务日志', '查看投诉列表', 'admin', '1', 'com.freight.ms.controller.ComplaintController:getList', '2018-04-26 17:26:10');
INSERT INTO `log` VALUES ('198', '业务日志', '查看活动列表', 'admin', '1', 'com.freight.ms.controller.ActivityController:getList', '2018-04-26 17:26:14');
INSERT INTO `log` VALUES ('199', '业务日志', '查看优惠券列表', 'admin', '1', 'com.freight.ms.controller.CouponController:getList', '2018-04-26 17:26:16');
INSERT INTO `log` VALUES ('200', '业务日志', '查看积分物品列表', 'admin', '1', 'com.freight.ms.controller.ExchangeController:getList', '2018-04-26 17:26:19');
INSERT INTO `log` VALUES ('201', '业务日志', '查看活动列表', 'admin', '1', 'com.freight.ms.controller.ActivityController:getList', '2018-04-26 17:26:21');
INSERT INTO `log` VALUES ('202', '业务日志', '添加活动', 'admin', '1', 'com.freight.ms.controller.ActivityController:addActivity', '2018-04-26 17:26:35');
INSERT INTO `log` VALUES ('203', '业务日志', '查看活动列表', 'admin', '1', 'com.freight.ms.controller.ActivityController:getList', '2018-04-26 17:26:36');
INSERT INTO `log` VALUES ('204', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 17:31:53');
INSERT INTO `log` VALUES ('205', '业务日志', '查看活动列表', 'admin', '1', 'com.freight.ms.controller.ActivityController:getList', '2018-04-26 17:31:55');
INSERT INTO `log` VALUES ('206', '业务日志', '添加活动', 'admin', '1', 'com.freight.ms.controller.ActivityController:addActivity', '2018-04-26 17:32:04');
INSERT INTO `log` VALUES ('207', '业务日志', '查看活动列表', 'admin', '1', 'com.freight.ms.controller.ActivityController:getList', '2018-04-26 17:32:05');
INSERT INTO `log` VALUES ('208', '业务日志', '查看活动列表', 'admin', '1', 'com.freight.ms.controller.ActivityController:getList', '2018-04-26 17:32:06');
INSERT INTO `log` VALUES ('209', '业务日志', '查看活动列表', 'admin', '1', 'com.freight.ms.controller.ActivityController:getList', '2018-04-26 17:32:07');
INSERT INTO `log` VALUES ('210', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 17:32:51');
INSERT INTO `log` VALUES ('211', '业务日志', '查看活动列表', 'admin', '1', 'com.freight.ms.controller.ActivityController:getList', '2018-04-26 17:32:53');
INSERT INTO `log` VALUES ('212', '业务日志', '查看优惠券列表', 'admin', '1', 'com.freight.ms.controller.CouponController:getList', '2018-04-26 17:33:10');
INSERT INTO `log` VALUES ('213', '业务日志', '添加优惠券', 'admin', '1', 'com.freight.ms.controller.CouponController:addUser', '2018-04-26 17:33:33');
INSERT INTO `log` VALUES ('214', '业务日志', '查看优惠券列表', 'admin', '1', 'com.freight.ms.controller.CouponController:getList', '2018-04-26 17:33:34');
INSERT INTO `log` VALUES ('215', '业务日志', '修改优惠券', 'admin', '1', 'com.freight.ms.controller.CouponController:editCoupon', '2018-04-26 17:33:43');
INSERT INTO `log` VALUES ('216', '业务日志', '查看优惠券列表', 'admin', '1', 'com.freight.ms.controller.CouponController:getList', '2018-04-26 17:33:43');
INSERT INTO `log` VALUES ('217', '业务日志', '添加优惠券', 'admin', '1', 'com.freight.ms.controller.CouponController:addUser', '2018-04-26 17:33:59');
INSERT INTO `log` VALUES ('218', '业务日志', '查看优惠券列表', 'admin', '1', 'com.freight.ms.controller.CouponController:getList', '2018-04-26 17:33:59');
INSERT INTO `log` VALUES ('219', '业务日志', '查看优惠券列表', 'admin', '1', 'com.freight.ms.controller.CouponController:getList', '2018-04-26 17:34:13');
INSERT INTO `log` VALUES ('220', '业务日志', '查看优惠券列表', 'admin', '1', 'com.freight.ms.controller.CouponController:getList', '2018-04-26 17:34:15');
INSERT INTO `log` VALUES ('221', '业务日志', '查看优惠券列表', 'admin', '1', 'com.freight.ms.controller.CouponController:getList', '2018-04-26 17:34:18');
INSERT INTO `log` VALUES ('222', '业务日志', '查看优惠券列表', 'admin', '1', 'com.freight.ms.controller.CouponController:getList', '2018-04-26 17:34:21');
INSERT INTO `log` VALUES ('223', '业务日志', '查看优惠券列表', 'admin', '1', 'com.freight.ms.controller.CouponController:getList', '2018-04-26 17:34:23');
INSERT INTO `log` VALUES ('224', '业务日志', '查看优惠券列表', 'admin', '1', 'com.freight.ms.controller.CouponController:getList', '2018-04-26 17:34:24');
INSERT INTO `log` VALUES ('225', '业务日志', '删除优惠券', 'admin', '1', 'com.freight.ms.controller.CouponController:deleteCoupon', '2018-04-26 17:34:32');
INSERT INTO `log` VALUES ('226', '业务日志', '查看优惠券列表', 'admin', '1', 'com.freight.ms.controller.CouponController:getList', '2018-04-26 17:34:32');
INSERT INTO `log` VALUES ('227', '业务日志', '查看积分物品列表', 'admin', '1', 'com.freight.ms.controller.ExchangeController:getList', '2018-04-26 17:34:35');
INSERT INTO `log` VALUES ('228', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-26 17:38:10');
INSERT INTO `log` VALUES ('229', '业务日志', '查看积分物品列表', 'admin', '1', 'com.freight.ms.controller.ExchangeController:getList', '2018-04-26 17:38:12');
INSERT INTO `log` VALUES ('230', '业务日志', '添加积分物品', 'admin', '1', 'com.freight.ms.controller.ExchangeController:addUser', '2018-04-26 17:38:21');
INSERT INTO `log` VALUES ('231', '业务日志', '查看积分物品列表', 'admin', '1', 'com.freight.ms.controller.ExchangeController:getList', '2018-04-26 17:38:21');
INSERT INTO `log` VALUES ('232', '业务日志', '添加积分物品', 'admin', '1', 'com.freight.ms.controller.ExchangeController:addUser', '2018-04-26 17:38:35');
INSERT INTO `log` VALUES ('233', '业务日志', '查看积分物品列表', 'admin', '1', 'com.freight.ms.controller.ExchangeController:getList', '2018-04-26 17:38:35');
INSERT INTO `log` VALUES ('234', '业务日志', '修改积分物品', 'admin', '1', 'com.freight.ms.controller.ExchangeController:editGoods', '2018-04-26 17:38:41');
INSERT INTO `log` VALUES ('235', '业务日志', '查看积分物品列表', 'admin', '1', 'com.freight.ms.controller.ExchangeController:getList', '2018-04-26 17:38:41');
INSERT INTO `log` VALUES ('236', '业务日志', '删除积分物品', 'admin', '1', 'com.freight.ms.controller.ExchangeController:deleteGoods', '2018-04-26 17:38:48');
INSERT INTO `log` VALUES ('237', '业务日志', '查看积分物品列表', 'admin', '1', 'com.freight.ms.controller.ExchangeController:getList', '2018-04-26 17:38:48');
INSERT INTO `log` VALUES ('238', '业务日志', '添加积分物品', 'admin', '1', 'com.freight.ms.controller.ExchangeController:addUser', '2018-04-26 17:38:56');
INSERT INTO `log` VALUES ('239', '业务日志', '查看积分物品列表', 'admin', '1', 'com.freight.ms.controller.ExchangeController:getList', '2018-04-26 17:38:56');
INSERT INTO `log` VALUES ('240', '业务日志', '添加积分物品', 'admin', '1', 'com.freight.ms.controller.ExchangeController:addUser', '2018-04-26 17:39:04');
INSERT INTO `log` VALUES ('241', '业务日志', '查看积分物品列表', 'admin', '1', 'com.freight.ms.controller.ExchangeController:getList', '2018-04-26 17:39:04');
INSERT INTO `log` VALUES ('242', '业务日志', '查看积分物品列表', 'admin', '1', 'com.freight.ms.controller.ExchangeController:getList', '2018-04-26 17:39:08');
INSERT INTO `log` VALUES ('243', '业务日志', '查看积分物品列表', 'admin', '1', 'com.freight.ms.controller.ExchangeController:getList', '2018-04-26 17:39:13');
INSERT INTO `log` VALUES ('244', '业务日志', '查看积分物品列表', 'admin', '1', 'com.freight.ms.controller.ExchangeController:getList', '2018-04-26 17:39:18');
INSERT INTO `log` VALUES ('245', '业务日志', '查看积分物品列表', 'admin', '1', 'com.freight.ms.controller.ExchangeController:getList', '2018-04-26 17:39:23');
INSERT INTO `log` VALUES ('246', '业务日志', '查看积分物品列表', 'admin', '1', 'com.freight.ms.controller.ExchangeController:getList', '2018-04-26 17:39:28');
INSERT INTO `log` VALUES ('247', '业务日志', '查看积分物品列表', 'admin', '1', 'com.freight.ms.controller.ExchangeController:getList', '2018-04-26 17:39:30');
INSERT INTO `log` VALUES ('248', '业务日志', '查看积分物品列表', 'admin', '1', 'com.freight.ms.controller.ExchangeController:getList', '2018-04-26 17:39:33');
INSERT INTO `log` VALUES ('249', '业务日志', '查看积分物品列表', 'admin', '1', 'com.freight.ms.controller.ExchangeController:getList', '2018-04-26 17:39:34');
INSERT INTO `log` VALUES ('250', '业务日志', '查看积分物品列表', 'admin', '1', 'com.freight.ms.controller.ExchangeController:getList', '2018-04-26 17:39:37');
INSERT INTO `log` VALUES ('251', '业务日志', '查看积分物品列表', 'admin', '1', 'com.freight.ms.controller.ExchangeController:getList', '2018-04-26 17:39:39');
INSERT INTO `log` VALUES ('252', '业务日志', '查看积分物品列表', 'admin', '1', 'com.freight.ms.controller.ExchangeController:getList', '2018-04-26 17:39:43');
INSERT INTO `log` VALUES ('253', '业务日志', '查看积分物品列表', 'admin', '1', 'com.freight.ms.controller.ExchangeController:getList', '2018-04-26 17:39:44');
INSERT INTO `log` VALUES ('254', '业务日志', '查看优惠券列表', 'admin', '1', 'com.freight.ms.controller.CouponController:getList', '2018-04-26 17:39:49');
INSERT INTO `log` VALUES ('255', '业务日志', '查看活动列表', 'admin', '1', 'com.freight.ms.controller.ActivityController:getList', '2018-04-26 17:39:53');
INSERT INTO `log` VALUES ('256', '业务日志', '查看货主用户列表', 'admin', '1', 'com.freight.ms.controller.ConsignorController:getList', '2018-04-26 17:40:09');
INSERT INTO `log` VALUES ('257', '业务日志', '查看车主用户列表', 'admin', '1', 'com.freight.ms.controller.DriverController:getList', '2018-04-26 17:40:12');
INSERT INTO `log` VALUES ('258', '业务日志', '查看积分物品列表', 'admin', '1', 'com.freight.ms.controller.ExchangeController:getList', '2018-04-26 17:40:21');
INSERT INTO `log` VALUES ('259', '业务日志', '查看角色列表', 'admin', '1', 'com.freight.ms.controller.RoleManageController:getList', '2018-04-26 17:40:28');
INSERT INTO `log` VALUES ('260', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-28 14:40:47');
INSERT INTO `log` VALUES ('261', '业务日志', '查看用户列表', 'admin', '1', 'com.freight.ms.controller.UserManageController:getList', '2018-04-28 14:47:32');
INSERT INTO `log` VALUES ('262', '业务日志', '查看车主用户列表', 'admin', '1', 'com.freight.ms.controller.DriverController:getList', '2018-04-28 14:47:38');
INSERT INTO `log` VALUES ('263', '业务日志', '查看车主用户列表', 'admin', '1', 'com.freight.ms.controller.DriverController:getList', '2018-04-28 14:48:11');
INSERT INTO `log` VALUES ('264', '业务日志', '查看车主用户列表', 'admin', '1', 'com.freight.ms.controller.DriverController:getList', '2018-04-28 14:56:05');
INSERT INTO `log` VALUES ('265', '业务日志', '查看车主用户列表', 'admin', '1', 'com.freight.ms.controller.DriverController:getList', '2018-04-28 15:19:39');
INSERT INTO `log` VALUES ('266', '业务日志', '查看车主用户列表', 'admin', '1', 'com.freight.ms.controller.DriverController:getList', '2018-04-28 15:20:32');
INSERT INTO `log` VALUES ('267', '业务日志', '查看车主用户列表', 'admin', '1', 'com.freight.ms.controller.DriverController:getList', '2018-04-28 15:25:20');
INSERT INTO `log` VALUES ('268', '业务日志', '修改车主用户状态', 'admin', '1', 'com.freight.ms.controller.DriverController:changeStatus', '2018-04-28 15:25:23');
INSERT INTO `log` VALUES ('269', '业务日志', '查看车主用户列表', 'admin', '1', 'com.freight.ms.controller.DriverController:getList', '2018-04-28 15:25:23');
INSERT INTO `log` VALUES ('270', '业务日志', '修改车主用户状态', 'admin', '1', 'com.freight.ms.controller.DriverController:changeStatus', '2018-04-28 15:25:26');
INSERT INTO `log` VALUES ('271', '业务日志', '查看车主用户列表', 'admin', '1', 'com.freight.ms.controller.DriverController:getList', '2018-04-28 15:25:26');
INSERT INTO `log` VALUES ('272', '业务日志', '修改车主用户状态', 'admin', '1', 'com.freight.ms.controller.DriverController:changeStatus', '2018-04-28 15:25:29');
INSERT INTO `log` VALUES ('273', '业务日志', '查看车主用户列表', 'admin', '1', 'com.freight.ms.controller.DriverController:getList', '2018-04-28 15:25:29');
INSERT INTO `log` VALUES ('274', '业务日志', '修改车主用户状态', 'admin', '1', 'com.freight.ms.controller.DriverController:changeStatus', '2018-04-28 15:25:31');
INSERT INTO `log` VALUES ('275', '业务日志', '查看车主用户列表', 'admin', '1', 'com.freight.ms.controller.DriverController:getList', '2018-04-28 15:25:31');
INSERT INTO `log` VALUES ('276', '业务日志', '查看车主用户列表', 'admin', '1', 'com.freight.ms.controller.DriverController:getList', '2018-04-28 15:39:36');
INSERT INTO `log` VALUES ('277', '业务日志', '查看车主用户列表', 'admin', '1', 'com.freight.ms.controller.DriverController:getList', '2018-04-28 15:40:09');
INSERT INTO `log` VALUES ('278', '业务日志', '查看车主用户列表', 'admin', '1', 'com.freight.ms.controller.DriverController:getList', '2018-04-28 15:40:59');
INSERT INTO `log` VALUES ('279', '业务日志', '查看车主用户列表', 'admin', '1', 'com.freight.ms.controller.DriverController:getList', '2018-04-28 15:52:46');
INSERT INTO `log` VALUES ('280', '业务日志', '查看车主用户列表', 'admin', '1', 'com.freight.ms.controller.DriverController:getList', '2018-04-28 15:53:43');
INSERT INTO `log` VALUES ('281', '业务日志', '查看通知列表', 'admin', '1', 'com.freight.ms.controller.NotificationController:getList', '2018-04-28 15:54:21');
INSERT INTO `log` VALUES ('282', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-28 15:54:24');
INSERT INTO `log` VALUES ('283', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-28 15:54:26');
INSERT INTO `log` VALUES ('284', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-28 15:54:28');
INSERT INTO `log` VALUES ('285', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-28 15:54:50');
INSERT INTO `log` VALUES ('286', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-28 15:54:52');
INSERT INTO `log` VALUES ('287', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-28 15:54:54');
INSERT INTO `log` VALUES ('288', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-28 15:54:57');
INSERT INTO `log` VALUES ('289', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-28 15:54:58');
INSERT INTO `log` VALUES ('290', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-28 15:55:12');
INSERT INTO `log` VALUES ('291', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-28 15:55:14');
INSERT INTO `log` VALUES ('292', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-28 15:55:15');
INSERT INTO `log` VALUES ('293', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-28 15:55:16');
INSERT INTO `log` VALUES ('294', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-28 15:55:17');
INSERT INTO `log` VALUES ('295', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-28 15:55:18');
INSERT INTO `log` VALUES ('296', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-28 15:55:19');
INSERT INTO `log` VALUES ('297', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-28 15:55:27');
INSERT INTO `log` VALUES ('298', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-28 15:55:34');
INSERT INTO `log` VALUES ('299', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-28 15:55:35');
INSERT INTO `log` VALUES ('300', '业务日志', '查看日志列表', 'admin', '1', 'com.freight.ms.controller.LogController:getList', '2018-04-28 15:56:10');

-- ----------------------------
-- Table structure for notification
-- ----------------------------
DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '通知id',
  `title` varchar(255) NOT NULL COMMENT '通知标题',
  `content` varchar(255) DEFAULT NULL COMMENT '通知内容',
  `author_id` int(11) DEFAULT NULL COMMENT '发布人的id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `author_id` (`author_id`),
  CONSTRAINT `notification_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notification
-- ----------------------------
INSERT INTO `notification` VALUES ('2', '欢迎', '欢迎使用货运服务后台管理系统！', '16', '2018-04-20 15:29:36', '2018-04-20 15:29:36');
INSERT INTO `notification` VALUES ('3', '系统说明', null, '16', '2018-04-26 17:04:27', '2018-04-26 17:04:27');
INSERT INTO `notification` VALUES ('6', '123', '123', '16', '2018-04-26 17:24:34', '2018-04-26 17:24:34');

-- ----------------------------
-- Table structure for operation
-- ----------------------------
DROP TABLE IF EXISTS `operation`;
CREATE TABLE `operation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '操作id',
  `name` varchar(255) DEFAULT NULL COMMENT '操作名称，用于前端显示',
  `identifier` varchar(255) DEFAULT NULL COMMENT '操作标识符，用于后端权限判断',
  `type` int(11) DEFAULT NULL COMMENT '操作类型（1：菜单，2：按钮）',
  `parent_id` int(11) DEFAULT NULL COMMENT '父编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operation
-- ----------------------------
INSERT INTO `operation` VALUES ('1', '所有', 'all', '1', null);
INSERT INTO `operation` VALUES ('2', '用户管理', 'user', '1', '1');
INSERT INTO `operation` VALUES ('3', '查看用户列表', 'user:list', '2', '2');
INSERT INTO `operation` VALUES ('4', '添加用户', 'user:add', '2', '2');
INSERT INTO `operation` VALUES ('5', '修改用户', 'user:edit', '2', '2');
INSERT INTO `operation` VALUES ('6', '删除用户', 'user:delete', '2', '2');
INSERT INTO `operation` VALUES ('7', '冻结或解冻用户', 'user:change_status', '2', '2');
INSERT INTO `operation` VALUES ('8', '分配角色', 'user:change_role', '2', '2');
INSERT INTO `operation` VALUES ('9', '角色管理', 'role', '1', '1');
INSERT INTO `operation` VALUES ('10', '查看角色列表', 'role:list', '2', '9');
INSERT INTO `operation` VALUES ('11', '添加角色', 'role:add', '2', '9');
INSERT INTO `operation` VALUES ('12', '修改角色', 'role:edit', '2', '9');
INSERT INTO `operation` VALUES ('13', '删除角色', 'role:delete', '2', '9');
INSERT INTO `operation` VALUES ('14', '通知管理', 'notification', '1', '1');
INSERT INTO `operation` VALUES ('15', '查看通知信息', 'notification:view', '2', '14');
INSERT INTO `operation` VALUES ('16', '查看通知列表', 'notification:list', '2', '14');
INSERT INTO `operation` VALUES ('17', '添加通知', 'notification:add', '2', '14');
INSERT INTO `operation` VALUES ('18', '修改通知', 'notification:edit', '2', '14');
INSERT INTO `operation` VALUES ('19', '删除通知', 'notification:delete', '2', '14');
INSERT INTO `operation` VALUES ('20', '日志管理', 'log', '1', '1');
INSERT INTO `operation` VALUES ('21', '查看日志列表', 'log:list', '2', '20');
INSERT INTO `operation` VALUES ('22', '货主用户管理', 'consignor', '1', '1');
INSERT INTO `operation` VALUES ('23', '查看货主列表', 'consignor:list', '2', '22');
INSERT INTO `operation` VALUES ('24', '冻结或解冻货主', 'consignor:change_status', '2', '22');
INSERT INTO `operation` VALUES ('25', '车主用户管理', 'driver', '1', '1');
INSERT INTO `operation` VALUES ('26', '查看车主列表', 'driver:list', '2', '25');
INSERT INTO `operation` VALUES ('27', '冻结或解冻车主', 'driver:change_status', '2', '25');
INSERT INTO `operation` VALUES ('28', '车主认证管理', 'driver:auth', '2', '25');
INSERT INTO `operation` VALUES ('29', '车主位置查询', 'driver:location', '2', '25');
INSERT INTO `operation` VALUES ('30', '查看用户注册图表', 'chart_register', '2', '1');
INSERT INTO `operation` VALUES ('31', '订单查询', 'order', '2', '1');
INSERT INTO `operation` VALUES ('32', '投诉管理', 'complaint', '1', '1');
INSERT INTO `operation` VALUES ('33', '查看投诉列表', 'complaint:list', '2', '32');
INSERT INTO `operation` VALUES ('34', '处理投诉', 'complaint:handle', '2', '32');
INSERT INTO `operation` VALUES ('35', '报表查询', 'chart_order', '2', '1');
INSERT INTO `operation` VALUES ('36', '活动管理', 'activity', '1', '1');
INSERT INTO `operation` VALUES ('37', '查看活动列表', 'activity:list', '2', '36');
INSERT INTO `operation` VALUES ('38', '添加活动', 'activity:add', '2', '36');
INSERT INTO `operation` VALUES ('39', '修改活动', 'activity:edit', '2', '36');
INSERT INTO `operation` VALUES ('40', '删除活动', 'activity:delete', '2', '36');
INSERT INTO `operation` VALUES ('41', '优惠券管理', 'coupon', '1', '1');
INSERT INTO `operation` VALUES ('42', '查看优惠券列表', 'coupon:list', '2', '41');
INSERT INTO `operation` VALUES ('43', '添加优惠券', 'coupon:add', '2', '41');
INSERT INTO `operation` VALUES ('44', '修改优惠券', 'coupon:edit', '2', '41');
INSERT INTO `operation` VALUES ('45', '删除优惠券', 'coupon:delete', '2', '41');
INSERT INTO `operation` VALUES ('46', '发放优惠券', 'coupon:release', '2', '41');
INSERT INTO `operation` VALUES ('47', '积分兑换管理', 'goods', '1', '1');
INSERT INTO `operation` VALUES ('48', '查看积分物品列表', 'goods:list', '2', '47');
INSERT INTO `operation` VALUES ('49', '添加积分物品', 'goods:add', '2', '47');
INSERT INTO `operation` VALUES ('50', '修改积分物品', 'goods:edit', '2', '47');
INSERT INTO `operation` VALUES ('51', '删除积分物品', 'goods:delete', '2', '47');
INSERT INTO `operation` VALUES ('52', '查看兑换记录', 'goods:exchange_record', '2', '47');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `order_no` varchar(255) NOT NULL COMMENT '订单号',
  `consignor_id` int(11) DEFAULT NULL COMMENT '货主用户id',
  `driver_id` int(11) DEFAULT NULL COMMENT '车主用户id',
  `receiver_name` varchar(255) DEFAULT NULL COMMENT '收货人姓名',
  `receiver_phone` varchar(255) DEFAULT NULL COMMENT '收货人电话',
  `start_address` varchar(255) DEFAULT NULL COMMENT '发货地址',
  `end_address` varchar(255) DEFAULT NULL COMMENT '收货地址',
  `price` double DEFAULT NULL COMMENT '订单价格',
  `coupon_id` int(11) DEFAULT NULL COMMENT '优惠券id',
  `distance` double DEFAULT NULL COMMENT '距离',
  `goods_type` varchar(255) DEFAULT NULL COMMENT '货物类型',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `order_status` int(11) DEFAULT NULL COMMENT '订单状态（1：等待接单，2：司机运输中，3：已完成，4：已取消）',
  `pay_status` int(11) DEFAULT NULL COMMENT '付款状态（1：未付款，2：已付款）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `operation_id` int(11) DEFAULT NULL COMMENT '操作id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('2', '2', '2');
INSERT INTO `permission` VALUES ('8', '3', '21');
INSERT INTO `permission` VALUES ('9', '3', '23');
INSERT INTO `permission` VALUES ('10', '3', '24');
INSERT INTO `permission` VALUES ('11', '3', '30');
INSERT INTO `permission` VALUES ('12', '3', '42');
INSERT INTO `permission` VALUES ('13', '3', '43');
INSERT INTO `permission` VALUES ('14', '3', '44');
INSERT INTO `permission` VALUES ('15', '3', '45');
INSERT INTO `permission` VALUES ('16', '3', '46');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '角色名，用于前端展示',
  `description` varchar(255) DEFAULT '' COMMENT '说明',
  `identifier` varchar(255) DEFAULT NULL COMMENT '标识符，用于后端权限判断',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('2', '超级管理员', '', 'admin', '2018-04-13 14:02:09', '2018-04-13 14:02:13');
INSERT INTO `role` VALUES ('3', '测试', '', 'test', '2018-04-16 15:38:56', '2018-04-16 15:39:00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `salt` varchar(255) NOT NULL COMMENT '加密盐',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `sex` int(11) DEFAULT NULL COMMENT '性别（1：男，2：女）',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `telephone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态（0：正常，1：冻结）',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '用户类型（0：普通用户，1：超级管理员）',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('16', 'admin', 'e00fde26eff670784506dc6ad120fcbd', '8eb52c1f61e32979242abc6e4ea92dd8', '管理员', '1', null, null, '0', '1', '2', '2018-04-12 15:22:22', '2018-04-26 16:58:56');
INSERT INTO `user` VALUES ('32', 'test1', '2346b0c656fba9a18abd0d91c0372e0f', '32dc4e97c0261d6c64f218adffd2ada7', '测试', '2', '12', null, '1', '0', '3', '2018-04-15 14:59:37', '2018-04-26 17:00:01');
