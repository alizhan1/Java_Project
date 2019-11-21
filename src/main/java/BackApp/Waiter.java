package BackApp;

public class Waiter extends Person {

    private static Integer counter = 0;

    private Integer assignedTable;
    private Integer waiterId;

    public Waiter(Integer assignedTable) {
        counter++;
        this.waiterId = counter;
        this.assignedTable = assignedTable;
    }

    public void takeOrder(Chief chief, Food food) throws InterruptedException {
        chief.update(food);
    }

    public Integer getWaiterId() {
        return waiterId;
    }

    public Integer getAssignedTable() {
        return assignedTable;
    }
}
