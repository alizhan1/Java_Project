package BackApp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bill {
    private static Integer counter = 0;

    private Integer billNumber;
    private Payment payment;
    private Date date;
    private Integer tableId;
    private Integer waiterId;
    private Map<String, Integer> orderMap = new HashMap<>();

    public Bill(Integer paymentMethod, Waiter waiter, List<Food> orders) {
        this.payment = new Payment(paymentMethod);
        this.date = new Date();
        this.tableId = waiter.getAssignedTable();
        this.waiterId = waiter.getWaiterId();
        for (Food order : orders) {
            orderMap.put(order.getName(), order.getPrice());
        }
        this.billNumber = counter;
        this.counter++;
    }

    public Date getDate() {
        return date;
    }

    public Integer getBillNumber() {
        return billNumber;
    }

    public Integer getTableId() {
        return tableId;
    }

    public Integer getWaiterId() {
        return waiterId;
    }

    public Map<String, Integer> getOrderMap() {
        return orderMap;
    }

    public Payment getPayment() {
        return payment;
    }
}