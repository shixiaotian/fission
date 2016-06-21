/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Version : 50711
 Source Host           : 127.0.0.1
 Source Database       : fission_filesystem

 Target Server Version : 50711
 File Encoding         : utf-8

 Date: 06/21/2016 16:11:02 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `file`
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `fileId` char(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '文件唯一标识主键',
  `fileSrcName` char(255) NOT NULL,
  `fileName` char(255) NOT NULL,
  `filePath` char(255) NOT NULL,
  `fileOnwerId` char(32) NOT NULL,
  `fileOnwerFrom` char(255) NOT NULL,
  `fileSize` char(20) NOT NULL,
  PRIMARY KEY (`fileId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `file`
-- ----------------------------
BEGIN;
INSERT INTO `file` VALUES ('test', 'test', 'test', '/test', 'test', 'test', '123');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
