public class Robo {
    private String name;
    private float weight;

    public Robo(String name, int weight) {
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


}
