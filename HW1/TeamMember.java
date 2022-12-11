package lesson1.HW1;

public class TeamMember {

    private final String name;
    private final int power;
    private Status status;

    public TeamMember(String name, int power) {
        this.name = name;
        this.power = power;
        this.status = Status.NOT_STARTED;
    }

    public Status getStatus() {
        return status;
    }

    public void squat(int difficulty) {
        if (difficulty < power) {
            System.out.println("(+) Член команды " + name + " прошел приседания");
            this.status = Status.PASSED;
        } else {
            System.out.println("(-) Член команды " + name + " не прошел приседания");
            this.status = Status.FAILED;
        }
    }

    public void pushUp(int difficulty) {
        if (difficulty < power) {
            System.out.println("(+) Член команды " + name + " прошел отжимания");
            this.status = Status.PASSED;
        } else {
            System.out.println("(-) Член команды " + name + " не прошел отжимания");
            this.status = Status.FAILED;
        }
    }

    public void Jump(int difficulty) {
        if (difficulty < power) {
            System.out.println("(+) Член команды " + name + " прошел прыжки");
            this.status = Status.PASSED;
        } else {
            System.out.println("(-) Член команды " + name + " не прошел прыжки");
            this.status = Status.FAILED;
        }
    }

    public void showMemberResults() {
        switch (this.status) {
            case FAILED:
                System.out.println("(-) Член команды " + name + " не прошел полосу препятствий ");
                break;
            case PASSED:
                System.out.println("(+) Член команды " + name + " прошел полосу препятствий успешно");
                break;
            case NOT_STARTED:
                System.out.println("(!) Член команды " + name + " не начал проходить полосу препятствий");
                break;
            default:
                throw new IllegalStateException("'" + status + "'ожидает");
        }
    }

}
