FROM nacos/nacos-server:1.2.1

MAINTAINER admin@spring-boot.cn

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai

ENV DOCKERIZE_VERSION v0.6.1

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && yum update && yum install -y wget \
    && wget http://106.52.116.231:9527/dockerize/${DOCKERIZE_VERSION}/dockerize-linux-amd64-${DOCKERIZE_VERSION}.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-linux-amd64-${DOCKERIZE_VERSION}.tar.gz \
    && rm dockerize-linux-amd64-${DOCKERIZE_VERSION}.tar.gz

ENTRYPOINT dockerize -wait tcp://minion-mysql:3306 -timeout 1800s bin/docker-startup.sh