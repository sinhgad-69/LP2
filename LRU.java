import java.util.ArrayList;
import java.util.Scanner;

public class LRU{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Frames: ");
        int frame = sc.nextInt(), pagefault = 0;
        System.out.println("Enter number of Pages: ");
        int pg = sc.nextInt(), pages[] = new int[pg];
        System.out.println("Enter pages: ");
        for(int i=0;i<pg;i++)
            pages[i] = sc.nextInt();

        ArrayList<Integer> s = new ArrayList<>(frame);
        for(int i: pages){
            if(!s.contains(i)){
                if(s.size() == frame)
                    s.remove(0);
                s.add(i);
                pagefault++;
            }else{
                s.remove((Integer)i);
                s.add(i);
            }
        }
        System.out.print("Page Faults: "+ pagefault);
        sc.close();
    }
}