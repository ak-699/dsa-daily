package DAY_5;

public class MaxConsecutiveOnes {
    public static int get(int[] arr) {
        int maxi = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
                maxi = Math.max(maxi, count);
            } else
                count = 0;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] ones = { 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1 };
        System.out.println("Max ones count: " + get(ones));
    }
}
