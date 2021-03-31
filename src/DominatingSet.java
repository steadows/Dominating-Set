import java.util.*;
import java.util.Scanner;

/*
 * CIS263 - Winter 2021 - Project 2
 * Steve Meadows
 */

public class DominatingSet {

    private static int n;
    private static int adjacencyMatrix[][];
    
    /* Return true if the SetOfLabels x is
     * a subset that is a dominating set.
     * Your code goes here.
     */
    private static boolean isDominatingSet(SetOfLabels x) {
        int setAsArray[] = new int[n];
        int result[] = new int[n];

        // convert powerset to binary encoded array
        for(int i = 0;i < n;i++) {
            if (x.contains(NodeLabel.values()[i])) {
                setAsArray[i] = 1;
            }
            else {
                setAsArray[i] = 0;
            }
        }

        // multiply adjacency matrix by the encoded array 
        for (int i = 0; i < n; i++) { // use nested loops to multiply the two arrays together
            int c = 0;
            for (int j = 0; j < setAsArray.length; j++) {
                int l = setAsArray[j];
                int m = adjacencyMatrix[j][i];
                c += l * m; // sum the products of each set of elements
            }
            result[i] = c; 
        } 

        // if the resulting array contains a zero, it is not a dominate
        if (Arrays.stream(result).anyMatch(noGo -> noGo == 0) == true) {
            return false;
        }
        else{
            return true;
        }
    }

    public static void main(String args[]) {
        /* Read the size of the graph - number of vertices
        and then read the adjacency matrix for the graph
         */
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        adjacencyMatrix = new int [n][n];
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < n;j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }
        
        // Calculate the size of the power set: 2^n
        int twoToN = 1;
        for(int i = 0;i < n;i++) {
            twoToN = twoToN * 2;
        }
        // System.out.println("2^n is: "+twoToN);

        SetOfLabels smallestDominatingSet = new SetOfLabels(twoToN-1,n);
        int sizeOfSmallestDominatingSet = n;

        

        // Iterate over all the elements in the PowerSet
        // Those elements are encoded by the integers 1..2^n -1
        // For each posssible subset, check if it is a dominating set
        // Report the smallest dominating set
        long startTime = System.currentTimeMillis();
        for(int i = 1;i < twoToN;i++) {
            SetOfLabels candidate = new SetOfLabels(i,n);

            if (isDominatingSet(candidate)) {
                if (candidate.getNumberOfElements()<sizeOfSmallestDominatingSet) {
                    smallestDominatingSet = candidate;
                    sizeOfSmallestDominatingSet = candidate.getNumberOfElements();
                }
            }
        }
        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;

        System.out.println("The smallest dominating set is: "+
            smallestDominatingSet.toString());
        System.out.println("The size of the smallest dominating set is: "+
            smallestDominatingSet.getNumberOfElements());
        System.out.println("Run Time  = " + runTime + " ms");

    }
}