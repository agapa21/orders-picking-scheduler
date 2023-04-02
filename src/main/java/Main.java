import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String args[]) {

        Store store = new Store();
        List<Order> orders = Collections.synchronizedList(new ArrayList<Order>());

        StoreJsonReader storeJsonReader = new StoreJsonReader(args[0], store);
        OrdersJsonReader ordersJsonReader = new OrdersJsonReader(args[1], orders);

        Picker[] pickers = new Picker[store.pickersArray.length];

        for(int i = 0; i<store.pickersArray.length;i++)
        {
            pickers[i] = new Picker(store.pickersArray[i], store.pickingStartTime, store.pickingEndTime);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(store.pickersArray.length);

        Signal[] signals = new Signal[pickers.length];

        for(int i = 0; i < signals.length; i++)
        {
            signals[i] = new Signal();
        }

        SignalCheck signalCheck = new SignalCheck();

        while (!orders.isEmpty()) {
            for (int i = 0; i < pickers.length; i++) {
                executorService.execute(new TaskDistributor(orders, pickers[i], signals[i]));
            }
            signalCheck.checkSignals(signals, orders);
        }

        executorService.shutdown();

    }
}
