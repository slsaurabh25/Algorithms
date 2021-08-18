import java.util.*;

class TreeNode {
    public int value;
    public List<TreeNode> children = new LinkedList<>();

    public TreeNode(int rootValue) {
        value = rootValue;
    }

}

public class example2 {

    public static void main(String[] args) throws Exception {

        Map<Integer, Integer> childParentMap = new HashMap<>(10);
        /*childParentMap.put(9, 10);
        childParentMap.put(8, 10);
        childParentMap.put(7, 10);
        childParentMap.put(6, 9);
        childParentMap.put(5, 9);
        childParentMap.put(4, 8);
        childParentMap.put(3, 8);
        childParentMap.put(2, 7);
        childParentMap.put(1, 7);*/

        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int i=0;i<testCases-1;i++) {

            int parent  = sc.nextInt();
            int child  = sc.nextInt();
            childParentMap.put(child, parent);
        }

        // All children in the tree
        Collection<Integer> children = childParentMap.keySet();

        // All parents in the tree
        Collection<Integer> values = childParentMap.values();

        // Using extra space here as any changes made to values will
        // directly affect the map
        Collection clonedValues = new HashSet();
        for (Object value : values) {
            clonedValues.add(value);
        }

        // Find parent which is not a child to any node. It is the
        // root node
        clonedValues.removeAll(children);

        // Some error handling
        if (clonedValues.size() != 1) {
            throw new Exception("More than one root found or no roots found");
        }

        int rootValue = (int) clonedValues.iterator().next();
        TreeNode root = new TreeNode(rootValue);

        HashMap<Object, TreeNode> valueNodeMap = new HashMap<>();
        // Put the root node into value map as it will not be present
        // in the list of children
        valueNodeMap.put(root.value, root);

        // Populate all children into valueNode map
        for (Object child : children) {
            TreeNode valueNode = new TreeNode((Integer) child);
            valueNodeMap.put(child, valueNode);
        }

        // Now the map contains all nodes in the tree. Iterate through
        // all the children and
        // associate them with their parents
        for (Object child : children) {
            TreeNode childNode = valueNodeMap.get(child);
            int parent = childParentMap.get(child);
            TreeNode parentNode = valueNodeMap.get(parent);
            parentNode.children.add(childNode);
        }

        System.out.println("Height of tree is : " +
                maxDepth(root.children));
    }

    public static int maxDepth(List<TreeNode> node)
    {
        if (node == null)
            return 0;
        else
        {
            /* compute the depth of each subtree */
            int lDepth = 0;
            for (int i=0; i<node.size()-1;i++) {
                lDepth = maxDepth(node.get(i).children);
            }
            return (lDepth + 1);
        }
    }

}
