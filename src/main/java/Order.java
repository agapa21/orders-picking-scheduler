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
        pickingTime = pT;
    }
}
