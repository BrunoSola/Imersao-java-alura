Olá, seja bem-vindo!

Sou iniciante em programação e este é meu primeiro desafio em java.
| 🪧 Vitrine.Dev |     |
| -------------  | --- |
| ✨ Nome        | Imersão Java
| 🏷️ Tecnologias | Java, Spring, MongoDB, Heroku, Postman
| 🚀 URL         | 
| 🤿 Desafio | https://cursos.alura.com.br/imersoes (Imersao Java 1)

# Objetivo
- [Consumir API de filmes, criar JsonParse para manipular o Json(utilizando expressões regulares)](https://github.com/BrunoSola/Imersao-Java#1---consumir-api-de-filmes-criar-jsonparse-para-manipular-o-json)
- Criar figurinhas personalizadas, com base nos atributos do Json;
- Melhoria de codigo com POO(encapsulamento e refatoração);
- Criar Propria API com Spring;
- Publicar a API no Cloud.

## 🔨 Tecnologias

- ``Java``
- ``Spring``
- ``MongoDB``
- ``Heroku``
- ``Postman``

# 1 - Consumir API de filmes, criar JsonParse para manipular o Json

Primeiramente, é necessario definir a API. Neste caso, escolhemos o site do <a href="https://imdb-api.com/" target="_blank">IMDb-API</a>, e a API do top250 filmes.
O site do IMDb-API exige que se cadastremos, e assim cada usuario terá sua API key, para que se possa utilizar dos seus serviços.

Acessando sua API key:
- [x] Após se registrar e confirmar o registro pelo recebimento do e-mail
- [x] Clicar no nome do usuário
- [x] Abrir o Profile
- [x] Abrir API Tester
- [x] Pronto, sua API Key estará visível

Localizando a API top250 filmes:
- [x] Acessar a aba API,no site do [IMDb-API](https://imdb-api.com/).
- [x] Procurar na coluna Others API - Top250Movies().
<img src="https://user-images.githubusercontent.com/79088492/206038578-cc210144-bc6f-43d1-bf25-a3ca6eb7e983.png" align="center"/>

- [x] Copiar a URL da API.
<img src="https://user-images.githubusercontent.com/79088492/206039818-9775e678-0582-4108-8957-00672e6c8a42.png" align="center"/>


## Agora é hora de codar! 😁

### Bibliotecas
#### app.java
``` Java
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
```
[Infos sobre http](https://docs.oracle.com/en/java/javase/12/docs/api/java.net.http/java/net/http/package-summary.html)<br/>
[Infos sobre URI](https://docs.oracle.com/javase/7/docs/api/java/net/URI.html)

#### JsonParse.java
``` Java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
```
[Infos sobre regex](https://docs.oracle.com/javase/8/docs/api/index.html?java/util/regex/package-summary.html)<br/>
*Obs:* ***É de extrema importancia a importação de todas as bibliotecas para correto funcionamento do programa.***

### Resultado #1
Utilizamos o *for* para percorer *listOfMovies*, pegar(*get*) os atributos e mostrar no *terminal*.
``` Java
for (Map<String, String> movies: listOfMovies){
            System.out.println(movies.get("title"));
            System.out.println(movies.get("image"));
            System.out.println(movies.get("imDbRating"));
            System.out.println();
            }
```            
<img src="https://user-images.githubusercontent.com/79088492/206053859-054a3fcd-20b4-45a2-b74e-4dc30b01c68f.png" aling="center" /><br/>

#### Tarefas extras: Decorar terminal

- [x] Realce do texto
- [x] Cores no Terminal
- [x] Sistema de Avaliação

- Title
``` Java
System.out.println("\u001b[1;30;42m"+"Title:"+"\u001b[m "+"\u001b[1;4;32m" + movies.get("title")+ "\u001b[m");
``` 
- Movie Cover
``` Java
System.out.println("\u001b[1;30;44m"+"Movie cover:"+"\u001b[m "+ movies.get("image"));
``` 
- Rating IMDb
``` Java
var starRating = new StarRating();
double rating = Double.parseDouble(movies.get("imDbRating"));
System.out.println("\u001b[1;30;43m" + "Rating IMDb:" + "\u001b[m" + starRating.generateStar(rating));
``` 
- Resultado no terminal
<img src="https://user-images.githubusercontent.com/79088492/206338918-541fc0e2-0c49-437d-a97b-99a210b268b5.png" aling="center"><br/>
  
  


