
# VerveVault - Final (Spring Boot + H2)

This is a minimal Spring Boot project implementing the VerveVault features:
- Add & View Notes
- Add & View Tasks (toggle complete)
- Add & View Events
- Add & View Attendance

Technology stack:
- Spring Boot (Web, Thymeleaf, Data JPA)
- H2 in-memory database (configured in application.properties)
- Bootstrap CDN for UI

Run with Maven:
```
mvn spring-boot:run
```

H2 Console: http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:vervedb)
