// ===== BAD: Direct Field Access =====

public class BadPerson {
    public String name;
    public int age;
}

// OUTSIDE CLASS - main or another class:
public class Test {
    public static void main(String[] args) {
        BadPerson p = new BadPerson();
        p.name = "Alice";
        p.age = 25;
        
        System.out.println("Age: " + p.age);    // 25
        
        // ANYONE can directly change it:
        p.age = -5;  // ALLOWED - no protection!
        
        System.out.println("Age: " + p.age);    // -5 (WRONG!)
    }
}



