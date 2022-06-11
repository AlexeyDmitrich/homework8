/**
 * Объект - препятствие на пути движения.
 * имеет длину, которая может быть так же и отрицательной (движущийся объект уйдет с пути).
 * Имплементация интерфейса Difficultness позволяет добавить высоту, но для этого рекомендуется
 * создать объект класса Wall.
 */
public class Road implements Difficultness {
    double length;
    /**
     * конструктор; на входе ожидает увидеть
     * @param length - длину препятствия
     */
    public Road(double length) {
        this.length = length;
    }
    // геттер, не пригодился в рамках задачи
    public double getLength() {
        return length;
    }

    @Override
    public double high() {    // высота препятствия
        return 0;
    }

    @Override
    public double distance() {    // длина препятствия
        return length;
    }

    @Override
    public double difficult() {
        return length;
    }

    @Override
    public void about() {
        System.out.printf("Дорога длиной %.2f м.\n", length);
    }

}
