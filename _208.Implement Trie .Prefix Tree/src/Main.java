class Trie {
    Node root;
    public Trie() {
        this.root=new Node();
        root.have=true;
    }

    public void insert(String word) {
        Node current=root;
        for(int i=0;i<word.length();i++)
        {
            if(current.links[word.charAt(i)-'a']==null)
            {
                current.links[word.charAt(i)-'a']=new Node();
                current.kids=true;
            }
           current= current.links[word.charAt(i)-'a'];
        }
        current.have=true;
    }

    public boolean search(String word) {
        Node current=root;
        for(int i=0;i<word.length();i++)
        {
            if(current.links[word.charAt(i)-'a']==null)
                return false;
            current=current.links[word.charAt(i)-'a'];
        }
        if(current.have)
            return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        if(prefix=="")
            return true;
        Node current=root;
        for(int i=0;i<prefix.length();i++)
        {
            if(current.links[prefix.charAt(i)-'a']==null)
            {
                return false;
            }
            current=current.links[prefix.charAt(i)-'a'];
        }
        if(!current.kids&&current.have==false)
            return false;
        return true;
    }
}
class Node {
    Node[] links;
    boolean have;
    boolean kids;
    Node()
    {
        this.have=false;
        this.links=new Node[26];
        this.kids=false;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}