import java.util.ArrayList;

/**
 * Module for managing user notifications. Allows user to swap notification
 * mediums, send notifications through the selected platform, and record the
 * logs of all send messages during the session.
 *
 * <p>Class was generated with AI assistance. Output was changed to add
 * exception handling when sending a message without an active medium and
 * record medium when adding to messageLog in notifyUser() method, display a
 * message when switching mediums in setMedium(), and reverse display order
 * of log messages in displayLog().</p>
 *
 * <p>Original Query:</p>
 *
 * <pre>
 * Create a class called AlertSystem that uses the emailservice and smsservice
 * classes. It should have a notificationmedium object as a private field, a
 * method setMedium(NotificationMedium medium) for swapping the service and
 * another method notifyUser(String message) for using the send method of the
 * active medium.
 * </pre>
 *
 * <p>Command used to generate javadocs for package:</p>
 *
 * <pre>{@code}javadoc -d docs -author -version *.java</pre>
 *
 * <p>To run, please run the following commands within the directory of the
 * package:</p>
 *
 * <pre>{@code}
 * javac *.java
 * java AlertSystem
 * </pre>
 *
 * <p>Example output:</p>
 *
 * <pre>{@code}
 * === Notification System Demo ===
 *
 * Switching to Email service.
 * [EMAIL]: LinkedIn Job Alerts
 * [EMAIL]: Amazon Order Confirmation
 * [EMAIL]: Canvas Notification
 *
 * Switching to SMS service.
 * [SMS]: Verification Code
 * [SMS]: Doctor's Appointment Reminder
 * [SMS]: Mom
 *
 * --- Session Message Log ---
 * 1. [SMS] Mom
 * 2. [SMS] Doctor's Appointment Reminder
 * 3. [SMS] Verification Code
 * 4. [Email] Canvas Notification
 * 5. [Email] Amazon Order Confirmation
 * 6. [Email] LinkedIn Job Alerts
 * Total messages: 6
 * </pre>
 *
 * @author Miguel Pinpin
 * @version 1.0
 */

public class AlertSystem {
    private NotificationMedium medium;
    private ArrayList<String> messageLog;

    /**
     * Constructor for AlertSystem class. Creates an empty message log and
     * sets active notification medium to null.
     */
    public AlertSystem() {
        this.medium = null;
        this.messageLog = new ArrayList<>();
    }

    /**
     * Changes the notification medium to chosen platform.
     *
     * <p>Method was altered from AI output to include output message when
     * switching platforms.</p>
     *
     * @param medium the notification platform to switch to
     */
    public void setMedium(NotificationMedium medium) {
        this.medium = medium;
        System.out.println("\nSwitching to " + medium + " service.");
    }

    /**
     * Sends a message to the terminal output through the current active
     * notification platform.
     *
     * <p>Method was altered from original AI output. Additional check for
     * an active notification platform was added using an if/throw block, and
     * print message output was changed to include medium.</p>
     *
     * @param message the message to send through the active notification
     *                platform
     * @throws IllegalStateException if no medium has been set prior to
     *                               sending a message
     */
    public void notifyUser(String message) {
        if (medium == null) {
            throw new IllegalStateException("No notification medium has been " +
                    "set.");
        }
        medium.send(message);
        messageLog.add("[" + medium + "] " + message);
    }

    /**
     * Displays all sent messages for the session in descending order with
     * most recent messages first.
     *
     * <p>Method was altered from AI output to reverse the order in which
     * messages were displayed (originally ascending order).</p>
     */
    public void displayLog() {
        System.out.println("\n--- Session Message Log ---");
        if (messageLog.isEmpty()) {
            System.out.println("No messages sent this session.");
        } else {
            for (int i = messageLog.size() - 1; i >= 0; i--) {
                System.out.println((messageLog.size() - i) + ". " + messageLog.get(i));
            }
        }
        System.out.println("Total messages: " + messageLog.size());
    }

    /**
     * Application entry point for demonstrating simulated notification system.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Notification System Demo ===");

        AlertSystem alerts = new AlertSystem();

        // Demonstrate email notifications
        alerts.setMedium(new EmailService());
        alerts.notifyUser("LinkedIn Job Alerts");
        alerts.notifyUser("Amazon Order Confirmation");
        alerts.notifyUser("Canvas Notification");

        // Switch to SMS medium
        alerts.setMedium(new SMSService());
        alerts.notifyUser("Verification Code");
        alerts.notifyUser("Doctor's Appointment Reminder");
        alerts.notifyUser("Mom");

        // Display message list
        alerts.displayLog();
    }

}
