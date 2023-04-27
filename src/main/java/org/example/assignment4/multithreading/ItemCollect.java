package org.example.assignment4.multithreading;
import org.example.assignment4.itemlist.Items;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ItemCollect implements Runnable{
    private final int capacity = 2;
    private String urlOfDB;
    private String username;
    private String password;
    private List<Items> item;
    public ItemCollect(List<Items> items,String urlOfDB, String username, String password) {
        this.urlOfDB = urlOfDB;
        this.username = username;
        this.password = password;
        this.item = items;
    }
    @Override
    public void run() {
        try {
            //We have Created the connection here
            Connection connection = DriverManager.getConnection(urlOfDB, username, password);
            //now we need to set the statement for query
            Statement statement = connection.createStatement();
            String quaryStatement = "SELECT ItemName,ItemPrice,ItemQuantity,ItemType FROM new_table";
            //In-order to get the data from the database bases on columbh or row we use ResultSet
            ResultSet resultSet = statement.executeQuery(quaryStatement);
            System.out.println("result set"+resultSet.toString());
            synchronized (this) {
                while (item.size() > capacity) {
                    wait();
                }
            }
            while (resultSet.next()){
                String itemName = resultSet.getString("ItemName");
                double itemPrice = resultSet.getDouble("ItemPrice");
                int quantityOfItem = resultSet.getInt("ItemQuantity");
                String itemType = resultSet.getString("ItemType");
                Items itemsToAddUsingObject = new Items(itemName,itemPrice,quantityOfItem,itemType);
                item.add(itemsToAddUsingObject);
                notify();
                Thread.sleep(1);
            }
            System.out.println(resultSet.toString());
            //now we have fetched data from database so we need to close the connection.
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
