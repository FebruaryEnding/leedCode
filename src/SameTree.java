/**
 * https://leetcode-cn.com/problems/same-tree/
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1:
 * <p>
 * 输入:       1         1
 * / \       / \
 * 2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * <p>
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:      1          1
 * /           \
 * 2             2
 * <p>
 * [1,2],     [1,null,2]
 * <p>
 * 输出: false
 * 示例 3:
 * <p>
 * 输入:       1         1
 * / \       / \
 * 2   1     1   2
 * <p>
 * [1,2,1],   [1,1,2]
 * <p>
 * 输出: false
 */
public class SameTree {

    private boolean result = true;
    //做个二叉树遍历不就完事了吗
    public boolean isSameTree(TreeNode p, TreeNode q) {
        this.compareTree(p, q);
        return result;
    }

    private void compareTree(TreeNode p, TreeNode q) {
        if(q != null && p != null) {
            if (p.val != q.val) {
                result = false;
            } else {
                if (p.left != null && q.left != null) {
                    compareTree(p.left, q.left);
                }
                if (p.right != null && q.right != null) {
                    compareTree(p.right, q.right);
                }
                if (p.right == null && q.right == null) {
                    return;
                }
                if (p.right == null && q.right != null) {
                    result = false;
                }
                if (p.right != null && q.right == null) {
                    result = false;
                }
                if (p.left == null && q.left != null) {
                    result = false;
                }
                if (p.left != null && q.left == null) {
                    result = false;
                }
            }
        }else if(q == null && p == null){

        }else {
            result = false;
        }
    }

    public void iterableTree(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.println(treeNode.val);
            if (treeNode.left != null) {
                iterableTree(treeNode.left);
            }
            if (treeNode.right != null) {
                iterableTree(treeNode.right);
            }
        }
    }


    public static void main(String[] args) {
        SameTree sameTree = new SameTree();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
//        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        TreeNode t = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
//        t.left = t1;
        t.right = t2;
        boolean sameTree1 = sameTree.isSameTree(treeNode, t);
        System.out.println(sameTree1);
//        sameTree.iterableTree(treeNode);
//        sameTree.iterableTree(treeNode1);
    }

}

