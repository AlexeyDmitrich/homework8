import java.util.Random;
import java.util.Scanner;

public class MainHomework8 {
    static Random rnd = new Random();
    static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {
/*
Cat[] catsTeam = new Cat[5];
Human[] humansTeam = new Human[5];
Robo[] robosTeam = new Robo[5];
*/

        System.out.println("Введите количество участников забега");
        int arr = input.nextInt();
        motion[] runners = new motion[arr];
        runnerIncubator(runners, arr);
        System.out.println("В забеге примут участие:");
        runnersList(runners);
        System.out.println("Введите количество препятствий");
        int arrDiff = input.nextInt();
        Difficultness[] steps = new Difficultness[arrDiff];
        difficultnessBuilder(steps, arrDiff);
        stepList(steps);

        start(runners, steps);
        winners(runners, steps);


    }

    static void runnerIncubator(motion[] runners, int arrLength) {
        int id = 0;
        while (id < arrLength) {
            int typeIndex;
            typeIndex = rnd.nextInt(3);
            if (typeIndex == 0) {
                runners[id] = new Cat(Cat.catNameGen(), Cat.catWeightGen());
            } else if (typeIndex == 1) {
                runners[id] = new Human(Human.humanNameGen(), Human.humanWeightGen());
            } else if (typeIndex == 2) {
                runners[id] = new Robo(Robo.roboNameGen(), Robo.roboWeightGen());
            }
    //        System.out.println("Добавлен участник " + runners[id] + " под номером " + id);
            id += 1;
        }
        //return runners[id];
    }

    static void difficultnessBuilder (Difficultness[] steps, int arrDiffLength){
        int id = 0;
        while (id < arrDiffLength) {
            int typeIndex;
            typeIndex = rnd.nextInt(2);
            if (typeIndex == 0) {
                steps[id] = new Road(rnd.nextInt(10000) * 0.8);
            } else if (typeIndex == 1) {
                steps[id] = new Wall(rnd.nextInt(7) * 0.7);
            }
    //        System.out.println("добавлено препятствие: " + steps[id] + ". " + steps[id].difficult() + " м.");

            id += 1;
        }
    }
    static void runnersList(motion[] runners){
        for (int i = 0; i < runners.length; i++) {
            runners[i].aboutRunner();
            System.out.println();
        }
    }
    static void stepList (Difficultness[] steps){
        for (int i = 0; i < steps.length; i++) {
            steps[i].about();
            System.out.println();
        }
    }

    static void start (motion[] runners, Difficultness[] steps){
        for (int i = 0; i < runners.length; i++) {
            for (int j = 0; j < steps.length; j++){
                runners[i].goOn(steps[j]);
            }
        /*      */
        }
    }

    static void winners (motion[] runners, Difficultness[] steps){
        int winner = 0;
        for (int i = 0; i < runners.length; i++) {
            for (int j = steps.length-1; j < steps.length; j++) {
                if (runners[i].getMoveNext()) {
                    winner += 1;
                    System.out.print("Победитель №" + winner + ":\n" );
                    runners[i].aboutRunner();
                    //input.nextLine();
                }
            }
        }
        if (winner == 0){
            System.out.println("В этом забеге победил организатор препятствий");
        }
    }
}
