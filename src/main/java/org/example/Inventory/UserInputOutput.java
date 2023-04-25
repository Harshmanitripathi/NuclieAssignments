package Inventory;

import ExceptionCheck.Validation;
import Products.ProductDetails;

import java.util.*;
import java.util.List;

public class UserInputOutput {

    static List<ProductDetails> item = new ArrayList<ProductDetails>();

    public static void takeItemDetails() {
        Scanner sc = new Scanner(System.in);
        String nameOfItem="",priceOfItem="",quantityOfItem="",typeOfItem="";
        while (true){
            if (item.size() >= 1){
                System.out.println("Do you want to enter new Item (Y/N)");
                String decisionTaken = sc.next();
                if (decisionTaken.equalsIgnoreCase("n")){
                    break;
                }
            }

            while(true) {
                System.out.println("Enter the name of item you want to enter");
                nameOfItem = sc.next();
                if (Validation.validateForName(nameOfItem)){
                    break;
                }
            }
            while (true) {
                System.out.println("Enter the price of item");
                priceOfItem = sc.next();
                if (Validation.validateUserInputForBadInput(priceOfItem)){
                    break;
                }
            }
            while (true) {
                System.out.println("Enter the quantity of item");
                quantityOfItem = sc.next();
                if (Validation.validateUserInputForBadInput(quantityOfItem)){
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
            priceOfItem = CalculateTaxes.calculateTax(typeOfItem,priceOfItem,quantityOfItem);
            ProductDetails productDetails = new ProductDetails(nameOfItem,priceOfItem,quantityOfItem,typeOfItem);
            item.add(productDetails);
        }
        System.out.println("Displaying the list of items");
        showItemsListed();
    }
    public static void showItemsListed(){
        System.out.println("ItemName \t ItemPrice \t Itemquantity \t ItemType");
        for (ProductDetails items: item) {
            System.out.println(items.getItemName()+"\t \t"+items.getItemPrice()+"\t \t \t"+items.getItemquantity()+"\t \t \t \t"+items.getItemtype());
            System.out.println();
        }
    }
}
