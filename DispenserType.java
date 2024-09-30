package FruitJuiceMachine;

public class DispenserType {
    private int numberOfItems;
    private int cost;

    // Default constructor - sets number of items to 50 and cost to 30 PHP
    public DispenserType() {
        numberOfItems = 50;
        cost = 30;
    }

    // Parameterized constructor - sets custom number of items and cost
    public DispenserType(int setNoOfItems, int setCost) {
        numberOfItems = setNoOfItems;
        cost = setCost;
    }

    // Get the number of items in the dispenser
    public int getNoOfItems() {
        return numberOfItems;
    }

    // Get the cost of the item
    public int getCost() {
        return cost;
    }

    // Decrement the number of items by 1 (sale happens)
    public void makeSale() {
        if (numberOfItems > 0) {
            numberOfItems--;
        }
    }
}

