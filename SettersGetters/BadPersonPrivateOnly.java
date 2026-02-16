// ===== IN-BETWEEN: BadPerson tries to use PRIVATE fields =====

public class BadPerson {
    private String name;  // PRIVATE - cannot access from outside!
    private int age;      // PRIVATE - cannot access from outside!
}

// OUTSIDE CLASS - main or another class:
public class Test {
    public static void main(String[] args) {
        BadPerson p = new BadPerson();
        
        // TRYING TO ACCESS PRIVATE FIELDS:
        
        // p.name = "Alice";  // COMPILE ERROR!
        // The field BadPerson.name is not visible
        
        // System.out.println(p.age);  // COMPILE ERROR!
        // The field BadPerson.age is not visible
        
        // p.age = -5;  // COMPILE ERROR!
        // The field BadPerson.age is not visible
        
        // PROBLEM: We cannot use BadPerson at all!
        // Fields are private but there are NO getters/setters
        // This class is broken and useless
    }
}
