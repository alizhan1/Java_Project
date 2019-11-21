package BackApp;

public class Payment {
    private static final int MASTERCARD = 1;
    private static final int VISA = 2;
    private static final int CASH = 3;

    private int paymentMethod;

    public Payment(int paymentMethod) {
        if (paymentMethod == MASTERCARD || paymentMethod == VISA || paymentMethod == CASH) {
            this.paymentMethod = paymentMethod;
        }
        else {
            System.out.println("[ERROR] Incorrect payment method specified!");
        }
    }
}
