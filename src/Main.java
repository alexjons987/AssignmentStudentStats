import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        final int CLASS_SIZE = 8;

        // Create relevant arrays of relevant size
        String[] students = new String[CLASS_SIZE];
        int[] results = new int[CLASS_SIZE];

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
        double averageResult = totalResult / (float) CLASS_SIZE;
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

        // Sort list based on result
        for (int i = 0; i < CLASS_SIZE; i++) {
            boolean swapped = false;
            for (int j = 0; j < CLASS_SIZE - i - 1; j++) {
                if (results[j] < results[j + 1]) {
                    String tempName = students[j];
                    int tempScore = results[j];

                    students[j] = students[j + 1];
                    results[j] = results[j + 1];

                    students[j + 1] = tempName;
                    results[j + 1] = tempScore;

                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }

        for (int i = 0; i < students.length; i++) {
            System.out.printf("%d. %s - %d (%c)\n", i + 1, students[i], results[i], getGradeFromResult(results[i]));
        }

        // Every student above average
        int studentsAboveAvgCount = 0;
        for (int i = 0; i < CLASS_SIZE; i++) {
            if (results[i] > averageResult) {
                System.out.printf("%s performed above average!\n", students[i]);
                studentsAboveAvgCount++;
            }
        }
        System.out.printf("Students above average: %d\n", studentsAboveAvgCount);

        // Search-loop
        while (true) {
            String search;
            do {
                System.out.print("Search for a student: ");
            } while ((search = scanner.next()).isEmpty());

            for (int i = 0; i < CLASS_SIZE; i++)
                if (students[i].contains(search))
                    System.out.printf("%s - %d (%c)\n", students[i], results[i], getGradeFromResult(results[i]));

            if (search.equals("exit"))
                break;
        }
    }

    public static char getGradeFromResult(int result) {
        if (result <= 40)
            return 'F';
        else if (result <= 49)
            return 'E';
        else if (result <= 59)
            return 'D';
        else if (result <= 69)
            return 'C';
        else if (result <= 79)
            return 'B';
        else
            return 'A';
    }
}