class Solution {
    private void recursion(int[] nums,boolean[] have,ArrayList<Integer> current,ArrayList<List<Integer>> result)
    {
        if(current.size()==nums.length)
        {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(have[i])
            continue;
            current.add(nums[i]);
            have[i]=true;
            recursion(nums, have,current,result);
            current.remove(current.size()-1);
            have[i]=false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> result=new ArrayList<>();
        boolean [] have=new boolean[nums.length];
        recursion(nums,have,new ArrayList<>(),result);
        return result;
    }
}
// ниже приведена улучшенная версия ,идея взята у одного из пользователей leetcode
class Solution {
    private void recursion(int[] nums,int index,ArrayList<List<Integer>> result)
    {
        if(nums.length-1==index)
        {
           ArrayList<Integer> c=new ArrayList<Integer>();
           for(int i=0;i<nums.length;i++)
           {
            c.add(nums[i]);
           }
           result.add(c);
            return;
        }
        int tmp;
        for(int i=index;i<nums.length;i++)
        {
           tmp=nums[index];
           nums[index]=nums[i];
           nums[i]=tmp;
            recursion(nums,index+1,result);
            nums[i]=nums[index];
            nums[index]=tmp;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> result=new ArrayList<>();
        
        recursion(nums,0,result);
        return result;
    }
}
