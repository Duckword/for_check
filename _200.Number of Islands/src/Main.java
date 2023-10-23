import java.util.ArrayDeque;
import java.util.Deque;

/*class Solution {

    public int numIslands(char[][] grid) {
        boolean[][]visited=new boolean[grid.length][grid[0].length];
        boolean[][]push=new boolean[grid.length][grid[0].length];
        int count=0;
        ArrayDeque<int[]>q=new ArrayDeque<>();
    for(int i=0;i<grid.length;i++)
    {
        for(int j=0;j<grid[i].length;j++)
        {
            if(grid[i][j]=='1'&&visited[i][j]==false) {
                {

                    int[] tmp=new int[2];
                    tmp[0]=i;
                    tmp[1]=j;
                    q.add(tmp);
                    int m=grid.length;
                    int n=grid[0].length;
                    int [] current;
                    while(!q.isEmpty())
                    {
                        current=q.pollFirst();
                        visited[current[0]][current[1]]=true;
                        if(current[0]+1<m&&grid[current[0]+1][current[1]]=='1'&&!push[current[0]+1][current[1]])//по строке вверх и вниз
                        {
                            tmp=new int[2];
                            tmp[0]=current[0]+1;
                            tmp[1]=current[1];
                            q.add(tmp);
                            push[current[0]+1][current[1]]=true;
                        }
                        if(current[0]>0&&grid[current[0]-1][current[1]]=='1'&&!push[current[0]-1][current[1]])//по строке вверх и вниз
                        {
                            tmp=new int[2];
                            tmp[0]=current[0]-1;
                            tmp[1]=current[1];
                            q.add(tmp);
                            push[current[0]-1][current[1]]=true;
                        }
                        if(current[1]+1<n&&grid[current[0]][current[1]+1]=='1'&&!push[current[0]][current[1]+1])//по столбцу вверх и вниз
                        {
                            tmp=new int[2];
                            tmp[0]=current[0];
                            tmp[1]=current[1]+1;
                            q.add(tmp);
                            push[current[0]][current[1]+1]=true;
                        }
                        if(current[1]>0&&grid[current[0]][current[1]-1]=='1'&&!push[current[0]][current[1]-1])//по столбцу вверх и вниз
                        {
                            tmp=new int[2];
                            tmp[0]=current[0];
                            tmp[1]=current[1]-1;
                            q.add(tmp);
                            push[current[0]][current[1]-1]=true;
                        }
                    }
                }
                count++;
            }
        }
    }
    return count;
    }
}*/
class Solution {
    public void recur(char[][] grid,int i,int j)
    {
        if(grid[i][j]=='0')
            return;

        grid[i][j]='0';
        if(i+1<grid.length)
            recur(grid,i+1,j);
        if(i>0)
            recur(grid,i-1,j);
        if(j+1<grid[0].length)
            recur(grid,i,j+1);
        if(j>0)
            recur(grid,i,j-1);
    }

    public int numIslands(char[][] grid) {

        int count=0;
    for(int i=0;i<grid.length;i++)
    {
        for(int j=0;j<grid[0].length;j++)
        {
            if(grid[i][j]=='1')
            {
                count++;
                recur(grid,i,j);
            }
        }
    }
    return count;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}