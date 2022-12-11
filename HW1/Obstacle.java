package lesson1.HW1;

public abstract  class Obstacle {

        private final int difficulty;

        public Obstacle(int difficulty) {
            this.difficulty = difficulty;
        }

        public int getDifficulty() {
            return difficulty;
        }

        public abstract void goChallenge(TeamMember member);

}

