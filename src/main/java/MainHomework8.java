import java.util.Random;
import java.util.Scanner;

public class MainHomework8 {
    static Random rnd = new Random();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введите количество участников забега");
        int arr = input.nextInt();
        Motion[] runners = new Motion[arr];
        System.out.printf("Выделяем бюджет на соревнования %d бегунов...\n", arr);
        runnerIncubator(runners, arr);
        System.out.println("Набираем бегунов по объявлению...");
        System.out.println();
        System.out.println("В забеге примут участие:");
        runnersList(runners);
        System.out.println("Введите количество препятствий");
        int arrDiff = input.nextInt();
        Difficultness[] steps = new Difficultness[arrDiff];
        System.out.printf("Выделяем бюджет на %d этапов полосы препятствий...\n", arrDiff);
        difficultnessBuilder(steps, arrDiff);
        System.out.println("Строим полосу препятствий по Вашему ТЗ... \nПостроено: \n");
        stepList(steps);

        System.out.println("-==========*** Забег начался! ***==========-");
        start(runners, steps);
        System.out.println("-==========*** Забег окончен! ***==========-");
        System.out.println();
        winners(runners, steps);

    }

    /**
     * На самом деле мы не набираем бегунов по объявлению,
     * все они генерируются в этом инкубаторе и вносятся в массив.
     * @param runners - на входе метод ожидает массив, заготовленный для бегунов;
     * @param arrLength - длина массива так же должна быть заранее установлена.
     */
    static void runnerIncubator(Motion[] runners, int arrLength) {
        int id = 0;
        while (id < arrLength) {
            int typeIndex;
            typeIndex = rnd.nextInt(3);
            if (typeIndex == 0) {
                runners[id] = new Cat(Cat.catNameGen(), Cat.catWeightGen());   // генерируем кота
            } else if (typeIndex == 1) {
                runners[id] = new Human(Human.humanNameGen(), Human.humanWeightGen());  // генерируем человека
            } else if (typeIndex == 2) {
                runners[id] = new Robo(Robo.roboNameGen(), Robo.roboWeightGen());   // генерируем робота
            }
    //        System.out.println("Добавлен участник " + runners[id] + " под номером " + (id + 1));
            id += 1;
        }
        //return runners[id];
    }

    /**
     * метод для строительства препятствий: генерирует дороги и стены с небольшим усложнением,
     * размещает их в массив
     * @param steps на входе ожидает массив для размещения препятствий
     * @param arrDiffLength длину массива необходимо задать предварительно
     */
    static void difficultnessBuilder (Difficultness[] steps, int arrDiffLength){
        int id = 0;
        double hardKoef = 0.5;    // коэффициент усложнения препятствий
        while (id < arrDiffLength) {
            int typeIndex;
            typeIndex = rnd.nextInt(2);
            if (typeIndex == 0) {
                steps[id] = new Road(((rnd.nextInt(200)+100)-100) * (hardKoef+1));
            } else if (typeIndex == 1) {
                steps[id] = new Wall(((rnd.nextInt(5) - 2)) * hardKoef);
            }
    //        System.out.println("добавлено препятствие: " + steps[id] + ". " + steps[id].difficult() + " м.");
            id += 1;
            hardKoef += 0.05;
        }
    }

    /**
     * метод для вывода списка участников
     * @param runners на входе ожидает массив бегунов
     */
    static void runnersList(Motion[] runners){
        for (int i = 0; i < runners.length; i++) {
            runners[i].aboutRunner();
            System.out.println();
        }
    }

    /**
     * метод для вывода списка всех препятствий
     * @param steps принимает массив препятствий
     */
    static void stepList (Difficultness[] steps){
        for (int i = 0; i < steps.length; i++) {
            steps[i].about();
            System.out.println();
        }
    }

    /**
     * Метод принимает два массива: массив бегунов и массив препятствий.
     * Затем каждый участник проходит по очереди все препятствия.
     * Принцип можно немного изменить, и к каждому препятствию будут приступать по очереди все участники, но для полосы препятствий
     * обычно используется именно реализованный метод.
     * @param runners массив бегунов
     * @param steps массив препятствий
     */
    static void start (Motion[] runners, Difficultness[] steps){
        for (int i = 0; i < runners.length; i++) {
            System.out.printf("На старт вызывается %s!\n", runners[i].toString());
            for (int j = 0; j < steps.length; j++){
                if (runners[i].getMoveNext()) {
                    runners[i].goOn(steps[j]);
                }
            }
            System.out.println();
        }

    }

    /**
     * Метод выводит победителей (всех, кто дотянул до конца маршрута)
     * принимает всё те же массивы бегунов и препятствий, если бегун сохранил
     * подвижность на последнем препятствии - считаем, что победил.
     * @param runners массив бегунов
     * @param steps массив препятствий
     */
    static void winners (Motion[] runners, Difficultness[] steps){
        int winner = 0;
        for (int i = 0; i < runners.length; i++) {
            for (int j = steps.length-1; j < steps.length; j++) {
                if (runners[i].getMoveNext()) {
                    winner += 1;
                    System.out.print("Победитель №" + winner + ":\n" );
                    runners[i].aboutRunner();
                    System.out.println();
                    //input.nextLine();
                }
            }
        }
        if (winner == 0){    // вполне вероятный исход
            System.out.println("В этом забеге победил организатор соревнований");
        }
    }
}
