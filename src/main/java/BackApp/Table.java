package BackApp;

public class Table {
    private double capacity;
    private boolean isOccupied;

    public Table(double capacity, boolean isOccupied) {
        this.capacity = capacity;
        this.isOccupied = isOccupied;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public double getCapacity() {
        return capacity;
    }

    public void occupy() {
        this.isOccupied = true;
    }

    public void unoccupy() {
        this.isOccupied = false;
    }
}
