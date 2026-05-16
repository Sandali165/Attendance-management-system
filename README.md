# Attendance Management System

## Project Overview

The Attendance Management System is a simple Spring Boot application developed to demonstrate a complete CI/CD workflow using Jenkins and Docker.

This project automatically builds, tests, and containerizes the application whenever code is pushed to GitHub.

---

# Technologies Used

* Java 21
* Spring Boot 3
* Maven
* Docker
* Jenkins
* GitHub

---

# Features

* REST API for attendance management
* Maven build automation
* Docker containerization
* Jenkins CI/CD pipeline
* GitHub integration

---

# API Endpoints

## Check Service Status

```http
GET /attendance/status
```

Response:

```text
Attendance Service Running
```

---

## User Check-In

```http
POST /attendance/checkin
```

Response:

```text
User Checked In
```

---

# Running the Project Locally

## Step 1 - Clone Repository

```bash
git clone https://github.com/Sandali165/Attendance-management-system.git
```

---

## Step 2 - Navigate to Project

```bash
cd Attendance-management-system
```

---

## Step 3 - Run Application

```bash
mvn spring-boot:run
```

Application runs on:

```text
http://localhost:8080
```

---

# Docker Setup

## Build Docker Image

```bash
docker build -t attendance-app .
```

---

## Run Docker Container

```bash
docker run -p 8080:8080 attendance-app
```

---

# Jenkins CI/CD Pipeline

The Jenkins pipeline performs the following stages:

1. Clone GitHub Repository
2. Build Maven Project
3. Run Test Cases
4. Create JAR File
5. Build Docker Image

---

# Project Structure

```text
attendance-management-system/
│
├── src/
├── Dockerfile
├── pom.xml
├── mvnw
├── mvnw.cmd
└── Jenkins Pipeline
```

---

# Future Improvements

* AWS EC2 Deployment
* AWS ECR Integration
* Load Balancer Setup
* Database Integration
* Authentication System

---

# Author

Sandali165

---

