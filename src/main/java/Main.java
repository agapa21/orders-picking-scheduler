import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String args[])
    {
        Store store = new Store();
        List <Order> orders = new ArrayList<Order>();

        StoreJsonReader storeJsonReader = new StoreJsonReader(args[0], store);
        OrdersJsonReader ordersJsonReader = new OrdersJsonReader(args[1], orders);

        ExecutorService executorService = Executors.newFixedThreadPool(store.pickersArray.length);
        for (int i = 0; i < store.pickersArray.length; i++) {
            //executorService.execute();
        }
        executorService.shutdown();


    }
}
