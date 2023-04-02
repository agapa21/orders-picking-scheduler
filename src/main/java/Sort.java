import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Sort {

    Sort(){}

    //sorting orders by completeBy
    public JSONArray sortJSON(JSONArray jsonArr) {

        JSONArray sortedJsonArray = new JSONArray();

        List<JSONObject> jsonValues = new ArrayList<JSONObject>();
        jsonArr.forEach( emp -> jsonValues.add((JSONObject) emp) );
        Collections.sort( jsonValues, new Comparator<JSONObject>() {

            private static final String KEY_NAME = "completeBy";

            @Override
            public int compare(JSONObject a, JSONObject b) {
                String valA = new String();
                String valB = new String();

                try {
                    valA = (String) a.get(KEY_NAME);
                    valB = (String) b.get(KEY_NAME);
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }

                return valA.compareTo(valB);
            }
        });

        for (int i = 0; i < jsonArr.size(); i++) {
            sortedJsonArray.add(jsonValues.get(i));
        }

        return sortedJsonArray;
    }
}
