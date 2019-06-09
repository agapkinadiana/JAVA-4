package worker.programmers;

import org.apache.log4j.Logger;

public class Senior extends Junior {
    private static final Logger LOG = Logger.getLogger(Senior.class);

    boolean teamLead;

    public Senior (String surname, String name, String patronymic, int experience, int salary, Language language) {
        super (surname, name, patronymic, experience, salary, language);
        LOG.info("new senior");
    }

    @Override
    public void writeProgramm() {
        System.out.println("Override method in Senior class");
    }

    @Override
    public String toString() {
        return "Senior - " + super.toString() +
                " , teamLead=" + teamLead + '\n';
    }

    public boolean isTeamLead() { return teamLead; }

    public void setTeamLead(boolean teamLead) { this.teamLead = teamLead; }
}
