# Incredible India Hotels

Traditional Java 21/Jakarta Web Application for hotel booking across India.

## Stack
- Java 21 / javac 21
- Maven 3.9.x
- Apache Tomcat 10.x
- Jakarta Servlet 6
- JSP/JSTL
- MySQL 8
- JDBC
- WAR packaging

## Build
```bash
java -version
javac -version
mvn -version
mvn clean package
```

The WAR is generated as:
`target/HotelBooking-1.0.war`

## Database
1. Start MySQL.
2. Run `database/hotel_booking_db.sql`.
3. If your MySQL credentials differ, update `DBConnection.java`.

## Tomcat
Copy `target/HotelBooking-1.0.war` to `TOMCAT_HOME/webapps/`, start Tomcat 10, then open:
`http://localhost:8080/HotelBooking-1.0/`

## Images
The database includes five image records per hotel. The demo uses remote Unsplash URLs. The application has a local SVG fallback for failed image loads. For production, replace remote image URLs with licensed/local hotel photography.

## Important
This is a starter production-style project, not a payment-enabled production booking platform. Before real deployment, add a payment gateway, externalized secrets, CSRF protection, connection pooling, rate limiting, stronger availability locking, audit logging and proper licensed photography.
