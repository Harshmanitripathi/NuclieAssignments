package org.example.assignment4.multithreading;

import org.example.assignment4.itemlist.Items;
import org.example.assignment4.itemlist.TaxUpdatedItem;

import java.util.List;

public class CalculateTax extends Thread{
    public List<Items> itemList;
    public List<TaxUpdatedItem> taxUpdatedItemList;
    public CalculateTax(List<Items> itemList, List<TaxUpdatedItem> taxUpdatedItemList) {
        this.itemList = itemList;
        this.taxUpdatedItemList = taxUpdatedItemList;
    }
    @Override
    public void run() {
        if (itemList.size() == taxUpdatedItemList.size()) {
            while (itemList.size() == taxUpdatedItemList.size()) {
                try {
                    wait();
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        }
        for (Items items: itemList) {
            double priceOfItem = items.getPriceOfItem();
            int quantityOfITem = items.getQuantityOofItem();
            String typeOfItem = items.getTypeOfItem();
            double priceWithAddedTax=0.00;
            if (typeOfItem.equalsIgnoreCase("Raw")){
                priceWithAddedTax = priceOfItem * quantityOfITem;
                priceWithAddedTax = (priceOfItem * 12.5)/100;
            }
            else if (typeOfItem.equalsIgnoreCase("Manufactured")){
                priceWithAddedTax = priceOfItem * quantityOfITem;
                priceWithAddedTax = ((priceOfItem * 12.5)/100 + priceOfItem) * 2/100 + priceOfItem;
            }
            else if (typeOfItem.equalsIgnoreCase("Imported")) {
                priceWithAddedTax = priceOfItem * quantityOfITem;
                priceWithAddedTax = priceOfItem * 10/100 + priceOfItem;
                if (priceWithAddedTax <= 100) {
                    priceWithAddedTax += 5;
                } else if (priceWithAddedTax > 100 && priceWithAddedTax <= 200) {
                    priceWithAddedTax += 10;
                } else {
                    priceWithAddedTax = (priceWithAddedTax * 5)/100 + priceWithAddedTax;
                }
            }
            double taxPrice = priceWithAddedTax - priceOfItem;
            TaxUpdatedItem taxUpdatedItem = new TaxUpdatedItem(items.getNameOfItem(),priceOfItem,taxPrice,priceWithAddedTax);
            taxUpdatedItemList.add(taxUpdatedItem);
        }
    }
}
