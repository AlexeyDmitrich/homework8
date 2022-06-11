/**
 * Объект - препятствие на пути движения.
 * имеет высоту, которая может быть так же и отрицательной (класс опишет яму).
 * Имплементация интерфейса Difficultness позволяет добавить длину верхней (нижней для ямы) поверхности,
 * но для этого рекомендуется создать объект класса Road.
 */
public class Wall implements Difficultness{
    double high;   // высота стены

    /**
     * конструктор; на входе ожидает увидеть
     * @param high - высоту препятствия
     */
    public Wall(double high) {
        this.high = high;
    }
// геттер, не пригодился в рамках задачи
    public double getHigh() {
        return high;
    }

    @Override
    public double high() {    // высота препятствия
        return high;
    }

    @Override
    public double distance() {    // длина препятствия
        return 0;
    }

    @Override
    public double difficult() {
        return high;
    }

    @Override
    public void about() {
        if (high > 0.1) {
            System.out.printf("Стена высотой %.2f м.\n", high);
        } else if (high < -0.1) {
            System.out.printf("Яма глубиной %.2f м.\n", -high);
        } else {
            System.out.println("Лежачий полицейский\n");
        }
    }
}
