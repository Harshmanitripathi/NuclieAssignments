package org.example.assignment4.itemlist;

public class TaxUpdatedItem {
    public String nameOfItem = "";
    public double priceOfItem = 0.00;
    public double taxprice = 0.00, totalPriceOfItem = 0.00;

    public String getNameOfItem() {
        return nameOfItem;
    }

    public void setNameOfItem(String nameOfItem) {
        this.nameOfItem = nameOfItem;
    }

    public double getPriceOfItem() {
        return priceOfItem;
    }

    public void setPriceOfItem(double priceOfItem) {
        this.priceOfItem = priceOfItem;
    }

    public double getTaxprice() {
        return taxprice;
    }

    public void setTaxprice(double taxprice) {
        this.taxprice = taxprice;
    }

    public double getTotalPriceOfItem() {
        return totalPriceOfItem;
    }

    public void setTotalPriceOfItem(double totalPriceOfItem) {
        this.totalPriceOfItem = totalPriceOfItem;
    }

    public TaxUpdatedItem(String nameOfItem, double priceOfItem, double taxprice, double totalPriceOfItem) {
        this.nameOfItem = nameOfItem;
        this.priceOfItem = priceOfItem;
        this.taxprice = taxprice;
        this.totalPriceOfItem = totalPriceOfItem;
    }
}