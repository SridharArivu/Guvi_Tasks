public class Student {
    private Integer roll_no;
    private String name;
    private Integer age;
    private String course;

    // Constructor
    public Student(Integer roll_no, String name, Integer age, String course) throws AgeNotWithinRangeException,NameNotValidException{
        // Validating Age
        if (age < 15 || age > 21)
            throw new AgeNotWithinRangeException("Age must be between in the range of 15 to 21");
        else this.age = age;

        // Validating Name
        if(name.matches(".*[\\d!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?].*"))
            throw new NameNotValidException("Special characters or Numbers are not allowed");
        else  this.name = name;
       
        this.roll_no = roll_no;
        this.course = course;
    }
    //Getters
    public Integer getRoll_no() {
        return roll_no;
    }
    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }
    public String getCourse() {
        return course;
    }
    
    // Setters
    public void setRoll_no(Integer roll_no) {
        this.roll_no = roll_no;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    
}
