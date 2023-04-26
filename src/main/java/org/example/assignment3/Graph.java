package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Graph {

    public static void displayDFS(int element, Map<Integer, List<Integer>> particularMember, int[] vis)
    {
            vis[element] = 1;
            for (int node : particularMember.get(element)) {
                if (vis[node] == 0) {
                    System.out.print(node + "->");
                    displayDFS(node, particularMember, vis);
                }
            }
        System.out.println();
    }

    public static boolean checkForCircle(int element, Map<Integer, List<Integer>> particularMember, int[] vis, int[] dfsvis) {
        vis[element] = 1;
        dfsvis[element]=1;
        for (int node: particularMember.get(element)){
            if (vis[node] == 0){
                if (checkForCircle(node, particularMember, vis, dfsvis))
                    return true;
            } else if (dfsvis[node]>0) {
                return true;
            }
        }
        dfsvis[element]=0;
        return false;
    }

    public static void displayParent(int element, Map<Integer, List<Integer>> particularMember, int[] visForParent, int nodeForParent, ArrayList<Integer> pathForParent)
    {
        visForParent[element] =1;
        for (int node: particularMember.get(element))
        {
            if (visForParent[node] == 0)
            {

                if (node == nodeForParent){
                    System.out.print("we have found the path: ");
                    for (int showPath: pathForParent) {
                        System.out.print(showPath+"->");
                    }
                    return;
                }
                pathForParent.add(node);
                displayParent(node, particularMember, visForParent, nodeForParent,pathForParent);
            }
        }
        visForParent[element]=0;

    }
}
