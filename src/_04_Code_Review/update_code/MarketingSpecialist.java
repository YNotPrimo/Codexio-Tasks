package _04_Code_Review.update_code;

class MarketingSpecialist extends Worker {
    public MarketingSpecialist() {
        super(5000.00);
    }
    public void spendMoney(double marketingCampaignCost) {
        if (validPrice(marketingCampaignCost)) {
            this.budget -= marketingCampaignCost;
        }
    }
}
