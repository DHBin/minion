FROM mysql:5.7.29

MAINTAINER admin@spring-boot.cn

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

COPY ./db/*.sql /docker-entrypoint-initdb.d/