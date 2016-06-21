/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Version : 50711
 Source Host           : 127.0.0.1
 Source Database       : fission_authsystem

 Target Server Version : 50711
 File Encoding         : utf-8

 Date: 06/21/2016 16:10:55 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `authorityRole`
-- ----------------------------
DROP TABLE IF EXISTS `authorityRole`;
CREATE TABLE `authorityRole` (
  `roleId` char(32) NOT NULL COMMENT '权限角色id',
  `name` char(40) NOT NULL COMMENT '权限角色名称',
  `url` char(255) NOT NULL,
  `createDate` datetime NOT NULL,
  `lock` tinyint(1) NOT NULL,
  `deleted` tinyint(1) NOT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限角色表，存储\n如：梨子权限，苹果权限，对应的url';

-- ----------------------------
--  Table structure for `codeList`
-- ----------------------------
DROP TABLE IF EXISTS `codeList`;
CREATE TABLE `codeList` (
  `code` char(40) NOT NULL COMMENT '定义代码号',
  `describe` char(50) NOT NULL COMMENT '代码描述',
  `createDate` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userCode` char(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '用户主键，唯一标识id，可以当作code使用',
  `username` char(50) NOT NULL COMMENT '用户账号',
  `password` char(40) NOT NULL COMMENT '用户密码',
  `token` char(10) NOT NULL COMMENT '用户当前验签',
  `lock` tinyint(1) NOT NULL DEFAULT '0' COMMENT '用户是否被锁定',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '用户是否被删除',
  `createDate` datetime NOT NULL COMMENT '创建日期',
  PRIMARY KEY (`userCode`),
  UNIQUE KEY `user.username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa', 'bibijiang', '94cd166631d14dab533858b9b47e9584a2ff3f65', '000000', '0', '0', '2016-04-21 17:01:10');
COMMIT;

-- ----------------------------
--  Table structure for `userOperation`
-- ----------------------------
DROP TABLE IF EXISTS `userOperation`;
CREATE TABLE `userOperation` (
  `userCode` char(32) NOT NULL COMMENT '用户主键 32位uuid',
  `operation` char(20) NOT NULL COMMENT '用户操作类型，例如修改密码，value就显示旧密码',
  `operationDescribe` char(50) NOT NULL COMMENT '用户操作描述，例如旧密码',
  `date` datetime NOT NULL COMMENT '这条记录发生的日期',
  PRIMARY KEY (`userCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
