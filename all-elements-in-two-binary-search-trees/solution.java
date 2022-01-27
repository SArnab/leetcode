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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        final Deque<TreeNode> stk1 = new ArrayDeque<>();
        final Deque<TreeNode> stk2 = new ArrayDeque<>();
        
        final ArrayList<Integer> results = new ArrayList<>();
        while (root1 != null || root2 != null || !stk1.isEmpty() || !stk2.isEmpty()) {
            
            // We always want to traverse the left-sides of the node first
            while (root1 != null) {
                stk1.addFirst(root1);
                root1 = root1.left;
            }
            
            while (root2 != null) {
                stk2.addFirst(root2);
                root2 = root2.left;
            }
                
            // Pop from both stacks in-order onto the result array
            // Anytime we pop a node, we want to traverse its right side to get the larger values
            final TreeNode node1 = stk1.peekFirst();
            final TreeNode node2 = stk2.peekFirst();

            if (node2 == null || (node1 != null && node1.val <= node2.val)) {
                results.add(stk1.removeFirst().val);
                // By setting it to root1 / root2, on the next iteration we will push the left-side of this larger node onto the stack
                // aka "in-order" traversal
                root1 = node1.right;
            } else if (node1 == null || (node2 != null && node2.val <= node1.val)) {
                results.add(stk2.removeFirst().val);
                root2 = node2.right;
            }
        }
        
        return results;
    }
}