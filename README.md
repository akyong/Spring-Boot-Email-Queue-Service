# 📬 Spring Boot Email Queue Service

A demo project that showcases how to integrate **Spring Boot**, **JMS (ActiveMQ)**, and **JavaMailSender** to build a robust **email sending service using messaging queues**.

This project is designed to demonstrate:
- Event-driven architecture using JMS
- Message queue via **ActiveMQ Classic**
- Sending emails using **Gmail SMTP**
- Clean code separation using **Controller**, **Service**, **Domain**, and **Config** layers
- JSON serialization and custom `MessageConverter`

---
![Deskripsi GIF](https://raw.githubusercontent.com/username/nama-repo/main/assets/nama-file.gif)

## ✨ Features

- ✅ Queue-based email sending system
- ✅ Asynchronous message processing via JMS
- ✅ SMTP email integration using Gmail
- ✅ JSON message converter for clean POJO handling
- ✅ Modular & testable service architecture

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot 3.4.x
- ActiveMQ Classic (external broker)
- Spring JMS
- Spring Mail (SMTP)
- Jackson for JSON mapping

---

## 📦 Why ActiveMQ Classic?

This project uses ActiveMQ Classic instead of Artemis, because:
- Easier to configure and run for local development
- Simpler integration with Spring Boot JMS
- Ideal for quick prototyping or educational purpose

⚠️ Do not confuse with ActiveMQ Artemis (2.x+), which is a different messaging engine under the same Apache ActiveMQ umbrella.

---

## 🔗 Download ActiveMQ Classic

#### 1. Go to the official download page:
👉 https://activemq.apache.org/components/classic/download
#### 2. Choose version apache-activemq-5.19.0-bin.tar.gz for Mac/Linux
(or .zip for Windows users)
#### 3. Extract the archive:
```bash
tar -xzf apache-activemq-5.19.0-bin.tar.gz
cd apache-activemq-5.19.0/bin

```

## 🚀 How to Run

### 1. Clone the repository

```bash
git clone https://github.com/your-username/email-jms-service.git
cd email-jms-service
```

### 2. Configure application.properties
Edit src/main/resources/application.properties and add your email credentials:
```properties
spring.mail.username=your-email@gmail.com
spring.mail.password=your-app-password
spring.activemq.broker-url=tcp://localhost:61616
```
Use [Gmail App Password](https://myaccount.google.com/apppasswords) if you have 2FA enabled.


### 3. Start ActiveMQ broker
```bash
./apache-activemq-5.19.0/bin/activemq console
```

### 4. Run the Spring Boot App
Author use maven so
```bash
mvn spring-boot:run
```

### 5. Test the Email Endpoint
```http request
POST /api/email
Content-Type: application/json

{
  "to": "bobbyakyong@gmail.com",
  "subject": "Test Email - To Author",
  "body": "This email was sent via JMS Queue!"
}
```

### Project Structure
```bash
com.bobbyakyong.messaging
├── config/           # JMS config with message converter
├── controller/       # REST endpoints
├── domain/           # EmailRequest POJO
├── service/          # Producer, Consumer, EmailService
└── MessagingApplication.java  # Spring Boot entry point
```

## 👨‍💻 Author
### Bobby Akyong

📍 Developer from Indonesia 🇮🇩  
🌐 [www.bobbyakyong.com](https://www.bobbyakyong.com)  
📧 [bobbyakyong@gmail.com](mailto:bobbyakyong@gmail.com)

## 👨‍💻 Author

This project is licensed under the [MIT License](LICENSE).

