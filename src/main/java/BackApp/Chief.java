package BackApp;

import java.util.concurrent.TimeUnit;

public class Chief extends Person {
    private Integer orderId = 0;

    public synchronized void update(Food food) throws InterruptedException {
        System.out.println("Order #" + orderId + " has been accepted. " + food.getName());
        TimeUnit.SECONDS.sleep(2);
        food.setReady(true);
    }
}
