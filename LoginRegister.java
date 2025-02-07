import java.util.*;

public class LoginRegister {
    private static final HashMap<String, String> users = new HashMap<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("\n1. Register  2. Login  3. Reset Password  4. Exit: ");
            switch (sc.nextInt()) {
                case 1 -> register(sc);
                case 2 -> login(sc);
                case 3 -> resetPassword(sc);
                case 4 -> { return; }
            }
        }
    }

    private static void register(Scanner sc) {
        System.out.print("Username: ");
        String user = sc.next();
        System.out.print("Password: ");
        String pass = sc.next();
        System.out.println(users.putIfAbsent(user, pass) == null ? "Registered!" : "User exists!");
    }

    private static void login(Scanner sc) {
        System.out.print("Username: ");
        String user = sc.next();
        System.out.print("Password: ");
        String pass = sc.next();
        System.out.println(pass.equals(users.get(user)) ? "Login successful!" : "Invalid credentials.");
    }

    private static void resetPassword(Scanner sc) {
        System.out.print("Enter username for password reset: ");
        String user = sc.next();
        if (users.containsKey(user)) {
            System.out.print("Enter new password: ");
            String newPassword = sc.next();
            users.put(user, newPassword);
            System.out.println("Password successfully reset.");
        } else {
            System.out.println("User does not exist.");
        }
    }
}
