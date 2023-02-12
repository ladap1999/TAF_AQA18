package adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.annotations.BeforeTest;

public class BaseAdapter {
    protected Gson gson;

    public Gson getGson() {
        if (gson == null) {
            gson = new Gson();
            gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();
        }
        return gson;
    }
}
