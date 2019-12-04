package io.lovepoem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GetNodeCountBinaryTreeOneLevel {

    public static class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private String value;

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

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public TreeNode(String value) {
            this.value = value;
        }

        public TreeNode() {
        }
    }

    /*

     */
    public static int traverseTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        TreeNode left = node.getLeft();
        int count = 0;
        if (left != null) {
            traverseTree(left);
        }
        TreeNode right = node.getRight();
        if (right != null) {
            traverseTree(right);
        }
        return count;
    }

    public static Integer count(TreeNode node, int levelReq) {
        List<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(node);
        queue.add(null);
        int count = 0;
        int level = 0;
        System.out.println(queue);
        for (int i = 0; i < queue.size(); i++) {
            TreeNode n = queue.get(i);
            if (n == null) {
                level++;
                System.out.println(level + ":" + count);
                if (levelReq == level) {
                    return count;
                }
                count = 0;
                if (i == queue.size() - 1) {
                    break;
                } else {
                    queue.add(null);
                }
            } else {
                count++;
                if (n.getLeft() != null) {
                    queue.add(n.getLeft());
                }
                if (n.getRight() != null) {
                    queue.add(n.getRight());
                }
            }
        }
        return null;
    }


    public static int traverseTreeLevel(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node != null) {
            Queue<TreeNode> linkedList = new LinkedList<TreeNode>();
            linkedList.offer(node);
            int level = 0;
            int count = 0;
            while (!linkedList.isEmpty()) {
                node = linkedList.poll();
                level++;
                if (node.getLeft() != null) {
                    linkedList.offer(node.getLeft());
                    count++;
                }
                if (node.getRight() != null) {
                    linkedList.offer(node.getRight());
                    count++;
                }
            }
            System.out.println(level+ "-----" + count);
        }
        return 0;
    }

    /*
            A
         B     C
       D   E      G
             F
     */
    public static void main(String[] args) {
        TreeNode nodeA = new TreeNode("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");
        TreeNode nodeD = new TreeNode("D");
        TreeNode nodeE = new TreeNode("E");
        TreeNode nodeF = new TreeNode("F");
        TreeNode nodeG = new TreeNode("G");
        nodeA.setLeft(nodeB);
        nodeA.setRight(nodeC);
        nodeB.setLeft(nodeD);
        nodeB.setRight(nodeE);
        nodeE.setRight(nodeF);
        nodeC.setRight(nodeG);
        //int total = traverseTree(nodeA);
        //int total = traverseTreeLevel(nodeA);
        int a = count(nodeA, 2);
        //System.out.println(total);
        // System.out.println("total==" + total);
    }
}
