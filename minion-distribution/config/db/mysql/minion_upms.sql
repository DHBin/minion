SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

create schema minion_upms collate utf8mb4_unicode_ci;

use minion_upms;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'id',
  `label` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
  `description` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '说明',
  `type` tinyint(2) NOT NULL COMMENT '1-顶部菜单 2-左侧菜单',
  `path` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '前端页面路径',
  `component` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '前端组件路径',
  `icon` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单图标',
  `num` int(11) NOT NULL COMMENT '编号',
  `parent_num` int(11) NOT NULL COMMENT '父级编码',
  `order_num` int(11) NOT NULL COMMENT '顺序',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `create_uid` bigint(20) unsigned NOT NULL COMMENT '创建uid',
  `update_uid` bigint(20) unsigned DEFAULT NULL COMMENT '更新uid',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_menu_num_uindex` (`num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` VALUES (1, '系统管理', '错误页面', 2, '/upms', '', 'el-icon-s-tools', 1, -1, 1, '2020-05-01 03:46:33', '2020-05-01 11:46:33', 1, 1240867920893558785);
INSERT INTO `sys_menu` VALUES (2, '用户管理', '500', 2, 'user', 'views/upms/user', 'el-icon-user-solid', 11, 1, 1, '2020-03-21 06:54:57', '2020-03-21 14:54:57', 1, 1240192515995959297);
INSERT INTO `sys_menu` VALUES (3, '角色管理', '400', 2, 'role', 'views/upms/role', 'el-icon-s-custom', 12, 1, 2, '2020-03-21 06:55:56', '2020-03-21 14:55:56', 1, 1240192515995959297);
INSERT INTO `sys_menu` VALUES (4, '菜单管理', '菜单', 2, 'menu', 'views/upms/menu', 'el-icon-menu', 13, 1, 3, '2020-03-21 06:54:09', '2020-03-21 14:54:09', 1, 1240192515995959297);
INSERT INTO `sys_menu` VALUES (1241078089300623361, '权限管理', NULL, 2, 'perm', 'views/upms/perm', 'el-icon-s-platform', 14, 1, 4, '2020-03-21 06:58:02', '2020-03-21 14:58:03', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu` VALUES (1241225809789317121, '新增用户', NULL, 3, '', '', '', 111, 11, 111, '2020-03-21 04:53:25', '2020-03-21 12:53:26', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu` VALUES (1241226296613793793, '更新用户', NULL, 3, '', '', '', 112, 11, 112, '2020-03-21 12:53:05', '2020-03-21 12:53:05', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu` VALUES (1241232210418728961, '用户列表', NULL, 3, '', '', '', 110, 11, 110, '2020-03-21 09:51:28', '2020-03-21 17:51:29', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu` VALUES (1241235174617280513, '角色列表', NULL, 3, '', '', '', 120, 12, 120, '2020-03-21 10:13:32', '2020-03-21 18:13:33', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu` VALUES (1241235316242149377, '创建角色', NULL, 3, '', '', '', 121, 12, 121, '2020-03-21 13:28:55', '2020-03-21 13:28:55', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu` VALUES (1241253796337278977, '更新角色', NULL, 3, '', '', '', 123, 12, 123, '2020-03-21 14:42:21', '2020-03-21 14:42:21', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu` VALUES (1241253984636362754, '删除角色', NULL, 3, '', '', '', 124, 12, 124, '2020-03-21 10:15:26', '2020-03-21 18:15:27', 1240192515995959297, 1240867920893558785);
INSERT INTO `sys_menu` VALUES (1241254140979044354, '删除用户', NULL, 3, '', '', '', 113, 11, 113, '2020-04-19 15:58:16', '2020-04-19 23:58:16', 1240192515995959297, 1240867920893558785);
INSERT INTO `sys_menu` VALUES (1241254376820563969, '菜单列表', NULL, 3, '', '', '', 131, 13, 131, '2020-03-21 14:44:39', '2020-03-21 14:44:39', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu` VALUES (1241254551626571777, '创建菜单', NULL, 3, '', '', '', 132, 13, 132, '2020-03-21 14:45:21', '2020-03-21 14:45:21', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu` VALUES (1241254697986809857, '更新菜单', NULL, 3, '', '', '', 133, 13, 133, '2020-03-21 14:45:56', '2020-03-21 14:45:56', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu` VALUES (1241254812759744514, '删除菜单', NULL, 3, '', '', '', 134, 13, 134, '2020-03-21 14:46:23', '2020-03-21 14:46:23', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu` VALUES (1241254948235763714, '权限列表', NULL, 3, '', '', '', 141, 14, 141, '2020-03-21 14:46:56', '2020-03-21 14:46:56', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu` VALUES (1241302394064076801, '更新角色菜单权限', NULL, 3, '', '', '', 125, 12, 125, '2020-03-21 17:55:28', '2020-03-21 17:55:28', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu` VALUES (1241310951631261698, '首页', NULL, 1, '/wel/index', '', 'el-icon-document', 10, -1, 50, '2020-03-21 13:29:51', '2020-03-21 21:29:51', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_menu` VALUES (1241311239121440770, '文档', NULL, 1, 'https://fymd.gitee.io/minion/', '', 'el-icon-document', 30, -1, 60, '2020-03-21 13:29:58', '2020-03-21 21:29:58', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_menu` VALUES (1242841522316062721, '重载权限', NULL, 3, '', '', '', 142, 14, 142, '2020-03-25 15:51:33', '2020-03-25 23:51:34', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_menu` VALUES (1242843983776919553, '删除权限', NULL, 3, '', '', '', 143, 14, 143, '2020-03-26 00:01:11', '2020-03-26 00:01:11', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_menu` VALUES (1251757823226814465, '测试用户列表', NULL, 3, '', '', '', 71, 70, 71, '2020-04-19 18:25:28', '2020-04-19 14:24:40', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_menu` VALUES (1251759787083833346, '新增测试用户', NULL, 3, '', '', '', 72, 70, 72, '2020-04-19 18:25:28', '2020-04-19 14:29:24', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_menu` VALUES (1251885841148551169, '更新测试用户', NULL, 3, '', '', '', 73, 70, 73, '2020-04-19 18:25:28', '2020-04-19 22:50:18', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_menu` VALUES (1251885952041754625, '删除测试用户', NULL, 3, '', '', '', 74, 70, 74, '2020-04-19 18:25:28', '2020-04-19 22:50:45', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_menu` VALUES (1256067316093898754, '授权管理', NULL, 2, '/auth', '', 'icon-anquan', 2, -1, 2, '2020-05-05 01:00:25', '2020-05-05 09:00:25', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_menu` VALUES (1256069077932265473, '客户端管理', NULL, 2, 'client', 'views/upms/client', 'icon-kehuduan', 21, 2, 21, '2020-05-05 01:04:32', '2020-05-05 09:04:33', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_menu` VALUES (1256215452187750402, '新增客户端', NULL, 3, '', '', '', 211, 21, 211, '2020-05-04 09:34:53', '2020-05-04 17:34:53', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_menu` VALUES (1256216100060917761, '修改客户端', NULL, 3, '', '', '', 212, 21, 212, '2020-05-01 21:37:12', '2020-05-01 21:37:12', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_menu` VALUES (1257242379090411521, '删除客户端', NULL, 3, '', '', '', 213, 21, 213, '2020-05-04 09:35:24', '2020-05-04 17:35:25', 1240867920893558785, 1240867920893558785);
COMMIT;

-- ----------------------------
-- Table structure for sys_menu_perm
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_perm`;
CREATE TABLE `sys_menu_perm` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'id',
  `mid` bigint(20) unsigned NOT NULL COMMENT '菜单id',
  `pid` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '权限id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `create_uid` bigint(20) unsigned NOT NULL COMMENT '创建uid',
  `update_uid` bigint(20) unsigned DEFAULT NULL COMMENT '更新uid',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of sys_menu_perm
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu_perm` VALUES (1, 1241254376820563969, '5c61217bb528d09c77c0d0fde14fa358', '2020-03-21 07:08:13', NULL, 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu_perm` VALUES (1241226296655736833, 1241226296613793793, '97d5074513c4d79553a27e5f43b5c2a9', '2020-03-21 12:53:05', '2020-03-21 12:53:05', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu_perm` VALUES (1241226385411403778, 1241225809789317121, '0def146ed3c0343d2e6c728b440ae754', '2020-03-21 12:53:26', '2020-03-21 12:53:26', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu_perm` VALUES (1241235316279898113, 1241235316242149377, '3eec59054f3eb507096e2196c531ea92', '2020-03-21 13:28:55', '2020-03-21 13:28:55', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu_perm` VALUES (1241253796379222017, 1241253796337278977, 'd94b449caf526aa20868a8b7e5139655', '2020-03-21 14:42:21', '2020-03-21 14:42:21', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu_perm` VALUES (1241254376849924098, 1241254376820563969, '5600b90bc2e1900ffc67ff28702729cc', '2020-03-21 14:44:39', '2020-03-21 14:44:39', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu_perm` VALUES (1241254551655931906, 1241254551626571777, 'd0c01af93cd9485bc93cc349ff6acfb5', '2020-03-21 14:45:21', '2020-03-21 14:45:21', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu_perm` VALUES (1241254698251051010, 1241254697986809857, 'ab72f8a69c37710fd4831e35dc514bd9', '2020-03-21 14:45:56', '2020-03-21 14:45:56', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu_perm` VALUES (1241254812789104642, 1241254812759744514, '1069137917b67938906da66e3c6655d9', '2020-03-21 14:46:23', '2020-03-21 14:46:23', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu_perm` VALUES (1241254948260929537, 1241254948235763714, 'd46e14af30b9edc00bd149ec12845651', '2020-03-21 14:46:56', '2020-03-21 14:46:56', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu_perm` VALUES (1241301392162291714, 1241232210418728961, '231051c3538937e8488c108aebeb68e3', '2020-03-21 17:51:29', '2020-03-21 17:51:29', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu_perm` VALUES (1241301392174874626, 1241232210418728961, '2ff0e306f37b88686d9344c5e4a22ed8', '2020-03-21 17:51:29', '2020-03-21 17:51:29', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu_perm` VALUES (1241302394097631234, 1241302394064076801, '23b312d99b0bdf473190eca7951274b4', '2020-03-21 17:55:28', '2020-03-21 17:55:28', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu_perm` VALUES (1241302394114408449, 1241302394064076801, '5600b90bc2e1900ffc67ff28702729cc', '2020-03-21 17:55:28', '2020-03-21 17:55:28', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu_perm` VALUES (1241302394122797058, 1241302394064076801, '96fa70a9281e6f85c82a215f1d92d988', '2020-03-21 17:55:28', '2020-03-21 17:55:28', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu_perm` VALUES (1241306945764757506, 1241235174617280513, '5c61217bb528d09c77c0d0fde14fa358', '2020-03-21 18:13:33', '2020-03-21 18:13:33', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu_perm` VALUES (1241306945785729025, 1241235174617280513, 'f0e4be93237ddde1a8000cdbd183789e', '2020-03-21 18:13:33', '2020-03-21 18:13:33', 1240192515995959297, 1240192515995959297);
INSERT INTO `sys_menu_perm` VALUES (1241307423865081857, 1241253984636362754, 'af7a0acfe883b413306f03de590066a5', '2020-03-21 18:15:27', '2020-03-21 18:15:27', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_menu_perm` VALUES (1242841561415364610, 1242841522316062721, '641c4a02c1231ffec0b6812883b55059', '2020-03-25 23:51:34', '2020-03-25 23:51:34', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_menu_perm` VALUES (1242843983823056897, 1242843983776919553, 'c27760d02e31b32a4cfe3e40d5662d27', '2020-03-26 00:01:11', '2020-03-26 00:01:11', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_menu_perm` VALUES (1251758592227287041, 1251757823226814465, 'a9966b44306c21b78890d0404207099a', '2020-04-19 14:24:40', '2020-04-19 14:24:40', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_menu_perm` VALUES (1251759787100610562, 1251759787083833346, '8b7b8e0724ad239f0d4dc106aa602af7', '2020-04-19 14:29:24', '2020-04-19 14:29:24', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_menu_perm` VALUES (1251885841224048641, 1251885841148551169, '1a0851b33829583d3688f6553a892ab2', '2020-04-19 22:50:18', '2020-04-19 22:50:18', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_menu_perm` VALUES (1251885952062726145, 1251885952041754625, '3f14e2c5493c887b187ec10ac41b2e5c', '2020-04-19 22:50:45', '2020-04-19 22:50:45', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_menu_perm` VALUES (1251902945830641666, 1241254140979044354, '1af8378c754ab7b4934903e0e3bc1093', '2020-04-19 23:58:16', '2020-04-19 23:58:16', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_menu_perm` VALUES (1256216100153192449, 1256216100060917761, 'ee64ad27609a7312c998dedf2feb17a7', '2020-05-01 21:37:12', '2020-05-01 21:37:12', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_menu_perm` VALUES (1257242282625613826, 1256215452187750402, '523840ed03127be7c3a1e0acbd1ae05d', '2020-05-04 17:34:53', '2020-05-04 17:34:53', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_menu_perm` VALUES (1257242415056568322, 1257242379090411521, 'd7e7fc5fe2f8d75563a1fede98ec93b0', '2020-05-04 17:35:25', '2020-05-04 17:35:25', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_menu_perm` VALUES (1257476237866049537, 1256069077932265473, 'e7dcb25a5ad3fa7324d0483c253235b8', '2020-05-05 09:04:33', '2020-05-05 09:04:33', 1240867920893558785, 1240867920893558785);
COMMIT;

-- ----------------------------
-- Table structure for sys_perm
-- ----------------------------
DROP TABLE IF EXISTS `sys_perm`;
CREATE TABLE `sys_perm` (
  `id` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'id',
  `own` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所属项目',
  `name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `description` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '说明',
  `path` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '路径',
  `method` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '请求方法',
  `authorizations` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '权限标识',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_uid` bigint(20) unsigned DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `update_uid` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of sys_perm
-- ----------------------------
BEGIN;
INSERT INTO `sys_perm` VALUES ('0254c37bc66a7f67dfbbe7740ad1a90d', 'minion-auth-biz', NULL, NULL, '/error', '', NULL, '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('0def146ed3c0343d2e6c728b440ae754', 'minion-upms-biz', '创建用户', '', '/user', 'POST', 'sys_user_create', '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('1069137917b67938906da66e3c6655d9', 'minion-upms-biz', '删除菜单', '', '/menu/{id:\\d+}', 'DELETE', 'sys_menu_delete', '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('1af8378c754ab7b4934903e0e3bc1093', 'minion-upms-biz', '删除用户', '', '/user/{id:\\d+}', 'DELETE', 'sys_user_delete', '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('231051c3538937e8488c108aebeb68e3', 'minion-upms-biz', '获取用户列表', '', '/user', 'GET', 'sys_user_list', '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('23b312d99b0bdf473190eca7951274b4', 'minion-upms-biz', '更新角色的菜单', '', '/menu/role', 'PUT', 'sys_menu_role_update', '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('2ff0e306f37b88686d9344c5e4a22ed8', 'minion-upms-biz', '获取所有角色', '', '/role/all', 'GET', 'sys_role_all', '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('3e404142245c10db29840b7e6408ab20', 'minion-upms-biz', '获取左侧菜单', '', '/menu/getMenu', 'GET', '', '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('3eec59054f3eb507096e2196c531ea92', 'minion-upms-biz', '创建角色', '', '/role', 'POST', 'sys_role_create', '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('523840ed03127be7c3a1e0acbd1ae05d', 'minion-upms-biz', '添加Client', '', '/client', 'POST', 'auth_client_create', '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('5600b90bc2e1900ffc67ff28702729cc', 'minion-upms-biz', '获取所有菜单', '', '/menu', 'GET', 'sys_menu_list', '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('5c61217bb528d09c77c0d0fde14fa358', 'minion-upms-biz', '获取所有权限', '', '/perm/all', 'GET', 'sys_perm_all', '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('641c4a02c1231ffec0b6812883b55059', 'minion-upms-biz', '重载权限', '', '/perm/reload', 'PUT', 'sys_perm_reload', '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('762bd6c6958d0f0f7eceb8771ede0810', 'minion-upms-biz', '获取顶部菜单', '', '/menu/getTopMenu', 'GET', '', '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('8a58d9d38d24d31f977f20c4d2dc0141', 'minion-upms-biz', NULL, NULL, '/v2/api-docs-ext', 'GET', NULL, '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('96fa70a9281e6f85c82a215f1d92d988', 'minion-upms-biz', '获取角色的菜单', '', '/menu/role', 'GET', 'sys_menu_role_get', '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('97d5074513c4d79553a27e5f43b5c2a9', 'minion-upms-biz', '更新用户', '', '/user', 'PUT', 'sys_user_update', '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('9c3950609cdeb4aa0bb7f163ec99789b', 'minion-upms-biz', NULL, NULL, '/swagger-resources/configuration/ui', '', NULL, '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('a1a1b093802332ce33d91eb70dd8ab0f', 'minion-upms-biz', NULL, NULL, '/error', '', NULL, '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('ab72f8a69c37710fd4831e35dc514bd9', 'minion-upms-biz', '更新菜单', '', '/menu', 'PUT', 'sys_menu_update', '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('af7a0acfe883b413306f03de590066a5', 'minion-upms-biz', '删除角色', '', '/role/{id:\\d+}', 'DELETE', 'sys_role_delete', '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('c27760d02e31b32a4cfe3e40d5662d27', 'minion-upms-biz', '删除权限', '', '/perm/{id}', 'DELETE', 'sys_perm_delete', '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('c43109bb98fd79d2350bae6af445559e', 'minion-upms-biz', '登出', '', '/user/logout', 'GET', '', '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('d0c01af93cd9485bc93cc349ff6acfb5', 'minion-upms-biz', '创建菜单', '', '/menu', 'POST', 'sys_menu_create', '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('d46e14af30b9edc00bd149ec12845651', 'minion-upms-biz', '分页获取权限', '', '/perm', 'GET', 'sys_perm_list', '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('d7e7fc5fe2f8d75563a1fede98ec93b0', 'minion-upms-biz', '删除Client', '', '/client/{clientId}', 'DELETE', 'auth_client_delete', '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('d94b449caf526aa20868a8b7e5139655', 'minion-upms-biz', '更新角色', '', '/role', 'PUT', 'sys_role_update', '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('e402e106380d30aee9330c87e0efe3ca', 'minion-upms-biz', NULL, NULL, '/swagger-resources/configuration/security', '', NULL, '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('e7dcb25a5ad3fa7324d0483c253235b8', 'minion-upms-biz', '获取Client列表', '', '/client', 'GET', 'auth_client_list', '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('ee64ad27609a7312c998dedf2feb17a7', 'minion-upms-biz', '更新Client', '', '/client', 'PUT', 'auth_client_update', '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('efca993b7c7b4170e2a6a9ff95131717', 'minion-upms-biz', NULL, NULL, '/swagger-resources', '', NULL, '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('f0e4be93237ddde1a8000cdbd183789e', 'minion-upms-biz', '分页获取角色', '', '/role', 'GET', 'sys_role_list', '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
INSERT INTO `sys_perm` VALUES ('feaf9db753fba360d1c5d046dd9a5570', 'minion-upms-biz', '获取当前用户信息', '', '/user/getUserInfo', 'GET', '', '2020-05-01 11:53:24', 1240867920893558785, '2020-05-01 11:53:24', 1240867920893558785);
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'id',
  `name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名',
  `role_key` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色标识',
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '说明',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `create_uid` bigint(20) unsigned NOT NULL COMMENT '创建uid',
  `update_uid` bigint(20) unsigned DEFAULT NULL COMMENT '更新uid',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (1241302989927874561, '管理员', 'role_admin', '管理员（不要删除哦）', '2020-03-21 14:01:31', '2020-03-21 22:01:32', 1240192515995959297, 1240867920893558785);
COMMIT;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'id',
  `rid` bigint(20) unsigned NOT NULL COMMENT '用户id',
  `mid` bigint(20) unsigned NOT NULL COMMENT '菜单id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `create_uid` bigint(20) unsigned NOT NULL COMMENT '创建uid',
  `update_uid` bigint(20) unsigned DEFAULT NULL COMMENT '更新uid',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_menu` VALUES (1257242437789696001, 1241302989927874561, 1, '2020-05-04 17:35:30', '2020-05-04 17:35:30', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_role_menu` VALUES (1257242437806473217, 1241302989927874561, 2, '2020-05-04 17:35:30', '2020-05-04 17:35:30', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_role_menu` VALUES (1257242437814861825, 1241302989927874561, 1241232210418728961, '2020-05-04 17:35:30', '2020-05-04 17:35:30', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_role_menu` VALUES (1257242437814861826, 1241302989927874561, 1241225809789317121, '2020-05-04 17:35:30', '2020-05-04 17:35:30', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_role_menu` VALUES (1257242437823250433, 1241302989927874561, 1241226296613793793, '2020-05-04 17:35:30', '2020-05-04 17:35:30', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_role_menu` VALUES (1257242437831639042, 1241302989927874561, 1241254140979044354, '2020-05-04 17:35:30', '2020-05-04 17:35:30', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_role_menu` VALUES (1257242437835833346, 1241302989927874561, 3, '2020-05-04 17:35:30', '2020-05-04 17:35:30', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_role_menu` VALUES (1257242437844221954, 1241302989927874561, 1241235174617280513, '2020-05-04 17:35:30', '2020-05-04 17:35:30', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_role_menu` VALUES (1257242437848416257, 1241302989927874561, 1241235316242149377, '2020-05-04 17:35:30', '2020-05-04 17:35:30', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_role_menu` VALUES (1257242437852610562, 1241302989927874561, 1241253796337278977, '2020-05-04 17:35:30', '2020-05-04 17:35:30', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_role_menu` VALUES (1257242437856804866, 1241302989927874561, 1241253984636362754, '2020-05-04 17:35:30', '2020-05-04 17:35:30', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_role_menu` VALUES (1257242437860999169, 1241302989927874561, 1241302394064076801, '2020-05-04 17:35:30', '2020-05-04 17:35:30', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_role_menu` VALUES (1257242437860999170, 1241302989927874561, 4, '2020-05-04 17:35:30', '2020-05-04 17:35:30', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_role_menu` VALUES (1257242437865193473, 1241302989927874561, 1241254376820563969, '2020-05-04 17:35:30', '2020-05-04 17:35:30', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_role_menu` VALUES (1257242437865193474, 1241302989927874561, 1241254551626571777, '2020-05-04 17:35:30', '2020-05-04 17:35:30', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_role_menu` VALUES (1257242437873582082, 1241302989927874561, 1241254697986809857, '2020-05-04 17:35:30', '2020-05-04 17:35:30', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_role_menu` VALUES (1257242437877776385, 1241302989927874561, 1241254812759744514, '2020-05-04 17:35:30', '2020-05-04 17:35:30', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_role_menu` VALUES (1257242437877776386, 1241302989927874561, 1241078089300623361, '2020-05-04 17:35:30', '2020-05-04 17:35:30', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_role_menu` VALUES (1257242437881970690, 1241302989927874561, 1241254948235763714, '2020-05-04 17:35:30', '2020-05-04 17:35:30', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_role_menu` VALUES (1257242437890359297, 1241302989927874561, 1242841522316062721, '2020-05-04 17:35:30', '2020-05-04 17:35:30', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_role_menu` VALUES (1257242437894553601, 1241302989927874561, 1242843983776919553, '2020-05-04 17:35:30', '2020-05-04 17:35:30', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_role_menu` VALUES (1257242437894553602, 1241302989927874561, 1256067316093898754, '2020-05-04 17:35:30', '2020-05-04 17:35:30', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_role_menu` VALUES (1257242437902942209, 1241302989927874561, 1256069077932265473, '2020-05-04 17:35:30', '2020-05-04 17:35:30', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_role_menu` VALUES (1257242437907136513, 1241302989927874561, 1256215452187750402, '2020-05-04 17:35:30', '2020-05-04 17:35:30', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_role_menu` VALUES (1257242437911330818, 1241302989927874561, 1256216100060917761, '2020-05-04 17:35:30', '2020-05-04 17:35:30', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_role_menu` VALUES (1257242437915525122, 1241302989927874561, 1257242379090411521, '2020-05-04 17:35:30', '2020-05-04 17:35:30', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_role_menu` VALUES (1257242437919719425, 1241302989927874561, 1241310951631261698, '2020-05-04 17:35:30', '2020-05-04 17:35:30', 1240867920893558785, 1240867920893558785);
INSERT INTO `sys_role_menu` VALUES (1257242437923913730, 1241302989927874561, 1241311239121440770, '2020-05-04 17:35:30', '2020-05-04 17:35:30', 1240867920893558785, 1240867920893558785);
COMMIT;

-- ----------------------------
-- Table structure for sys_role_perm
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_perm`;
CREATE TABLE `sys_role_perm` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'id',
  `rid` bigint(20) unsigned NOT NULL COMMENT '角色id',
  `pid` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '权限id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `create_uid` bigint(20) unsigned NOT NULL COMMENT '创建uid',
  `update_uid` bigint(20) unsigned DEFAULT NULL COMMENT '更新uid',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'id',
  `username` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `phone` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '手机号码',
  `email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '邮箱',
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `dept_id` bigint(20) unsigned DEFAULT NULL COMMENT '部门id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `create_uid` bigint(20) unsigned NOT NULL COMMENT '创建uid',
  `update_uid` bigint(20) unsigned DEFAULT NULL COMMENT '更新uid',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '1为已删除，0为未删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_user_username_uindex` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (1240192515995959297, 'DHB', '1380013800', 'xx158@qq.com', '{bcrypt}$2a$10$wsugThnpTpm2090fhj9.5OvhWpH.8eM0eZM85HFN/PzaeaYIq6oeO', NULL, '2020-03-21 14:05:52', '2020-03-21 22:05:52', 0, 1240867920893558785, 0);
INSERT INTO `sys_user` VALUES (1240867920893558785, 'admin', '13800138000', '13025667098a@gmail.com', '{bcrypt}$2a$10$wOR9pMjwEE8dhoCquVFqXe7nBy.Dm2gDYHnG5.GV/AB.taF744J0.', NULL, '2020-03-21 09:58:01', '2020-03-21 17:58:01', 1240192515995959297, 1240192515995959297, 0);
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'id',
  `uid` bigint(20) unsigned NOT NULL COMMENT '用户id',
  `rid` bigint(20) unsigned NOT NULL COMMENT '角色id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `create_uid` bigint(20) unsigned NOT NULL COMMENT '创建uid',
  `update_uid` bigint(20) unsigned DEFAULT NULL COMMENT '更新uid',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` VALUES (1241303038627938306, 1240867920893558785, 1241302989927874561, '2020-03-21 17:58:01', '2020-03-21 17:58:01', 1240192515995959297, 1240192515995959297);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;