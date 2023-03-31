import java.util.Arrays;

public class Store {
    String[] pickersArray;
    String pickingStartTime;
    String pickingEndTime;

    Store(){}

    public void setPickersArray(String[] pA){
        pickersArray = pA;
        //System.out.println(Arrays.toString(pickersArray));
    }

    public void setPickingStartTime(String pST){
        pickingStartTime = pST;
    }

    public void setPickingEndTime(String pET){
        pickingEndTime = pET;
    }
}
