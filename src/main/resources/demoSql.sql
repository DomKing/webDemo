CREATE TABLE `t_dredge_type` (
	`f_id` BIGINT(20) NOT NULL,
	`f_code` VARCHAR(45) NULL DEFAULT NULL COMMENT '编码',
	`t_community_supply_type_f_id` BIGINT(20) NOT NULL COMMENT '疏通服务类别所属商家类型',
	`f_name` VARCHAR(45) NULL DEFAULT NULL COMMENT '类型名称',
	`f_pic_url` VARCHAR(45) NULL DEFAULT NULL COMMENT '图标',
	`f_desc` VARCHAR(45) NULL DEFAULT NULL COMMENT '描述',
	`f_price_desc` VARCHAR(45) NULL DEFAULT '人工费+时段费+部分耗材费' COMMENT '价格说明',
	`f_sys_add_time` DATETIME NULL DEFAULT NULL COMMENT '新增时间',
	`f_sys_upd_time` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
	`f_sys_add_user` BIGINT(20) NULL DEFAULT NULL COMMENT '新增者',
	`f_sys_upd_user` BIGINT(20) NULL DEFAULT NULL COMMENT '修改者',
	`f_sys_del_state` TINYINT(1) NULL DEFAULT NULL COMMENT '记录状态=={"0":"正常","1":"已删除"}',
	PRIMARY KEY (`f_id`)
)
COMMENT='疏通类型'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

INSERT INTO `t_dredge_type` VALUES (1, NULL, 113, '冰箱清洗', 'n_bingxiangqingxi.png', '128元-208元', '人工费+时段费+部分耗材费', NULL, '2016-01-15 16:34:08', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (2, NULL, 113, '洗衣机清洗', 'n_xiyijiqingxi.png', '88元-128元', '人工费+时段费+部分耗材费', NULL, '2016-01-15 16:34:08', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (3, NULL, 113, '空调清洗', 'kongtiaoqingxi.png', '88元-268元', '人工费+时段费+部分耗材费', NULL, '2016-01-15 16:34:08', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (4, NULL, 113, '油烟机清洗', 'youyanjiqingxi.png', '118元', '人工费+时段费+部分耗材费', NULL, '2016-10-17 14:54:21', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5, NULL, 111, '电脑维修', 'diannaoweixiu.png', '30-280元', '人工费+时段费+部分耗材费', NULL, '2016-01-15 16:34:08', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (6, NULL, 111, '电视维修', 'dianshiweixiu.png', '100-300元', '人工费+时段费+部分耗材费', NULL, '2016-01-15 16:34:08', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (7, NULL, 111, '冰箱维修', 'bingxiangweixiu.png', '50-300元', '人工费+时段费+部分耗材费', NULL, '2016-01-15 16:34:08', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (8, NULL, 111, '小家电维修', 'xiaojiadianweixiu.png', '20-100元', '人工费+时段费+部分耗材费', NULL, '2016-01-15 16:34:08', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (10, NULL, 114, '下水道疏通', 'xiashuidaoshutong.png', '100-180元', '人工费+时段费+部分耗材费', NULL, '2016-01-15 16:34:08', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (11, NULL, 112, '马桶安装', 'matonganzhuang.png', '80-150元', '人工费+时段费+部分耗材费', NULL, '2016-01-15 16:34:08', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (12, NULL, 111, '空调维修', 'kongtiaoweixiu.png', '50-300元', '人工费+时段费+部分耗材费', NULL, '2016-01-15 16:34:08', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (14, NULL, 111, '管件维修', 'guanjianweixiu_2.png', '35-80元', '人工费+时段费+部分耗材费', '2015-12-11 17:24:35', '2016-01-15 16:34:08', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (16, NULL, 114, '上门开锁', 'shangmenkaisuo_1.png', '50-150元', '人工费+时段费+部分耗材费', '2015-12-10 18:41:06', '2016-01-15 16:34:08', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (17, NULL, 114, '更换锁芯', 'suoxingenghuan_1.png', '50-150元', '人工费+时段费+部分耗材费', '2015-12-10 18:41:06', '2016-01-15 16:34:08', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (18, NULL, 111, '热水器维修', 'reshuiqiweixiu_1.png', '50-150元', '人工费+时段费+部分耗材费', '2015-12-10 18:41:06', '2016-01-15 16:34:08', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (19, NULL, 112, '灯具安装', 'anzhuang_dengju.png', '50-100元', '人工费+时段费+部分耗材费', NULL, '2016-01-15 16:34:08', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (20, NULL, 112, '家具安装', 'anzhuang_jiaju.png', '价格面议', '人工费+时段费+部分耗材费', NULL, '2016-01-15 16:34:08', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (21, NULL, 112, '卫浴安装', 'anzhuang_weiyu.png', '30-150元', '人工费+时段费+部分耗材费', NULL, '2016-01-15 16:34:08', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (22, NULL, 112, '综合安装', 'anzhuang_zonghe.png', '价格面议', '人工费+时段费+部分耗材费', NULL, '2016-01-15 16:34:08', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (23, NULL, 111, '洗衣机维修', 'n_xiyijiweixiu.png', '价格面议（参考定价：80元-300元）', '人工费+时段费+部分耗材费', NULL, '2016-01-15 16:34:08', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (24, NULL, 115, '钟点工', 'zhongdiangong_20160815.png', '35 元/小时', '人工费+时段费+部分耗材费', NULL, '2016-08-15 17:34:52', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (25, '', 112, '场地维护', 'changdiweihu2.png', '100-300元', '人工费+时段费+部分耗材费', '2016-06-20 17:26:38', '2016-06-20 17:23:36', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (26, NULL, 115, '育婴师', 'yuyingshi_20160815.png', '价格面议', '人工费+时段费+部分耗材费', NULL, '2016-08-15 17:34:52', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (27, NULL, 115, '月嫂服务', 'yuesao_20160815.png', '价格面议', '人工费+时段费+部分耗材费', NULL, '2016-08-15 17:34:52', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (40, NULL, 116, '消杀除虫', 'xiaoshachuchong_20160815.png', '价格面议', '人工费+时段费+部分耗材费', NULL, '2016-08-15 17:34:52', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (41, NULL, 116, '家庭除醛', 'jiatingchuquan_20160815.png', '价格面议', '人工费+时段费+部分耗材费', NULL, '2016-08-15 17:34:52', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5001, NULL, 117, '旧房翻新', '2fanxin.png', '价格面议', '人工费+时段费+部分耗材费', '2016-09-09 16:59:45', '2016-09-09 16:59:45', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5002, NULL, 117, '厨房翻新', '3fanxin.png', '价格面议', '人工费+时段费+部分耗材费', '2016-09-09 16:59:45', '2016-09-09 16:59:45', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5003, NULL, 117, '卫生间翻新', '4fanxin.png', '价格面议', '人工费+时段费+部分耗材费', '2016-09-09 16:59:45', '2016-09-09 16:59:45', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5004, NULL, 117, '墙面刷新', '5fanxin.png', '价格面议', '人工费+时段费+部分耗材费', '2016-09-09 16:59:45', '2016-09-09 16:59:45', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5005, NULL, 117, '地面改造', '6fanxin.png', '价格面议', '人工费+时段费+部分耗材费', '2016-09-09 16:59:45', '2016-09-09 16:59:45', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5006, NULL, 117, '橱柜换新', '7fanxin.png', '价格面议', '人工费+时段费+部分耗材费', '2016-09-09 16:59:45', '2016-09-09 16:59:45', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5007, NULL, 117, '水电防水改造', '8fanxin.png', '价格面议', '人工费+时段费+部分耗材费', '2016-09-09 16:59:45', '2016-09-09 16:59:45', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5008, NULL, 117, '局部翻新改造', '9fanxin.png', '价格面议', '人工费+时段费+部分耗材费', '2016-09-09 16:59:45', '2016-09-09 16:59:45', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5009, NULL, 115, '钟点工包时', '10zhongdian.png', '价格面议', '人工费+时段费+部分耗材费', '2016-09-09 16:59:45', '2016-09-09 16:59:45', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5010, NULL, 115, '钟点工包月', '10zhongdian.png', '价格面议', '人工费+时段费+部分耗材费', '2016-09-09 16:59:45', '2016-09-09 16:59:45', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5012, NULL, 113, '家电保养套餐', 'tc_jiadianbaoyang.png', '价格面议', '人工费+时段费+部分耗材费', '2016-11-10 17:31:39', '2016-11-10 17:31:39', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5013, NULL, 116, '深度保洁', 'tc_shenduqingjie.png', '价格面议', '人工费+时段费+部分耗材费', '2016-11-10 17:47:50', '2016-11-10 17:47:50', NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5015, NULL, 119, '房屋维修', '20170322133915888.png', NULL, NULL, '2017-03-13 10:52:12', NULL, NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5016, NULL, 119, '门窗维修', '20170322133915889.png', NULL, NULL, '2017-03-13 10:52:12', NULL, NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5017, NULL, 119, '管件维修', '20170322133915890.png', NULL, NULL, '2017-03-13 10:52:12', NULL, NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5018, NULL, 119, '公共照明', '20170322133915891.png', NULL, NULL, '2017-03-13 10:52:12', NULL, NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5019, NULL, 119, '下水道疏通', '20170322133915892.png', NULL, NULL, '2017-03-13 10:52:12', NULL, NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5020, NULL, 119, '公共楼道', '20170322133915893.png', NULL, NULL, '2017-03-13 10:52:12', NULL, NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5021, NULL, 119, '车禁维修', '20170322133915894.png', NULL, NULL, '2017-03-13 10:52:12', NULL, NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5022, NULL, 119, '门禁维修', '20170322133915895.png', NULL, NULL, '2017-03-13 10:52:12', NULL, NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5023, NULL, 119, '电路维修', '20170322133915896.png', NULL, NULL, '2017-03-13 10:52:12', NULL, NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5024, NULL, 119, '水管维修', '20170322133915897.png', NULL, NULL, '2017-03-13 10:52:12', NULL, NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5025, NULL, 119, '电梯维修', '20170322133915898.png', NULL, NULL, '2017-03-13 10:52:12', NULL, NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5026, NULL, 119, '小区环境保洁', '20170322133915899.png', NULL, NULL, '2017-03-13 10:52:12', NULL, NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5027, NULL, 119, '小区安保', '20170322133915900.png', NULL, NULL, '2017-03-13 10:52:12', NULL, NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5028, NULL, 119, '天燃气维修', '20170322133915901.png', NULL, NULL, '2017-03-13 10:52:12', NULL, NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5029, NULL, 119, '居民付费服务', '20170322133915902.png', NULL, NULL, '2017-03-13 10:52:12', NULL, NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5030, NULL, 119, '投诉意见', '20170322133915907.png', NULL, NULL, '2017-03-13 10:52:12', NULL, NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5031, NULL, 119, '小区泳池', '20170322133915903.png', NULL, NULL, '2017-03-13 10:52:12', NULL, NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5032, NULL, 119, 'IT维修', '20170322133915904.png', NULL, NULL, '2017-03-13 10:52:12', NULL, NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5033, NULL, 119, '其他', '20170322133915905.png', NULL, NULL, '2017-03-13 10:52:12', NULL, NULL, NULL, 0);
INSERT INTO `t_dredge_type` VALUES (5034, NULL, 119, '公共设施', '20170322133915906.png', NULL, NULL, '2017-03-13 10:52:12', NULL, NULL, NULL, 0);
