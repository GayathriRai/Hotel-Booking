FROM tomcat:10.1-jdk21

RUN rm -rf /usr/local/tomcat/webapps/*

COPY HotelBooking-1.0.war /usr/local/tomcat/webapps/HotelBooking.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
