package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class BinaryTree {

    public static void main(String[] args) {
        // 以二叉树的先序遍历的顺序构建二叉树
        LinkedList<Integer> input = new LinkedList<>(Arrays.asList(1,2,4,null,null,null,3,null,5,null,null));
        TreeNode root = createBinaryTree(input);
        System.out.println("递归");
        System.out.println("\n二叉树先序遍历");
        preOrderTraversal(root);
        System.out.println("\n二叉树中序遍历");
        inOrderTraversal(root);
        System.out.println("\n二叉树后序遍历");
        postOrderTraversal(root);
        System.out.println("\n非递归");
        System.out.println("\n二叉树后序遍历");
        postOrderTraversalNonRecursive(root);

    }

    /**
     * 创建二叉树
     * @param input 输入列表
     */
    private static TreeNode createBinaryTree(LinkedList<Integer> input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        TreeNode node = null;

        // 返回并删除列表的第一个元素
        Integer data = input.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(input);
            node.rightChild = createBinaryTree(input);
        }

        return node;
    }

    /**
     * 二叉树先序遍历
     * @param node 二叉树节点
     */
    private static void preOrderTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderTraversal(node.leftChild);
            preOrderTraversal(node.rightChild);
        }
    }

    /**
     * 二叉树中序遍历
     * @param node 二叉树节点
     */
    private static void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.leftChild);
            System.out.print(node.data + " ");
            inOrderTraversal(node.rightChild);
        }
    }

    /**
     * 二叉树后序遍历
     * @param node 二叉树节点
     */
    private static void postOrderTraversal(TreeNode node) {
        if (node != null) {
            postOrderTraversal(node.leftChild);
            postOrderTraversal(node.rightChild);
            System.out.print(node.data + " ");
        }
    }

    /**
     *
     */
    private static void postOrderTraversalNonRecursive(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        // 指向前一个遍历过节点，初始值为null
        TreeNode pre = null;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.leftChild;
            }

            // 此时只要要访问节点，不能弹出该节点 反例（先序遍历）1,2,4,null,null,null,3,null,5,null,null
            cur = stack.peek();
            if (cur.rightChild != null && cur.rightChild != pre) {
                cur = cur.rightChild;
            } else {
                stack.pop();
                System.out.print(cur.data + " ");
                pre = cur;
                // 遍历过的节点应该赋值为null
                cur = null;
            }
        }
    }

    /**
     * 二叉树节点（嵌套类）
     */
    static class TreeNode {
        Integer data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(Integer data) {
            this.data = data;
        }
    }

}


