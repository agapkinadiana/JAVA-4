package director;

import com.google.gson.annotations.SerializedName;
import org.apache.log4j.Logger;
import worker.Worker;
import company.Company;
import java.util.ArrayList;
import java.util.Comparator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name="director")
@XmlAccessorType(XmlAccessType.FIELD)
public class Director <T extends Worker> implements Serializable{
    private static final Logger LOG = Logger.getLogger(Director.class);

    @XmlElement(name="name")
    private String name;

    public Company company = new Company("IBM", "Belarus", 4);
    private static Director<Worker> ourInstance = new Director<>("Scott");

    public static Director<Worker> getInstance() {
        return ourInstance;
    }

    public Director(String name) {
        this.name = name;
        workers = new ArrayList<>();
        LOG.info("new director");
    }

    private Director() {
        workers = new ArrayList<>();
    }

    public static class Secretary extends Worker {
        public Secretary(String surname, String name, String patronymic, int experience, int salary) {
            super(surname, name, patronymic, experience, salary);
        }

        public void call() {
            System.out.println("Hello, " + this.getName() + " " + this.getPatronymic() + " is busy");
        }
    }

    public ArrayList<T> getWorkers() {
        return workers;
    }

    public void setWorkers(ArrayList<T> workers) {
        this.workers = workers;
    }

    @XmlElement(name="worker")
    @SerializedName("workers")
    public ArrayList<T> workers = null;

    public void addWorker(Worker worker) {
        getInstance().workers.add(worker);
    }

    public int countWorkers() {
        return this.workers.size();
    }

    public void sortBySalary(){
        getInstance().workers.sort(Comparator.comparing(Worker::getSalary));
        System.out.println(getInstance().workers.toString());
    }

    private boolean checkWorkers() {
        if (this.workers.isEmpty())
            return false;
        return true;
    }

    public void printWorkers() {
        for (Worker worker : this.workers) { System.out.println(worker.toString()); }
    }
}
