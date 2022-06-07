public interface motion {
    default void run(int distance, String name, int limit, boolean moveNext) {
        if (moveNext) {
            if (distance > 0 && distance <= limit) {
                System.out.printf("%s пробежал %d метров", name, distance);
                moveNext = true;
            } else if (distance > limit) {
                System.out.printf("%s устал, пробежав %d метров и не может двигаться дальше", name, distance);
                moveNext = false;
            } else if (distance < 0) {
                System.out.printf("%s убежал в обратном направлении", name);
                moveNext = false;
            }
        }
    }

    default void jump(int high, String name, int barier, int limit, boolean moveNext) {
        if (moveNext) {
            if (high > 0 && high <= barier) {
                System.out.printf("%s перепрыгнул %d-метровую преграду", name, high);
                moveNext = true;
            } else if (high > barier && high <= limit) {
                System.out.printf("%s смог перелезть через %d-метровую стену", name, high);
                moveNext = true;
            } else if (high > limit) {
                System.out.printf("%s не смог преодолеть %d-метровое препятствие", name, high);
                moveNext = false;
            } else if (high == 0) {
                System.out.printf("%s не заметил препятствия на пути", name);
                moveNext = true;
            } else if (high < 0 && high >= (-(limit))) {
                System.out.printf("%s свалился в яму, глубиной -(%d метра) и еле выбрался", name, high);
                moveNext = true;
            } else {
                System.out.printf("%s свалился в глубокую яму и не сможет самостоятельно выбраться");
            }
        }
    }
}
