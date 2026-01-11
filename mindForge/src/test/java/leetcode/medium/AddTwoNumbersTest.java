package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * AddTwoNumbers 的单元测试类
 * 目的：
 * 1. 验证链表加法的正确性
 * 2. 覆盖常见情况、边界情况和进位情况
 * 3. 保证以后重构 solution 方法时行为不被破坏
 */
class AddTwoNumbersTest {

    /**
     * 测试 LeetCode 官方示例：
     * (2 -> 4 -> 3) + (5 -> 6 -> 4) = (7 -> 0 -> 8)
     * 对应数值：342 + 465 = 807
     */
    @Test
    void testExampleCase() {
        // 创建被测试对象
        AddTwoNumbers solution = new AddTwoNumbers();

        // 构造输入链表 l1 = [2, 4, 3]
        ListNode l1 = buildList(2, 4, 3);

        // 构造输入链表 l2 = [5, 6, 4]
        ListNode l2 = buildList(5, 6, 4);

        // 调用被测试的方法
        ListNode result = solution.solution(l1, l2);

        // 验证结果链表是否等于 [7, 0, 8]
        assertListEquals(result, 7, 0, 8);
    }

    /**
     * 测试两个链表长度不相等的情况
     * (9 -> 9) + (1) = (0 -> 0 -> 1)
     * 对应数值：99 + 1 = 100
     */
    @Test
    void testDifferentLengthLists() {
        AddTwoNumbers solution = new AddTwoNumbers();

        ListNode l1 = buildList(9, 9);
        ListNode l2 = buildList(1);

        ListNode result = solution.solution(l1, l2);

        assertListEquals(result, 0, 0, 1);
    }

    /**
     * 测试连续进位的情况
     * (9 -> 9 -> 9) + (1) = (0 -> 0 -> 0 -> 1)
     * 对应数值：999 + 1 = 1000
     */
    @Test
    void testCarryAtEnd() {
        AddTwoNumbers solution = new AddTwoNumbers();

        ListNode l1 = buildList(9, 9, 9);
        ListNode l2 = buildList(1);

        ListNode result = solution.solution(l1, l2);

        assertListEquals(result, 0, 0, 0, 1);
    }

    // =========================
    // ===== 辅助工具方法 =====
    // =========================

    /**
     * 根据给定的整数序列构造链表
     * 例如：
     * buildList(2, 4, 3) 会生成：
     * 2 -> 4 -> 3 -> null
     * 这个方法的存在意义：
     * - 避免在每个测试中手写链表构造逻辑
     * - 让测试代码更简洁、更可读
     */
    private ListNode buildList(int... values) {
        // dummy 节点用于简化链表构造逻辑
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // 遍历输入值，逐个创建节点并连接
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }

        // 返回真正的头结点（跳过 dummy）
        return dummy.next;
    }

    /**
     * 验证链表的值序列是否与期望值一致
     * 例如：
     * assertListEquals(result, 7, 0, 8)
     * 这个方法的存在意义：
     * - 不关心链表结构，只关心“结果是否正确”
     * - 一旦失败，可以精确定位是哪一位不对
     */
    private void assertListEquals(ListNode node, int... expected) {
        int index = 0;

        // 同时遍历链表和期望数组，逐个比较值
        while (node != null && index < expected.length) {
            assertEquals(
                    expected[index],
                    node.val,
                    "Mismatch at index " + index
            );
            node = node.next;
            index++;
        }

        // 如果链表还有剩余节点，说明结果多了
        assertNull(node, "Result list is longer than expected");

        // 如果期望数组还有剩余值，说明结果少了
        assertEquals(
                expected.length,
                index,
                "Result list is shorter than expected"
        );
    }
}
