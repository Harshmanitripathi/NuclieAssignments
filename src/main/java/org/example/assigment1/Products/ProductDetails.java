package Products;

public class ProductDetails {
    String itemName,itemPrice,itemquantity,itemtype;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemquantity() {
        return itemquantity;
    }

    public void setItemquantity(String itemquantity) {
        this.itemquantity = itemquantity;
    }

    public String getItemtype() {
        return itemtype;
    }

    public void setItemtype(String itemtype) {
        this.itemtype = itemtype;
    }

    public ProductDetails(String itemName, String itemPrice, String itemquantity, String itemtype) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemquantity = itemquantity;
        this.itemtype = itemtype;
    }
}
