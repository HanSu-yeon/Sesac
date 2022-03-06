## 쿠버네티스로 Wordpress & MySQL 블로그 배포하기

### 목표

📢 Pod, ReplicatSet, Deployment, Service, Volume을 이용해 워드프레스 블로그 배포하기

### 조건

**MySQL**

| Key             | Value                                             |
| --------------- | ------------------------------------------------- |
| 컨테이너 이미지 | mysql:5.7                                         |
| 포트            | 3306                                              |
| 환경변수1       | MYSQL_DATABASE: wordpress                         |
| 환경변수2       | MYSQL_ROOT_PASSWORD: root(시크릿에서 참조할 예정) |

**Wordpress**

| Key             | Value                                                |
| --------------- | ---------------------------------------------------- |
| 컨테이너 이미지 | wordpress:5.5.3-apache                               |
| 포트            | 80                                                   |
| 환경변수1       | WORDPRESS_DB_HOST: [MySQL 서비스의 이름]             |
| 환경변수2       | WORDPRESS_DB_USER: root                              |
| 환경변수3       | WORDPRESS_DB_NAME: wordpress                         |
| 환경변수4       | WORDPRESS_DB_PASSWORD: root (시크릿에서 참조할 예정) |

➕NFS스토리지를 사용해 PV에 연결하기

➕Service: NodePort

**실습환경**

Kubespray를 활용한 멀티 노드 쿠버네티스 클러스터 구성
[참고](https://myanjini.tistory.com/entry/Kubespray%EB%A5%BC-%ED%99%9C%EC%9A%A9%ED%95%9C-%EB%A9%80%ED%8B%B0-%EB%85%B8%EB%93%9C-%EC%BF%A0%EB%B2%84%EB%84%A4%ED%8B%B0%EC%8A%A4-%ED%81%B4%EB%9F%AC%EC%8A%A4%ED%84%B0-%EA%B5%AC%EC%84%B1)
