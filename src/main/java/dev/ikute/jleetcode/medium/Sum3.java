package dev.ikute.jleetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3Sum problem.
 *
 * @see <a href="https://leetcode.com/problems/3sum/">3Sum</a>
 */
public class Sum3 {

    static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> triples = new ArrayList<>(nums.length);

        if (nums.length < 3) {
            return triples;
        }

        Arrays.sort(nums);
        for (int idx = 0; idx < nums.length - 2; idx += 1) {
            if (nums[idx] > target) {
                break;
            }

            if (idx > 0 && nums[idx] == nums[idx - 1]) {
                continue;
            }

            int x = target - nums[idx];
            int lhs = idx + 1;
            int rhs = nums.length - 1;

            for (; ; ) {
                if (lhs >= rhs) {
                    break;
                }

                int sum = nums[lhs] + nums[rhs];
                if (sum == x) {
                    List<Integer> triple = List.of(nums[idx], nums[lhs], nums[rhs]);
                    triples.add(triple);

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

                if (sum < x) {
                    lhs += 1;
                } else {
                    rhs -= 1;
                }
            }
        }

        return triples;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        return threeSum(nums, 0);
    }
}
