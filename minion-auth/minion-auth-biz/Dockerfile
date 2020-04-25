FROM openjdk:8-jre

MAINTAINER admin@spring-boot.cn

ENV DOCKERIZE_VERSION v0.6.1

ENV PROGRAM_NAME minion-auth-biz

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && apt-get update && apt-get install -y wget \
    && wget http://106.52.116.231:9527/dockerize/${DOCKERIZE_VERSION}/dockerize-linux-amd64-${DOCKERIZE_VERSION}.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-linux-amd64-${DOCKERIZE_VERSION}.tar.gz \
    && rm dockerize-linux-amd64-${DOCKERIZE_VERSION}.tar.gz

WORKDIR /${PROGRAM_NAME}

EXPOSE 9001

ADD ./target/${PROGRAM_NAME}.jar ./

CMD dockerize -wait tcp://minion-register:8848 -wait tcp://minion-zookeeper:2181 -wait tcp://minion-mysql:3306 -wait tcp://minion-redis:6379 -timeout 1800s\
     java -Xms128m -Xmx256m -Djava.security.egd=file:/dev/./urandom -jar ${PROGRAM_NAME}.jar
