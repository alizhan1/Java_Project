package BackApp;

public class Waiter extends Person {
    private static Integer counter = 0;

    private Integer waiterId;

    public Waiter() {
        counter++;
        this.waiterId = counter;
    }

    public void takeOrder(Chief chief, Food food) throws InterruptedException {
        chief.update(food);
    }

    public Integer getWaiterId() {
        return waiterId;
    }
}
