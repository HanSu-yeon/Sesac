FROM ubuntu:18.04

RUN apt-get update
RUN apt-get install -y apache2

ADD ./hello.html /var/www/html/

WORKDIR /var/www/html

EXPOSE 80

CMD ["apachectl", "-DFOREGROUND"]