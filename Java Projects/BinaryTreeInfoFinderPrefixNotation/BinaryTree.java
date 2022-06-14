/*
 * Author: Thomas, Lindley
 * Project: CMSC 350 Project 3
 * Date: 09/29/2020
 * Class Description: This class creates a binary tree from supplied input, checks parentheses syntax, and provides
 * methods to operate on the object
 */

import java.util.Stack;

public class BinaryTree {
    public Node root;

    private static class Node {
        char c;
        Node linkLeft;
        Node linkRight;

        Node(char c) {
            this.c = c;
            linkLeft = null;
            linkRight = null;

        }

        public void setLeft(Node link) {
            linkLeft = link;
        }

        public void setRight(Node link) {
            linkRight = link;
        }
    }

    BinaryTree(String input) throws InvalidTreeSyntax {
        char[] chars = input.toCharArray();

        root = treeCreate(chars, 1, chars.length - 2);

        //Check syntax
        Stack<Character> pCheck = new Stack<Character>();
        String parentheses = "";
        for (char aChar : chars) {
            if (aChar == '(') {
                parentheses += "(";
            } else if (aChar == ')') {
                parentheses += (")");
            }
        }
        System.out.println(parentheses);
        for (char st : parentheses.toCharArray()) {
            if (st == '(') {
                pCheck.push(st);
            } else {
                if (pCheck.isEmpty()) {
                    throw new InvalidTreeSyntax("Invalid syntax, check parentheses.");
                }
                char p = (Character) pCheck.peek();
                if (st == ')' && p == '(') {
                    pCheck.pop();
                }
            }
        }
        if (!pCheck.isEmpty()) {
            throw new InvalidTreeSyntax("Invalid syntax, check parentheses.");
        }
    }

    public int findIndex(char[] chars, int startIndex, int endIndex) throws InvalidTreeSyntax {
        Stack<Character> cStack = new Stack<Character>();
        if (startIndex > endIndex) return -1;
        for (int i = startIndex; i <= endIndex; i++) {
            if (chars[i] == '(') {
                cStack.push(chars[i]);
            } else if (chars[i] == ')') {
                if (cStack.peek() == '(') {
                    cStack.pop();
                }
                if (cStack.isEmpty()) {
                    return i;
                }
            }
        }
        return -1;
    }

    public Node treeCreate(char[] chars, int startIndex, int endIndex) throws InvalidTreeSyntax {
        Node node;
        if (startIndex > endIndex) {
            return null;
        } else {
            node = new Node(chars[startIndex]);
        }
        int index = -1;
        if (startIndex + 1 <= endIndex && chars[startIndex + 1] == '(') {
            index = findIndex(chars, startIndex + 1, endIndex);
        }
        if (index != -1) {
            node.setLeft(treeCreate(chars, startIndex + 2, index - 1));
            node.setRight(treeCreate(chars, index + 2, endIndex - 1));
        }
        return node;
    }

    public boolean balanced() {
        return balancedRec(this.root);
    }

    private boolean balancedRec(Node node) {
        if (node == null) {
            return true;
        }
        return (Math.abs(heightRec(node.linkLeft) - heightRec(node.linkRight)) <= 1) &&
                (balancedRec(node.linkLeft) && balancedRec(node.linkRight));
    }

    public boolean proper() {
        return properRec(this.root);
    }

    private boolean properRec(Node node) {
        if (node == null) {
            return true;
        } else if ((node.linkLeft == null && node.linkRight != null) || (node.linkLeft != null && node.linkRight == null)) {
            return false;
        } else return properRec(node.linkLeft) && properRec(node.linkRight);
    }

    public boolean full() {
        return fullRec(root);
    }

    private boolean fullRec(Node node) {
        if (node == null) return true;
        if (node.linkLeft == null && node.linkRight == null) return true;
        if (node.linkLeft != null && node.linkRight != null) {
            return (fullRec(node.linkLeft) && fullRec(node.linkRight));
        }
        return false;
    }

    public int height() {
        return heightRec(this.root);
    }

    private int heightRec(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(heightRec(node.linkLeft), heightRec(node.linkRight));
    }

    public int nodes() {
        return nodesRec(this.root);
    }

    private int nodesRec(Node node) {
        if (node == null) return 0;
        return 1 + nodesRec(node.linkLeft) + nodesRec(node.linkRight);
    }

    public String inOrder() {
        return inOrderRec(this.root);
    }

    private String inOrderRec(Node node) {
        if (node == null) return "";
        return "(" + inOrderRec(node.linkLeft) + node.c + inOrderRec(node.linkRight) + ")";
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
