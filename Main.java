import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //  1. INPUT SCHOOL DETAILS
        System.out.print("Enter School Name: ");
        String schoolName = sc.nextLine();

        System.out.print("Enter Teacher Name: ");
        String teacherName = sc.nextLine();

        System.out.print("Enter Grade: ");
        String grade = sc.nextLine();

        System.out.print("Enter Year: ");
        int year = sc.nextInt();
        sc.nextLine();

        //  2. INPUT STUDENT DETAILS
        int n = 12;

        String[] names = new String[n];
        double[] eng = new double[n];
        double[] math = new double[n];
        double[] hist = new double[n];
        double[] geo = new double[n];
        double[] sci = new double[n];
        double[] prog = new double[n];
        double[] total = new double[n];
        char[] rank = new char[n];

        System.out.println("\nEnter records for " + n + " students:");

        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));

            System.out.print("Name: ");
            names[i] = sc.nextLine();

            System.out.print("English: ");
            eng[i] = sc.nextDouble();

            System.out.print("Math: ");
            math[i] = sc.nextDouble();

            System.out.print("History: ");
            hist[i] = sc.nextDouble();

            System.out.print("Geography: ");
            geo[i] = sc.nextDouble();

            System.out.print("Science: ");
            sci[i] = sc.nextDouble();

            System.out.print("Programming: ");
            prog[i] = sc.nextDouble();
            sc.nextLine();

            // 3. CALCULATE TOTAL + GRADE
            total[i] = eng[i] + math[i] + hist[i] + geo[i] + sci[i] + prog[i];

            if (total[i] >= 540) rank[i] = 'A';
            else if (total[i] >= 480) rank[i] = 'B';
            else if (total[i] >= 420) rank[i] = 'C';
            else if (total[i] >= 360) rank[i] = 'D';
            else rank[i] = 'F';
        }

        //  4. CLASS STATISTICS
        double totalEng = 0, totalAll = 0, totalMath = 0, totalHist = 0, totalGeo = 0, totalSci = 0, totalProg = 0;
        int aCount = 0, bCount = 0, cCount = 0, dCount = 0, fCount = 0;

        for (int i = 0; i < n; i++) {
            totalEng += eng[i];
            totalMath += math[i];
            totalHist += hist[i];
            totalGeo += geo[i];
            totalSci += sci[i];
            totalProg += prog[i];

            switch (rank[i]) {
                case 'A': aCount++; break;
                case 'B': bCount++; break;
                case 'C': cCount++; break;
                case 'D': dCount++; break;
                case 'F': fCount++; break;
            }
        }
        totalAll = totalEng + totalMath + totalHist + totalGeo + totalSci + totalProg;

        //  5. OUTPUT REPORT
        System.out.println("\n========================================================================================");
        System.out.println("                     " + schoolName);
        System.out.println("                     Teacher: " + teacherName);
        System.out.println("                     Grade: " + grade);
        System.out.println("                     Year: " + year);
        System.out.println("==========================================================================================");
        System.out.printf("%-20s %-7s %-7s %-7s %-10s %-7s %-12s %-7s %s\n",
                "Student Name", "English", "Math", "History", "Geography", "Science", "Programming", "Total", "Rank");
        System.out.println("==========================================================================================");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-20s %-7.2f %-7.2f %-7.2f %-10.2f %-7.2f %-12.2f %-7.2f %c\n",
                    names[i], eng[i], math[i], hist[i], geo[i], sci[i], prog[i], total[i], rank[i]);
        }

        System.out.println("==========================================================================================");
        System.out.printf("%-20s %-7.2f %-7.2f %-7.2f %-10.2f %-7.2f %-12.2f %-7.2f\n",
                "Totals:", totalEng, totalMath, totalHist, totalGeo, totalSci, totalProg, totalAll);

        System.out.printf("%-20s %-7.2f %-7.2f %-7.2f %-10.2f %-7.2f %-12.2f %-7.2f\n",
                "Averages:", totalEng / n, totalMath / n, totalHist / n,
                totalGeo / n, totalSci / n, totalProg / n, totalAll / n);

        System.out.println("\nRanks     A's: " + aCount + "   B's: " + bCount +
                "   C's: " + cCount + "   D's: " + dCount + "   F's: " + fCount);

        System.out.println("==========================================================================================");
    }
}