import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeTest {

    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        TreeNode treeNode1 = new TreeNode(20);
        treeNode.right = treeNode1;
        treeNode1.right = new TreeNode(25);
        treeNode1.left = new TreeNode(15);
        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.right = new TreeNode(5);
        treeNode2.left = new TreeNode(-5);
        treeNode.left = treeNode2;
        List<List<Integer>> lists = new TreeTest().levelOrder(treeNode);
        System.out.println("--");
        TreeNode.print(treeNode);
        TreeNode treeNode3 = invertTree(treeNode);
        TreeNode.print(treeNode);

        TreeNode treeNode4 = new TreeNode(1);
        compare(treeNode4.getLeft(), treeNode4.getRight());
        System.out.println(symmetric);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        checkFun01(root, 0);
        checkFun02(root);
        return resList;
    }

    //广度搜索 层遍历 DFS--递归方式
    public void checkFun01(TreeNode node, Integer deep) {
        if (node == null) return;
        deep++;

        if (resList.size() < deep) {
            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<Integer>();
            resList.add(item);
        }
        System.out.println(deep + ":" + node.val);
        resList.get(deep - 1).add(node.val);

        checkFun01(node.left, deep);
        checkFun01(node.right, deep);
    }


    //BFS--迭代方式--借助队列
    public void checkFun02(TreeNode node) {
        if (node == null) return;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(node);

        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<Integer>();
            int len = que.size();

            while (len > 0) {
                TreeNode tmpNode = que.poll();
                itemList.add(tmpNode.val);

                if (tmpNode.left != null) que.offer(tmpNode.left);
                if (tmpNode.right != null) que.offer(tmpNode.right);
                len--;
            }

            resList.add(itemList);
        }

    }

    /**
     * 翻转二叉树
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        TreeNode temp = root.getLeft();
        root.left = root.right;
        root.right = temp;
        invertTree(root.getLeft());
        invertTree(root.getRight());
        return root;
    }

    public static boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        }
        if (left != null && right != null && left.val != right.val) {
            return false;
        }
        boolean compare = compare(left.left, right.right);
        boolean compare1 = compare(left.right, right.left);
        return compare && compare1;
    }
}
