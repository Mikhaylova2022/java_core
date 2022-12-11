package lesson1.HW1;

public class Squat extends Obstacle{
    public Squat(int difficulty) {
        super(difficulty);
    }

    @Override
    public void goChallenge(TeamMember member) {
        member.squat(super.getDifficulty());
    }
}

