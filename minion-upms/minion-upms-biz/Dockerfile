FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER admin@spring-boot.cn

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /minion-upms-biz

WORKDIR /minion-upms-biz

EXPOSE 9002

ADD ./target/minion-upms-biz.jar ./

CMD sleep 60;java -Djava.security.egd=file:/dev/./urandom -jar minion-upms-biz.jar
