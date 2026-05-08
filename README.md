Overview
Secure Notes Application is a Java-based desktop application designed to securely store and manage personal notes using AES encryption. The project focuses on security, usability, and modern UI design while demonstrating concepts such as authentication, encryption, database connectivity, and session management.

Features
Security


AES encryption for secure note storage


Password-based user authentication


Auto logout timer


Encrypted note export support


Secure database integration


Notes Management


Create notes


Edit notes


Delete notes


Search notes


Dashboard for note management


User Interface


Dark mode interface


Smooth animations


Responsive dashboard layout


User-friendly design


Additional Functionalities


Login and registration system


Session handling


Input validation


Error handling



Technologies Used


Java


Java Swing


Maven


MySQL


JDBC


AES Encryption


IntelliJ IDEA



Project Structure
SecureNotes/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/securenotes/
│   │   │       ├── ui/
│   │   │       ├── service/
│   │   │       ├── database/
│   │   │       ├── model/
│   │   │       └── utils/
│   │   │
│   │   └── resources/
│
├── pom.xml
└── README.md

Installation
Prerequisites


Java JDK 17 or higher


MySQL Server


Maven


IntelliJ IDEA



Setup Instructions
Clone the Repository
git clone https://github.com/your-username/secure-notes-app.git
Configure Database
Create a database in MySQL:
CREATE DATABASE securenotes;
Update database credentials in:
DatabaseConnection.java
Install Dependencies
mvn clean install
Run the Application
Run the main Java file from IntelliJ IDEA.

Encryption
The application uses AES encryption to protect user notes before storing them in the database.

Future Improvements


Cloud synchronization


Two-factor authentication


File attachments


Mobile application support


Password recovery system


Biometric authentication



License
This project is licensed under the MIT License.

Author
Rishi Tripathi
