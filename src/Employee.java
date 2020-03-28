import javax.persistence.*;

@Entity
@Table(name="emp2")

public class Employee {

    @Id@GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="salary")
    private double salary;

    public Employee() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }






}
