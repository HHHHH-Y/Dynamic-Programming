/**
 * Created with IntelliJ IDEA.
 * Description: 使用动态规划求解矩形覆盖问题
 * 我们可以使用 2 * 1 的小矩形横着或者竖着去覆盖更大的矩形
 * 请问用 n 个 2 * 1 的小矩形无重叠的覆盖一个 2 * n 的大矩形, 总共有多少种方法?
 *
 * 问题: 用 n 个 2*1 的小矩形去覆盖 2*n 的大矩形的方法数
 * 状态F(i): 用 i 个 2*1 的小矩形去覆盖 2*i 的大矩形的方法数
 * 转移方程:
 *    在 2*(i - 1) 的基础上再竖着拼接一个 2*1 的小矩形, 就可以形成一个 2*i 的矩形
 *    在 2*(i - 2) 的基础上再横着拼接两个 2*1 的小矩形, 就可以形成一个 2*i 的矩形
 *    F(i) = F(i - 1) + F(i - 2)
 * 初始状态: F(1) = 1   F(2) = 2
 * 返回值: F(n)
 * User: HHH.Y
 * Date: 2020-08-14
 */
public class Rectangular_Coverage {
    public int RectCover(int target) {
        // 1. 初始条件
        if(target == 0) {
            return 0;
        }
        if(target <= 2) {
            return target;
        }
        // 2. 创建一个数组, 用于存放子问题的解
        int[] arr = new int[target + 1];
        arr[1] = 1;
        arr[2] = 2;
        // 3. 根据状态转移方程求解
        for (int i = 3; i <= target; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[target];
    }
}
