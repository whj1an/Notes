package leetcode.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    void testExample1() {
        TwoSum ts = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = ts.solution(nums, target);

        assertArrayEquals(new int[]{0, 1}, result); //此方法用于
    }

    @Test
    void testExample2() {
        TwoSum ts = new TwoSum();
        int[] nums = {3, 2, 4};
        int target = 6;

        int[] result = ts.solution(nums, target);

        assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    void testDuplicateValues() {
        TwoSum ts = new TwoSum();
        int[] nums = {3, 3};
        int target = 6;

        int[] result = ts.solution(nums, target);

        assertArrayEquals(new int[]{0, 1}, result);
    }
}
