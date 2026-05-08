# Secure-Notes-Application
A modern Java-based Secure Notes Application designed to help users safely store and manage personal notes using strong encryption techniques.
This project focuses on security, usability, and a clean user experience, making it ideal for learning Java desktop application development, encryption, authentication systems, and UI design.

Features
Security Features
AES Encryption for secure note storage
Password-protected user authentication
Encrypted note export support
Auto logout timer for added security
Secure local database storage
Notes Management
Create new notes
Edit existing notes
Delete notes
Search and organize notes
Dashboard for managing all notes
User Interface
Modern dark mode UI
Smooth animations and transitions
User-friendly dashboard layout
Responsive and clean design
Additional Features
Login & Registration system
Session management
Error handling and validations
Maven project structure
MySQL database integration
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
│   │
├── pom.xml
└── README.md

Prerequisites

Make sure you have installed:

Java JDK 17+
MySQL Server
Maven
IntelliJ IDEA (Recommended)
Installation
Clone the Repository
git clone https://github.com/your-username/secure-notes-app.git
Open the Project

Open the project in IntelliJ IDEA as a Maven project.

Configure Database

Create a MySQL database:

CREATE DATABASE securenotes;

Update your database credentials inside:

DatabaseConnection.java
Install Dependencies

Maven will automatically download dependencies.

Or run:

mvn clean install
Run the Application

Run the main Java file from IntelliJ IDEA.

Encryption

This application uses AES (Advanced Encryption Standard) to encrypt user notes before storing them in the database.

Benefits:

Strong data protection
Secure storage
Prevents unauthorized access
📸 Screenshots

You can add screenshots here later:

Login Screen
Dashboard
Notes Editor
Dark Mode UI
Future Improvements
Cloud synchronization
Two-factor authentication
File attachments
Mobile version
Password recovery
Biometric authentication
Contributing

Contributions are welcome!

Fork the repository
Create a new branch
Commit changes
Push to your branch
Open a Pull Request
License

This project is licensed under the MIT License.

Author

Developed by Rishi Tripathi.
