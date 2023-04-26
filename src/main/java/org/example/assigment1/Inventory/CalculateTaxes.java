package Inventory;

public class CalculateTaxes {

    public static String calculateTax(String typeOfItem, String priceOfItem, String quantityOfITem) {

        if (typeOfItem.equalsIgnoreCase("Raw")){
            double priceWithAddedTax = Double.parseDouble(priceOfItem) * Integer.parseInt(quantityOfITem);
            priceWithAddedTax = (priceWithAddedTax * 1.125);
            return String.valueOf(priceWithAddedTax);
        }
        else if (typeOfItem.equalsIgnoreCase("Manufactured")){
            double priceWithAddedTax = Double.parseDouble(priceOfItem) * Integer.parseInt(quantityOfITem);
            priceWithAddedTax = ((priceWithAddedTax * .125) + priceWithAddedTax)*1.02;
            return String.valueOf(priceWithAddedTax);
        }
        else if (typeOfItem.equalsIgnoreCase("Imported")){
            double priceWithAddedTax = Double.parseDouble(priceOfItem) * Integer.parseInt(quantityOfITem);
            priceWithAddedTax = priceWithAddedTax * 1.10;
            if (priceWithAddedTax <=100){
                priceWithAddedTax += 5;
            }
            else if (priceWithAddedTax >100 && priceWithAddedTax <= 200) {
                priceWithAddedTax += 10;
            }
            else {
                priceWithAddedTax = (priceWithAddedTax * 1.05);
            }
            return String.valueOf(priceWithAddedTax);
        }
        return "Not valid type of Item entered";
    }
}
