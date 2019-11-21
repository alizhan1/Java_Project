package BackApp;

public class Table {
    private int capacity;
    private boolean isOccupied;

    public Table(int capacity, boolean isOccupied) {
        this.capacity = capacity;
        this.isOccupied = isOccupied;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public int getCapacity() {
        return capacity;
    }

    public void occupy() {
        this.isOccupied = true;
    }

    public void unoccupy() {
        this.isOccupied = false;
    }
}
