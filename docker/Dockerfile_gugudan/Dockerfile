# 우분투 18.04 버젼
FROM ubuntu:18.04

# 오픈소스 자바 8버젼 다운로드
RUN  apt-get update
RUN  apt-get upgrade
RUN  apt-get install -y openjdk-8-jdk

# 환경 변수 설정
RUN  export JAVA_HOME= || $(which javac)
RUN  export PATH=$JAVA_HOME/bin:$PATH
RUN  export CLASS_PATH=$JAVA_HOME/lib:$CLASS_PATH

# 자바 실행파일 가져오기
RUN    mkdir /var/myjava
WORKDIR /var/myjava
COPY   Gugudan.java .

# 자바 컴파일러
RUN javac -encoding utf-8 Gugudan.java

CMD ["java", "Gugudan"]