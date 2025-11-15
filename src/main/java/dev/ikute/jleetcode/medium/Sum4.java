package dev.ikute.jleetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4Sum problem.
 *
 * @see <a href="https://leetcode.com/problems/4sum/">4Sum</a>
 */
public class Sum4 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>(nums.length);

        if (nums.length < 4) {
            return quadruplets;
        }

        Arrays.sort(nums);

        for (int idx = 0; idx < nums.length - 3; idx += 1) {
            if (idx > 0 && nums[idx] == nums[idx - 1]) {
                continue;
            }

            for (int ijx = idx + 1; ijx < nums.length - 2; ijx += 1) {
                if (ijx > idx + 1 && nums[ijx] == nums[ijx - 1]) {
                    continue;
                }

                int lhs = ijx + 1;
                int rhs = nums.length - 1;

                for (; ; ) {
                    if (lhs >= rhs) {
                        break;
                    }

                    long sum = (long) nums[lhs] + (long) nums[rhs] + (long) nums[ijx] + (long) nums[idx];
                    if (sum == target) {
                        List<Integer> quadruplet = List.of(nums[idx], nums[ijx], nums[lhs], nums[rhs]);
                        quadruplets.add(quadruplet);

                        for (; ; ) {
                            if (lhs >= rhs) {
                                break;
                            }

                            boolean isLhsDouble = nums[lhs] == nums[lhs + 1];
                            boolean isRhsDouble = nums[rhs] == nums[rhs - 1];

                            if (isLhsDouble && isRhsDouble) {
                                lhs += 1;
                                rhs -= 1;

                                continue;
                            }

                            if (isLhsDouble) {
                                lhs += 1;
                                continue;
                            }

                            if (isRhsDouble) {
                                rhs -= 1;
                                continue;
                            }

                            break;
                        }
                    }

                    if (sum < target) {
                        lhs += 1;
                    } else {
                        rhs -= 1;
                    }
                }
            }
        }

        return quadruplets;
    }
}
