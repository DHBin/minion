# 配置

## 组件

### Mysql

执行db目录下的sql

```
minion_auth.sql
minion_upms.sql
```

### Zookeeper

在Zookeeper官网下载[http://zookeeper.apache.org/releases.html](http://zookeeper.apache.org/releases.html)

Zookeeper作Dubbo的注册中心

使用默认端口

### Nacos

官网：[https://nacos.io/](https://nacos.io/)

使用默认端口


## 环境配置

host添加对应组件IP

```
127.0.0.1 minion-register
127.0.0.1 minion-mysql
127.0.0.1 minion-redis
127.0.0.1 minion-zookeeper
127.0.0.1 minion
```

开发环境推荐使用[SwitchHosts](https://github.com/oldj/SwitchHosts)

## 服务配置

运行nacos，新增下面配置信息

> minion-dev.yml

```yaml
management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: ALWAYS
spring:
  redis:
    host: minion-redis
    password: redis密码
```

> minion-auth-biz-dev.yml

```yaml
# 数据源
spring:
  datasource:
    type: com.zaxxer.hikari.HikariDataSource
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: 数据库用户名
    password: 数据库密码
    url: jdbc:mysql://minion-mysql:3306/minion_auth?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai
```

> minion-gateway-dev.yml

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: minion-auth
          uri: lb://minion-auth-biz
          predicates:
            - Path=/auth/**
          filters:
            - StripPrefix=1
            - ValidateCodeGateWayFilter
        - id: minion-upms-biz
          uri: lb://minion-upms-biz
          predicates:
            - Path=/upms/**
          filters:
            - StripPrefix=1
          metadata:
            swagger: "true"
            swagger_title: "后台管理系统"
```

> minion-upms-biz-dev.yml

```yaml
# 数据源
spring:
  datasource:
    type: com.zaxxer.hikari.HikariDataSource
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: 数据库用户名
    password: 数据库密码
    url: jdbc:mysql://minion-mysql:3306/minion_upms?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai
swagger:
  enabled: true
  title: upms
  description: '后台管理系统'
  base-package: cn.dhbin.minion.upms
security:
  oauth2:
    client:
      client-id: test
      client-secret: test
    resource:
      token-info-uri: http://minion-auth-biz/oauth/check_token
```
