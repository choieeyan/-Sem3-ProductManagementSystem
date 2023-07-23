/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaassignment;

import javaassignment.Product;
import java.util.Scanner;

/**
 *
 * @author Kum Hoe
 */
public class ProductConsole extends Product{
    private ProductManager pm;
    private Scanner sc;
    private int i;
    
    public ProductConsole(){
        this.sc = new Scanner(System.in);
        this.pm = new ProductManager();
    }
    
    private int Menu(){
        System.out.println("Product Menu");
        System.out.println("1. Add Product");
        System.out.println("2. Show All Product");
        System.out.println("3. Remove Product");
        System.out.println("0. Exit");
        int choice = readInt(0, 3);
    return choice;
    }

    public void Start(){
        while(true){
            int choice = Menu();
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    addProduct();
                    break;
                case 2:
                    showAll();
                    break;
                case 3:
                    removeProduct();
                    break;
                default:
                    throw new AssertionError();
                
            }
        }
    }
    
    private int readInt(int min, int max) {
        int choice;
        while(true){
            try{
                choice = Integer.parseInt(sc.nextLine());
                if(choice >= min && choice <= max){
                    break;
                }                         
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return choice;
    }
    
    private float readFloat(int min, float max){
        float pretailprice = 0;
        while(true){
            try{
                pretailprice = Float.parseFloat(sc.nextLine());
                if(pretailprice >= min && pretailprice <= max);
                break;
            }   
        catch(Exception e){
            System.out.println("Invalid value! Try to enter correct value!");
            }
        }
    return pretailprice;
    }

    
    
        
    private void addProduct(){
        System.out.println("Enter Product ID: ");
        int pid = readInt(0, Integer.MAX_VALUE);
        
        System.out.println("Enter Product Name ");
        String pname = sc.nextLine();
        
        System.out.println("Enter Product Brand: " );
        String pbrand = sc.nextLine();
        
        System.out.println("Enter Product Description: " );
        String pdescription = sc.nextLine();
        
        System.out.println("Enter Product Quantity: " );
        int pquantity = readInt(0, Integer.MAX_VALUE);
        
        System.out.println("Enter Product Retail Price: " );
        float pretailprice = readFloat(0, Float.MAX_VALUE);
        
        System.out.println("Enter Product Supplier Info: " );
        String psupplierinfo = sc.nextLine();
        
        System.out.println("Enter Product Category: " );
        String pcategory = sc.nextLine();
        
        Product p = new Product(pid, pname, pbrand, pdescription, pquantity, pretailprice, psupplierinfo, pcategory); 
        this.pm.addProduct(p);
        } 

    private void showAll() {
        System.out.println("--All Product--");
        System.out.println("ID\tName\tBrand\tDescription\tQuantity\tRetailPrice\tSupplierInfo\tCategory");
        for (int i = 0 ; i < this.pm.count(); i++) {
            Product p = this.pm.getProduct(i);
            System.out.println(p.getpID() + "\t" + p.getpName() + "\t" + p.getpBrand() + "\t" + p.getpDescription() + " \t " + "\t" + p.getpQuantity() + "\t" + "\t" + p.getpRetailPrice() + "\t" + "\t" + p.getpSupplierInfo() + "\t" + "\t" + p.getpCategory());
    }
    }

    private void removeProduct() {
        System.out.println("Enter product ID");
        int pid = readInt(0, Integer.MAX_VALUE);
        boolean result = this.pm.removeProduct(pid);
        if(result){
            System.out.println("Product was removed");   
        }
        else{
            System.out.println("Product not found");
        }
    }


}


