package lesson1.HW1;

public class Course {
    private Obstacle[] obstacles;

    public Course(Obstacle...obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        System.out.println("Команда  " + team.getTitle() + "' проходит полосу препятствий");
        for(TeamMember member:team.getMembers()) {
            for(Obstacle obstacle:obstacles) {
                obstacle.goChallenge(member);
                if (member.getStatus() == Status.FAILED) {
                    break;
                }
            }
        }
    }
}
