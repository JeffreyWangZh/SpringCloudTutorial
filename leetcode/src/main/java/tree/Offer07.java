package tree;

import common.TreeNode;

import java.util.HashMap;

/**
 * @Author jw9j
 * @create 2021/6/13 3:01
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *
 */
public class Offer07 {
    int[] preorder;
    HashMap<Integer,Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preoder,int[] inorder){
        if (preoder.length == 0 || inorder.length == 0 || preoder.length!=inorder.length) return null;
        this.preorder = preoder;
        for(int i=0;i<inorder.length;i++)
            dic.put(inorder[i],i);
        return recur(0,0,inorder.length-1);
    }
    TreeNode recur(int root, int left, int right){
        if(left>right) return null;
        TreeNode node = new TreeNode(preorder[root]);
        int i = dic.get(preorder[root]);
        node.left = recur(root+1,left,i-1);
        node.right = recur(root+i-left+1,i+1,right);
        return node;
    }
}
