
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
                          `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
                          `role` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                          PRIMARY KEY (`id`) USING BTREE,
                          UNIQUE INDEX `role`(`role`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES (1, 'admin');
INSERT INTO `roles` VALUES (2, 'client');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
                         `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
                         `username` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                         `password` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                         `email` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                         `name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
                         `surname` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
                         `role_id` int UNSIGNED NOT NULL DEFAULT 2,
                         `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         PRIMARY KEY (`id`) USING BTREE,
                         INDEX `role_id`(`role_id`) USING BTREE,
                         UNIQUE INDEX `username`(`username`) USING BTREE,
                         CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Cimba', 'admin', 'admin@gmail.com', 'Oleksandra', 'Mala', 1, '2022-08-06 16:06:49');
INSERT INTO `user` VALUES (2, 'gol', '1234', 'gol@ukr.net', NULL, NULL, 2, '2022-08-06 16:13:54');

SET FOREIGN_KEY_CHECKS = 1;
