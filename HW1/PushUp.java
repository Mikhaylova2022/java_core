package lesson1.HW1;

public class PushUp extends Obstacle {

    public PushUp(int difficulty) {
        super(difficulty);
    }

    @Override
    public void goChallenge(TeamMember member) {
        member.pushUp(super.getDifficulty());
    }
}
