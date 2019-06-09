package company;

import java.io.Serializable;
import org.apache.log4j.Logger;

public class Company implements Serializable {
    private static final Logger LOG = Logger.getLogger(Company.class);

    public String name;
    public String country;
    public int countCourpuses;

    public Company() { }

    public Company(String name, String country, int countCourpuses) {
        this.name = name;
        this.country = country;
        this.countCourpuses = countCourpuses;
        LOG.info("new company");
    }
}
