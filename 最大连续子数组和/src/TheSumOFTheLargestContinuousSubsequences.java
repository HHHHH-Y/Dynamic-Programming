/**
 * Created with IntelliJ IDEA.
 * Description: 使用动态规划求解最大连续子数组的和
 * 例如:
 * {6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和(子向量的长度至少是1)
 *
 * F(0): {6}
 * F(1): {6,-3}, {-3}
 * F(2): {6,-3,-2}, {-3,-2}, {-2}
 * F(3): {6,-3,-2,7}, {-3,-2,7}, {-2,7}, {7}
 * F(4): {6,-3,-2,7,-15}, {-3,-2,7,-15}, {-2,7,-15}, {7,-15}, {-15}
 *
 * 问题: 数组的最大连续和
 * 子问题: 局部元素构成的数组, 它的最大连续和
 * 状态F(i): 以第 i 个元素结尾的最大连续子序列和
 * 转移方程: 找以第 i 个元素结尾的最大连续子序列和, 只需要取(前 i - 1 个元素的最大和 + 第 i 个元素) 和 (第 i 个元素) 的最大值
 *          不是前 i - 1 个元素的最大和的元素就没有意义了, 所以不参与计算
 *          F(i) = max(F(i - 1) + a[i], a[i])
 * 初始状态:
 *          F(0) = a[0]
 * 返回值: 因为找出的都是每一个索引位置对应的连续最大值, 所以, 还需要找出这些索引位置中的最大值
 *         max(F(i))
 *
 * User: HHH.Y
 * Date: 2020-08-14
 */
public class TheSumOFTheLargestContinuousSubsequences {
    public int FindGreatestSumOfSubArray(int[] array) {
       /* // 1. 判断给定的数组是否为空
        if(array.length == 0) {
            return 0;
        }
        // 2. 创建一个数组, 用于存放每一个索引位置中连续最大的值
        int[] max = new int[array.length];
        max[0] = array[0];
        // 3. 实现状态转移方程
        for (int i = 1; i < array.length; i++) {
            max[i] = Math.max(max[i - 1] + array[i], array[i]);
        }
        // 4. 找出结果数组中的最大值
        int maxSum = max[0];
        for(int i = 1; i < max.length; i++) {
            maxSum = Math.max(maxSum, max[i]);
        }
        return maxSum;*/

        if(array.length == 0) {
            return 0;
        }
        // 不需要创建一个保存结果的数组, 直接在原来的数组上进行修改
        int maxSum = array[0];
        // 实现状态转移方程
        for (int i = 1; i < array.length; i++) {
            array[i] = Math.max(array[i - 1] + array[i], array[i]);
            maxSum = Math.max(maxSum, array[i]);
        }
        return maxSum;
    }
}
