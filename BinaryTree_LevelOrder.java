/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    List<List<Integer>> list1 = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null){
            return list1;
        }
        Queue<TreeNode> queue =  new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int level = queue.size();
            
            for(int i=0; i<level; i++){
                TreeNode newnode = queue.poll();
                list.add(newnode.val);
                if(newnode.left != null){
                   queue.offer(newnode.left);
                }
                if(newnode.right != null){
                    queue.offer(newnode.right);
                }
            }
            list1.add(list);
        }
        return list1;
    }
}
