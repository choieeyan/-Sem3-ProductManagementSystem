/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaassignment;

import Data.FileAccess;
import Data.TextAccess;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Kum Hoe
 */
public class Product implements FileAccess{
    
    protected TextAccess FA;
    protected int pID, pQuantity;
    protected String pName, pBrand, pDescription, pImage, pSupplierInfo, pCategory;
    protected float pRetailPrice;   
    
    public Product(int pid, String pname, String pbrand, String pdescription, int pquantity ,float pretailprice, String pimage, String psupplierinfo, String pCategory) {
        this.pID = pid;
        this.pName = pname;
        this.pBrand = pbrand;
        this.pDescription = pdescription;
        this.pQuantity = pquantity;
        this.pRetailPrice = pretailprice;
        this.pImage = pimage;
        this.pSupplierInfo = psupplierinfo;
        this.pCategory = pCategory;
    }

    public Product(int pid, String pname, String pbrand, String pdescription, int pquantity, float pretailprice, String psupplierinfo, String pCategory) {
        this.pID = pid;
        this.pName = pname;
        this.pBrand = pbrand;
        this.pDescription = pdescription;
        this.pQuantity = pquantity;
        this.pRetailPrice = pretailprice;
        this.pSupplierInfo = psupplierinfo;
        this.pCategory = pCategory;
    }


    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpBrand() {
        return pBrand;
    }

    public void setpBrand(String pBrand) {
        this.pBrand = pBrand;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public int getpQuantity() {
        return pQuantity;
    }

    public void setpQuantity(int pQuantity) {
        this.pQuantity = pQuantity;
    }

    public float getpRetailPrice() {
        return pRetailPrice;
    }

    public void setpRetailPrice(float pRetailPrice) {
        this.pRetailPrice = pRetailPrice;
    }

    public String getpImage() {
        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage;
    }

    public String getpSupplierInfo() {
        return pSupplierInfo;
    }

    public void setpSupplierInfo(String pSupplierInfo) {
        this.pSupplierInfo = pSupplierInfo;
    }
    
    public String getpCategory() {
        return pCategory;
    }

    public void setpCategory(String pCategory) {
        this.pCategory = pCategory;
    }
    
    @Override
    public boolean remove(String id) {
        //remove the content
        ArrayList<String> old_list = FA.readAll();//existing content
        ArrayList<String> new_list = new ArrayList();
        //iterate each element in old_list
        for (String oldLine : old_list) {
            String[] split = oldLine.split("\\|");
            if (!split[0].equals(id)) { 
                new_list.add(oldLine); //keep the content that is not matching with the id
            }
        }
        //write the new_list element to the file
        if(new_list.size() > 0){
            try(PrintWriter out = new PrintWriter(new FileWriter("product.txt", false))) {
                for (String line : new_list) {
                    out.println(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }else{
            return false;
        }
    }    
        

    @Override
    public String  create(){
        String records = String.join("|",
                String.valueOf(pID), pName, pBrand, pDescription, String.valueOf(pQuantity), String.valueOf(pRetailPrice), pSupplierInfo, pCategory);
        boolean ok = FA.write(records);
            if(ok){
                return String.valueOf(pID);
            }
            else{
                return null;
            }
    }
    
    public boolean read() {
        boolean success = false;
        ArrayList<String> data = FA.readAll();
        
        for (String records : data) {
            String[] split = records.split("\\|");
            if (split[0].equals(pID)
                    && split[6].equals(pSupplierInfo)) {
                success = true;
                break;
            }
            else{
                return success;
            }
        }
        return false;
    }
        
    public Product(){
            FA = new TextAccess();
            FA.setFileName("product.txt");
    }

}
