***ExamPortalServlet***

**Guidance to create database:**
```CREATE DATABASE examportal;

USE examportal;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role ENUM('TEACHER', 'STUDENT', 'ADMIN') NOT NULL DEFAULT 'STUDENT'
);


CREATE TABLE tests (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    duration INT NOT NULL, -- Duration in minutes
    creator_id INT NOT NULL,
    FOREIGN KEY (creator_id) REFERENCES users(id)
);

CREATE TABLE questions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    test_id INT NOT NULL,
    question_text VARCHAR(255) NOT NULL,
    correct_option INT NOT NULL,
    option1 VARCHAR(100) NOT NULL,
    option2 VARCHAR(100) NOT NULL,
    option3 VARCHAR(100) NOT NULL,
    option4 VARCHAR(100) NOT NULL,
    FOREIGN KEY (test_id) REFERENCES tests(id)
);

CREATE TABLE test_results (
    id INT AUTO_INCREMENT PRIMARY KEY,
    test_id INT NOT NULL,
    student_id INT NOT NULL,
    score INT NOT NULL,
    FOREIGN KEY (test_id) REFERENCES tests(id),
    FOREIGN KEY (student_id) REFERENCES users(id)
);
```
