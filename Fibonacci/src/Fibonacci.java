/**
 * Created with IntelliJ IDEA.
 * Description: 使用动态规划求解 Fibonacci 问题
 * 大家都知道 Fibonacci 数列, 现在要求输入一个整数 n, 请你输出 Fibonacci 数列的第 n 项
 * 从第 0 项开始, 第 0 项为 0, 第 1 项为 1
 *
 * 问题: 求解数列的第 n 项值
 * 状态F(i): 数列第 i 项的值
 * 转移方程: F(i) = F(i - 1) + F(i - 2)
 * 初始状态: F(0) = 0  F(1) = 1
 * 返回: F(n)
 * User: HHH.Y
 * Date: 2020-08-13
 */
public class Fibonacci {
    public static void main(String[] args) {
        int n = 5;
        int ret = fibonacci(n);
        System.out.println(ret);
    }

    private static int fibonacci(int n) {
        /*// 1. 使用递归的方式
        if(n == 0) {
            return 0;
        }
        if(n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);*/

        // 2. 使用动态规划的方式
        // ①. 确定初始值
        if(n <= 1) {
            return n;
        }
        // ②. 创建一个数组, 用于保存子问题的解, 题目要求是从 0 开始的
        int[] array = new int[n + 1];
        // 对这个数组进行初始化 F(0) = 0, F(1) = 1
        array[0] = 0;
        array[1] = 1;
        // ③. 通过状态转移方程求解
        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];

        // 3. 采用非递归的形式
//        int fn2 = 0;
//        int fn1 = 1;
//        int fn = 0;
//        if(n <= 1) {
//            return n;
//        }
//        for (int i = 2; i <= n; i++) {
//            fn = fn2 + fn1;
//            fn2 = fn1;
//            fn1 = fn;
//        }
//        return fn;
    }
}
