# Installation

## Prerequisites

Before running the application, make sure the following software is installed on your system:

- Java JDK 17 or higher
- MySQL Server
- Maven
- IntelliJ IDEA

---

# Setup Instructions

## Step 1: Clone the Repository

```bash
git clone https://github.com/your-username/secure-notes-app.git
```

---

## Step 2: Open the Project

1. Open IntelliJ IDEA  
2. Click on "Open"  
3. Select the cloned project folder  
4. Open it as a Maven project  

---

## Step 3: Configure the Database

Open MySQL and create a database:

```sql
CREATE DATABASE securenotes;
```

Update your database credentials inside:

```plaintext
DatabaseConnection.java
```

Example:

```java
private static final String URL = "jdbc:mysql://localhost:3306/securenotes";
private static final String USER = "root";
private static final String PASSWORD = "your_password";
```

---

## Step 4: Install Maven Dependencies

Open terminal inside the project folder and run:

```bash
mvn clean install
```

This will automatically download all required dependencies.

---

## Step 5: Run the Application

1. Open the project in IntelliJ IDEA  
2. Locate the main Java file  
3. Right-click the file  
4. Click "Run"  

The application should now start successfully.

---

# Encryption

The application uses AES (Advanced Encryption Standard) encryption to secure user notes before storing them in the database.

## Benefits of AES Encryption

- Strong data protection
- Secure local storage
- Protection against unauthorized access

---

# Future Improvements

- Cloud synchronization
- Two-factor authentication
- File attachments
- Mobile application support
- Password recovery system
- Biometric authentication

---

# License

This project is licensed under the MIT License.

---

# Author

Rishi Tripathi
