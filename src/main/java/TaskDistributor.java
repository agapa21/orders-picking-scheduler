import java.time.LocalTime;
import java.util.List;

public class TaskDistributor extends Thread{

    Order getOrder = new Order();
    int pickingTime;
    int counter=0;

    TaskDistributor(List<Order> orders, Picker picker, Signal signal) {

        while(counter<orders.size()) {

            getOrder = orders.get(counter);

            pickingTime = Integer.parseInt(getOrder.pickingTime);

            try {

                LocalTime d = LocalTime.parse(picker.myTime);
                LocalTime d1 = d.plusMinutes(pickingTime);

                LocalTime d2 = LocalTime.parse(picker.myTime);
                LocalTime d3 = LocalTime.parse(picker.myEndTime);

                if (d.isAfter(d2) || d.equals(d2)) {

                    if (d1.isBefore(d3) || d1.equals(d3)) {
                        System.out.println(picker.id + " " + getOrder.orderID + " " + d);
                        orders.remove(0);
                        for (int i = 0; i < orders.size(); i++) System.out.println(orders.get(i).orderID);
                        picker.myTime = d1.toString();
                        return;
                    } else {
                        counter++;
                    }
                } else {
                    counter++;
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
        signal.s = false;
    }

    @Override
    public void run() {

    }
}

