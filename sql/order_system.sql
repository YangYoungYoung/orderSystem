/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : order_system

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-11-08 17:33:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_area
-- ----------------------------
DROP TABLE IF EXISTS `t_area`;
CREATE TABLE `t_area` (
  `id` int(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL COMMENT '区域表'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_area
-- ----------------------------
INSERT INTO `t_area` VALUES ('1', '大厅');
INSERT INTO `t_area` VALUES ('2', '包厢');

-- ----------------------------
-- Table structure for t_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_cart`;
CREATE TABLE `t_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车Id',
  `sid` int(11) DEFAULT NULL COMMENT '商家Id',
  `dishId` int(11) DEFAULT NULL COMMENT '菜品Id',
  `dishName` varchar(255) DEFAULT NULL COMMENT '菜名',
  `dishImage` varchar(255) DEFAULT NULL COMMENT '菜品图片',
  `dishPrice` decimal(10,2) DEFAULT NULL,
  `number` int(11) DEFAULT NULL COMMENT '数量',
  `tableId` int(100) DEFAULT NULL,
  `totalPrice` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cart
-- ----------------------------
INSERT INTO `t_cart` VALUES ('20', '1', '7', '拌土豆丝', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%B2%BE%E7%BE%8E%E5%87%89%E8%8F%9C/%E6%8B%8C%E5%9C%9F%E8%B1%86%E4%B8%9D.jpg', '10.00', '1', '8', '10.00');

-- ----------------------------
-- Table structure for t_feedback
-- ----------------------------
DROP TABLE IF EXISTS `t_feedback`;
CREATE TABLE `t_feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shopId` int(11) DEFAULT NULL,
  `openId` varchar(100) DEFAULT NULL,
  `remark` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_feedback
-- ----------------------------
INSERT INTO `t_feedback` VALUES ('1', '1', 'o1Px45Hvg-ji35SlXJc_N_Yp_iJM', '4163132');

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单Id',
  `sid` int(11) DEFAULT NULL COMMENT '商家Id',
  `dishName` varchar(255) DEFAULT NULL COMMENT '菜名',
  `dishPrice` decimal(10,2) DEFAULT NULL COMMENT '菜价',
  `dishImage` varchar(255) DEFAULT NULL COMMENT '菜品图片',
  `dishType` int(11) DEFAULT NULL COMMENT '菜品类型Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '1', '姜撞奶', '30.00', 'http://menufile.oss-cn-beijing.aliyuncs.com/1/1573200659560.jpg', '7');
INSERT INTO `t_menu` VALUES ('2', '1', '栗子蛋糕', '3.00', 'http://menufile.oss-cn-beijing.aliyuncs.com/1/1573200666651.jpg', '7');
INSERT INTO `t_menu` VALUES ('3', '1', '浓巧克力蛋糕', '28.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E9%A4%90%E5%90%8E%E7%94%9C%E7%82%B9/%E6%B5%93%E5%B7%A7%E5%85%8B%E5%8A%9B%E8%9B%8B%E7%B3%95.jpg', '7');
INSERT INTO `t_menu` VALUES ('4', '1', '砂糖冰雪冷元子', '60.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E9%A4%90%E5%90%8E%E7%94%9C%E7%82%B9/%E7%A0%82%E7%B3%96%E5%86%B0%E9%9B%AA%E5%86%B7%E5%85%83%E5%AD%90.jpg', '7');
INSERT INTO `t_menu` VALUES ('5', '1', '双皮奶', '20.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E9%A4%90%E5%90%8E%E7%94%9C%E7%82%B9/%E5%8F%8C%E7%9A%AE%E5%A5%B6.jpg', '7');
INSERT INTO `t_menu` VALUES ('6', '1', '养颜西米露', '22.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E9%A4%90%E5%90%8E%E7%94%9C%E7%82%B9/%E5%85%BB%E9%A2%9C%E8%A5%BF%E7%B1%B3%E9%9C%B2.jpg', '7');
INSERT INTO `t_menu` VALUES ('7', '1', '拌土豆丝', '10.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%B2%BE%E7%BE%8E%E5%87%89%E8%8F%9C/%E6%8B%8C%E5%9C%9F%E8%B1%86%E4%B8%9D.jpg', '1');
INSERT INTO `t_menu` VALUES ('8', '1', '酱牛肉', '30.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%B2%BE%E7%BE%8E%E5%87%89%E8%8F%9C/%E9%85%B1%E7%89%9B%E8%82%89.jpg', '1');
INSERT INTO `t_menu` VALUES ('9', '1', '口水鸡', '32.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%B2%BE%E7%BE%8E%E5%87%89%E8%8F%9C/%E5%8F%A3%E6%B0%B4%E9%B8%A1.jpg', '1');
INSERT INTO `t_menu` VALUES ('10', '1', '凉拌木耳', '10.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%B2%BE%E7%BE%8E%E5%87%89%E8%8F%9C/%E5%87%89%E6%8B%8C%E6%9C%A8%E8%80%B3.jpg', '1');
INSERT INTO `t_menu` VALUES ('11', '1', '拍黄瓜', '8.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%B2%BE%E7%BE%8E%E5%87%89%E8%8F%9C/%E6%8B%8D%E9%BB%84%E7%93%9C.jpg', '1');
INSERT INTO `t_menu` VALUES ('12', '1', '可乐', '3.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E9%85%92%E6%B0%B4/%E5%8F%AF%E4%B9%90.jpg', '4');
INSERT INTO `t_menu` VALUES ('13', '1', '矿泉水', '2.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E9%85%92%E6%B0%B4/%E7%9F%BF%E6%B3%89%E6%B0%B4.jpg', '4');
INSERT INTO `t_menu` VALUES ('14', '1', '崂山啤酒', '2.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E9%85%92%E6%B0%B4/%E5%B4%82%E5%B1%B1%E5%95%A4%E9%85%92.jpg', '4');
INSERT INTO `t_menu` VALUES ('15', '1', '农夫山泉', '2.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E9%85%92%E6%B0%B4/%E5%86%9C%E5%A4%AB%E5%B1%B1%E6%B3%89.jpg', '4');
INSERT INTO `t_menu` VALUES ('16', '1', '雪碧', '3.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E9%85%92%E6%B0%B4/%E9%9B%AA%E7%A2%A7.jpg', '4');
INSERT INTO `t_menu` VALUES ('17', '1', '雪花啤酒', '5.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E9%85%92%E6%B0%B4/%E9%9B%AA%E8%8A%B1%E5%95%A4%E9%85%92.jpg', '4');
INSERT INTO `t_menu` VALUES ('18', '1', '潮州卤水猪肚', '38.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%83%A7%E8%85%8A%E5%8D%A4%E7%B1%BB/%E6%BD%AE%E5%B7%9E%E5%8D%A4%E6%B0%B4%E7%8C%AA%E8%82%9A.jpg', '3');
INSERT INTO `t_menu` VALUES ('19', '1', '卤水豆腐', '22.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%83%A7%E8%85%8A%E5%8D%A4%E7%B1%BB/%E5%8D%A4%E6%B0%B4%E8%B1%86%E8%85%90.jpg', '3');
INSERT INTO `t_menu` VALUES ('20', '1', '蜜汁烧鹅肝', '98.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%83%A7%E8%85%8A%E5%8D%A4%E7%B1%BB/%E8%9C%9C%E6%B1%81%E7%83%A7%E9%B9%85%E8%82%9D.jpg', '3');
INSERT INTO `t_menu` VALUES ('21', '1', '蜜汁烧鸡翼', '76.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%83%A7%E8%85%8A%E5%8D%A4%E7%B1%BB/%E8%9C%9C%E6%B1%81%E7%83%A7%E9%B8%A1%E7%BF%BC.jpg', '3');
INSERT INTO `t_menu` VALUES ('22', '1', '炭烧猪脚', '86.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%83%A7%E8%85%8A%E5%8D%A4%E7%B1%BB/%E7%82%AD%E7%83%A7%E7%8C%AA%E8%84%9A.jpg', '3');
INSERT INTO `t_menu` VALUES ('23', '1', '钵钵鸡', '34.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E5%9B%9B%E5%B7%9D%E8%8F%9C%E7%B3%BB/%E9%92%B5%E9%92%B5%E9%B8%A1.jpg', '3');
INSERT INTO `t_menu` VALUES ('24', '1', '宫保鸡丁', '29.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E5%9B%9B%E5%B7%9D%E8%8F%9C%E7%B3%BB/%E5%AE%AB%E4%BF%9D%E9%B8%A1%E4%B8%81.jpg', '2');
INSERT INTO `t_menu` VALUES ('25', '1', '回锅肉', '38.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E5%9B%9B%E5%B7%9D%E8%8F%9C%E7%B3%BB/%E5%9B%9E%E9%94%85%E8%82%89.jpg', '2');
INSERT INTO `t_menu` VALUES ('26', '1', '麻婆豆腐', '28.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E5%9B%9B%E5%B7%9D%E8%8F%9C%E7%B3%BB/%E9%BA%BB%E5%A9%86%E8%B1%86%E8%85%90.jpg', '2');
INSERT INTO `t_menu` VALUES ('27', '1', '水煮牛肉', '45.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E5%9B%9B%E5%B7%9D%E8%8F%9C%E7%B3%BB/%E6%B0%B4%E7%85%AE%E7%89%9B%E8%82%89.jpg', '2');
INSERT INTO `t_menu` VALUES ('28', '1', '冬阴功汤', '31.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E6%B1%A4%E7%B1%BB/%E5%86%AC%E9%98%B4%E5%8A%9F%E6%B1%A4.jpg', '6');
INSERT INTO `t_menu` VALUES ('29', '1', '番茄疙瘩汤', '18.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E6%B1%A4%E7%B1%BB/%E7%95%AA%E8%8C%84%E7%96%99%E7%98%A9%E6%B1%A4.jpg', '6');
INSERT INTO `t_menu` VALUES ('30', '1', '萝卜丝鲫鱼汤', '26.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E6%B1%A4%E7%B1%BB/%E8%90%9D%E5%8D%9C%E4%B8%9D%E9%B2%AB%E9%B1%BC%E6%B1%A4.jpg', '6');
INSERT INTO `t_menu` VALUES ('31', '1', '酸菜芋头汤', '27.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E6%B1%A4%E7%B1%BB/%E9%85%B8%E8%8F%9C%E8%8A%8B%E5%A4%B4%E6%B1%A4.jpg', '6');
INSERT INTO `t_menu` VALUES ('32', '1', '土豆白菜汤', '26.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E6%B1%A4%E7%B1%BB/%E5%9C%9F%E8%B1%86%E7%99%BD%E8%8F%9C%E6%B1%A4.jpg', '6');
INSERT INTO `t_menu` VALUES ('33', '1', '素炒饼', '10.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E4%B8%BB%E9%A3%9F/%E7%B4%A0%E7%82%92%E9%A5%BC.jpg', '5');
INSERT INTO `t_menu` VALUES ('34', '1', '扬州炒饭', '22.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E4%B8%BB%E9%A3%9F/%E6%89%AC%E5%B7%9E%E7%82%92%E9%A5%AD.jpg', '5');
INSERT INTO `t_menu` VALUES ('35', '2', '北京烤鸭', '88.00', 'http://menufile.oss-cn-beijing.aliyuncs.com/2/1573194673002.jpg', '9');
INSERT INTO `t_menu` VALUES ('37', '2', '拍黄瓜', '188.00', 'http://menufile.oss-cn-beijing.aliyuncs.com/2/1573194750422.jpg', '10');

-- ----------------------------
-- Table structure for t_menu_dishtype
-- ----------------------------
DROP TABLE IF EXISTS `t_menu_dishtype`;
CREATE TABLE `t_menu_dishtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) DEFAULT NULL,
  `dishType` varchar(255) DEFAULT NULL COMMENT '菜品类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu_dishtype
-- ----------------------------
INSERT INTO `t_menu_dishtype` VALUES ('1', '1', '精美凉菜');
INSERT INTO `t_menu_dishtype` VALUES ('2', '1', '四川菜系');
INSERT INTO `t_menu_dishtype` VALUES ('3', '1', '烧腊卤菜');
INSERT INTO `t_menu_dishtype` VALUES ('4', '1', '酒水');
INSERT INTO `t_menu_dishtype` VALUES ('5', '1', '主食');
INSERT INTO `t_menu_dishtype` VALUES ('6', '1', '汤类');
INSERT INTO `t_menu_dishtype` VALUES ('7', '1', '餐后甜点');
INSERT INTO `t_menu_dishtype` VALUES ('8', '1', '热菜');
INSERT INTO `t_menu_dishtype` VALUES ('9', '2', '热菜');
INSERT INTO `t_menu_dishtype` VALUES ('10', '2', '凉菜');
INSERT INTO `t_menu_dishtype` VALUES ('11', '1', '凉菜');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单Id',
  `orderId` varchar(255) DEFAULT NULL,
  `dishId` int(11) DEFAULT NULL COMMENT '菜品Id',
  `sid` int(11) DEFAULT NULL,
  `tableId` int(11) DEFAULT NULL COMMENT '桌号',
  `openId` varchar(255) DEFAULT NULL,
  `dishName` varchar(255) DEFAULT NULL,
  `dishPrice` decimal(10,2) DEFAULT NULL,
  `dishImage` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `totalPrice` decimal(10,2) DEFAULT NULL,
  `status` int(11) DEFAULT '0' COMMENT '订单状态 0:未付款 1:已付款',
  `dishStatus` int(255) DEFAULT NULL COMMENT '菜品状态 0: 已出单 1:正在做 2:已上菜 3:已退菜',
  `orderTime` datetime DEFAULT NULL,
  `payTime` datetime DEFAULT NULL,
  `remark` varchar(2000) DEFAULT NULL COMMENT '备注',
  `isDelete` int(1) unsigned zerofill DEFAULT NULL COMMENT '0: 未删除   1：已删除',
  `isPrint` int(1) unsigned zerofill DEFAULT NULL COMMENT '是否已打印 0：未打印  1：已打印',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('4', '201911051143450001', '7', '1', '1', 'o1Px45Hvg-ji35SlXJc_N_Yp_iJM', '拌土豆丝', '10.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%B2%BE%E7%BE%8E%E5%87%89%E8%8F%9C/%E6%8B%8C%E5%9C%9F%E8%B1%86%E4%B8%9D.jpg', '1', '10.00', '1', '0', '2019-11-05 11:43:46', '2019-11-05 11:43:46', '', '0', '0');
INSERT INTO `t_order` VALUES ('5', '201911051143450001', '8', '1', '1', 'o1Px45Hvg-ji35SlXJc_N_Yp_iJM', '酱牛肉', '30.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%B2%BE%E7%BE%8E%E5%87%89%E8%8F%9C/%E9%85%B1%E7%89%9B%E8%82%89.jpg', '1', '30.00', '1', '0', '2019-11-05 11:43:46', '2019-11-05 11:43:46', '', '0', '0');
INSERT INTO `t_order` VALUES ('6', '201911051143450001', '9', '1', '1', 'o1Px45Hvg-ji35SlXJc_N_Yp_iJM', '口水鸡', '32.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%B2%BE%E7%BE%8E%E5%87%89%E8%8F%9C/%E5%8F%A3%E6%B0%B4%E9%B8%A1.jpg', '1', '32.00', '1', '0', '2019-11-05 11:43:46', '2019-11-05 11:43:46', '', '0', '0');
INSERT INTO `t_order` VALUES ('17', '201911071644370001', '7', '1', '10', null, '拌土豆丝', '10.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%B2%BE%E7%BE%8E%E5%87%89%E8%8F%9C/%E6%8B%8C%E5%9C%9F%E8%B1%86%E4%B8%9D.jpg', '1', '0.00', '0', '3', '2019-11-07 16:44:38', null, '', '0', '1');
INSERT INTO `t_order` VALUES ('18', '201911071644370001', '8', '1', '10', null, '酱牛肉', '30.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%B2%BE%E7%BE%8E%E5%87%89%E8%8F%9C/%E9%85%B1%E7%89%9B%E8%82%89.jpg', '1', '0.00', '0', '3', '2019-11-07 16:44:38', null, '', '0', '1');
INSERT INTO `t_order` VALUES ('19', '201911071644370001', '9', '1', '10', null, '口水鸡', '32.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%B2%BE%E7%BE%8E%E5%87%89%E8%8F%9C/%E5%8F%A3%E6%B0%B4%E9%B8%A1.jpg', '1', '0.00', '0', '3', '2019-11-07 16:44:38', null, '', '0', '1');
INSERT INTO `t_order` VALUES ('20', '201911071644370001', '10', '1', '10', null, '凉拌木耳', '10.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%B2%BE%E7%BE%8E%E5%87%89%E8%8F%9C/%E5%87%89%E6%8B%8C%E6%9C%A8%E8%80%B3.jpg', '1', '10.00', '0', '0', '2019-11-07 16:44:38', null, '', '0', '1');
INSERT INTO `t_order` VALUES ('21', '201911071644370001', '11', '1', '10', null, '拍黄瓜', '8.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%B2%BE%E7%BE%8E%E5%87%89%E8%8F%9C/%E6%8B%8D%E9%BB%84%E7%93%9C.jpg', '1', '8.00', '0', '0', '2019-11-07 16:44:38', null, '', '0', '1');
INSERT INTO `t_order` VALUES ('22', '201911071644370001', '24', '1', '10', null, '宫保鸡丁', '29.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E5%9B%9B%E5%B7%9D%E8%8F%9C%E7%B3%BB/%E5%AE%AB%E4%BF%9D%E9%B8%A1%E4%B8%81.jpg', '1', '29.00', '0', '0', null, null, null, '0', '0');
INSERT INTO `t_order` VALUES ('23', '201911071644370001', '27', '1', '10', null, '水煮牛肉', '45.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E5%9B%9B%E5%B7%9D%E8%8F%9C%E7%B3%BB/%E6%B0%B4%E7%85%AE%E7%89%9B%E8%82%89.jpg', '1', '45.00', '0', '0', null, null, null, '0', '0');
INSERT INTO `t_order` VALUES ('24', '201911071656590001', '12', '1', '10', null, '可乐', '3.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E9%85%92%E6%B0%B4/%E5%8F%AF%E4%B9%90.jpg', '1', '3.00', '0', '0', '2019-11-07 16:57:00', null, '', '0', '0');
INSERT INTO `t_order` VALUES ('25', '201911071705140001', '12', '1', '9', null, '可乐', '3.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E9%85%92%E6%B0%B4/%E5%8F%AF%E4%B9%90.jpg', '1', '3.00', '0', '0', '2019-11-07 17:05:14', null, '', '0', '1');
INSERT INTO `t_order` VALUES ('26', '201911071705140001', '13', '1', '9', null, '矿泉水', '2.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E9%85%92%E6%B0%B4/%E7%9F%BF%E6%B3%89%E6%B0%B4.jpg', '1', '2.00', '0', '0', '2019-11-07 17:05:14', null, '', '0', '1');
INSERT INTO `t_order` VALUES ('27', '201911071705140001', '18', '1', '9', null, '潮州卤水猪肚', '38.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%83%A7%E8%85%8A%E5%8D%A4%E7%B1%BB/%E6%BD%AE%E5%B7%9E%E5%8D%A4%E6%B0%B4%E7%8C%AA%E8%82%9A.jpg', '1', '0.00', '0', '3', '2019-11-07 17:05:49', null, null, '0', '1');
INSERT INTO `t_order` VALUES ('28', '201911081059170001', '7', '1', '1', 'o1Px45Hvg-ji35SlXJc_N_Yp_iJM', '拌土豆丝', '10.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%B2%BE%E7%BE%8E%E5%87%89%E8%8F%9C/%E6%8B%8C%E5%9C%9F%E8%B1%86%E4%B8%9D.jpg', '1', '10.00', '0', '0', '2019-11-08 10:59:17', null, '', '0', '0');
INSERT INTO `t_order` VALUES ('29', '201911081059170001', '8', '1', '1', 'o1Px45Hvg-ji35SlXJc_N_Yp_iJM', '酱牛肉', '30.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%B2%BE%E7%BE%8E%E5%87%89%E8%8F%9C/%E9%85%B1%E7%89%9B%E8%82%89.jpg', '1', '30.00', '0', '0', '2019-11-08 10:59:17', null, '', '0', '0');
INSERT INTO `t_order` VALUES ('30', '201911081101180001', '8', '1', '1', 'o1Px45Hvg-ji35SlXJc_N_Yp_iJM', '酱牛肉', '30.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%B2%BE%E7%BE%8E%E5%87%89%E8%8F%9C/%E9%85%B1%E7%89%9B%E8%82%89.jpg', '1', '30.00', '0', '0', '2019-11-08 11:01:19', null, '', '0', '0');
INSERT INTO `t_order` VALUES ('31', '201911081104020001', '8', '1', '1', 'o1Px45Hvg-ji35SlXJc_N_Yp_iJM', '酱牛肉', '30.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%B2%BE%E7%BE%8E%E5%87%89%E8%8F%9C/%E9%85%B1%E7%89%9B%E8%82%89.jpg', '1', '30.00', '0', '0', '2019-11-08 11:04:02', null, '', '0', '0');
INSERT INTO `t_order` VALUES ('32', '201911081112530001', '7', '1', '1', 'o1Px45Hvg-ji35SlXJc_N_Yp_iJM', '拌土豆丝', '10.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%B2%BE%E7%BE%8E%E5%87%89%E8%8F%9C/%E6%8B%8C%E5%9C%9F%E8%B1%86%E4%B8%9D.jpg', '1', '10.00', '0', '0', '2019-11-08 11:12:54', null, '', '0', '0');
INSERT INTO `t_order` VALUES ('33', '201911081114090001', '7', '1', '1', 'o1Px45Hvg-ji35SlXJc_N_Yp_iJM', '拌土豆丝', '10.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%B2%BE%E7%BE%8E%E5%87%89%E8%8F%9C/%E6%8B%8C%E5%9C%9F%E8%B1%86%E4%B8%9D.jpg', '1', '10.00', '0', '0', '2019-11-08 11:14:10', null, '', '0', '0');
INSERT INTO `t_order` VALUES ('34', '201911081431090001', '7', '1', '1', 'o1Px45Hvg-ji35SlXJc_N_Yp_iJM', '拌土豆丝', '10.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%B2%BE%E7%BE%8E%E5%87%89%E8%8F%9C/%E6%8B%8C%E5%9C%9F%E8%B1%86%E4%B8%9D.jpg', '1', '10.00', '0', '0', '2019-11-08 14:31:09', null, '', '0', '0');
INSERT INTO `t_order` VALUES ('35', '201911081436400001', '19', '1', '1', 'o1Px45Hvg-ji35SlXJc_N_Yp_iJM', '卤水豆腐', '22.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%83%A7%E8%85%8A%E5%8D%A4%E7%B1%BB/%E5%8D%A4%E6%B0%B4%E8%B1%86%E8%85%90.jpg', '1', '22.00', '0', '0', '2019-11-08 14:36:40', null, '', '0', '0');
INSERT INTO `t_order` VALUES ('36', '201911081440240001', '12', '1', '1', 'o1Px45Hvg-ji35SlXJc_N_Yp_iJM', '可乐', '3.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E9%85%92%E6%B0%B4/%E5%8F%AF%E4%B9%90.jpg', '1', '3.00', '0', '0', '2019-11-08 14:40:24', null, '', '0', '0');
INSERT INTO `t_order` VALUES ('37', '201911081441310001', '7', '1', '1', 'o1Px45Hvg-ji35SlXJc_N_Yp_iJM', '拌土豆丝', '10.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%B2%BE%E7%BE%8E%E5%87%89%E8%8F%9C/%E6%8B%8C%E5%9C%9F%E8%B1%86%E4%B8%9D.jpg', '1', '10.00', '1', '0', '2019-11-08 14:41:32', '2019-11-08 14:41:52', '', '0', '1');
INSERT INTO `t_order` VALUES ('38', '201911081441310001', '8', '1', '1', 'o1Px45Hvg-ji35SlXJc_N_Yp_iJM', '酱牛肉', '30.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%B2%BE%E7%BE%8E%E5%87%89%E8%8F%9C/%E9%85%B1%E7%89%9B%E8%82%89.jpg', '2', '60.00', '1', '0', '2019-11-08 14:41:32', '2019-11-08 14:41:52', '', '0', '1');
INSERT INTO `t_order` VALUES ('39', '201911081633280001', '12', '1', '1', 'o1Px45Hvg-ji35SlXJc_N_Yp_iJM', '可乐', '3.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E9%85%92%E6%B0%B4/%E5%8F%AF%E4%B9%90.jpg', '2', '6.00', '1', '0', '2019-11-08 16:33:28', '2019-11-08 16:36:47', '', '0', '1');
INSERT INTO `t_order` VALUES ('40', '201911081707540001', '7', '1', '4', null, '拌土豆丝', '10.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%B2%BE%E7%BE%8E%E5%87%89%E8%8F%9C/%E6%8B%8C%E5%9C%9F%E8%B1%86%E4%B8%9D.jpg', '1', '10.00', '0', '1', '2019-11-08 17:07:54', null, '', '0', '1');
INSERT INTO `t_order` VALUES ('41', '201911081707540001', '8', '1', '4', null, '酱牛肉', '30.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%B2%BE%E7%BE%8E%E5%87%89%E8%8F%9C/%E9%85%B1%E7%89%9B%E8%82%89.jpg', '1', '30.00', '0', '2', '2019-11-08 17:07:54', null, '', '0', '1');
INSERT INTO `t_order` VALUES ('42', '201911081707540001', '9', '1', '4', null, '口水鸡', '32.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%B2%BE%E7%BE%8E%E5%87%89%E8%8F%9C/%E5%8F%A3%E6%B0%B4%E9%B8%A1.jpg', '1', '0.00', '0', '3', '2019-11-08 17:07:54', null, '', '0', '1');
INSERT INTO `t_order` VALUES ('43', '201911081707540001', '11', '1', '4', null, '拍黄瓜', '8.00', 'https://menufile.oss-cn-beijing.aliyuncs.com/shanxiandajiudian/%E7%B2%BE%E7%BE%8E%E5%87%89%E8%8F%9C/%E6%8B%8D%E9%BB%84%E7%93%9C.jpg', '1', '8.00', '0', '1', '2019-11-08 17:08:26', null, null, '0', '1');

-- ----------------------------
-- Table structure for t_shop
-- ----------------------------
DROP TABLE IF EXISTS `t_shop`;
CREATE TABLE `t_shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商铺Id',
  `name` varchar(255) DEFAULT NULL COMMENT '店铺名字',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `address` varchar(255) DEFAULT NULL,
  `wifi` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `longitude` varchar(255) DEFAULT NULL COMMENT '经度',
  `latitude` varchar(255) DEFAULT NULL COMMENT '纬度',
  `details` varchar(2000) DEFAULT NULL COMMENT '店铺展示图',
  `banner` varchar(255) DEFAULT NULL COMMENT '轮播图',
  `orgNo` varchar(255) DEFAULT NULL COMMENT '机构号',
  `mercId` varchar(255) DEFAULT NULL COMMENT '商家号',
  `trmNo` varchar(255) DEFAULT NULL COMMENT '设备号',
  `appId` varchar(255) DEFAULT NULL COMMENT '小程序appId',
  `secret` varchar(255) DEFAULT NULL COMMENT '小程序secret',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_shop
-- ----------------------------
INSERT INTO `t_shop` VALUES ('1', '聪悦大饭店', null, '河北省石家庄市中华北大街中储广场B座', '1234567890', '0311-88818808', '114.48308', '38.074283', 'https://shopfiles.oss-cn-beijing.aliyuncs.com/details/1/1.jpg;https://shopfiles.oss-cn-beijing.aliyuncs.com/details/1/2.jpg;https://shopfiles.oss-cn-beijing.aliyuncs.com/details/1/3.jpg', 'https://shopfiles.oss-cn-beijing.aliyuncs.com/banner/1/1.jpg;https://shopfiles.oss-cn-beijing.aliyuncs.com/banner/1/2.jpg', '42285', '800121000038152', 'XB345898', 'wxd0ccefffed1623c5', '6d777f9bceb827b31934faefa1e69f2f');

-- ----------------------------
-- Table structure for t_table
-- ----------------------------
DROP TABLE IF EXISTS `t_table`;
CREATE TABLE `t_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '餐桌Id',
  `sid` int(11) DEFAULT NULL COMMENT '店铺Id',
  `table_name` varchar(255) DEFAULT NULL COMMENT '餐桌名',
  `status` int(11) unsigned zerofill DEFAULT NULL COMMENT '餐桌状态 0:空闲  1: 已开桌  2:用餐  3:待清理',
  `floor` int(11) unsigned DEFAULT '1' COMMENT '楼层',
  `specification` int(11) DEFAULT NULL COMMENT '餐桌的规格',
  `area` int(11) DEFAULT NULL COMMENT '区域',
  `population` int(11) unsigned zerofill DEFAULT '00000000000' COMMENT '该桌的人数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_table
-- ----------------------------
INSERT INTO `t_table` VALUES ('1', '1', '1号桌', '00000000002', '1', '1', '1', '00000000004');
INSERT INTO `t_table` VALUES ('2', '1', '2号桌', '00000000002', '2', '2', '2', '00000000009');
INSERT INTO `t_table` VALUES ('4', '1', '4号桌', '00000000002', '1', '1', '2', '00000000005');
INSERT INTO `t_table` VALUES ('5', '1', '5号桌', '00000000000', '1', '1', '1', '00000000123');
INSERT INTO `t_table` VALUES ('6', '1', '6号桌', '00000000002', '1', '1', '1', '00000000123');
INSERT INTO `t_table` VALUES ('7', '1', '7号桌', '00000000002', '1', '1', '1', '00000000006');
INSERT INTO `t_table` VALUES ('8', '1', '8号桌', '00000000002', '1', '1', '1', '00000000008');
INSERT INTO `t_table` VALUES ('9', '1', '9号桌', '00000000002', '1', '1', '1', '00000000008');
INSERT INTO `t_table` VALUES ('10', '1', '10号桌', '00000000002', '1', '1', '1', '00000000008');
INSERT INTO `t_table` VALUES ('11', '1', '11号桌', '00000000003', '1', '1', '2', '00000000008');
INSERT INTO `t_table` VALUES ('12', '1', '001', '00000000001', '1', '1', '1', '00000000005');
INSERT INTO `t_table` VALUES ('13', '1', '002', '00000000000', '1', '1', '1', '00000000000');
INSERT INTO `t_table` VALUES ('14', '2', '001', '00000000000', '4', '4', '1', '00000000000');
INSERT INTO `t_table` VALUES ('15', '2', '002', '00000000000', '4', '4', '1', '00000000000');
INSERT INTO `t_table` VALUES ('16', '2', '003', '00000000000', '4', '4', '1', '00000000000');
INSERT INTO `t_table` VALUES ('17', '2', '004', '00000000000', '4', '4', '1', '00000000000');
INSERT INTO `t_table` VALUES ('18', '2', '005', '00000000000', '4', '4', '1', '00000000000');
INSERT INTO `t_table` VALUES ('19', '2', '001', '00000000000', '4', '5', '2', '00000000000');
INSERT INTO `t_table` VALUES ('20', '2', '002', '00000000000', '4', '5', '2', '00000000000');
INSERT INTO `t_table` VALUES ('21', '2', '003', '00000000000', '4', '5', '2', '00000000000');
INSERT INTO `t_table` VALUES ('22', '2', '004', '00000000000', '4', '5', '2', '00000000000');
INSERT INTO `t_table` VALUES ('23', '2', '001', '00000000000', '5', '5', '2', '00000000000');
INSERT INTO `t_table` VALUES ('24', '2', '002', '00000000000', '5', '5', '2', '00000000000');
INSERT INTO `t_table` VALUES ('25', '2', '003', '00000000000', '5', '5', '2', '00000000000');
INSERT INTO `t_table` VALUES ('26', '2', '004', '00000000000', '5', '5', '2', '00000000000');
INSERT INTO `t_table` VALUES ('27', '2', '005', '00000000000', '5', '5', '2', '00000000000');
INSERT INTO `t_table` VALUES ('28', '2', '006', '00000000000', '5', '5', '2', '00000000000');

-- ----------------------------
-- Table structure for t_table_area
-- ----------------------------
DROP TABLE IF EXISTS `t_table_area`;
CREATE TABLE `t_table_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area` int(11) DEFAULT NULL COMMENT '区域ID',
  `floor` int(11) DEFAULT NULL,
  `shopId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_table_area
-- ----------------------------
INSERT INTO `t_table_area` VALUES ('1', '1', '1', '1');
INSERT INTO `t_table_area` VALUES ('2', '2', '1', '1');
INSERT INTO `t_table_area` VALUES ('4', '2', '2', '1');
INSERT INTO `t_table_area` VALUES ('6', '1', '4', '2');
INSERT INTO `t_table_area` VALUES ('7', '2', '4', '2');
INSERT INTO `t_table_area` VALUES ('8', '2', '5', '2');

-- ----------------------------
-- Table structure for t_table_floor
-- ----------------------------
DROP TABLE IF EXISTS `t_table_floor`;
CREATE TABLE `t_table_floor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shopId` int(11) DEFAULT NULL,
  `floor` varchar(255) DEFAULT NULL COMMENT '餐桌_楼层关联表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_table_floor
-- ----------------------------
INSERT INTO `t_table_floor` VALUES ('1', '1', '1');
INSERT INTO `t_table_floor` VALUES ('2', '1', '2');
INSERT INTO `t_table_floor` VALUES ('3', '1', '3');
INSERT INTO `t_table_floor` VALUES ('4', '2', '1');
INSERT INTO `t_table_floor` VALUES ('5', '2', '2');
INSERT INTO `t_table_floor` VALUES ('6', '2', '3');

-- ----------------------------
-- Table structure for t_table_specification
-- ----------------------------
DROP TABLE IF EXISTS `t_table_specification`;
CREATE TABLE `t_table_specification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `specification` varchar(255) DEFAULT NULL,
  `shopId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_table_specification
-- ----------------------------
INSERT INTO `t_table_specification` VALUES ('1', '4人桌', '1');
INSERT INTO `t_table_specification` VALUES ('2', '6人桌', '1');
INSERT INTO `t_table_specification` VALUES ('3', '8人桌', '1');
INSERT INTO `t_table_specification` VALUES ('4', '2人桌', '2');
INSERT INTO `t_table_specification` VALUES ('5', '5人桌', '2');

-- ----------------------------
-- Table structure for t_table_status
-- ----------------------------
DROP TABLE IF EXISTS `t_table_status`;
CREATE TABLE `t_table_status` (
  `id` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_table_status
-- ----------------------------
INSERT INTO `t_table_status` VALUES ('0', '空闲');
INSERT INTO `t_table_status` VALUES ('1', '已开桌');
INSERT INTO `t_table_status` VALUES ('2', '用餐中');
INSERT INTO `t_table_status` VALUES ('3', '待清理');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(100) NOT NULL AUTO_INCREMENT COMMENT 'userId',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `sid` int(10) NOT NULL COMMENT '商铺ID',
  `usertype` int(1) NOT NULL DEFAULT '2' COMMENT '0管理员，1老板，2服务员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '123456', '000000', '1', '1');
INSERT INTO `t_user` VALUES ('2', '123', '456', '2', '1');
INSERT INTO `t_user` VALUES ('3', '12333', '123', '2', '0');
INSERT INTO `t_user` VALUES ('4', '456', '321', '1', '2');
INSERT INTO `t_user` VALUES ('5', '111', '111', '2', '2');
INSERT INTO `t_user` VALUES ('6', '1233312312', '123', '1', '1');
INSERT INTO `t_user` VALUES ('9', '123321', '123', '1', '2');
INSERT INTO `t_user` VALUES ('10', 'b123', '123', '2', '1');
INSERT INTO `t_user` VALUES ('11', '111111', '123', '1', '2');
