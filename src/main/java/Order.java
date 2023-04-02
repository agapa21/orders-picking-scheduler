import java.text.SimpleDateFormat;
import java.time.LocalTime;

public class Order {

    String orderID;
    String completeBy;
    String pickingTime;

    Order(){}

    public void setOrderID(String oID){
        orderID = oID;
        //System.out.println(orderID);
    }

    public void setCompleteBy(String cB){
        completeBy = cB;
    }

    public void setPickingTime(String pT){
        //orders.forEach( emp -> checkTime( (Order) emp , store) );

        pickingTime = pT.replaceAll("[\\D]", "");

    }
}
