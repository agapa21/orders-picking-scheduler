import java.text.SimpleDateFormat;
import java.time.LocalTime;

public class Order {

    String orderID;
    String completeBy;
    String pickingTime;

    Order(){}

    public void setOrderID(String oID){
        orderID = oID;
    }

    public void setCompleteBy(String cB){
        completeBy = cB;
    }

    public void setPickingTime(String pT){

        pickingTime = pT.replaceAll("[\\D]", "");

    }
}
