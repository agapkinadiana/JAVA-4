package worker;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="worker", propOrder={
        "surname",
        "name",
        "patronymic",
        "experience",
        "salary"
})
public abstract class Worker implements Serializable{
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private String surname;
    @XmlElement(required = true)
    private String name;
    @XmlElement
    private String patronymic;
    @XmlElement
    protected int experience;
    @XmlElement
    protected int salary;

    public Worker() {}

    public Worker (String surname, String name, String patronymic, int experience, int salary) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.experience = experience;
        this.salary = salary;
    }

    public String getSurname() { return surname; }

    public String getName() { return name; }

    public String getPatronymic() { return patronymic; }

    public int getExperience() { return experience; }

    public int getSalary() { return salary; }

    public void setSurname(String surname) { this.surname = surname; }

    public void setName(String name) { this.name = name; }

    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }

    public void setExperience(int experience) { this.experience = experience; }

    public void setSalary(int salary) { this.salary = salary; }

    @Override
    public String toString() {
        return "Worker - " +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", experience=" + experience +
                ", salary=" + salary ;
    }
}
