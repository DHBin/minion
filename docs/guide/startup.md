# 启动

## 后端

```
MinionGatewayApplication        9000  网关
MinionAuthApplication       9001  鉴权
MinionUpmsApplication       9002  用户权限系统
MinionMonitorApplication        9003 监控
```

## 前端

前端基于avue-cli开发，代码：https://gitee.com/FYMD/avue-cli


### 克隆项目

```
git clone https://gitee.com/FYMD/avue-cli.git
```

### 切换minion分支

```
git checkout minion
```


### 进入项目

```
cd avue-cli
```

### 安装依赖

```
npm install --registry=https://registry.npm.taobao.org
```

### 启动服务

```
npm run serve
```

