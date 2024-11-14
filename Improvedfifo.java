import java.util.ArrayList;
import java.util.Scanner;

public class Improvedfifo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept number of frames from the user
        System.out.print("Enter the number of frames: ");
        int frameCount = scanner.nextInt();

        // Accept number of pages from the user
        System.out.print("Enter the number of pages: ");
        int pageCount = scanner.nextInt();

        // Accept the pages to be referenced
        System.out.print("Enter pages: ");
        int[] pages = new int[pageCount];
        for (int i = 0; i < pageCount; i++) {
            pages[i] = scanner.nextInt();
        }

        // Initialize the list for frames and page fault counter
        ArrayList<Integer> frameList = new ArrayList<>(frameCount);
        int pageFaults = 0;
        int nextFrameToReplace = 0; // Tracks the next frame to be replaced in FIFO order

        // Process each page reference
        for (int page : pages) {
            if (!frameList.contains(page)) { // Page not in frame list
                if (frameList.size() < frameCount) {
                    // If there is space in the frame list, add the page directly
                    frameList.add(page);
                } else {
                    // Replace the oldest page in the frame list (FIFO)
                    frameList.set(nextFrameToReplace, page);
                    nextFrameToReplace = (nextFrameToReplace + 1) % frameCount;
                }
                pageFaults++; // Increment page fault count
                System.out.println("Page fault: Loaded " + page);
            }
        }

        // Output the total number of page faults
        System.out.println("Total Page Faults: " + pageFaults);

        scanner.close();
    }
}
