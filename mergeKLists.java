// Time Complexity : O(nLogk)
// Space complexity : O(k)
/* Approach : we use a priority queue (min-heap) to keep track of the smallest node among the heads of the lists. 
We repeatedly extract the smallest node from the heap, add it to the result list, and if the extracted node has a next node, 
we add that next node to the heap. This process continues until the heap is empty, ensuring that the merged list is sorted.
 */
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
        // Create a priority queue (min-heap) to store the nodes, ordered by their values
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Create a dummy node to serve as the head of the result list
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        
        // Add the head of each list to the priority queue
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }            
        }
        
        // Process the priority queue until it is empty
        while (!pq.isEmpty()) {
            // Extract the node with the smallest value
            ListNode min = pq.poll();
            // Add it to the result list
            curr.next = min;
            // If the extracted node has a next node, add it to the priority queue
            if (min.next != null) {
                pq.add(min.next);
            }
            // Move to the next node in the result list
            curr = curr.next;
        }
        
        // Return the merged list, starting from the node after the dummy node
        return result.next;
    }
}
