package Demo2;

public class Student {
    /**
     * Student.java
     *
     * Represents a student with three test grades.
     *
     * Notice:
     *   - All fields are private
     *   - Grades start at 0 in the constructor (teacher enters them later)
     *   - Setters reject grades below 0 or above 100
     */


        // -------------------------
        // FIELDS
        // -------------------------
        private String name;
        private int    studentId;
        private double grade1;
        private double grade2;
        private double grade3;


        // -------------------------
        // CONSTRUCTOR
        // -------------------------
        /**
         * Creates a new Student.
         * Grades always start at 0 -- they are entered later using setters.
         */
        public Student(String name, int studentId) {
            this.name      = name;
            this.studentId = studentId;
            this.grade1    = 0;
            this.grade2    = 0;
            this.grade3    = 0;
        }


        // -------------------------
        // GETTERS
        // -------------------------
        public String getName() {
            return name;
        }

        public int getStudentId() {
            return studentId;
        }

        public double getGrade1() {
            return grade1;
        }

        public double getGrade2() {
            return grade2;
        }

        public double getGrade3() {
            return grade3;
        }


        // -------------------------
        // SETTERS
        // -------------------------
        public void setName(String name) {
            if (name == null || name.isEmpty()) {
                System.out.println("Error: Name cannot be empty.");
                return;
            }
            this.name = name;
        }

        public void setGrade1(double grade) {
            if (grade < 0 || grade > 100) {
                System.out.println("Error: Grade must be between 0 and 100. Got: " + grade);
                return;
            }
            this.grade1 = grade;
        }

        public void setGrade2(double grade) {
            if (grade < 0 || grade > 100) {
                System.out.println("Error: Grade must be between 0 and 100. Got: " + grade);
                return;
            }
            this.grade2 = grade;
        }

        public void setGrade3(double grade) {
            if (grade < 0 || grade > 100) {
                System.out.println("Error: Grade must be between 0 and 100. Got: " + grade);
                return;
            }
            this.grade3 = grade;
        }

        // NOTE: No setStudentId() -- once assigned, an ID should never change.


        // -------------------------
        // HELPER METHODS
        // -------------------------

        /**
         * Calculates and returns the average of the three grades.
         */
        public double getAverage() {
            return (grade1 + grade2 + grade3) / 3;
        }

        /**
         * Prints a full report for this student.
         */
        public void printReport() {
            System.out.println("-------------------------------");
            System.out.println("Name       : " + name);
            System.out.println("Student ID : " + studentId);
            System.out.printf( "Grade 1    : %.1f%n", grade1);
            System.out.printf( "Grade 2    : %.1f%n", grade2);
            System.out.printf( "Grade 3    : %.1f%n", grade3);
            System.out.printf( "Average    : %.2f%n", getAverage());
            System.out.println("-------------------------------");
        }
    }

