public class SalesPathSolution {

    static class Node {
        int cost;
        Node[] children;
        Node parent;

        Node(int cost) {
            this.cost = cost;
            children = null;
            parent = null;
        }
    }

    static class SalesPath {
        static int minSum = Integer.MAX_VALUE;
        int getCheapestCost(Node rootNode) {

            // your code goes here
            if (rootNode == null)
                return minSum;
            //helper(rootNode, minSum, rootNode.cost);
            helper(rootNode, rootNode.cost);
            return minSum;
        }

        //void helper(Node rootNode, int minSum, int runningSum) {
        void helper(Node rootNode, int runningSum) {

            if (rootNode.children == null) {
                if (minSum > runningSum)
                    minSum = runningSum;
                return;
            }
            for (Node child : rootNode.children)
                //helper(child, minSum,runningSum + child.cost);
                helper(child, runningSum + child.cost);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(0);

        Node root5 = new Node(5);
        Node root4 = new Node(4);
        Node root3 = new Node(3);
        Node root2 = new Node(2);
        Node root1 = new Node(1);
        Node root11 = new Node(1);
        Node root0 = new Node(0);
        Node root10 = new Node(10);
        Node root6 = new Node(6);
        Node root111 = new Node(1);
        Node root55 = new Node(5);


        root6.children = new Node[] { root111, root55};
        root0.children = new Node[] { root10};
        root1.children = new Node[] {root11};
        root2.children = new Node[] { root1};
        root3.children = new Node[] { root2, root0};
        root5.children = new Node[] { root4};

        root.children = new Node[]{root5, root3, root6};

        SalesPath salesPath = new SalesPath();
        System.out.println(salesPath.getCheapestCost(root));
    }
}
