//Abdulelah Ahmed

import java.util.Scanner;

public class GeneralStore {
    public static void main(String[] args) {
        // Initialization of Item Names and Prices Based on Item Codes
        String[] itemName = {"Book", "Pencil", "Pen", "Ruler", "Cardboard"};
        int[] itemPrice = {3000, 4000, 5000, 6000, 2000};

        Scanner input = new Scanner(System.in);

        // Input the Quantity of Items to be Purchased
        System.out.print("Enter the quantity of items to be purchased: ");
        int purchaseQuantity = input.nextInt();

        // Initialization of arrays to store input data
        String[] itemCode = new String[purchaseQuantity];
        int[] purchaseQuantityArray = new int[purchaseQuantity];

        // Input item data
        for (int i = 0; i < purchaseQuantity; i++) {
            System.out.println("Item data number " + (i + 1));
            System.out.print("Enter item code (1-5): ");
            itemCode[i] = input.next();

            // Validate item code
            while (!isValidItemCode(itemCode[i])) {
                System.out.println("Invalid item code. Please re-enter.");
                System.out.print("Enter item code (1-5): ");
                itemCode[i] = input.next();
            }

            System.out.print("Enter quantity to purchase: ");
            purchaseQuantityArray[i] = input.nextInt();
        }

        // Display output
        System.out.println("\n General Store ");
        System.out.println("\n**********************");
        System.out.println("No   Item Code   Item Name   Price    Quantity   Total Price");

        int totalPayment = 0;

        for (int i = 0; i < purchaseQuantity; i++) {
            int index = Integer.parseInt(itemCode[i]) - 1;
            int totalItemPrice = itemPrice[index] * purchaseQuantityArray[i];
            totalPayment += totalItemPrice;

            System.out.println("==========================================================================");
            System.out.printf("%-5d%-14s%-14s%-14d%-13d%-13d1\n", (i + 1), itemCode[i], itemName[index], itemPrice[index], purchaseQuantityArray[i], totalItemPrice);
        }
        System.out.println("==========================================================================");
        System.out.println("\nTotal Price: " + totalPayment);
        System.out.println("==========================================================================");
    }

    // Validate item code (only 1-5)
    static boolean isValidItemCode(String code) {
        int codeInt;
        try {
            codeInt = Integer.parseInt(code);
        } catch (NumberFormatException e) {
            return false;
        }
        return codeInt >= 1 && codeInt <= 5;
    }
}
