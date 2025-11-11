package DAY_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {
    public List<List<Integer>> optimal(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        optimalHelper(0, new ArrayList<>(), arr, result);
        return result;
    }

    private void optimalHelper(int start, List<Integer> tmp, int[] arr, List<List<Integer>> result) {
        result.add(new ArrayList<>(tmp));
        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1])
                continue;
            tmp.add(arr[i]);
            optimalHelper(i + 1, tmp, arr, result);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subset2 s2 = new Subset2();
        int[] arr = { 1, 2, 2 };
        var result = s2.optimal(arr);
        result.stream().forEach(System.out::println);
    }
}
