public interface motion {
    void run (int distance);

    default void jump(int high, String name, int barier, int limit) {
        if (high > 0 && high <= barier){
            System.out.printf("%s перепрыгнул %d-метровую преграду", name, high);
        } else if (high > barier && high <= limit){
            System.out.printf("%s смог перелезть через %d-метровую стену", name, high);
        } else if (high > limit) {
            System.out.printf("%s не смог преодолеть %d-метровое препятствие", name, high);
        } else if (high == 0) {
            System.out.printf("%s не заметил препятствия на пути", name);
        } else {
            System.out.printf("%s свалился в яму, глубиной -(%d метра) и еле выбрался", name, high);
        }
    }
}
