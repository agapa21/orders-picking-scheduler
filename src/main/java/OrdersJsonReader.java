import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class OrdersJsonReader {
    OrdersJsonReader(String file, List<Order> orders) {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(file)) {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);

            Sort sort = new Sort();
            jsonArray = sort.sortJSON(jsonArray);

            jsonArray.forEach( emp -> parseOrder( (JSONObject) emp , orders) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void parseOrder(JSONObject orderObj, List<Order> orders) {

            Order order = new Order();

            order.setOrderID((String) orderObj.get("orderId"));
            //System.out.println(orderID);

            order.setCompleteBy((String) orderObj.get("completeBy"));
            //System.out.println(completeBy);

            order.setPickingTime((String) orderObj.get("pickingTime"));

            orders.add(order);
    }
}
