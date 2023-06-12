package org.example.assignment4.multithreading;
import org.example.assignment4.itemlist.Items;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.assignment4.DataBaseDetails.*;

public class ItemCollect extends Thread{
    private final int capacity = 2;
    private List<Items> item;
    public ItemCollect(List<Items> items) {

        this.item = items;
    }
    @Override
    public void run() {
        try {
            //We have Created the connection here
            Connection connection = DriverManager.getConnection(URL_OF_DATABSE, USERNAME, PASSWORD);
            //now we need to set the statement for query
            Statement statement = connection.createStatement();
            String quaryStatement = "SELECT ItemName,ItemPrice,ItemQuantity,ItemType FROM new_table";
            //In-order to get the data from the database bases on columbh or row we use ResultSet
            ResultSet resultSet = statement.executeQuery(quaryStatement);
            System.out.println("result set"+resultSet.toString());

            while (resultSet.next()){
                String itemName = resultSet.getString("ItemName");
                double itemPrice = resultSet.getDouble("ItemPrice");
                int quantityOfItem = resultSet.getInt("ItemQuantity");
                String itemType = resultSet.getString("ItemType");
                Items itemsToAddUsingObject = new Items(itemName,itemPrice,quantityOfItem,itemType);
                item.add(itemsToAddUsingObject);
                notify();
            }
            System.out.println(resultSet.toString());
            //now we have fetched data from database so we need to close the connection.
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
