package org.example.assignment4.taxcalculate;

import org.example.assignment4.itemlist.Items;
import org.example.assignment4.itemlist.TaxUpdatedItem;
import org.example.assignment4.multithreading.ItemCollect;
import org.example.assignment4.multithreading.CalculateTax;
import java.util.ArrayList;
import java.util.List;


public class UsingDataOfDB {

    public static void fetchDataAndApplyTaxes() throws InterruptedException {

        List<Items> itemList = new ArrayList<Items>();
        List<TaxUpdatedItem> taxUpdatedItemList = new ArrayList<TaxUpdatedItem>();
        ItemCollect itemCollect = new ItemCollect(itemList);
        itemCollect.start();
        CalculateTax itemCalculateTax = new CalculateTax(itemList,taxUpdatedItemList);
        synchronized (itemCalculateTax) {
            itemCalculateTax.wait();
            itemCalculateTax.start();
        }
        System.out.println("ItemName \t ItemPrice \t Tax \t TotalPrice");
        for (TaxUpdatedItem item: taxUpdatedItemList) {
            System.out.println(item.getNameOfItem()+"\t \t"+item.getPriceOfItem()+"\t \t \t"+item.getTaxprice()+"\t \t"+item.getTotalPriceOfItem());
        }
    }
}
