package com.general.tree.binary;

/**
 * Created by dhanetwa on 2/28/2018.
 */
class Node{
    int data;
    Node left;
    Node right;
    public Node() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }
    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}

class Tree{
     private Node node;

    public Tree() {
        this.node = null;
    }

    public void insert(int data){
        node = insertNode(node, data);
    }

    public Node insertNode(Node node, int data){
        if(node == null){
            return new Node(data);
        }else{
            if(data <= node.data){
                node.left = insertNode(node.left, data);
            }else{
                node.right = insertNode(node.right, data);
            }
        }
        return node;
    }

    public void delete(int data){
        /*node = searchNode(data);
        node = null;*/
        if(data == node.data){
            node = null;
        }else if(data <= node.data){
            node = node.left;
            node = searchNode(data);
        }else{
            node = node.right;
            node = searchNode(data);
        }
    }

    public Node searchNode(int data){
        if(data == node.data){
            return node;
        }else if(data<=node.data){
            node = node.left;
            node = searchNode(data);
        }else{
            node = node.right;
            node = searchNode(data);
        }
        return node;
    }
}
public class MyBinarySearchTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(40);
        tree.delete(10);
    }
}
