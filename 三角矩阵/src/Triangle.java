import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: 使用动态规划求解三角矩阵问题
 * 给出一个三角形，计算从三角形顶部到底部的最小路径和，每一步都可以移动到下面一行相邻的数字，（只能从 [i][j] 移动到 [i+1][j] 或者 [i+1][j+1]）
 * 例如： 给出三角形如下：
 * [2]
 * [3,4]
 * [6,5,7]
 * [4,1,8,3]
 * 最小的从顶部到底部的路径和是 2 + 3 + 5 + 1 = 11
 *
 * 问题：从 (0,0) 到达最后一行的最小路径和
 * 状态 F(i,j): 从（0,0）到达（i,j）的最小路径和
 * 转换方程：到达 i - 1 层的最小路径 + 这一层 [i][j]
 *          min{F(i -1, j), F(i - 1, j - 1)} + a[i][j]
 *     注意：每一行的第一列和最后一列，都只有一条路径可以到达
 *          F(i,0) = F(i - 1, 0) + a[i][0]
 *          F(i,i) = F(i - 1, i - 1) + a[i][i]
 *
 * 初始状态：F(0, 0) = a[0][0]
 * 返回结果: min{F(row - 1, j)}
 * User: HHH.Y
 * Date: 2020-08-23
 */
public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // 如果这个集合中没有元素，则返回0
        if(triangle.size() == 0) {
            return 0;
        }
        // 创建一个集合 minPathSum，用于存放最小路径和
        List<List<Integer>> minPathSum = new ArrayList<>();
        // 对集合初始化
        for (int i = 0; i < triangle.size(); i++) {
            minPathSum.add(new ArrayList<>());
        }
        // 将集合首元素初始化
        minPathSum.get(0).add(triangle.get(0).get(0));
        int row = triangle.size();
        // 执行转换方程
        for (int i = 1; i < row; i++) {
            int curSum = 0;
            for (int j = 0; j <= i; j++) {
                // 每一行的第一列
                if(j == 0) {
                    curSum = minPathSum.get(i - 1).get(j) + triangle.get(i).get(j);
                } else if(j == i) {
                    curSum = minPathSum.get(i - 1).get(j - 1) + triangle.get(i).get(j);
                } else {
                    curSum = Math.min(minPathSum.get(i - 1).get(j), minPathSum.get(i - 1).get(j - 1)) + triangle.get(i).get(j);
                }
                minPathSum.get(i).add(curSum);
            }
        }

        // 找最后一行中最小的数
        int ret = minPathSum.get(row - 1).get(0);
        for (int i = 1; i < row; i++) {
            ret = Math.min(ret, minPathSum.get(row - 1).get(i));
        }
        return ret;

    }
}
