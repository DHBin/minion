# 配置

## 数据库

执行db目录下的sql

```
minion_auth.sql
minion_upms.sql
```

## 环境配置

host添加对应组件IP

```
127.0.0.1 minion-register
127.0.0.1 minion-mysql
127.0.0.1 minion-redis
127.0.0.1 minion-zookeeper
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
dubbo:
  scan:
    base-packages: cn.dhbin.minion.auth.service.impl;
  protocol:
    name: dubbo
    port: 20880
  consumer:
    check: false
  registry:
    address: zookeeper://minion-zookeeper:2181
  cloud:
    subscribed-services: minion-upms-biz
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
dubbo:
  scan:
    base-packages: cn.dhbin.minion.upms.service.impl
  protocol:
    name: dubbo
    port: 20881
  registry:
    address: zookeeper://minion-zookeeper:2181
  cloud:
    subscribed-services: minion-auth-biz
```

## 模拟前端菜单

权限系统还没完善，目前菜单存在redis中模拟，在redis中添加以下字段

> upms::menu

```json
[[{"path":"/cache","component":"views/util/cache","children":[],"meta":{"keepAlive":true,"i18n":"cache"},"icon":"icon-caidan","label":"缓冲"},{"path":"/tags","component":"views/util/tags","children":[],"meta":{"i18n":"tags"},"icon":"icon-caidan","label":"标签"},{"path":"/store","component":"views/util/store","children":[],"meta":{"i18n":"store"},"icon":"icon-caidan","label":"存储"},{"path":"https://avuejs.com/doc/api?test1=1&test2=2","meta":{"i18n":"api"},"icon":"icon-caidan","label":"全局函数"},{"path":"/logs","component":"views/util/logs","children":[],"meta":{"i18n":"logs"},"icon":"icon-caidan","label":"日志监控"},{"path":"/table","component":"views/util/table","children":[],"meta":{"i18n":"table"},"icon":"icon-caidan","label":"表格"},{"path":"/form","component":"views/util/form","children":[],"meta":{"i18n":"form"},"icon":"icon-caidan","label":"表单"},{"path":"/permission","component":"views/util/permission","children":[],"meta":{"i18n":"permission"},"icon":"icon-caidan","label":"权限"},{"path":"/top","component":"views/util/top","children":[],"meta":{"i18n":"top"},"icon":"icon-caidan","label":"返回顶部"},{"path":"/crud-form","component":"views/util/crud-form","children":[],"meta":{"i18n":"crudForm"},"icon":"icon-caidan","label":"表格表单"},{"path":"/affix","component":"views/util/affix","children":[],"meta":{"i18n":"affix"},"icon":"icon-caidan","label":"图钉"},{"path":"/error","children":[{"path":"error","component":"components/error-page/403","children":[],"icon":"icon-caidan","label":"403"},{"path":"404","component":"components/error-page/404","children":[],"icon":"icon-caidan","label":"404"},{"path":"500","component":"components/error-page/500","children":[],"icon":"icon-caidan","label":"500"}],"meta":{"i18n":"error"},"icon":"icon-caidan","label":"异常页"}],[],[{"path":"/test","component":"views/test","children":[],"meta":{"i18n":"test"},"icon":"icon-caidan","label":"测试页面"}]]
```

> upms::topMenu

```json
[{"path":"/wel/index","meta":{"i18n":"dashboard"},"icon":"el-icon-document","label":"首页","parentId":0},{"path":"https://avuejs.com","meta":{"menu":false,"i18n":"website"},"icon":"el-icon-document","label":"官网","parentId":1},{"path":"/test/index","meta":{"i18n":"test"},"icon":"el-icon-document","label":"测试","parentId":2},{"path":"/wel/dashboard","meta":{"menu":false,"i18n":"more"},"icon":"el-icon-document","label":"更多","parentId":3}]
```
