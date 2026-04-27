import java.util.Scanner;

public class Main{

    // login function
    public static boolean login(String username, String password){
        return username.equals("anu") && password.equals("1137");
    }

    //Show products
    public static void showProducts(){
        System.out.println("\n===== PRODUCTS =====");
        System.out.println("1. Laptop - 50000");
        System.out.println("2. Mouse - 1000");
        System.out.println("3. Keyboard - 2000");
        System.out.println("4. Headphones - 3000");
    }

    //Get products Price
    public static int getPrice(int choice){
        if (choice == 1){
            return 50000;
        } else if (choice == 2){
            return 1000;
        } else if(choice == 3){
            return 2000;
        } else if (choice == 4){
            return 3000;
        } else {
            return 0;
        }
    }

    // Apply coupon
    public static double applyDiscount(double total, String coupon){
        if(coupon.equals("SAVE10")){
            System.out.println("Coupon applied: 10% OFF");
            return total - (total * 0.10);
        }
        return total;
    }

    //Add  GST
    public static double addGST(double total){
        return total + (total * 0.18);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Username: ");
        String username = sc.nextLine();

        System.out.println("password: ");
        String password = sc.nextLine();

        if(!login(username, password)){
            System.out.println("Invalide login");
            return;
        }

        System.out.println("Login successful!");

        while(true){

            showProducts();

            System.out.println("\nChoose Product: ");
            int product = sc.nextInt();

            int price = getPrice(product);

            if(price == 0){
                System.out.println("Invalide product");
                continue;
            }

            System.out.println("Enter Quantity: ");
            int quantity = sc.nextInt();

            double total = price * quantity;

            sc.nextLine();

            System.out.println("Enter coupon (SAVE10) or press enter");
            String coupon = sc.nextLine();

            total = applyDiscount(total, coupon);

            total = addGST(total);

            System.out.println("\nPayment Method: ");
            System.out.println("1. upi");
            System.out.println("2. Card");
            System.out.println("3. Cash");

            System.out.println("Choose Payment: ");
            int payment = sc.nextInt();

            String method = "";

            if (payment == 1){
                method = "UPI";
            } else if (payment == 2){
                method = "Card";
            } else if(payment == 3){
                method = "Cash";
            } else {
                method = "unknown";
            }

            System.out.println("\n===== Invoice =====");
            System.out.println("Quantity: " + quantity);
            System.out.println("Final Amount: " + total);
            System.out.println("Payment method: " + method);
            System.out.println("Order placed sucessfully!");

            System.out.println("\nDo you wan to shop again? (yes/no)");
            sc.nextLine();
            String again = sc.nextLine();

            if(again.equalsIgnoreCase("no")){
                System.out.println("Thank you for shopping!");
                break;
            }
        }
    }
}