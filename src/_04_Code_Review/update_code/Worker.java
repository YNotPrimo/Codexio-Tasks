package _04_Code_Review.update_code;

public abstract class Worker {
    private Shop shop;
    protected double budget;

    public Worker() {
        this.shop = Shop.getInstance();
        this.shop.addWorker(this);
        this.budget = 0.0;
    }
    public Worker(double budget) {
        this();
        this.budget = budget;
    }

    public double getBudget() {
        return this.budget;
    }

    protected boolean validPrice(double price) {
        if (price <= 0.0) {
            System.out.println("ERROR: The given price is below or equal to 0");
            return false;
        }
        return true;
    }
}
