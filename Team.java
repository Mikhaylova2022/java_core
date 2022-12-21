package lesson1.HW1;

public class Team {
    private String title;
    private TeamMember[] members;

    public Team(String title, TeamMember...members) {
        this.title = title;
        this.members = members;
    }

    public TeamMember[] getMembers() {
        return members;
    }

    public String getTitle() {
        return title;
    }

    public void showSuccessfulResults() {
        System.out.println("********** Все успешные результаты  команды: " + title);
        for(TeamMember member:members) {
            if (member.getStatus() == Status.PASSED) {
                member.showMemberResults();
            }
        }
        printSplitter();
    }

    public void showResults() {
        System.out.println("******* Все результаты команды:" + title);
        for(TeamMember member:members) {
            member.showMemberResults();
        }
        printSplitter();
    }

    public void printSplitter() {
        System.out.println("======================================");
    }
}
