class MinStack {
    int point;
    int []ancestor;
    int currentminindex;
    int [] stack;
    public MinStack() {
        this.currentminindex=-1;
        this.point=0;
        this.ancestor=new int[8];
        this.stack=new int[8];
    }

    public void push(int val) {
        if(currentminindex==-1)
            currentminindex=0;
        else {
            if(val<stack[currentminindex])
            {
                ancestor[point] = currentminindex;
                currentminindex=point;
            }
        }
        stack[point]=val;
        point++;
        if(point==stack.length)
        {
            int[] tmpstack=new int[stack.length*2];
            for(int i=0;i<stack.length;i++)
            {
                tmpstack[i]=stack[i];
            }
            int[] tmpancestor=new int[ancestor.length*2];
            for(int i=0;i<ancestor.length;i++)
            {
                tmpancestor[i]=ancestor[i];
            }
            stack=tmpstack;
            ancestor=tmpancestor;
        }
    }

    public void pop() {
        if(point-1==currentminindex)
        {
            currentminindex=ancestor[currentminindex];
        }
        point--;
        if(stack.length/2>8&&point<stack.length/2)
        {
            int[] tmpstack=new int[stack.length/2];
            for(int i=0;i<tmpstack.length;i++)
            {
                tmpstack[i]=stack[i];
            }
            int[] tmpancestor=new int[ancestor.length/2];
            for(int i=0;i<tmpancestor.length;i++)
            {
                tmpancestor[i]=ancestor[i];
            }
            stack=tmpstack;
            ancestor=tmpancestor;

        }
    }

    public int top() {
        return stack[point-1];
    }

    public int getMin() {
    return stack[currentminindex];
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}