import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description: 使用动态规划求解字符串分割问题
 * 给定一个字符串s和一组单词dict，判断s是否可以用空格分割成一个单词序列，使得单词序列中所有的单词都是dict中的单词（序列可以包含一个或多个单词）。
 * 例如:
 * 给定s=“leetcode”；
 * dict=["leet", "code"].
 * 返回true，因为"leetcode"可以被分割成"leet code".
 *
 * 问题: 单词是否可以成功分割
 * 子问题: 单词的前几个字符是否可以成功分割
 * 状态F(i): 单词的前 i 个字符是否可以成功分割
 * 转移方程: 在判断前 i 个字符是否可以分割时, 可以先判断前 j 个字符是否可以分割 (j < i)
 *          只有当前 j 个字符都可以成功分割之后, 再去判断 [j + 1, i] 的字符是否可以分割, 如果也可以成功分割, 则说明单词的前 i 个字符是可以成功分割的
 *          j < i && F[j] && [j+1, i]   只有都为真的时候, 才能分割成功
 * 辅助条件: 判断前 i 个字符是否可以在字典中找到
 * 返回结果: F(i), 当 i 为数组的长度时, 为F(s.length)
 * User: HHH.Y
 * Date: 2020-08-14
 */
public class StringBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        /*// 1. 判断 s 是否为空
        if(s.length() == 0) {
            return false;
        }
        // 2. 创建一个 boolean 类型的数组, 用于保存子问题的结果
        // 由于数组的下标是从 0 开始的, 而结果是从 1 开始统计的, 所以数组长度应该为 s.length + 1
        boolean[] canBreak = new boolean[s.length() + 1]; // 一开始默认数组中的元素值为 false
        for(int i = 1; i <= s.length(); i++) {
            // 3. 首先判断一下整体是否可以在字典中找到
            if(dict.contains(s.substring(0, i))) {
                canBreak[i] = true;
                continue;
            }
            // 否则执行状态转移方程
            // j < i && F[j] && [j+1, i] 应该为 true
            for(int j = i - 1; j > 0; j--) {  // j < i
                // F[j] && [j+1, i] 都应该为 true
                if(canBreak[j] && dict.contains(s.substring(j, i))) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[s.length()];*/

        /**
         * 也可以不用单独把整体情况拿出来处理
         * 可以从转移方程是: j < i && F[j] && [j+1, i] 必须为真 这个条件入手
         */
        boolean[] canBreak = new boolean[s.length() + 1];
        // 可以将 canBreak[0] 设置为 true, 这样既满足了 0 < i, 又满足了 F[0] 为 true, 只需要判断 [1, i] 为  true 就可以了, 这就相当于是判断整体
        canBreak[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(canBreak[j] && dict.contains(s.substring(j, i))) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }
}
