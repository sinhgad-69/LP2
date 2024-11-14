import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class MyProcess {
    int id;
    int burstTime;
    int priority;
    int waitTime;
    int turnAroundTime;

    MyProcess(int id, int burstTime, int priority) {
        this.id = id;
        this.burstTime = burstTime;
        this.priority = priority;
    }
}
public class easypriority{

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();
        MyProcess[] processes = new MyProcess[n];

        System.out.print("\nEnter burst time and priority for each process:\n");
        for (int i = 0; i < n; i++) {
            System.out.print("Process[" + (i + 1) + "]: ");
            int burstTime = sc.nextInt();
            int priority = sc.nextInt();
            processes[i] = new MyProcess(i + 1, burstTime, priority);
        }
        sc.close();
        // Sort processes by priority using a Comparator
        Arrays.sort(processes, Comparator.comparingInt(p -> p.priority));

        // Calculate wait time and turnaround time
        // Initialize total wait time and turnaround time
        int totalWaitTime = 0;
        int totalTurnAroundTime = 0;

        // Calculate wait time and turnaround time for each process
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                processes[i].waitTime = 0;
            } else {
                processes[i].waitTime = processes[i - 1].waitTime + processes[i - 1].burstTime;
            }
            processes[i].turnAroundTime = processes[i].waitTime + processes[i].burstTime;

            // Accumulate total wait time and turnaround time
            totalWaitTime += processes[i].waitTime;
            totalTurnAroundTime += processes[i].turnAroundTime;
        }

        // Display the process details
        System.out.print("\n\nProcess \tBurst Time \tWait Time \tTurn Around Time \tPriority\n");
        for (MyProcess process : processes) {
            System.out.printf("   %d\t\t   %d\t\t     %d\t\t     %d\t\t     %d\n",
                    process.id, process.burstTime, process.waitTime, process.turnAroundTime, process.priority);
        }

        // Calculate and display average waiting and turnaround times
        System.out.printf("\nAverage Wait Time: %.2f\n", (double) totalWaitTime / n);
        System.out.printf("Average Turn Around Time: %.2f\n", (double) totalTurnAroundTime / n);

        sc.close();
    }
}
