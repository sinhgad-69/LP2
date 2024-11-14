public class ImprovedFCFS {
    // Function to find the waiting time for all processes 
    static void findWaitingTime(int processes[], int n, int bt[], int wt[]) {
        // Waiting time for the first process is 0 
        wt[0] = 0;

        // Calculating waiting time for each process
        for (int i = 1; i < n; i++) {
            wt[i] = bt[i - 1] + wt[i - 1];
        }
    }

    // Function to calculate turnaround time 
    static void findTurnAroundTime(int processes[], int n, int bt[], int wt[], int tat[]) {
        // Calculating turnaround time by adding bt[i] + wt[i] 
        for (int i = 0; i < n; i++) {
            tat[i] = bt[i] + wt[i];
        }
    }

    // Function to calculate average time 
    static void findavgTime(int processes[], int n, int bt[]) {
        int wt[] = new int[n], tat[] = new int[n];
        int total_wt = 0, total_tat = 0;

        // Function to find waiting time of all processes 
        findWaitingTime(processes, n, bt, wt);

        // Function to find turnaround time for all processes 
        findTurnAroundTime(processes, n, bt, wt, tat);

        // Display processes along with all details 
        System.out.printf("Processes Burst time Waiting time Turn around time\n");

        // Calculate total waiting time and total turnaround time 
        
        for (int i = 0; i < n; i++) {
            total_wt += wt[i];
            total_tat += tat[i];
            System.out.printf(" %d ", (i + 1));
            System.out.printf("     %d ", bt[i]);
            System.out.printf("     %d ", wt[i]);
            System.out.printf("     %d\n", tat[i]);
        }

        // Calculate and display average waiting time and average turnaround time 
        float average_wt = (float) total_wt / n;
        float average_tat = (float) total_tat / n;
        System.out.printf("Average waiting time = %.2f\n", average_wt);
        System.out.printf("Average turn around time = %.2f\n", average_tat);
    }

    // Driver code 

    public static void main(String[] args) {
        // Process IDs 
        int processes[] = {1, 2, 3};
        int n = processes.length;

        // Burst time of all processes 
        int burst_time[] = {10, 5, 8};

        // Calculate and display average times
        findavgTime(processes, n, burst_time);
    }
}