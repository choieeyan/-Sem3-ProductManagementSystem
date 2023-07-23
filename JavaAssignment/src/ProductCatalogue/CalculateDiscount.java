
package ProductCatalogue;

public class CalculateDiscount {
    public double percentage, amount, discounted, retail;

    public CalculateDiscount() {
    }

    public double getRetail() {
        return retail;
    }

    public void setRetail(double retail) {
        this.retail = retail;
    }

    
    public double discountPercentage(double percentage){
        discounted = retail - ((retail * percentage)/100);
        return discounted;
    }
    
    public double discountAmount(double amount){
        discounted = retail - amount;
        return discounted;
    }
}
