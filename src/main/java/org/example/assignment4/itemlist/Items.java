package org.example.assignment4.itemlist;

public class Items {
    String nameOfItem="",typeOfItem="";
    double priceOfItem=0.00;
    int quantityOofItem=0;

    public String getNameOfItem() {
        return nameOfItem;
    }

    public void setNameOfItem(String nameOfItem) {
        this.nameOfItem = nameOfItem;
    }

    public String getTypeOfItem() {
        return typeOfItem;
    }

    public void setTypeOfItem(String typeOfItem) {
        this.typeOfItem = typeOfItem;
    }

    public double getPriceOfItem() {
        return priceOfItem;
    }

    public void setPriceOfItem(double priceOfItem) {
        this.priceOfItem = priceOfItem;
    }

    public int getQuantityOofItem() {
        return quantityOofItem;
    }

    public void setQuantityOofItem(int quantityOofItem) {
        this.quantityOofItem = quantityOofItem;
    }

    public Items(String nameOfItem, double priceOfItem, int quantityOofItem, String typeOfItem) {
        this.nameOfItem = nameOfItem;
        this.typeOfItem = typeOfItem;
        this.priceOfItem = priceOfItem;
        this.quantityOofItem = quantityOofItem;
    }
}
