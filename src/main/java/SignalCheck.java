import java.util.List;

public class SignalCheck {

    public void checkSignals(Signal[] signals, List<Order> orders)
    {
        for(int i=0; i < signals.length; i++)
        {
            if (signals[i].s == true) return;
        }

        orders.removeAll(orders);
    }
}
