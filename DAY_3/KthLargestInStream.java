package DAY_3;

import java.util.PriorityQueue;

public class KthLargestInStream {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k = 0;

    public KthLargestInStream(int k) {
        this.k = k;
    }

    public void addElement(Integer a) {
        pq.offer(a);
        if (pq.size() > k) {
            pq.poll();
        }
    }

    public int getKthMaximum() {
        return pq.size() == k ? pq.peek() : -1;
    }

    public static void main(String[] args) {
        KthLargestInStream kl = new KthLargestInStream(3);
        int[] nums = { 1, 2, 3, 4, 5, 6 };
        for (int i = 0; i < nums.length; i++) {
            kl.addElement(nums[i]);
            if (kl.getKthMaximum() == -1) {
                System.out.println("Not enough elements ");
            } else {
                System.out.println("Third largest value: " + kl.getKthMaximum());
            }
        }
    }
}
