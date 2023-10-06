public class User {
    private String firstName;
    private String middleName;
    private String lastName;
    private String password;

    public User(String firstName, String middleName, String lastName, String password) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User: " + firstName + " " + middleName + " " + lastName;
    }

    public static void main(String[] args) {
        User user1 = new User("Mr.", "Aagman", "Mehto", "MrAaMe");
        User user2 = new User("Mr.", "Mohit", "Patel", "MrMoPa");

        System.out.println(user1);
        System.out.println("Password: MrAaMe"); 
        System.out.println(user2);
        System.out.println("Password: MrMoPa");
    }
}
