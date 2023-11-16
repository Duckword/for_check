import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[] numbers=new int[n];
        for(int i=0;i<n;i++)
        {
            numbers[i]=in.nextInt();
        }
        int search=1;
        for(int i=0;i<n;i++)
        {
            if(numbers[i]<search)
            {
                search=numbers[i]+1;
            }
            else {
                if (numbers[i]==search)
                {
                    search++;
                }
            }
        }
        System.out.println(search-1);
    }
}