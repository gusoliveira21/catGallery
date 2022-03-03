# catGallery

## :dart: Objetivo:
- Consumir uma API pública.
- Buscar imagens de gatos na api.
- Mostrar imagens na galeria.
- Ter uma tela.


## :wrench: Arquitetura usada:
<br>
<p align="center">
<img src='https://user-images.githubusercontent.com/42920754/156558383-363f3383-31f5-41dd-9621-a0a69368e136.png' width='25%' heigth="25%">
<p/>

## :bulb: Ferramentas utilizadas:
- **Retrofit**: Utilizada para facilitar o consumo de serviços web, recebendo uma lista de dados.
- **LiveData**: Foi utilizada para observar a lista de Url's, até que o retroit recebesse os dados.
- **Binding**: Utilizado para vincular os dados da View.
- **Coroutine**: Auxiliou o retrofi no recebimento dos dados, de modo a não interromper o funcionamento da aplicação.
- **Glide**: Recurso usado para obter a imagem vinculada ao URL e converter para bitmap.
- **Glide Transformations**: Sendo uma extenção do Glide, foi usado para que as imagens se mantivessem em um tamanho padrão.


## :anger: Desafios:
<p>No começo, meu maior desafio foi entender como eu poderia utilizar ID-Secret utilizando diretamente o Retrofit, sem ter que recorrer a abordagens muito mirabolantes e ao mesmo tempo enteder como criar uma estrutura de classes que suportariam meu resultado Json sem ter um modelo que fizesse sentido para ter uma base. Foi ai que resolvi utilizar o tipo String para obter uma resposta do Retrofit sem ter uma estrutura de classe para receber meu Json. Com os dados retornados da API em mãos, recorri ao bom e velho "Json to Kotlin" para agilizar o trabalho de criação das classes de dados.
<p/>
<p>
Após isso, meu empecilho foi fazer o retorno dos meus dados não travarem o aplicativo devido a demora na resposta, para isso, precisei aprender a utilizar Coroutines para fazer minha chamada a api e seleção dos endereços das imagens em segundo plano.
<p/>
<p>
Por fim, estava tendo trabalho com obtenção das imagens por meio do URL, tentei converter em Bitmap e enviar para a view, mas nunca funcionada, logo, recorri a boa e velha pesquisa e encontrei a API Glide, ferramenta que me ajudou muito na finalização do trabalho.<p/>
