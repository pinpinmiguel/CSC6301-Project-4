# CSC6301-Project-4
Project for Week 4 of CSC6301
A lightweight Java application demonstrating composition coding concepts through a pluggable notification system. The system allows runtime swapping between notification mediums (Email, SMS) without modifying core logic, and maintains a session log of all sent messages.

Capabilities
------------
The application simulates a notification dispatch system with three core capabilities:

Medium Swapping — The active notification platform (Email or SMS) can be switched at runtime via a single method call. No recompilation or structural changes are needed, because each service is swapped by reassigning a reference to the shared NotificationMedium interface.

Message Dispatch — Once a medium is set, messages are sent through it and printed to the terminal with a labeled prefix (e.g., [EMAIL] or [SMS]). Attempting to send without a medium set throws an IllegalStateException with a descriptive error.

Session Logging — Every sent message is recorded in an in-memory log tied to the AlertSystem instance. At any point, the log can be printed to the terminal in reverse chronological order (most recent first), along with a total message count.

Requirements
------------
Software:
Minimum Version of Java Development Kit (JDK) - 17.0.1
Terminal / Command Prompt - Any Windows CMD, PowerShell, macOS Terminal, or Linux shell

Hardware:
No special hardware requirements

Quick Start
-----------
1. Verify java is installed and meets the minimum version required. Java can be verified by typing into the temrinal:

`java -version`
`javac -version`

2. Place the follwing .java files into the same folder:

```
AlertSystem.java
NotificationMedium.java
EmailService.java
SMSService.java
```

3. Compile the .java files by navigating to the directory in your terminal and running:

`javac *.java`


4. Run the AlertSystem class file using:

`java AlertSystem`

Expected Output:
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

5. Generate HTML documentation using the javadocs tool:

`javadoc -d docs -author -version *.java`

This command will generate the documentation for the program in a /docs folder in the directory of the files.
