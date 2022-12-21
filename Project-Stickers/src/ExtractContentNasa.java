import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtractContentNasa implements ExtractContent{

    public List<Content> extractContent(String json) {

        JsonParser parser = new JsonParser();
        List<Map<String, String>> listOfAttributes = parser.parse(json);
        List<Content> contentAttributes = new ArrayList<>();

        for(Map<String, String> attributes : listOfAttributes) {
            String title = attributes.get("title");
            String urlImage = attributes.get("url");
            var content = new Content(title, urlImage);
            contentAttributes.add(content);

        }
        return contentAttributes;
    }
}
