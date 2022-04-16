package com.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dhanetwa on 7/5/2018.
 */
public class BinaryTreeOperation {
    private BinaryTreeNode root;

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    BinaryTreeNode insertNodeUsingQueueLevelOrder(BinaryTreeNode root, int data) {
        if (root == null) {
            return null;
        }
        Queue<BinaryTreeNode> binaryTreeNodeQueue = new LinkedList<>();
        binaryTreeNodeQueue.add(root);
        while (!binaryTreeNodeQueue.isEmpty()) {
            BinaryTreeNode tmp = binaryTreeNodeQueue.poll();
            if (tmp != null) {
                if (tmp.getLeft() != null) {
                    binaryTreeNodeQueue.add(tmp.getLeft());
                } else {
                    tmp.left = new BinaryTreeNode(data);
                    return root;
                }
            }
            if (tmp.getRight() != null) {
                binaryTreeNodeQueue.add(tmp.getRight());
            } else {
                tmp.right = new BinaryTreeNode(data);
                return root;
            }
        }
        return root;
    }

    //recursive

    public void insert(int data) {
        root = insert(root, data);
    }

    BinaryTreeNode insert(BinaryTreeNode node, int data) {
        if (node == null) {
            node = new BinaryTreeNode(data);
        } else {
            if (node.getRight() == null) {
                node.right = insert(node.right, data);
            } else {
                node.left = insert(node.left, data);
            }
        }
        return node;
    }

    void traverseTreePreorder(BinaryTreeNode node) {
        if (node != null) {
            System.out.println(node.getData());
            traverseTreePreorder(node.getLeft());
            traverseTreePreorder(node.getRight());
        }
    }

    public static void main(String[] args) {
        BinaryTreeOperation binaryTreeOperation = new BinaryTreeOperation();
        /*BinaryTreeNode root = new BinaryTreeNode(1);
        binaryTreeOperation.insertNodeUsingQueueLevelOrder(root, 2);
        binaryTreeOperation.insertNodeUsingQueueLevelOrder(root, 3);
        binaryTreeOperation.insertNodeUsingQueueLevelOrder(root, 4);
        binaryTreeOperation.insertNodeUsingQueueLevelOrder(root, 5);
        binaryTreeOperation.insertNodeUsingQueueLevelOrder(root, 6);
        binaryTreeOperation.insertNodeUsingQueueLevelOrder(root, 7);
*/
//        BinaryTreeNode root = new BinaryTreeNode(0);
        binaryTreeOperation.insert(1);
        binaryTreeOperation.insert(2);
        binaryTreeOperation.insert(3);
        binaryTreeOperation.insert(4);
        binaryTreeOperation.insert(5);
        binaryTreeOperation.insert(6);
        binaryTreeOperation.insert(7);

        binaryTreeOperation.traverseTreePreorder(binaryTreeOperation.getRoot());
    }
}
