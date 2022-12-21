package lesson1.HW1;

public class main {
    public static void main(String[] args) {
        Course c = new Course( new PushUp(30), new Squat(50), new Jump(60)); // Создаем полосу препятствий
        //Создаем 1 команду
        Team team1 = new Team("эМки", new TeamMember("Марина", 70), new TeamMember("Митя", 60), new TeamMember("Миша", 39),new TeamMember("Милена",45));
        // Создаем 2 команду
        Team team2 = new Team("Ашки", new TeamMember("Арина", 42), new TeamMember("Андрей", 55), new TeamMember("Алёна", 61),new TeamMember("Алекс",72));
        // Пригласить приступить 1 команду пройти полосу препятствий
        c.doIt(team1);
        // Пригласить приступить 2 команду пройти полосу препятствий
        c.doIt(team2);
        // Показать результаты
        team1.showResults();
        team2.showResults();
        // Успешное прохождение(результаты)
        team1.showSuccessfulResults();
        team2.showSuccessfulResults();
    }
}
