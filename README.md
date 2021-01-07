Configuration
-------------
### <span id="anchor"></span>application.properties

**\# points to application-dev.properties**

**spring.profiles.active=dev**

**spring.servlet.multipart.enabled=true**

**spring.servlet.multipart.max-file-size=5MB**

**spring.servlet.multipart.max-request-size=5MB**

**spring.thymeleaf.cache=false**

**spring.thymeleaf.enabled=true**

**spring.thymeleaf.prefix=classpath:/templates/**

**spring.thymeleaf.suffix=.html**

**spring.datasource.driverClassName=org.postgresql.Driver**

**spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect**

**spring.jpa.hibernate.ddl-auto=update**

### <span id="anchor-1"></span>application-dev.properties

**\# Set corresponding Config Vars on heroku for these. They should be
injected.**
**\# Set spring.profiles.active=dev in application.properties**

**----------------------------------------------
**  Database on Heroku**
**----------------------------------------------

**spring.datasource.url=jdbc:postgresql://DB\_HOST:5432/DB\_NAME?user=DB\_USER&password=DB\_PASSWORD&sslmode=require**

**---------------------------------------------
**   Mail Setup**
**---------------------------------------------

**spring.mail.host=**

**spring.mail.username=**

**\# Reply-to email adress; you must own this email adress**

**spring.mail.sender=**

**spring.mail.password=**

**spring.mail.port=587**

**spring.mail.properties.mail.smtp.auth=true**

**spring.mail.properties.mail.smtp.starttls.enable=true**


**---------------------------------------------
**\# Shop Admin Account**
**---------------------------------------------

**spring.security.user.name=**

**spring.security.user.password=**
