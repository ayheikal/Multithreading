
import java.util.Scanner;

public class Main {



    public static void main(String...Strings){
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter # of pumps: ");
        int x=scan.nextInt();
        System.out.print("Enter # of clients: ");
        int y=scan.nextInt();
        scan.nextLine();
        String[]arr=new String[y];
        for(int i=0;i<y;i++){
            arr[i]=scan.next();
        }

        Semaphore ob1=new Semaphore(x);
        Petrol []ob2=new Petrol[y];

        for (int i=0;i<y;i++){
            ob2[i]=new Petrol(arr[i],ob1);
            Mythread  w=new Mythread(ob2[i]);

            w.start();
        }
        




    }
}
