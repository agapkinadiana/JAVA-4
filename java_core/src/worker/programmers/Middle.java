package worker.programmers;

import org.apache.log4j.Logger;

public class Middle extends Junior implements IAction {
    private static final Logger LOG = Logger.getLogger(Middle.class);

    public Middle (String surname, String name, String patronymic, int experience, int salary, Language language) {
        super (surname, name, patronymic, experience, salary, language);
        LOG.info("new middle");
    }

    @Override
    public int disutilityProgrammer() {
        return 0;
    }

    @Override
    public int getBonus() {
        return (int)(this.salary * 0.2);
    }

    @Override
    public String toString() {
        return "Middle - "+ super.toString() + '\n';
    }
}
