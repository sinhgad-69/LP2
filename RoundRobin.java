import java.util.Scanner;  
public class RoundRobin  {  
    public static void main(String args[])  {  
        int n,i,qt,count,temp,sq=0,bt[],wt[],tat[],rem_bt[];  
        float awt=0,atat=0;  
        bt = new int[10];  
        wt = new int[10];  
        tat = new int[10];  
        rem_bt = new int[10];  
        Scanner sc = new Scanner(System.in);  
        System.out.print("Enter the number of process (maximum 10) = ");  
        n = sc.nextInt();  
        System.out.print("Enter the burst time of the process\n");  
        for (i = 0; i < n; i++) {  
            System.out.print("P" + i + " = ");   
            bt[i] = sc.nextInt();  
            rem_bt[i] = bt[i];  
        }  
        System.out.print("Enter the quantum time: ");  
        qt = sc.nextInt();  
        while (true) {
            int completedProcesses = 0; // Count of completed processes
        
            for (i = 0; i < n; i++) {
                if (rem_bt[i] > 0) { // Check if the process still has remaining time
                    // Allocate time to the process
                    if (rem_bt[i] > qt) {
                        sq += qt; // Increase total time by quantum time
                        rem_bt[i] -= qt; // Reduce remaining time by quantum time
                    } else {
                        sq += rem_bt[i]; // Add remaining time to total time
                        rem_bt[i] = 0; // Process is completed
                    }
                    tat[i] = sq; // Update turnaround time for the process
                } else {
                    completedProcesses++; // Count the completed process
                }
            }
        
            // Break the loop if all processes are completed
            if (completedProcesses == n) {
                break;
            }
        }
        System.out.print("--------------------------------------------------------------------------------");  
        System.out.print("\nProcess\t      Burst Time\t       Turnaround Time\t          Waiting Time\n");  
        System.out.print("--------------------------------------------------------------------------------");  
        for(i=0;i<n;i++)  {  
            wt[i]=tat[i]-bt[i];  
            awt += wt[i];  // Equivalent to awt = awt + wt[i];
            atat += tat[i]; // Equivalent to atat = atat + tat[i];
            System.out.print("\n "+(i+1)+"\t "+bt[i]+"\t\t "+tat[i]+"\t\t "+wt[i]+"\n");  
        }  
        awt=awt/n;  
        atat=atat/n;  
        System.out.println("\nAverage waiting Time = "+awt+"\n");  
        System.out.println("Average turnaround time = "+atat);  
    }  
} 