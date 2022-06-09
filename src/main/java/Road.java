public class Road implements Difficultness {
    double length;

    public Road(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    @Override
    public double high() {
        return length;
    }

    @Override
    public double distance() {
        return 0;
    }

    @Override
    public double difficult() {
        return length;
    }

    @Override
    public void about() {
        System.out.println("Впереди дорога длиной " + length + " м.");
    }

}
