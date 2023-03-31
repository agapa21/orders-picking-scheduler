import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String args[])
    {
        Store store = new Store();
        List <Order> orders = new ArrayList<Order>();

        StoreJsonReader storeJsonReader = new StoreJsonReader(args[0], store);
        OrdersJsonReader ordersJsonReader = new OrdersJsonReader(args[1], orders);
    }
}
