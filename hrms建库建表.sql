/*
 Navicat Premium Data Transfer

 Source Server         : 我的sqlServer
 Source Server Type    : SQL Server
 Source Server Version : 15002095
 Source Host           : PCWHD:1433
 Source Catalog        : xpu_hrms
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 15002095
 File Encoding         : 65001

 Date: 02/07/2022 19:11:47
*/

CREATE DATABASE xpu_hrms;
USE xpu_hrms;
-- ----------------------------
-- Table structure for db_department
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[db_department]') AND type IN ('U'))
	DROP TABLE [dbo].[db_department]
GO

CREATE TABLE [dbo].[db_department] (
  [id] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [department_name] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [position] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [duty] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL
)
GO

ALTER TABLE [dbo].[db_department] SET (LOCK_ESCALATION = TABLE)
GO

EXEC sp_addextendedproperty
'MS_Description', N'部门名',
'SCHEMA', N'dbo',
'TABLE', N'db_department',
'COLUMN', N'department_name'
GO

EXEC sp_addextendedproperty
'MS_Description', N'职位类型 职位名',
'SCHEMA', N'dbo',
'TABLE', N'db_department',
'COLUMN', N'position'
GO

EXEC sp_addextendedproperty
'MS_Description', N'职责',
'SCHEMA', N'dbo',
'TABLE', N'db_department',
'COLUMN', N'duty'
GO


-- ----------------------------
-- Table structure for db_file
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[db_file]') AND type IN ('U'))
	DROP TABLE [dbo].[db_file]
GO

CREATE TABLE [dbo].[db_file] (
  [id] char(32) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [file_name] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [file_content] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [post_time] datetime  NOT NULL,
  [post_staff] char(32) COLLATE Chinese_PRC_CI_AS  NOT NULL
)
GO

ALTER TABLE [dbo].[db_file] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for db_interviewee
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[db_interviewee]') AND type IN ('U'))
	DROP TABLE [dbo].[db_interviewee]
GO

CREATE TABLE [dbo].[db_interviewee] (
  [id] char(32) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [name] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [sex] varchar(20) COLLATE Chinese_PRC_CI_AS  NULL,
  [age] int  NULL,
  [desired_position] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [desired_department] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [work_experience] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [work_grade] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[db_interviewee] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for db_position
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[db_position]') AND type IN ('U'))
	DROP TABLE [dbo].[db_position]
GO

CREATE TABLE [dbo].[db_position] (
  [id] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [position_level] char(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [position_salary] real DEFAULT 0 NULL,
  [position] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL
)
GO

ALTER TABLE [dbo].[db_position] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for db_staff
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[db_staff]') AND type IN ('U'))
	DROP TABLE [dbo].[db_staff]
GO

CREATE TABLE [dbo].[db_staff] (
  [id] char(32) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [name] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [sex] varchar(20) COLLATE Chinese_PRC_CI_AS  NULL,
  [age] int  NULL,
  [place] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [birth] datetime  NULL,
  [tel] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [staff_department] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [staff_position] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [entry_time] datetime  NULL,
  [leave_time] datetime  NULL,
  [isdelete] varchar(10) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[db_staff] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for db_user
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[db_user]') AND type IN ('U'))
	DROP TABLE [dbo].[db_user]
GO

CREATE TABLE [dbo].[db_user] (
  [id] char(32) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [staff_name] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [user_account] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [user_password] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [creat_time] datetime  NOT NULL,
  [role_id] int  NOT NULL
)
GO

ALTER TABLE [dbo].[db_user] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Primary Key structure for table db_department
-- ----------------------------
ALTER TABLE [dbo].[db_department] ADD CONSTRAINT [PK__db_depar__3213E83F09B759E2] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table db_file
-- ----------------------------
ALTER TABLE [dbo].[db_file] ADD CONSTRAINT [PK__db_file__3213E83F09615A31] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table db_interviewee
-- ----------------------------
ALTER TABLE [dbo].[db_interviewee] ADD CONSTRAINT [PK__db_inter__3213E83F7DB31B7E] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table db_position
-- ----------------------------
ALTER TABLE [dbo].[db_position] ADD CONSTRAINT [PK__db_posit__3213E83FCA3D5B20] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table db_staff
-- ----------------------------
ALTER TABLE [dbo].[db_staff] ADD CONSTRAINT [PK__db_staff__3213E83F739A3F95] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table db_user
-- ----------------------------
ALTER TABLE [dbo].[db_user] ADD CONSTRAINT [PK__db_user__3213E83F1A21E87A] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Foreign Keys structure for table db_file
-- ----------------------------
ALTER TABLE [dbo].[db_file] ADD CONSTRAINT [FK__db_file__post_st__00DF2177] FOREIGN KEY ([post_staff]) REFERENCES [dbo].[db_user] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO


-- ----------------------------
-- Foreign Keys structure for table db_interviewee
-- ----------------------------
ALTER TABLE [dbo].[db_interviewee] ADD CONSTRAINT [FK__db_interview__id__03BB8E22] FOREIGN KEY ([id]) REFERENCES [dbo].[db_user] ([id]) ON DELETE CASCADE ON UPDATE CASCADE
GO


-- ----------------------------
-- Foreign Keys structure for table db_position
-- ----------------------------
ALTER TABLE [dbo].[db_position] ADD CONSTRAINT [FK__db_positi__posit__05A3D694] FOREIGN KEY ([position]) REFERENCES [dbo].[db_department] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO


-- ----------------------------
-- Foreign Keys structure for table db_staff
-- ----------------------------
ALTER TABLE [dbo].[db_staff] ADD CONSTRAINT [FK__db_staff__id__04AFB25B] FOREIGN KEY ([id]) REFERENCES [dbo].[db_interviewee] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [dbo].[db_staff] ADD CONSTRAINT [FK__db_staff__staff___7849DB76] FOREIGN KEY ([staff_position]) REFERENCES [dbo].[db_position] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [dbo].[db_staff] ADD CONSTRAINT [FK__db_staff__staff___7C1A6C5A] FOREIGN KEY ([staff_department]) REFERENCES [dbo].[db_department] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [dbo].[db_staff] ADD CONSTRAINT [FK__db_staff__id__7D0E9093] FOREIGN KEY ([id]) REFERENCES [dbo].[db_user] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

