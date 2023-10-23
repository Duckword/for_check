import java.util.ArrayDeque;

class Solution {
    public int orangesRotting(int[][] grid) {
        int count = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[] current;
        int[] tmp;
        int time = 0;
        int fresh = 0;
        int rotten ;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    fresh++;
                else {
                    if (grid[i][j] == 2) {
                        tmp = new int[2];
                        tmp[0] = i;
                        tmp[1] = j;
                        q.add(tmp);
                    }
                }
            }
        }
        rotten = q.size();
        while (!q.isEmpty()) {
            if (rotten == 0) {
                time++;
                rotten = q.size();
            }
            current = q.pollFirst();
            rotten--;
            if (current[0] + 1 < grid.length && grid[current[0] + 1][current[1]] == 1) {
                fresh--;
                grid[current[0] + 1][current[1]] = 0;
                tmp = new int[2];
                tmp[0] = current[0] + 1;
                tmp[1] = current[1];
                q.add(tmp);
            }
            if (current[0] > 0 && grid[current[0] - 1][current[1]] == 1) {
                fresh--;
                grid[current[0] - 1][current[1]] = 0;
                tmp = new int[2];
                tmp[0] = current[0] - 1;
                tmp[1] = current[1];
                q.add(tmp);
            }
            if (current[1] + 1 < grid[0].length && grid[current[0]][current[1] + 1] == 1) {
                fresh--;
                grid[current[0]][current[1] + 1] = 0;
                tmp = new int[2];
                tmp[0] = current[0];
                tmp[1] = current[1] + 1;
                q.add(tmp);
            }
            if (current[1] > 0 && grid[current[0]][current[1] - 1] == 1) {
                fresh--;
                grid[current[0]][current[1] - 1] = 0;
                tmp = new int[2];
                tmp[0] = current[0];
                tmp[1] = current[1] - 1;
                q.add(tmp);
            }
        }
        if (fresh > 0)
            return -1;
        return time;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}