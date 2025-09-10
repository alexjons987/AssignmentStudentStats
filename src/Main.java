import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int classSize = 8;

        // Create relevant arrays of relevant size
        String[] students = new String[classSize];
        int[] results = new int[classSize];

        // Add students
        students[0] = "Alexander";
        students[1] = "Natdanai";
        students[2] = "James";
        students[3] = "Sebastian";
        students[4] = "Valentin";
        students[5] = "Ibrahim";
        students[6] = "Bill";
        students[7] = "GenericStudent";

        // Assign random results
        for (int i = 0; i < results.length; i++) {
            results[i] = random.nextInt(0, 100 + 1);
            System.out.printf("%s: %d\n", students[i], results[i]);
        }

        System.out.println(); // Newline for pretty printing in console

        // Average results
        double totalResult = 0;
        for (int result : results)
            totalResult += result;
        double averageResult = totalResult / (float) classSize;
        System.out.printf("Average result: %.2f\n", averageResult);

        // Find the highest and lowest results
        int highestIndex = 0; // Assume first is highest
        int highestResult = results[highestIndex];

        int lowestIndex = 0; // Assume first is lowest
        int lowestResult = results[lowestIndex];

        for (int i = 1; i < results.length; i++) {
            if (results[i] > highestResult) { // New highest
                highestIndex = i;
                highestResult = results[i];
            } else if (results[i] < lowestResult) { // New lowest
                lowestIndex = i;
                lowestResult = results[i];
            }
        }
        System.out.printf("Best student was %s with a score of %d\n", students[highestIndex], highestResult);
        System.out.printf("Worst student was %s with a score of %d\n", students[lowestIndex], lowestResult);
    }
}