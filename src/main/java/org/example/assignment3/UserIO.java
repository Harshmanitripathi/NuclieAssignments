package Tree;

import java.util.*;


public class UserIO {


   static ArrayList<Integer> nodesOfFamilyMember;
   static Map<Integer, List<Integer>> particularMember = new HashMap<>();
    public static void takeInput()
    {
        Scanner sc = new Scanner(System.in);
        nodesOfFamilyMember = new ArrayList<Integer>();int maxElement = 1000000;
        while (true) {
            System.out.println("Enter the nodes you want");
            String node = sc.next();
            if (node.equalsIgnoreCase("y"))
                break;
            maxElement = Math.max(Integer.parseInt(node),maxElement);
            nodesOfFamilyMember.add(Integer.parseInt(node));
            particularMember.put(Integer.parseInt(node), new ArrayList<>());
        }
        System.out.println("Enter the edge and type y if done with connections");

        while (true){
            System.out.print("enter source: ");
            int source = sc.nextInt();
            System.out.print("enter destination: ");
            int destination = sc.nextInt();
            System.out.println();
            addedgeOfEachNode(source,destination);
            String check = "";
            System.out.println("If you want to exit , type y");
            check = sc.next();
            if(check.equalsIgnoreCase("y"))
                break;
        }
        int vis[] = new int[maxElement];
        for (int element: nodesOfFamilyMember) {
            if (vis[element] == 0)
            {
                System.out.print("Particular element for dfs "+element+": ");
                Graph.displayDFS(element, particularMember, vis);
                System.out.println();
            }

        }


    }

    static void addedgeOfEachNode(int source , int destination){
        particularMember.get(source).add(destination);
    }

    public static void display() {
        for (int i: nodesOfFamilyMember)
        {
            if(particularMember.get(i).size() > 0)
            {
                System.out.print("Children for parent "+i+" is: ");
                for (int j: particularMember.get(i))
                {
                    System.out.print(j+"->");
                }
                System.out.println("End");
            }
        }
    }

    static boolean checkCircleInGraph(){
        int[] vis1 = new int[Collections.max(nodesOfFamilyMember) +1];
        int[] dfsvis = new int[Collections.max(nodesOfFamilyMember) +1];
        for (int i=0;i<vis1.length;i++){
            vis1[i] =0;
            dfsvis[i]=0;
        }
        boolean check=false;
        for (int element: nodesOfFamilyMember)
        {
            if (vis1[element] == 0)
            {
                if (Graph.checkForCircle(element, particularMember, vis1,dfsvis))
                {
                    check = true;
                    break;
                }
            }
        }
        if (check) {
            System.out.println("It contains a circle , please re-enter the graph");
            return true;
        }
        return false;
    }

    static void displayParent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the nodes whom you want parents");
        int nodeForPrents = sc.nextInt();
        int[] visForParent = new int[Collections.max(nodesOfFamilyMember) +1];
        ArrayList<Integer> pathofParent = new ArrayList<>();
        for (int i = 0; i < visForParent.length; i++)
            visForParent[i] = 0;
        for (int element: nodesOfFamilyMember)
        {
            if (visForParent[element] == 0) {
                pathofParent.add(element);
                Graph.displayParent(element, particularMember, visForParent, nodeForPrents, pathofParent);
            }
            pathofParent = new ArrayList<>();
        }
    }

    public static void displayChildren() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the node whom you want to see children: ");
        int i = sc.nextInt();
            if(particularMember.get(i).size() > 0)
            {
                System.out.print("Children for parent "+i+" is: ");
                for (int j: particularMember.get(i))
                {
                    System.out.print(j+"->");
                }
                System.out.println("End");
            }
            else if (!nodesOfFamilyMember.contains(i)){
                System.out.println("This element in removed form list");
            }
            else {
                System.out.println("Node donot exist");
            }

    }

//    As I made the adjacency list is form of Map<Integer, List<Integer>> particularMember = new HashMap<>();
//    ,if I need to delete a parent I just need to delete the key whole subtree will get deleted
//    but for deleteting a child I need to go by traditinal way to traverse by each key and to see if
//    the particular element is their child or not, an delete them if they exist.
    public static void deleteNode() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the node you want to delete: ");
        int nodeToDelete = sc.nextInt();boolean check=false;
        if (particularMember.containsKey(nodeToDelete)) {
            System.out.println("I am inside nodeTODelete");
            particularMember.remove(nodeToDelete);
            nodesOfFamilyMember.remove(Integer.valueOf(nodeToDelete));
            check =true;
        }
        else{
            for (int i: nodesOfFamilyMember){
                if (particularMember.get(i).contains(nodeToDelete)){
                    System.out.println("inside element to delete in arraylist");
                    (particularMember.get(i)).remove(nodeToDelete);
                    check = true;
                    break;
                    }
            }
        }
        if (check == false)
            System.out.println("element to be deleted not found");
        else
            display();
    }
}
