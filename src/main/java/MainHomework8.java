import java.util.Random;

public class MainHomework8 {
    static Random rnd = new Random();

    public static void main(String[] args) {
/*
Cat[] catsTeam = new Cat[5];
Human[] humansTeam = new Human[5];
Robo[] robosTeam = new Robo[5];
*/

    }

    static void runnerIncubator(motion[] runners) {
        int id = 0;
        runners = new motion[15];
        int typeIndex;
        typeIndex = rnd.nextInt(2);
        if (typeIndex == 0) {
            runners[id] = new Cat(Cat.catNameGen(), Cat.catWeightGen());
        } else if (typeIndex == 1) {
            runners[id] = new Human(Human.humanNameGen(), Human.humanWeightGen());
        } else if (typeIndex == 2) {
        runners[id] = new Robo(Robo.roboNameGen(), Robo.roboWeightGen());
        }


    }
}
