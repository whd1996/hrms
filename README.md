# hrms

**java _人力资源管理系统_**<br>
**数据库采用 sqlserver2019或mysql8.0**<br>
• 环境及技术说明：页面全部为html页面,交互由ajax与Bootstrap-table完成<br><br>
目前项目已修改为mysql数据库，如果想要使用sqlserver数据库<br>
只需要将com.xpu.hrms.data.source.config.DataBaseConfigure文件中注解<br>@ConfigurationProperties(prefix = "**mysql**
.datasource.hrms")
中的**mysql**改为**sqlserver** <br>
**将pom文件中mysql驱动依赖注释掉并反向注释sqlserver驱动依赖**<br>
同时时将**application.properties**属性文件中的**有关mysql配置注释掉，有关sqlserver配置反向注释**即可<br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **_名称 &emsp;&emsp;&emsp; &emsp;&emsp;&emsp;&emsp;工具及版本<br>_**
***

* Java &emsp; &emsp; &emsp; &emsp; &emsp;&emsp;&emsp;Jdk1.8<br>

* **

* 开发工具 &emsp;&emsp;&emsp;&emsp;&emsp;&emsp; Eclipse IDE Version: 2022-03<br>

* **

* 数据库 &emsp; &emsp; &emsp; &emsp; &emsp; &emsp;mysql8.0或Sql server2019<br>

* **

* 数据库连接池&emsp; &emsp; &emsp; &emsp;Druid1.1.0<br>

* **

* 服务器 &emsp; &emsp; &emsp; &emsp; &emsp;&emsp; Tomcat 9.0<br>

* **

* 后端框架 &emsp; &emsp; &emsp; &emsp; &emsp; Springboot2.0.4+mybatis1.3.2<br>

* **

* 前端框架 &emsp; &emsp; &emsp; &emsp; &emsp; Bootstrap+jQuery<br>

* **

* 构建工具 &emsp; &emsp; &emsp; &emsp; &emsp; Maven3.61<br>

* **

* 文件字符编码 &emsp;&emsp; &emsp;&emsp;Utf8

* **
