import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TaskDistributor extends Thread{

    Order getOrder1 = new Order();
    Order getOrder2 = new Order();
    String myTime;
    int pickingTime1;
    int pickingTime2;
    int myID;
    List <Order> myOrders = new ArrayList<Order>();

    TaskDistributor(List<Order> orders, Picker picker) {

        getOrder1 = orders.get(0);

        pickingTime1 = Integer.parseInt(getOrder1.pickingTime);

            try {

                LocalTime d = LocalTime.parse(picker.myTime);
                LocalTime d1 = d.plusMinutes(pickingTime1);

                LocalTime d2 = LocalTime.parse(picker.myTime);
                LocalTime d3 = LocalTime.parse(picker.myEndTime);

                    if (d.isAfter(d2) || d.equals(d2)) {

                        if (d1.isBefore(d3) || d1.equals(d3)) {
                            myOrders.add(getOrder1);
                            System.out.println(picker.id + " " + getOrder1.orderID + " " + d);
                            orders.remove(0);
                            picker.myTime = d1.toString();
                        } else {
                            orders.removeAll(orders);
                            return;
                        }
                    }

            } catch (Exception e) {

                e.printStackTrace();
            }

    }
    @Override
    public void run() {

    }
}

