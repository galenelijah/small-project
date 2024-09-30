import java.util.Scanner;

public class main {
	// Show Selection
	static CashRegister register = new CashRegister();
    static DispenserType appleJuice = new DispenserType(10, 30);
    static DispenserType orangeJuice = new DispenserType(10, 40);
    static DispenserType mangoLassi = new DispenserType(10, 50);
    static DispenserType fruitPunch = new DispenserType(10, 60);
    public static void showSelection() {
        System.out.println("\n=======FRUIT JUICE MACHINE=======\nPlease enter a number from the following options:");
        System.out.println("1. Apple Juice - PHP " + appleJuice.getCost());
        System.out.println("2. Orange Juice - PHP " + orangeJuice.getCost());
        System.out.println("3. Mango Lassi - PHP " + mangoLassi.getCost());
        System.out.println("4. Fruit Punch - PHP " + fruitPunch.getCost());
        System.out.println("5. Exit\n");
    }

    // Selling a product
    public static void sellProduct(DispenserType product, CashRegister register) {
        Scanner input = new Scanner(System.in);

        if (product.getNoOfItems() > 0) {
            System.out.println("The item costs: PHP " + product.getCost() + ".");
            System.out.print("Please deposit money: PHP ");
            int amountDeposited = input.nextInt();
            input.nextLine();
            int change;

            if (amountDeposited >= product.getCost()) {
                register.acceptAmount(product.getCost());
                product.makeSale();
                System.out.println("Collect your item. Thank you for your purchase!");
                change = amountDeposited - product.getCost();
                if (change > 0) {
                    System.out.println("Here is your change: PHP " + change + ".");
                }
                System.out.println("\nCurrent cash register balance: " + register.getCurrentBalance());
            }
            else {
            	int fundRequired = product.getCost()-amountDeposited;
            	int addedFund;  	
            	System.out.println("Insufficient funds. Please enter at least PHP " + fundRequired + " additionally to purchase product.");
            	System.out.print("Please deposit money: PHP ");
           		addedFund = input.nextInt();
           		input.nextLine();
            	
            	if(addedFund >= fundRequired) {
            		register.acceptAmount(product.getCost());
                    product.makeSale();
            		System.out.println("Collect your item. Thank you for your purchase!");
            		change = (amountDeposited+addedFund) - product.getCost();
            		 if (change > 0) {
                         System.out.println("Here is your change: PHP " + change + ".");
                     }
                     System.out.println("\nCurrent cash register balance: " + register.getCurrentBalance());
            	}
            	else {
            		System.out.println("Insufficient funds. Transaction cancelled.\n");
            	}
                
            }
        } 
        else {
            System.out.println("Sorry, this item is sold out.\n");
        }
    }

    public static void main(String[] args) {
        // Create a cash register and dispensers for each juice
        

        Scanner input = new Scanner(System.in);
        int choice;

        do {
            showSelection();
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    sellProduct(appleJuice, register);
                    break;
                case 2:
                    sellProduct(orangeJuice, register);
                    break;
                case 3:
                    sellProduct(mangoLassi, register);
                    break;
                case 4:
                    sellProduct(fruitPunch, register);
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid selection, please try again.\n");
                    break;
            }
        } while (choice != 5);
    }
}
