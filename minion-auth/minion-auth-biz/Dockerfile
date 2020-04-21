FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER admin@spring-boot.cn

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /minion-auth-biz

WORKDIR /minion-auth-biz

EXPOSE 9001

ADD ./target/minion-auth-biz.jar ./

CMD sleep 60;java -Djava.security.egd=file:/dev/./urandom -jar minion-auth-biz.jar
