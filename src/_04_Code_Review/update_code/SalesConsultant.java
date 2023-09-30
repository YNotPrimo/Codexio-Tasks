package _04_Code_Review.update_code;

class SalesConsultant extends Worker {
    public SalesConsultant() {
        super();
    }
    public void sellProduct(double price) {
        if (validPrice(price)) {
            this.budget += price;
        }
    }
}

