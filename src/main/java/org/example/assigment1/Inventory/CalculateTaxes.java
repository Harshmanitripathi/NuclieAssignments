package org.example.assigment1.Inventory;

import java.text.DecimalFormat;

public class CalculateTaxes {
//    objectForReducingToTwoDecimalPlaces object of class DecimalFormat is used to convert double value to 2 decimal places
    private static final DecimalFormat objectForReducingToTwoDecimalPlaces = new DecimalFormat("0.00");
    public static String calculateTax(String typeOfItem, double priceOfItem, int quantityOfITem) {
        double priceWithAddedTax=0.00;
        if (typeOfItem.equalsIgnoreCase("Raw")){
            priceWithAddedTax = priceOfItem * quantityOfITem;
            priceWithAddedTax = priceOfItem + ((priceOfItem * 12.5) /100);
        }
        else if (typeOfItem.equalsIgnoreCase("Manufactured")){
            priceWithAddedTax = priceOfItem * quantityOfITem;
            priceWithAddedTax = priceOfItem+(priceOfItem*12.5/100 + ((priceOfItem * 12.5)/100 + priceOfItem)*2/100);
        }
        else if (typeOfItem.equalsIgnoreCase("Imported")){
            priceWithAddedTax = priceOfItem * quantityOfITem;
            priceWithAddedTax = priceOfItem + (priceOfItem *10)/100 ;
            if (priceWithAddedTax <=100){
                priceWithAddedTax += 5;
            } else if (priceWithAddedTax >100 && priceWithAddedTax <= 200) {
                priceWithAddedTax += 10;
            } else {
                priceWithAddedTax = (priceWithAddedTax * 5)/100 + priceWithAddedTax;
            }

        } else {
            return typeOfItem + " is not belonging to any type of item";
        }
        return objectForReducingToTwoDecimalPlaces.format(priceWithAddedTax);
    }
}
