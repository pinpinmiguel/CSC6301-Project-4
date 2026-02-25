# CSC6301-Project-4
A modular notification system built in Java demonstrating SOLID and composition design principles. The system simulates sending notifications through multiple platforms (Email, SMS) with runtime-swappable delivery methods and session logging.

## Overview
This notification system allows users to:

- Send notifications through multiple platforms (Email, SMS, WhatsApp)
- Switch notification mediums at runtime without recompiling
- Track all sent messages in a session log
- Display message history in reverse chronological order

The system simulates a long-term software maintenance project and thus prioritizes maintainability and extensibility. New notification services can be added without modifying the core `AlertSystem` class.

## Requirements

### Software

| Software | Version |
|----------|---------|
| Java JDK | 17.0.1 or higher |

Verify installation by running in the terminal:

```
java -version
javac -version
```
No dependencies on external libraries required as well.

### Hardware
- Any modern system capable of running Java

## Quick Start

### 1. Clone or Download

Download and extract the project to your local machine. Place the follwing .java files into the same folder:

```
AlertSystem.java
NotificationMedium.java
EmailService.java
SMSService.java
```

### 2. Navigate to Project Root and compile

Compile the .java files by navigating to the directory in your terminal and running:

```
javac *.java
```

### 3. Run the AlertSystem class file

While in the same directory, run:

```
java AlertSystem
```

### Expected Output:

```
=== Notification System Demo ===

Switching to EMAIL service.
[EMAIL] LinkedIn Job Alerts
[EMAIL] Amazon Order Confirmation
[EMAIL] Canvas Notification

Switching to SMS service.
[SMS] Verification Code
[SMS] Doctor's Appointment Reminder
[SMS] Mom

--- Session Message Log ---
1. [SMS] Mom
2. [SMS] Doctor's Appointment Reminder
3. [SMS] Verification Code
4. [EMAIL] Canvas Notification
5. [EMAIL] Amazon Order Confirmation
6. [EMAIL] LinkedIn Job Alerts
Total messages: 6
```

If output is not as expected, build health is compromised.

### Documentation

Generate JavaDoc HTML documentation by navigating to project directory and running in the terminal:

```
javadoc -d docs -author -version *.java
```

This command will generate the documentation for the program in a /docs folder in the directory of the files.
