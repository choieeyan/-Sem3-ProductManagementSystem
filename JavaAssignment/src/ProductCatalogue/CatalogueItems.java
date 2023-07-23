package ProductCatalogue;

import Data.TextAccess;
import java.io.FileNotFoundException;
import javaassignment.Product;

public class CatalogueItems extends Product{
    protected double discountAmnt; 

    public CatalogueItems() {
    }
    
    public CatalogueItems(int pid, String pname, String pbrand, String pdescription, int pquantity, float pretailprice, String psupplierinfo, String pCategory, double discountAmnt) {
        super(pid, pname, pbrand, pdescription, pquantity, pretailprice, psupplierinfo, pCategory);
        this.discountAmnt = discountAmnt;
    }

    public CatalogueItems(int pid, String pname, String pbrand, String pdescription, int pquantity, float pretailprice, String pimage, String psupplierinfo, String pCategory, double discountAmnt) {
        super(pid, pname, pbrand, pdescription, pquantity, pretailprice, pimage, psupplierinfo, pCategory);
        this.discountAmnt = discountAmnt;
    }

    public void setDiscountAmnt(double discountAmnt) {
        this.discountAmnt = discountAmnt;
    }

    public double getDiscountAmnt() {
        return discountAmnt;
    }
    
    public String create(String cID){
        TextAccess TA = new TextAccess(); 
        TA.setFileName(cID + ".txt"); 
        String data = String.join("|",
                Integer.toString(pID), pName, pBrand, pDescription, Integer.toString(pQuantity), Float.toString(pRetailPrice), pSupplierInfo, pCategory, Double.toString(discountAmnt), cID);
        boolean ok = TA.write(data);
        if (ok) {
            return cID;
        } else {
            return null;
        } 
    }


    
    public static void main(String[] args) throws FileNotFoundException{
        
        
    }    
}
