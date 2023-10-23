import java.util.ArrayList;
import java.util.List;

/*class Solution {
    private void build(int count,List<Integer> current,List<List<Integer>> result,List<Integer>[] ancestor)
    {   if(count==0)
    {
        result.add(new ArrayList<>(current));
        return;
    }
        for(int i=0;i<ancestor[count].size();i++)
        {
            current.add(ancestor[count].get(i));
            build(count-ancestor[count].get(i),current,result,ancestor);
            current.remove(current.size()-1);
        }
    }
    private List<Integer>[] search(int target,int [] candidates)
    {

        List<Integer>[] result=new List[target+1];

        for(int i=1;i<target+1;i++)
        {
            result[i]=new ArrayList<>();
            for(int j=0;j<candidates.length;j++)
            {
                if(i-candidates[j]<0)
                {
                    break;
                }

                if(i-candidates[j]==0||result[i-candidates[j]].size()>0)
                    result[i].add(candidates[j]);

            }
        }
        return result;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List[] ancestor=search(target,candidates);
        List<List<Integer>> result=new ArrayList<>();
        build(target,new ArrayList<>(),result,ancestor);
        return result;
    }
}*/
class Solution {
    private void build(int count,int index,int[] candidates,List<Integer> current,List<List<Integer>> result)
    {
        if(count==0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if(count<0)
        {
            return;
        }
        for(int i=index;i< candidates.length;i++)
        {
            current.add(candidates[i]);
            build(count-candidates[i],i,candidates,current,result);
            current.remove(current.size()-1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        build(target,0,candidates,new ArrayList<>(),result);
        return result;
    }
}
public class Main {
    public static void main(String[] args)
    {
        Solution sol=new Solution();
        int target=8;
        int[]condidates={2,3,5};
        List<List<Integer>> res=sol.combinationSum(condidates,target);
    }
}