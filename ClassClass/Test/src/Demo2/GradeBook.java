package Demo2;

public class GradeBook {
    /**
     * GradeBook.java
     *
     * Uses the Student class to manage two students.
     * Run this file -- it contains the main() method.
     */


        public static void main(String[] args) {

            // ----- Create two students -----
            // Grades are NOT set in the constructor -- they start at 0
            Student alice = new Student("Alice Johnson", 3001);
            Student bob   = new Student("Bob Smith",     3002);


            // ----- Set Alice's grades using setters -----
            System.out.println("=== Entering Alice's Grades ===");
            alice.setGrade1(88.5);
            alice.setGrade2(92.0);
            alice.setGrade3(79.5);


            // ----- Set Bob's grades -- one of them is invalid -----
            System.out.println("\n=== Entering Bob's Grades ===");
            bob.setGrade1(75.0);
            bob.setGrade2(110.0);   // ❌ invalid -- setter will reject this
            bob.setGrade3(83.0);


            // ----- Print both reports -----
            System.out.println("\n=== Student Reports ===");
            alice.printReport();
            bob.printReport();

            // Notice Bob's Grade 2 stayed at 0 because 110 was rejected.
            // Ask yourself: is an average of 0 for a missing grade fair?
            // How might you handle this differently?
        }
    }

