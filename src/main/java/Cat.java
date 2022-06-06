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
            System.out.printf("%s пробежал %d метров");
        } else if (distance > 150){
            // todo: внести реализацию
        }

    }

    @Override
    public void jump(int high) {

    }
}
