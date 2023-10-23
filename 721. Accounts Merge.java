// class Solution {
//     public List<List<String>> accountsMerge(List<List<String>> accounts) {
//         HashMap<String,List<String>> map=new HashMap<String,List<String>>();
//         int count=0;
//         boolean duplicate;
//         List<String> current=new ArrayList<>();//компилятору надо
//         while(count<accounts.size())
//         {   duplicate=false;
//             for(int i=1;i<accounts.get(count).size();i++)
//             {
//                 if(map.containsKey(accounts.get(count).get(i)))
//                 {
//                     duplicate=true;
//                     current=map.get(accounts.get(count).get(i));
//                     break;
//                 }
//             }
//             if(duplicate)
//             {
//                 for(int i=1;i<accounts.get(count).size();i++)
//             {   if(!map.containsKey(accounts.get(count).get(i)))
//                 {
//                     current.add(accounts.get(count).get(i));
//                 map.put(accounts.get(count).get(i),current);
//                 }
//             }
//             accounts.remove(count);
//             }
//             else
//             {
//                 for(int i=1;i<accounts.get(count).size();i++)
//             {
                
//                 map.put(accounts.get(count).get(i),current);
                
//             }
//             count++;
//             }


//         }
//         String name;
//         for(int i=0;i<accounts.size();i++)
//         {   
//             name=accounts.get(i).get(0);
//             accounts.get(i).remove(0);
//            Collections.sort(accounts.get(i));
//             accounts.get(i).add(0,name);
//         }
//         return accounts;
//     }
// }

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DisjoinSet set=new DisjoinSet(accounts.size());
        HashMap<String,Integer> have=new HashMap<String,Integer>();
        for(int i=0;i<accounts.size();i++)
        {
            for(int j=1;j<accounts.get(i).size();j++)
            {
                if(have.containsKey(accounts.get(i).get(j)))
                {
                    set.union(have.get(accounts.get(i).get(j)),i);
                }
                else
                {
                     have.put(accounts.get(i).get(j),i);
                }
            }
        }
        List<List<String>> result=new ArrayList<>();
        for(int i=0;i<accounts.size();i++)
        {
           result.add(new ArrayList<String>());
        }
         have.entrySet().stream().forEach(
            input->result.get(set.FindLider(input.getValue())).add(input.getKey()));
        // {
        //     for(int j=1;j<accounts.get(i).size();j++)
        //     {
        //        result.get(set.FindLider(have.get(accounts.get(i).get(j)))).add(accounts.get(i).get(j));
        //     }
        // }
        for(int i=0;i<result.size();i++)
        {   
            if(result.get(i).size()!=0)
            {
            Collections.sort(result.get(i));
            result.get(i).add(0,accounts.get(i).get(0));
            }

        }
        int count=0;
        while(count<result.size())
        {
            if(result.get(count).size()==0)
            {
                result.remove(count);
            }
            else count++;
        }
        return result;
        
    }
}
class DisjoinSet
{
    int[] ancestor;
    int[] size;
    DisjoinSet(int n)
    {
        this.ancestor=new int[n];
        for(int i=0;i<n;i++)
        {
            ancestor[i]=i;
        }
        this.size=new int [n];
        for(int i=0;i<n;i++)
        {
            size[i]=1;
        }
    }
    int FindLider(int a)
    {
       if(a==ancestor[a])
       return a;
       return ancestor[a]=FindLider(ancestor[a]);
    }
    void union(int a,int b)
    {
        a=FindLider(a);
        b=FindLider(b);
        if(a==b)
        return;
        if(size[a]>size[b])
        {
            ancestor[b]=a;
            size[a]+=size[b];
        }
        else
        {
            ancestor[a]=b;
            size[b]+=size[a];
        }
    }

}