package Tree;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        UserIO.takeInput();

        boolean continueWithOperation = true;
        while (true){
            System.out.println("Enter the thing you want to perform display=1, displayParent=2, displayChildren=3, deleteNode=4, checkingCircle=5 type anyother key to discontinue");
            String operation = sc.next();
        switch (operation) {
            case "1":
                UserIO.display();
                break;
            case "2":
                UserIO.displayParent();
                break;
            case "3":
                UserIO.displayChildren();
                break;
            case "4":
                UserIO.deleteNode();
                break;
            case "5":
                if (UserIO.checkCircleInGraph())
                    UserIO.takeInput();
                break;
            default:
                continueWithOperation = false;
                break;
        }
        if (!continueWithOperation)
            break;
        }

    }
}