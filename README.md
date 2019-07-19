# ssm-druid
##  使用ssm框架进行配置druid连接池
##  配置了swagger进行网页接口查看
##  druid查看地址 http://localhost:82/druid/sql.html
##  swagger 接口查看地址 http://localhost:82/swagger-ui.html#

#druid配置步骤
##1 导入依赖包 
##2 在apllication.properties文件中配置druid连接池 信息
###spring.datasource.url=jdbc:mysql://47.103.31.213:3306/shop?###serverTimezone=GMT%2B8&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8
###spring.datasource.username=root
###spring.datasource.password=Mysql123456!
###spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
###spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver

##连接池的配置信息
###spring.datasource.initialSize=5
###spring.datasource.minIdle=5
###spring.datasource.maxActive=20
###spring.datasource.maxWait=60000
###spring.datasource.timeBetweenEvictionRunsMillis=60000
###spring.datasource.minEvictableIdleTimeMillis=300000
###spring.datasource.validationQuery=SELECT 1 FROM DUAL
###spring.datasource.testWhileIdle=true
###spring.datasource.testOnBorrow=false
###spring.datasource.testOnReturn=false
###spring.datasource.poolPreparedStatements=true
###spring.datasource.maxPoolPreparedStatementPerConnectionSize=20
### 配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
###spring.datasource.filters=stat,wall
##通过connectProperties属性来打开mergeSql功能；慢SQL记录
###spring.datasource.connectionProperties=druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000
