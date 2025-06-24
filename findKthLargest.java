// Time Complexity : O(nLogk)
// Space complexity : O(k)
/* Approach : we use a min-heap (priority queue) to keep track of the k largest elements. As we iterate through the array, 
we add each element to the heap. If the heap's size exceeds k, we remove the smallest element, ensuring the heap always 
contains the k largest elements encountered so far. After processing all elements, the smallest element in the heap 
is the k-th largest in the array.
 
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Create a min-heap (priority queue) to store the k largest elements
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // Iterate through each number in the array
        for (int num : nums) {
            // Add the current number to the priority queue
            pq.add(num);
            
            // If the size of the priority queue exceeds k, remove the smallest element
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        // The top element of the priority queue is the k-th largest element
        return pq.peek();
    }
}
