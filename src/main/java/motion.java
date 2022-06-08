public interface motion {
    default boolean run(int distance, String name, int limit, boolean moveNext) {
        if (moveNext) {
            if (distance > 0 && distance <= limit) {
                System.out.printf("%s пробежал %d метров\n", name, distance);
            } else if (distance > limit) {
                System.out.printf("%s устал, пробежав %d метров и не может двигаться дальше\n", name, limit);
                moveNext = false;
            } else if (distance < 0) {
                System.out.printf("%s убежал в обратном направлении\n", name);
                moveNext = false;
            }
        }
        else {
            System.out.printf("%s сошел с дистанции ранее и не побежал дальше\n", name);
            moveNext = false;
        }
        return moveNext;
    }

    default boolean jump(int high, String name, int barier, int limit, boolean moveNext) {
        if (moveNext) {
            if (high > 0 && high <= barier) {
                System.out.printf("%s перепрыгнул %d-метровую преграду\n", name, high);
            } else if (high > barier && high <= limit) {
                System.out.printf("%s смог перелезть через %d-метровую стену\n", name, high);
            } else if (high > limit) {
                System.out.printf("%s не смог преодолеть %d-метровое препятствие\n", name, high);
                moveNext = false;
            } else if (high == 0) {
                System.out.printf("%s не заметил препятствия на пути\n", name);
            } else if (high < 0 && high >= (-(limit))) {
                System.out.printf("%s свалился в яму, глубиной %d метра и еле выбрался\n", name, -high);
            } else {
                System.out.printf("%s свалился в глубокую яму и не сможет самостоятельно выбраться\n");
                moveNext = false;
            }
        }
        else {
            System.out.printf("%s сошел с дистанции ранее и не побежал дальше\n", name);
            moveNext = false;
        }
        return moveNext;
    }
}
