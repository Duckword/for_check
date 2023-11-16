import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String txt=in.nextLine();
        int bestyandexindex=0;
        int countyandexbest=0;
        int candidatyandexindex=0;
        int countyandexcandidat=0;
        int cupindex=6;
        int cupcount=0;
        int current;
        String pat="YandexCup";
        for(int i=0;i<=txt.length()-pat.length();i++)
        {
            current=0;
            for(int j=0;j<6;j++)
            {
                if(txt.charAt(i+j)==pat.charAt(j))
                    current++;
            }
            if(current>countyandexcandidat) {
                countyandexcandidat = current;
                candidatyandexindex=i;
            }
            current=0;
            for(int j=6;j<9;j++)
            {
                if(txt.charAt(i+j)==pat.charAt(j))
                    current++;
            }
            if(current>=cupcount||current+countyandexcandidat>=cupcount+countyandexbest) {
                cupindex=i+6;
                cupcount = current;
                countyandexbest=countyandexcandidat;
                bestyandexindex=candidatyandexindex;
            }
        }
        StringBuilder tmp=new StringBuilder();
        for(int i=0;i<bestyandexindex;i++)
        {
            tmp.append(txt.charAt(i));
        }
            tmp.append("Yandex");
        for(int i=6+bestyandexindex;i<cupindex;i++)
        {
            tmp.append(txt.charAt(i));
        }
        tmp.append("Cup");
        for(int i=cupindex+3;i<txt.length();i++)
        {
            tmp.append(txt.charAt(i));
        }
        System.out.println(tmp.toString());

    }
}