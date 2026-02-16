// ===== GOOD: Setters Prevent Mistakes =====

public class GoodPerson {
    private String name;      // PRIVATE - outside code CANNOT access!
    private int age;          // PRIVATE - outside code CANNOT access!
    
    public String getName() {
        return name;
    }
    
    public void setName(String newName) {
        name = newName;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int newAge) {
        // VALIDATION: Only accept reasonable ages
        if (newAge >= 0 && newAge <= 150) {
            age = newAge;
        } else {
            System.out.println("Invalid age!");
        }
    }
}

// OUTSIDE CLASS - main or another class:
public class Test {
    public static void main(String[] args) {
        GoodPerson p = new GoodPerson();
        p.setName("Alice");
        p.setAge(25);
        
        System.out.println("Age: " + p.getAge());  // 25
        
        // p.age = -5;  // COMPILE ERROR! age is private!
        // MUST use the setter:
        p.setAge(-5);  // Prints "Invalid age!" - BLOCKED!
        
        System.out.println("Age: " + p.getAge());  // Still 25 (SAFE!)
    }
}



