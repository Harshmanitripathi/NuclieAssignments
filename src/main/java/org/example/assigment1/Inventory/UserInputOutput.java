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
        String nameOfItem="";
        String nameOfItemWithSpaces[];
        double priceOfItem=0;
        int quantityOfItem=0;
        String typeOfItem="";
        double priceOfItemIncludingTax=0.00;
        double taxOnItem=0.00;
        double totalPriceForItem = 0.00;
        while (true) {
            if (item.size() >= 1){
                System.out.print("Do you want to enter new Item (Y/N)");
                String decisionTaken = sc.next();
                if (decisionTaken.equalsIgnoreCase("n")) {
                    break;
                }
                sc.nextLine();
            }
            while(true) {
                int i=0;
                System.out.print("name- ");
                nameOfItemWithSpaces = sc.nextLine().split(" ");
                while (i < nameOfItemWithSpaces.length-1){
                    nameOfItem += nameOfItemWithSpaces[i++]+" ";
                }
                nameOfItem += nameOfItemWithSpaces[nameOfItemWithSpaces.length-1];
                if (Validation.validateForName(nameOfItem)) {
                    break;
                }
            }
            while (true) {
                System.out.print("price- ");
                String priceOfItemInString = sc.next();
                if (Validation.validateForDoubleValues(priceOfItemInString)) {
                    priceOfItem = Double.parseDouble(priceOfItemInString);
                    break;
                }
            }
            while (true) {
                System.out.print("quantity- ");
                String quantityOfItemInInteger = sc.next();
                    if (Validation.validateForDoubleValues(String.valueOf(quantityOfItem))) {
                        quantityOfItem = Integer.parseInt(quantityOfItemInInteger);
                        break;
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
            priceOfItemIncludingTax = Double.parseDouble(CalculateTaxes.calculateTax(typeOfItem,priceOfItem,quantityOfItem));
            taxOnItem = priceOfItemIncludingTax - priceOfItem;
            totalPriceForItem = priceOfItemIncludingTax * quantityOfItem;
            productDetails = new ProductDetails(nameOfItem,priceOfItem,quantityOfItem,typeOfItem,taxOnItem,totalPriceForItem);
            nameOfItem = "";
            item.add(productDetails);
        }
        System.out.println("Displaying the list of items");
        showItemsListed();
    }
    public static void showItemsListed(){
        System.out.println("ItemName \t ItemPrice \t TaxOnItem \t TotalPrice");
        for (ProductDetails items: item) {
            System.out.printf("%-15s %-10.2f %-10.2f %.2f",items.getItemName(),items.getItemPrice(),items.getTaxOfItem(),items.getTotalPriceOfItem());
            System.out.println();
        }
    }
}
