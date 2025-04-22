import java.util.Scanner;

public class SpeedChecker {

    public static void main(String[] args) {
        double currentSpeed = 0.0;
        double maxSpeed = 80.0; 
        String renterId = "renter_abc"; 
        String driverId = "driver_abc";
        String phoneNo = "1234567890"; 


        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the speed limit fleet company wants to set for renter " + renterId + ": ");
        maxSpeed = scanner.nextDouble();

        System.out.println("Enter the current speed of the vehicle monitored from GPS: ");
        currentSpeed = scanner.nextDouble();

        if (currentSpeed > maxSpeed) {
            System.out.println("Warnig : Maximux speed limit is exceeded");
            sendFirebaseNotification(driverId, "Your current speed is "+ currentSpeed + " km/h" + " Slow down your car as maximum speed limit is exceeded" );
            awsSmsSent(phoneNo, "Speed limit exceeded! Your current speed: " + currentSpeed + " km/h");


        } else {
            System.out.println("Current driving speed is as per the speed limit rule");
        }

        scanner.close();
    }

    private static void sendFirebaseNotification(String userId, String message) {
        // Here implementation with Firebase Cloud Messaging API

        System.out.println("Firebase Notification to " + userId + ": " + message);
    }
    
    private static void awsSmsSent(String phoneNo, String message) {
        // Here integration with AWS API can be done

        System.out.println("Speed exceed warning send using AWS SMS to " + phoneNo + ": " + message);
    }

}
