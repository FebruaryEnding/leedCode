import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public static void print(TreeNode tree) {
        Queue queue = new LinkedList();
        TreeNode last = null;
        TreeNode nlast = null;
        TreeNode tmpNode = null;
        queue.add(tree);
        last = tree;
        while (!queue.isEmpty()) {
            tmpNode = (TreeNode) queue.poll();
            if (null != tmpNode.getLeft()) {
                queue.add(tmpNode.getLeft());
                nlast = tmpNode.getLeft();
            }

            if (null != tmpNode.getRight()) {
                queue.add(tmpNode.getRight());
                nlast = tmpNode.getRight();
            }
            System.out.print(tmpNode.getVal()+" ");
            if (tmpNode.equals(last)) {
                System.out.println(" ");
                last = nlast;
            } else {
                continue;
            }
        }

    }
}