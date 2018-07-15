package com.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dhanetwa on 7/5/2018.
 */
public class BinaryTreeOperation {
    BinaryTreeNode insertNodeUsingQueueLevelOrder(BinaryTreeNode root, int data){
        if(root == null){
            return null;
        }
        Queue<BinaryTreeNode> binaryTreeNodeQueue = new LinkedList<>();
        binaryTreeNodeQueue.add(root);
        while(!binaryTreeNodeQueue.isEmpty()){
            BinaryTreeNode tmp = binaryTreeNodeQueue.poll();
            if(tmp != null){
                if(tmp.getLeft()!=null){
                    binaryTreeNodeQueue.add(tmp.getLeft());
                }
                else{
                    tmp.left = new BinaryTreeNode(data);
                    return root;
                }
            }
            if(tmp.getRight() != null){
                binaryTreeNodeQueue.add(tmp.getRight());
            }
            else{
                tmp.right = new BinaryTreeNode(data);
                return root;
            }
        }
        return root;
    }

    //recursive
    void insert(BinaryTreeNode root, int data){
        if(root == null){
            root = new BinaryTreeNode(data);
        }else{
            if(root.left == null){
                root.left = new BinaryTreeNode(data);
            }else if(root.right ==null){
                root.right = new BinaryTreeNode(data);
            }else{
                insert(root.right, data);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeOperation binaryTreeOperation = new BinaryTreeOperation();
        BinaryTreeNode root = new BinaryTreeNode(1);
        binaryTreeOperation.insertNodeUsingQueueLevelOrder(root, 2);
        binaryTreeOperation.insertNodeUsingQueueLevelOrder(root, 3);
        binaryTreeOperation.insertNodeUsingQueueLevelOrder(root, 4);
        binaryTreeOperation.insertNodeUsingQueueLevelOrder(root, 5);
        binaryTreeOperation.insertNodeUsingQueueLevelOrder(root, 6);
        binaryTreeOperation.insertNodeUsingQueueLevelOrder(root, 7);

        binaryTreeOperation.insert(root, 1);
        binaryTreeOperation.insert(root,2);
        binaryTreeOperation.insert(root,3);
        binaryTreeOperation.insert(root, 4);
        binaryTreeOperation.insert(root, 5);
        binaryTreeOperation.insert(root, 6);
        binaryTreeOperation.insert(root, 7);
    }
}
