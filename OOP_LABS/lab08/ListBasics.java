import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Ex 8.1 (Basic)
public class ListBasics {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(4, 9, 1, 7, 12, 3, 8, 15, 6, 2));
        int sum = 0;
        for (int n : nums) sum += n;
        System.out.println("Sum = " + sum);
        System.out.println("Max = " + Collections.max(nums));
        List<Integer> reversed = new ArrayList<>(nums);
        Collections.reverse(reversed);
        System.out.println("Reversed = " + reversed);
    }
}
