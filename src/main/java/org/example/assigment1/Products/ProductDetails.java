package org.example.assigment1.Products;

public class ProductDetails {
    String itemName;
    double itemPrice;
    int itemquantity;
    String itemtype;
    double taxOnItem;
    double totalPriceOfItem;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }
    public double getTaxOfItem() {
        return taxOnItem;
    }
    public double getTotalPriceOfItem() {
        return totalPriceOfItem;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemquantity() {
        return itemquantity;
    }

    public void setItemquantity(int itemquantity) {
        this.itemquantity = itemquantity;
    }

    public String getItemtype() {
        return itemtype;
    }

    public void setItemtype(String itemtype) {
        this.itemtype = itemtype;
    }

    public ProductDetails(String itemName, double itemPrice, int itemquantity, String itemtype , double taxOnItem, double totalPriceOfItem) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemquantity = itemquantity;
        this.itemtype = itemtype;
        this.taxOnItem = taxOnItem;
        this.totalPriceOfItem = totalPriceOfItem;
    }
    public String toStringName() {
        return this.getItemName()+"\t \t";
    }
    public double toStringItemPrice() {
        return this.getItemPrice();
    }
}
