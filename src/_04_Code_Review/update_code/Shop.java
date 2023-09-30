package _04_Code_Review.update_code;

import java.util.ArrayList;
import java.util.List;

class Shop {
    private static Shop instance;

    public static Shop getInstance() {
        if (instance == null) {
            instance = new Shop();
        }
        return instance;
    }

    private final List<Worker> workers;

    Shop() {
        this.workers = new ArrayList<>();
    }
    public void addWorker(Worker worker) {
        this.workers.add(worker);
    }
    public double getTurnover() {
        double turnOver = 0.0;
        for (Worker worker : this.workers) {
            turnOver += worker.getBudget();
        }
        return turnOver;
    }
}
