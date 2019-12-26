FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER admin@spring-boot.cn

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /minion-gateway

WORKDIR /minion-gateway

EXPOSE 9000

ADD ./target/minion-gateway.jar ./

CMD sleep 60;java -Djava.security.egd=file:/dev/./urandom -jar minion-gateway.jar
