class MinStack {
    Node min;
    Node last;
    public MinStack() {
    this.last=new Node();
    this.min=new Node();
          min.val  =Integer.MAX_VALUE;
    }

    public void push(int val) {
        Node tmp=new Node();
        tmp.val=val;
        if(val<=min.val)
        {
            tmp.ancestor=min;
            min=tmp;
        }
        tmp.prev=last;
        last=tmp;
    }

    public void pop() {

        if(last.val==min.val)
        {
            min=min.ancestor;
        }
        last=last.prev;
    }

    public int top() {
        return last.val;
    }

    public int getMin() {
        return min.val;
    }
}
class Node
{
    int val;
    Node ancestor;
   Node prev;
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}