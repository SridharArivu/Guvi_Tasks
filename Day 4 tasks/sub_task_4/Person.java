public class Person {
    String Name;
    int Age;

    public Person(String name, Integer age) {
        this.Name = name;
        this.Age = age;
    }
    public String getName() {
        return Name;
    }
    public Integer getAge() {
        return Age;
    }

    public void setName( String name) {
        this.Name = name;
    }
    public void setAge(Integer age) {
        this.Age = age;
    }
}
