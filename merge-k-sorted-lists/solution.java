/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        
        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = mergeTwo(result, lists[i]);
        }
        
        return result;
    }
    
    private ListNode mergeTwo(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        
        if (b == null) {
            return a;
        }
        
        ListNode head = null;
        ListNode curr = null;
        
        while (a != null || b != null) {     
            int val = 0;
            
            if (a == null) {
                // a is done, we can append the rest of b eagerly and exit
                curr.next = b;
                break;
            }
            
            if (b == null) {
                // b is done, we can append the rest of a eagerly and exit
                curr.next = a;
                break;
            }
            
            if (a != null && a.val <= b.val) {
                val = a.val;
                a = a.next;
            } else if (b != null && b.val <= a.val) {
                val = b.val;
                b = b.next;
            }
            
            final ListNode nextNode = new ListNode(val);
            if (curr == null) {
                curr = nextNode;
            } else {
                curr.next = nextNode;
                curr = nextNode;
            }
            
            if (head == null) {
                head = curr;
            }
        }
        
        return head;
    }
}