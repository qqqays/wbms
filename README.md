# wbms
web site back_end management system

_core: SpringMVC + Shiro + Mybatis-plus_

other: ehcache, freemarker, maven, adminLTE2, druid, logback, tomcat.

-  **项目构成** 

1. 系统后台使用 Spring + SpringMVC
2. 权限控制使用shiro
3. 缓存使用ehcache
4. 前端模板使用 freemarker + adminLTE2
5. 日志logback
6. 数据库连接池 druid
7. 持久层 mybatis-plus
8. 容器 tomcat

- **用途**

1. 快速部署用于中小型企业信息展示、新闻发布的小型网站，响应式布局，能方便快捷的拓展和开发新的功能。
2. 前后端可分离生成动态页面，也可一体通过freemarker生成静态页面。
3. 简单的修改freemarker，快速的修改页面结构。
4. restful风格url和api
5. 用户，角色，权限粒度细，简单配置shiro就能灵活的控制网站后台操作权限。

- **快速开始**

1. 导入resource/db/backend1.sql
2. 添加properties配置，如图。

![输入图片说明](https://gitee.com/uploads/images/2018/0307/165954_59e8ff3a_1274933.png "[%DRL$`)MGP@U4BCWEE@O3X.png")

jdbc是数据库配置，extend是数据库备份目录配置。
extend.properties 配置如图。

![输入图片说明](https://gitee.com/uploads/images/2018/0307/170401_107d92dc_1274933.png "ccccc.png")

3. maven import

- **实例**
![输入图片说明](https://gitee.com/uploads/images/2018/0307/170603_efccbd9c_1274933.png "屏幕截图.png")