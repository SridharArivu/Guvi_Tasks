public class Voter {
    private String voterId;
    private String name;
    private int age;

    // Constructor with parameterized
    public Voter(String voterId, String name, int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Invalid age for Voter");
        }
        this.voterId = voterId;
        this.name = name;
        this.age = age;
    }

    // Getters
    public String getVoterId() {
        return voterId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
