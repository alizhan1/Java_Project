package BackApp;

public class Table {
    private int capacity;
    public int getCapacity() {
        return capacity;
    }

    private boolean isOccupied;
    public boolean isOccupied() {
        return isOccupied;
    }

    public Table(int _capacity, boolean _isOccupied) {
        this.capacity = _capacity;
        this.isOccupied =_isOccupied;
    }

    public void occupy() {
        this.isOccupied = true;
    }

    public void unoccupy() {
        this.isOccupied = false;
    }
}
