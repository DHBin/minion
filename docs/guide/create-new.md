# 接入Minion

## 引入依赖

```shell script
git clone https://gitee.com/FYMD/minion.git
cd minion
mvn run install 
```

新建一个Spring Boot项目，在`pom.xml`中加入minion的依赖


```xml
    <dependencyManagement>
        <dependencies>
            <!--minion-->
            <dependency>
                <groupId>cn.dhbin</groupId>
                <artifactId>minion</artifactId>
                <version>${minion.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
```

## 注册中心

```xml
<!--注册中心客户端-->
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>
<!--配置中心客户端-->
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
</dependency>
```

`resources`中添加`bootstrap.yml`

```yaml
server:
  port: 端口号

spring:
  application:
    name: 服务名称
  cloud:
    nacos:
      discovery:
        namespace: nacos命名空间
        server-addr: ${NACOS-HOST:minion-register}:${NACOS-PORT:8848}
      config:
        namespace: ${spring.cloud.nacos.discovery.namespace}
        server-addr: ${spring.cloud.nacos.discovery.server-addr}
        file-extension: yml
        shared-configs:
          - minion-${spring.profiles.active}.${spring.cloud.nacos.config.file-extension}
  profiles:
    active: dev
```

## Web

Minion内置了一套restful实现，引入依赖即可

```xml
<!--Web模块-->
<dependency>
    <groupId>cn.dhbin</groupId>
    <artifactId>minion-core-restful</artifactId>
</dependency>
```

## Api文档

集成knife4j，访问路径http://127.0.0.1:9000/doc.html

```xml
<!--文档-->
<dependency>
    <groupId>cn.dhbin</groupId>
    <artifactId>minion-core-swagger</artifactId>
</dependency>
```

### 配置

```yaml
# 更多见cn.dhbin.minion.core.swagger.config.SwaggerProperties
swagger:
  enabled: true #是否显示
  title: swagger文档标题
  description: swagger文档描述
  base-package: 扫描包路径
```

## 日志

```xml
<!--日志模块-->
<dependency>
    <groupId>cn.dhbin</groupId>
    <artifactId>minion-core-log</artifactId>
</dependency>
```

## 监控

```xml
<!--监控模块-->
<dependency>
    <groupId>de.codecentric</groupId>
    <artifactId>spring-boot-admin-starter-client</artifactId>
</dependency>
```

## 接入网关

在`minion-gateway-dev.yml`中添加

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: minion-demo
          uri: lb://minion-demo
          predicates:
            - Path=/demo/**
          filters:
            - StripPrefix=1
          metadata:
            swagger: "true"
            swagger_title: "测试"
```

> 更多配置见Spring gateway的文档

## 鉴权

```xml
<!--鉴权模块-->
<dependency>
    <groupId>cn.dhbin</groupId>
    <artifactId>minion-core-security</artifactId>
</dependency>
```

### 配置

## bootstrap.yml

依赖dubbo向管理后台提供权限菜单，在管理后台点击`重载权限`即可

```yaml
dubbo:
  application:
    id: @artifactId@
    name: @artifactId@
  scan:
    base-packages: 扫描服务类包路径
  protocol:
    name: dubbo
    port: dubbo端口
  registry:
    address: zookeeper://minion-zookeeper:2181
  metadata-report:
    address: zookeeper://minion-zookeeper:2181
```

### Oauth2相关配置

```yaml
security:
  oauth2:
    client:
      client-id: test
      client-secret: test
    resource:
      token-info-uri: http://minion-auth-biz/oauth/check_token
```

启动类中添加`@EnableMinionResourceServer`
