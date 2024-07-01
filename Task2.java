import java.util.*;
class Task2
{
 public static void main(String[] args) 
 {
        int r1,r2,rnum,g,a;
        Random r=new Random();
        Scanner s=new Scanner(System.in);
        r1=1;
        r2=100;
        rnum=r.nextInt(r2-r1+1)+r1;
        System.out.print("Guess An Number Between 1 To 100: ");
        g=s.nextInt();
         System.out.println();
        a=0;
        while (rnum!=g)
        { 
         if (a>=5) 
         {
             System.out.println("You Have Failed All The 5 Atempts");
             System.out.println("Number is: "+rnum);
             break;
         }
         if (rnum!=g)
         {
          if (rnum>g) 
          {
            System.out.println("Higher Than Your Guess ");
          }
          else if (rnum<g) 
          {
            System.out.println("Lower Than Your Guess ");
          }
         }
         System.out.println();
          System.out.println("Attempt:"+(a+1));
         System.out.print("Again Guess The Number:");
         g=s.nextInt();
         System.out.println();
         a+=1;
         if (rnum==g)
         {
             break;
         }
        }
        if (rnum==g) 
        {
            System.out.println("Your Guess Is Correct");
        }
    } 
}