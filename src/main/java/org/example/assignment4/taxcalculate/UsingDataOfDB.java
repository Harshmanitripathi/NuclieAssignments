package org.example.assignment4.taxcalculate;

import org.example.assignment4.itemlist.Items;
import org.example.assignment4.itemlist.TaxUpdatedItem;
import org.example.assignment4.multithreading.ItemCollect;
import org.example.assignment4.multithreading.calculateTax;

import java.util.ArrayList;
import java.util.List;

public class UsingDataOfDB {

    public static void multithreading() throws InterruptedException {
        String urlOfDB = "jdbc:mysql://localhost:3306/mysql1?serverTimezone=UTC";
        String username = "root";
        String password = "Harsh@12345";
        List<Items> itemList = new ArrayList<Items>();
        List<TaxUpdatedItem> taxUpdatedItemList = new ArrayList<TaxUpdatedItem>();
        Thread itemCollect = new Thread(new ItemCollect(itemList,urlOfDB,username,password));
        itemCollect.start();
        itemCollect.join();
        Thread itemCalculateTax = new Thread(new calculateTax(itemList,taxUpdatedItemList));
        itemCalculateTax.start();
        itemCalculateTax.join();
        System.out.println("ItemName \t ItemPrice \t Tax \t TotalPrice");
        for (TaxUpdatedItem item: taxUpdatedItemList) {
            System.out.println(item.getNameOfItem()+"\t \t"+item.getPriceOfItem()+"\t \t \t"+item.getTaxprice()+"\t \t"+item.getTotalPriceOfItem());
        }
    }
}
