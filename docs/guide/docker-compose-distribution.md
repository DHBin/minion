# docker-compose 部署

## 安装Docker

```sh
curl -fsSL https://get.docker.com | bash -s docker --mirror Aliyun
```

## 安装docker-compose

```sh
DOCKER_COMPOSE_VERSION=1.25.5
curl -L https://get.daocloud.io/docker/compose/releases/download/${DOCKER_COMPOSE_VERSION}/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose
chmod +x /usr/local/bin/docker-compose
```

## 启动minion

```
# 克隆项目
git clone https://gitee.com/FYMD/minion.git
cd minion
mvn clean install
cd minion-distribution/target/minion-${minion_version}/minion

# 启动容器 带-d可后台启动
sudo docker-compose up --build
```

## 部署前端

克隆前端项目参考[这里](https://fymd.gitee.io/minion/guide/startup.html#%E5%89%8D%E7%AB%AF)


### nginx配置文件

```nginx
upstream minion {
        server 127.0.0.1:9000;
}

server {
    listen 81;

    location /nacos {
        proxy_pass http://127.0.0.1:8848;
    }

    location ~* ^/(code|auth|upms|doc.html|webjars|swagger-resources) {
       proxy_pass http://minion;
       proxy_connect_timeout 15s;
       proxy_send_timeout 15s;
       proxy_read_timeout 15s;
       proxy_set_header X-Real-IP $remote_addr;
       proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
    }


    location / {
        root /var/www/html;
    }

}
```

### 编译项目

```sh
npm run build
```

把生成的`dist`目录复制到`/var/www/html`路径下，over
