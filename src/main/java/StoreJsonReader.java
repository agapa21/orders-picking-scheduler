import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.*;
import java.util.*;


public class StoreJsonReader {

    StoreJsonReader(String file, Store store)
    {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(file))
        {
            JSONObject obj = (JSONObject) jsonParser.parse(reader);

            parseStore(obj, store);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void parseStore(JSONObject storeObj, Store store)
    {
        JSONArray jsonArray = (JSONArray) storeObj.get("pickers");
        String[] array = new String[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            array[i] = (String)jsonArray.get(i);
        }
       store.setPickersArray(array);
        /*Iterator<String> iterator = jsonArray.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/

        store.setPickingStartTime((String) storeObj.get("pickingStartTime"));
        //System.out.println(pickingStartTime);

        store.setPickingEndTime((String) storeObj.get("pickingEndTime"));
        //System.out.println(pickingEndTime);
    }
}
