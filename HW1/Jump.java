package lesson1.HW1;

public class Jump extends Obstacle {
    public Jump(int difficulty) {
        super(difficulty);
    }

    @Override
    public void goChallenge(TeamMember member) {
        member.Jump(super.getDifficulty());
    }
}