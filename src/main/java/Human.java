public class Human {
    private String name;
    private float weight;

    public Human(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    {
        name = "Василий";
        weight = 75;
    }

    public void aboutCat(){
        System.out.printf("Человека зовут %s; \nвесит %g килограмм", name, weight);
    }


}
