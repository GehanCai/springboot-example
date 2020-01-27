-- ----------------------------
-- table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
  `id`       bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `username` varchar(64)         NOT NULL COMMENT '用户账号',
  `password` varchar(512)        NOT NULL COMMENT '登录密码',
  `salt`     varchar(16)         NOT NULL COMMENT '密码验证',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='系统-用户';

-- ----------------------------
-- table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`
(
  `id`   bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `name` varchar(64)         NOT NULL COMMENT '角色名称',
  `code` varchar(64)         NOT NULL COMMENT '角色代码',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='系统-角色';

-- ----------------------------
-- table structure for sys_perm
-- ----------------------------
DROP TABLE IF EXISTS `sys_perm`;
CREATE TABLE `sys_perm`
(
  `id`   bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `name` varchar(64)         NOT NULL COMMENT '权限名称',
  `code` varchar(512)        NOT NULL COMMENT '权限代码',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='系统-权限';

-- ----------------------------
-- table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`
(
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户编号',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`user_id`, `role_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='系统-用户-角色';

-- ----------------------------
-- table structure for sys_role_perm
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_perm`;
CREATE TABLE `sys_role_perm`
(
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色编号',
  `perm_id` bigint(20) unsigned NOT NULL COMMENT '用户编号',
  PRIMARY KEY (`role_id`, `perm_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='系统-角色-权限';
