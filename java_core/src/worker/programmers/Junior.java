package worker.programmers;

import org.apache.log4j.Logger;
import worker.Worker;

public class Junior extends Worker implements IAction {
    private static final Logger LOG = Logger.getLogger(Junior.class);

    private Language language;

    public Junior (String surname, String name, String patronymic, int experience, int salary, Language language) {
        super(surname, name, patronymic, experience, salary);
        this.language = language;
        LOG.info("new junior");
    }

    public Language getLanguage() { return language; }

    public void setLanguage(Language language) { this.language = language; }

    @Override
    public void writeProgramm() { System.out.println("Write Prograam"); }

    @Override
    public void ficsBags() { System.out.println("Time for fixing bags- "); }

    @Override
    public int disutilityProgrammer() {
        return (int) (0.2 * this.experience * 4);
    }

    @Override
    public int getBonus() {
        return (int) (this.salary * 0.1);
    }

    @Override
    public String toString() {
        return "Junior - " + super.toString() +
                " , language=" + language + '\n';
    }
}
