package json;

import com.google.gson.Gson;
import director.Director;
import org.apache.log4j.Logger;

public class JsonGenerator {
    private static Logger LOG = Logger.getLogger(JsonGenerator.class.toString());

    public static void serialize(Director director, String path){
        //библиотека для сериализации в JSON
        Gson json = new Gson();
        String result = json.toJson(director);

        // генерация json строки
        LOG.info(result);
    }
}
