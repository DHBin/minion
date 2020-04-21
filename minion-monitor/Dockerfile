FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER admin@spring-boot.cn

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /minion-monitor

WORKDIR /minion-monitor

EXPOSE 9003

ADD ./target/minion-monitor.jar ./

CMD sleep 60;java -Djava.security.egd=file:/dev/./urandom -jar minion-monitor.jar
