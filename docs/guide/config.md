# 配置

## 环境配置

host添加对应组件IP

```
127.0.0.1   minion-register
127.0.0.1   minion-mysql
127.0.0.1   minion-redis
```

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

> minion-auth-dev.yml

```yaml
# 数据源
spring:
  datasource:
    type: com.zaxxer.hikari.HikariDataSource
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: 数据库用户
    password: 数据库密码
    url: jdbc:mysql://minion-mysql:3306/minion_auth?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai
dubbo:
  registry:
    address: nacos://minion-register:8848
  cloud:
    subscribed-services: minion-umps
```

> minion-gateway-dev.yml

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: minion-auth
          uri: lb://minion-auth
          predicates:
            - Path=/auth/**
          filters:
            - StripPrefix=1
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
swagger:
  enabled: true
  title: upms
  description: '后台管理系统'
  base-package: cn.dhbin.minion.upms
security:
  oauth2:
    client:
      client-id: upms
      client-secret: upms
    resource:
      token-info-uri: http://minion-auth/oauth/check_token
dubbo:
  scan:
    base-packages: cn.dhbin.minion.upms.service.impl
  protocol:
    name: dubbo
    port: -1
  registry:
    address: nacos://minion-register:8848
```
