package algo.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wingjay on 07/03/2018.
 * 中(前\后)序遍历
 *  1
 *   \
 *    3
 *   /
 *  2
 *  中: [ 1, 2, 3]
 *  前: [ 1, 3, 2]
 *  后: [ 2, 3, 1]
 */
public class OrderSearch {

    // 前序遍历，[ 依次打印左节点->把左节点押入栈->继续打印左节点至null->从栈弹出上一个左节点->指向其右节点 ]
    // https://leetcode.com/problems/binary-tree-preorder-traversal/description/
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                result.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return result;
    }

    // 后序
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur);
                cur = cur.right;
            } else {
                result.add(cur.val);
            }
        }
        return result;
    }

    // 中序遍历：一直把左节点压进栈，然后逐个弹出来，打印自身及右节点
    // https://leetcode.com/problems/binary-tree-inorder-traversal/description/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
