import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class Project {
    public static void main(String[] args) throws Exception {
        final String API_SECRET = System.getenv("API_SECRET_KEY");

        //String url = "https://imdb-api.com/en/API/Top250Movies/" + API_SECRET;
        //ExtractContent extract = new ExtractContentIMDB();

        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-12-12&end_date=2022-12-13";
        ExtractContent extract = new ExtractContentNasa();

        String json = new ClientHttp().bodyResponse(url);

        List<Content> attributes = extract.extractContent(json);

        var generator = new GeneratorStickers();

            for (int i = 0; i < attributes.size(); i++) {
                Content content = attributes.get(i);

                InputStream inputStream = new URL(content.urlImage()).openStream();
                String fileName = content.title() + ".png";
                generator.cria(inputStream, fileName, content.title());

                System.out.println(content.title());
                System.out.println();
            }
        }
}
