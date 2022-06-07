public class Cat implements motion{
    private String name;
    private float weight;

    public Cat(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    {
        name = "Хангрид";
        weight = 8;
    }

    public void aboutCat(){
        System.out.printf("Кота зовут %s; \nвесит %g килограмм", name, weight);
    }


    @Override
    public void run(int distance) {
        if (distance > 0 && distance <= 150){
            System.out.printf("%s пробежал %d метров", name, distance);
        } else if (distance > 150){
            // todo: внести реализацию
        }

    }

    @Override
    public void jump(int high) {
        if (high > 0 && high <= 2){
            System.out.printf("%s перепрыгнул %d-метровую преграду", name, high);
        } else if (high > 2 && high <= 4){
            System.out.printf("%s смог перелезть через %d-метровую стену", name, high);
        } else if (high > 4) {
            System.out.printf("%s не смог преодолеть %d-метровое препятствие", name, high);
        } else if (high == 0) {
            System.out.printf("%s не заметил препятствия на пути", name);
        } else {
            System.out.printf("%s свалился в яму, глубиной -(%d метра) и еле выбрался", name, high);
        }
    }
}
