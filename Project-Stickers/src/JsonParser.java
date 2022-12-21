import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonParser {
    // Expressao regular - Criada para o Json especifico.
    // 1ª Expressao visa, pegar todos os conteudos dentro da lista [ ].
    private static final Pattern REGEX_ITEMS = Pattern.compile(".*\\[(.+)\\].*");

    // 3ª Expressao visa, pegar todos os conteudos com o seguinte parametro, ex: "id":"12345".
    // Expressao regular - Criada para o Json especifico.
    private static final Pattern REGEX_ATRIBUTOS_JSON = Pattern.compile("\"(.+?)\":\"(.*?)\"");

    public List<Map<String, String>> parse(String json) {

        Matcher matcher = REGEX_ITEMS.matcher(json);
        if (!matcher.find()) {

            throw new IllegalArgumentException("Não encontrou items.");
        }
        // 2.ª Expressao visa, como os objetos são separados por {"id":"conteudo"...},{"id":"conteudo"...}.
        // A expressao vai quebrar os conteudos no separador -> },{ e armazenar o texto numa lista.
        String[] items = matcher.group(1).split("\\},\\{");

        // Cria lista de dados
        List<Map<String, String>> dados = new ArrayList<>();

        // Percorrer os ‘items’ e cria um HashMap(Chave-Valor= ex: "id":"12345") adicionando os valores em atributosItem.

        for (String item : items) {

            // Cria um HashMap(Chave-Valor= ex: "id":"12345")
            Map<String, String> atributosItem = new HashMap<>();

            // Agora é chamado a 3.ª expressao regular, que visa pegar os valores de chave-valor dentro das "."
            Matcher matcherAtributosJson = REGEX_ATRIBUTOS_JSON.matcher(item);
            while (matcherAtributosJson.find()) {
                String atributo = matcherAtributosJson.group(1);
                String valor = matcherAtributosJson.group(2);
                atributosItem.put(atributo, valor);
            }
            //Adiciona os atributos na lista de dados.
            dados.add(atributosItem);
        }

        return dados;

    }
}
