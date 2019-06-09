package worker;

import org.apache.log4j.Logger;

public class Admin extends Worker {
    private static final Logger LOG = Logger.getLogger(Admin.class);

    public Admin (String surname, String name, String patronymic, int experience, int salary) {
        super (surname, name, patronymic, experience, salary);
        LOG.info("new admin");
    }

    public void saveReserveCopy()
    {
        System.out.println("saveReserveCopy");
    }
    public void configUpdating()
    {
        System.out.println("configUpdating");
    }
    public void createUpdateAccount()
    {
        System.out.println("createUpdateAccount");
    }

    @Override
    public String toString() {
        return "Admin - " + super.toString() + '\n';
    }
}
