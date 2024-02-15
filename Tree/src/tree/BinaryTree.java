package tree;

import java.util.Arrays;
import java.util.LinkedList;

public class BinaryTree {

    public static void main(String[] args) {
        // 以二叉树的先序遍历的顺序构建二叉树
        LinkedList<Integer> input = new LinkedList<>(Arrays.asList(1,2,4,null,null,null,3,null,5,null,null));
        TreeNode treeNode = createBinaryTree(input);

        System.out.println("\n二叉树先序遍历");
        preOrderTraversal(treeNode);
        System.out.println("\n二叉树中序遍历");
        inOrderTraversal(treeNode);
        System.out.println("\n二叉树后序遍历");
        postOrderTraversal(treeNode);
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


