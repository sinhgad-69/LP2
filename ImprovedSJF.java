import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Job {
    int id;
    int burstTime;
    int waitTime;
    int turnaroundTime;

    Job(int id, int burstTime) {
        this.id = id;
        this.burstTime = burstTime;
        this.waitTime = 0;
        this.turnaroundTime = 0;
    }
}

public class ImprovedSJF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of jobs: ");
        int n = sc.nextInt();
        Job[] jobs = new Job[n];
        
        // Input burst times for each job
        for (int i = 0; i < n; i++) {
            System.out.print("Enter burst time for Job " + (i + 1) + ": ");
            int burstTime = sc.nextInt();
            jobs[i] = new Job(i + 1, burstTime);
        }
        sc.close();
        // Sort jobs by burst time
        Arrays.sort(jobs, Comparator.comparingInt(j -> j.burstTime));

        // Calculate waiting time and turnaround time
        int totalWaitTime = 0;
        int totalTurnaroundTime = 0;

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                jobs[i].waitTime = jobs[i - 1].waitTime + jobs[i - 1].burstTime;
            }
            jobs[i].turnaroundTime = jobs[i].waitTime + jobs[i].burstTime;
            totalWaitTime += jobs[i].waitTime;
            totalTurnaroundTime += jobs[i].turnaroundTime;
        }

        // Calculate average waiting time and turnaround time
        double avgWaitTime = (double) totalWaitTime / n;
        double avgTurnaroundTime = (double) totalTurnaroundTime / n;

        // Display results
        System.out.println("\nJob\tBurst Time\tWaiting Time\tTurnaround Time");
        for (Job job : jobs) {
            System.out.println(job.id + "\t" + job.burstTime + "\t\t" + job.waitTime + "\t\t" + job.turnaroundTime);
        }

        System.out.println("\nAverage Waiting Time: " + avgWaitTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);

        sc.close();
    }
}
