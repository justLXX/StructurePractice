import java.util.HashMap;
import java.util.Map;

public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        // key 为 target - nums[i];value 为 index
        int size = (int) ((nums.length / 0.75) + 1);

        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (map.containsKey(value)) {
                int[] result = {map.get(value), i};
                return result;
            }
            map.put(target - value, i);
        }
        return null;
    }
}

