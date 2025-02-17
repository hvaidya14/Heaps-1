//TC : O(nlogk)
//SC : O(k)

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
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b) -> (a.val - b.val));
        for (ListNode list:lists) {
            if (list != null){
                q.add(list);
            }
        }
        while (!q.isEmpty()) {
            ListNode min = q.poll();
            if (min.next != null) {
                q.add(min.next);
            }
            curr.next = min;
            curr = min;
        }
        return dummy.next;
    }
}
