package org.example.assigment1.Inventory;
import org.example.assigment1.ExceptionCheck.Validation;
import org.example.assigment1.Products.ProductDetails;

import java.util.*;
import java.util.List;
public class UserInputOutput {
    static List<ProductDetails> item = new ArrayList<ProductDetails>();
    static ProductDetails productDetails;
    public static void takeItemDetails() {
        Scanner sc = new Scanner(System.in);
        String nameOfItem="";double priceOfItem=0;int quantityOfItem=0;String typeOfItem="";
        double priceOfItemIncludingTax=0.00, taxOnItem=0.00;
        while (true) {
            if (item.size() >= 1){
                System.out.println("Do you want to enter new Item (Y/N)");
                String decisionTaken = sc.next();
                if (decisionTaken.equalsIgnoreCase("n")) {
                    break;
                }
            }
            while(true) {
                System.out.println("Enter the name of item you want to enter");
                    nameOfItem = sc.next();
                if (Validation.validateForName(nameOfItem)) {
                    break;
                }
            }
            while (true) {
                System.out.println("Enter the price of item");
                try {
                    priceOfItem = Double.parseDouble(sc.next());
                    if (priceOfItem > 0) {
                        break;
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            while (true) {
                System.out.println("Enter the quantity of item");
                try {
                    quantityOfItem = Integer.parseInt(sc.next());
                    if (quantityOfItem > 0) {
                        break;
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            while (true) {
                System.out.println("Enter the type of item (Raw=R ,Manufactured=M ,Impported=I");
                 typeOfItem = sc.next();
                if (typeOfItem.equalsIgnoreCase("r")) {
                    typeOfItem = "Raw"; break;
                } else if (typeOfItem.equalsIgnoreCase("m")) {
                    typeOfItem = "Manufactured"; break;
                } else if (typeOfItem.equalsIgnoreCase("i")) {
                    typeOfItem = "Imported"; break;
                }
                System.out.println("Enter valid input for item type");

            }
            priceOfItemIncludingTax = CalculateTaxes.calculateTax(typeOfItem,priceOfItem,quantityOfItem);
            taxOnItem = priceOfItemIncludingTax - priceOfItem*quantityOfItem;
            productDetails = new ProductDetails(nameOfItem,priceOfItem,quantityOfItem,typeOfItem);
            item.add(productDetails);
        }
        System.out.println("Displaying the list of items");
        showItemsListed(priceOfItemIncludingTax,taxOnItem);
    }
    public static void showItemsListed(double priceOfItemIncludingTax, double taxOnItem){
        System.out.println("ItemName \t ItemPrice \t TaxOnItem \t TotalPrice");
        for (ProductDetails items: item) {
            System.out.println(items.getItemName()+"\t \t"+items.getItemPrice()+"\t \t"+taxOnItem+"\t \t \t"+priceOfItemIncludingTax);
            System.out.println();
        }
    }
}
