# restful api

`minion-core-restful`模块对spring mvc进一步封装：

- 统一响应风格
- 统一异常处理
- 嵌套数据校验

## 引入依赖

```xml
<dependency>
    <groupId>cn.dhbin</groupId>
    <artifactId>minion-core-mybatis</artifactId>
    <version>${minion.version}</version>
</dependency>
```

### Controller

统一响应结果ApiResponse，Controller继承RestfulController，提供下面几种方式

```
cn.dhbin.minion.core.restful.controller.RestfulController

success(T)        成功-无特殊含义
success()         成功-无特殊含义
ok(T)             获取数据成功[GET]
ok()              获取数据成功[GET]
created(T)        创建或修改数据成功[POST|PUT|PATCH]
created()         创建或修改数据成功[POST|PUT|PATCH]
noContent(T)      删除成功[DELETE]
noContent()       删除成功[DELETE]
```
