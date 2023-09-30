package _04_Code_Review.old_code;

import java.util.ArrayList;
import java.util.List;

// The different classes can be in their own separate files
/* NOTE 1
    The SalesConsultant and MarketingSpecialist classes have overlapping functionalities.
    They can extend an abstract class which unify the repeated properties and functionalities.
    This will also clear the redundant instance check in the Shop class getTurnover() method
    and in the addWorker() method, the parameter type can be specified as the abstracted class.
*/
class SalesConsultant {
    // NOTE 2
    // Property can be renamed to just shop and can be final.
    private Shop workingShop;

    // See NOTE 1
    private double earnedMoney;

    // See NOTE 1
    public SalesConsultant() {
        this.workingShop = Shop.getInstance();
        this.workingShop.addWorker(this);
    }

    public void sellProduct(double price) {
        // NOTE 3
        // For better readability, the price can be checked if it's below 0.
        // If it is we can throw an Exception for example
        this.earnedMoney += Math.max(price, 0);
    }

    // See NOTE 1
    public double getMoney() {
        return this.earnedMoney;
    }
}

// See NOTE 1
class MarketingSpecialist {
    // See NOTE 2
    private Shop workingShop;

    // See NOTE 1
    private double budget = 5000.00;

    // See NOTE 1
    public MarketingSpecialist() {
        this.workingShop = Shop.getInstance();
        this.workingShop.addWorker(this);
    }
    public void spendMoney(double marketingCampaignCost) {
        // See NOTE 3
        this.budget -= Math.max(marketingCampaignCost, 0);
    }

    // See NOTE 1
    public double getBudget() {
        return this.budget;
    }
}

class Shop {
    private static Shop instance;
    public static Shop getInstance() {
        if (instance == null) {
            instance = new Shop();
        }
        return instance;
    }

    // The type of the items in the ArrayList needs to be specified
    // The property can also be final
    // Example: private final List<Object> workers = new ArrayList<>();
    // Additionally, it would be best if the property is instantiated in the constructor.
    private List workers = new ArrayList();

    // See NOTE 1
    public void addWorker(Object worker) {
        this.workers.add(worker);
    }
    public double getTurnover() {
        // For better readability, the type should be specified instead of using var
        var turnOver = 0.0;
        for (var worker : this.workers) {

            // See NOTE 1
            if (worker instanceof SalesConsultant); {
                turnOver += (( SalesConsultant)worker).getMoney();
            }

            // See NOTE 1
            if (worker instanceof MarketingSpecialist) {
                turnOver += (( MarketingSpecialist)worker).getBudget();
            }
        }
        return turnOver;
    }
}