package com.dsa.tree.BinarySearchTree;

import com.dsa.tree.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dhanetwa on 7/17/2018.
 */
public class BST {
    public BinaryTreeNode root;

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    public BST(){
        root = null;
    }

    public void insertLeaf(int data){
        root = insertLeafRec(root, data);
    }

    public BinaryTreeNode insertLeafRec(BinaryTreeNode leaf, int data){
        if(leaf == null){
            leaf = new BinaryTreeNode(data);
            return leaf;
        }
        if(data < leaf.getData()){
            leaf.setLeft(insertLeafRec(leaf.getLeft(), data));
        }else if(data > leaf.getData()){
            leaf.setRight(insertLeafRec(leaf.getRight(), data));
        }
        return leaf;
    }

    public void inorderTraversal(BinaryTreeNode leaf){
        if(leaf != null) {
            inorderTraversal(leaf.getLeft());
            System.out.println(leaf.getData());
            inorderTraversal(leaf.getRight());
        }
    }

    public void preorderTraversal(BinaryTreeNode leaf){
        if(leaf != null) {
            System.out.println(leaf.getData());
            preorderTraversal(leaf.getLeft());
            preorderTraversal(leaf.getRight());
        }
    }

    public void postorderTraversal(BinaryTreeNode leaf){
        if(leaf != null) {
            postorderTraversal(leaf.getLeft());
            postorderTraversal(leaf.getRight());
            System.out.println(leaf.getData());
        }
    }

    public BinaryTreeNode search(BinaryTreeNode leaf, int data){
        if(leaf == null || data == leaf.getData()){
            return leaf;
        }
        if(data < leaf.getData()){
            leaf = search(leaf.getLeft(), data);
        }else if(data > leaf.getData()){
            leaf = search(leaf.getRight(), data);
        }
        return leaf;
    }

    public BinaryTreeNode searchWithoutRec(BinaryTreeNode node, int data){
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            BinaryTreeNode traverseNode = queue.poll();
            if(traverseNode.getData() == data){
                return traverseNode;
            }
            if(traverseNode != null){
                if(data < traverseNode.getData()){ // if(traverseNode.getLeft != null){ queue.offer(traverseNode.getLeft)} --> use this when not a BST
                    queue.offer(traverseNode.getLeft());
                }else if(data > traverseNode.getData()){
                    queue.offer(traverseNode.getRight());
                }
            }
        }
        return node;
    }

    public void delete(int data){ // not yet done
        BinaryTreeNode node = search(root, data);
        if(node == null){
            System.out.println("node not available in tree");
        }
        if(node.getLeft() == null && node.getRight() == null){
            node = null;
        }
    }

    public int findMaxByRec(BinaryTreeNode node){
        if(node == null){
            return Integer.MIN_VALUE;
        }
        int res = node.getData();
        int lres = findMaxByRec(node.getLeft());
        int rres = findMaxByRec(node.getRight());
        if(lres > res){
            res = lres;
        }else if(rres > res){
            res = rres;
        }
        return res;
    }

    public int findMaxUsingQueue(BinaryTreeNode node){
        int maxValue = 0;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (queue.isEmpty() != true){
            BinaryTreeNode traverseNode = queue.poll();
            if(traverseNode.getData() > maxValue){
                maxValue = traverseNode.getData();
            }
            if(traverseNode != null){
                if(traverseNode.getLeft() != null){
                    queue.offer(traverseNode.getLeft());
                }
                if(traverseNode.getRight() != null){
                    queue.offer(traverseNode.getRight());
                }
            }
        }
        return maxValue;
    }

    public int findTreeSize(BinaryTreeNode node){
        if(node == null){
            return 0;
        }
        System.out.println(node.getData());
        int leftCount = findTreeSize(node.getLeft());
        System.out.println(leftCount);
        int rightCount = findTreeSize(node.getRight());
        System.out.println(rightCount);
        return 1 + leftCount + rightCount;
    }

    public int findTreeSizeWithoutRec(){
        int count = 0;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            BinaryTreeNode traverseNode = queue.poll();
            count++;
            if(traverseNode.getLeft() != null){
                queue.offer(traverseNode.getLeft());
            }
            if(traverseNode.getRight() != null){
                queue.offer(traverseNode.getRight());
            }
        }
        return count;
    }

    public int getHeightWithoutRec(){
        return 0;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insertLeaf(5);
        bst.insertLeaf(3);
        bst.insertLeaf(10);
        bst.insertLeaf(2);
        bst.insertLeaf(4);
        bst.insertLeaf(8);
        bst.insertLeaf(15);
        System.out.println("inorder ::");
        bst.inorderTraversal(bst.getRoot());
        System.out.println("preorder ::");
        bst.preorderTraversal(bst.getRoot());
        System.out.println("postorder ::");
        bst.postorderTraversal(bst.getRoot());
        BinaryTreeNode searchedNode = bst.search(bst.getRoot(), 8);
        System.out.println(searchedNode != null ? "found" : "not found");
        BinaryTreeNode searchedNodeUsingQueue = bst.searchWithoutRec(bst.getRoot(), 8);
        System.out.println("without rec " + searchedNode != null ? "found" : "not found");
        //bst.delete(2);
        System.out.println("Max:" + bst.findMaxByRec(bst.getRoot()));
        System.out.println("Max using queue:" + bst.findMaxUsingQueue(bst.getRoot()));

        System.out.println("tree size without rec : "+ bst.findTreeSizeWithoutRec());
        System.out.println("tree size: "+ bst.findTreeSize(bst.getRoot()));
        System.out.println(bst.getHeightWithoutRec());
    }
}
