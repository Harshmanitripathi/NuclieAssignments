package org.example.assignment4.multithreading;

import org.example.assignment4.itemlist.Items;
import org.example.assignment4.itemlist.TaxUpdatedItem;

import java.util.List;

public class calculateTax implements Runnable{
    public List<Items> itemList;
    public List<TaxUpdatedItem> taxUpdatedItemList;
    public calculateTax(List<Items> itemList, List<TaxUpdatedItem> taxUpdatedItemList) {
        this.itemList = itemList;
        this.taxUpdatedItemList = taxUpdatedItemList;
    }
    @Override
    public void run() {
        for (Items items: itemList) {
            double priceOfItem = items.getPriceOfItem();
            int quantityOfITem = items.getQuantityOofItem();
            String typeOfItem = items.getTypeOfItem();
            double priceWithAddedTax=0.00;
            if (typeOfItem.equalsIgnoreCase("Raw")){
                priceWithAddedTax = priceOfItem * quantityOfITem;
                priceWithAddedTax = (priceWithAddedTax * 1.125);
            }
            else if (typeOfItem.equalsIgnoreCase("Manufactured")){
                priceWithAddedTax = priceOfItem * quantityOfITem;
                priceWithAddedTax = ((priceWithAddedTax * .125) + priceWithAddedTax)*1.02;
            }
            else if (typeOfItem.equalsIgnoreCase("Imported")) {
                priceWithAddedTax = priceOfItem * quantityOfITem;
                priceWithAddedTax = priceWithAddedTax * 1.10;
                if (priceWithAddedTax <= 100) {
                    priceWithAddedTax += 5;
                } else if (priceWithAddedTax > 100 && priceWithAddedTax <= 200) {
                    priceWithAddedTax += 10;
                } else {
                    priceWithAddedTax = (priceWithAddedTax * 1.05);
                }
            }
            double taxPrice = priceWithAddedTax - priceOfItem*quantityOfITem;
            TaxUpdatedItem taxUpdatedItem = new TaxUpdatedItem(items.getNameOfItem(),priceOfItem,taxPrice,priceWithAddedTax);
            taxUpdatedItemList.add(taxUpdatedItem);
        }
    }
}
