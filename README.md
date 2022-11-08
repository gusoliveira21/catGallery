# catGallery v1.2

## :dart: Objetivo:
- Modificar appbar.
- Ajustar app para não atualizar lista depois de voltar do fullscreen.
- adicionar drawer layout com uma breve apresentação (opcional)

## :wrench: Design sugerido:
<br>
<p align="center">
<img src='https://user-images.githubusercontent.com/42920754/200461550-f0571c1d-1a29-40d5-915d-f61413d5ccda.PNG' width='25%' heigth="25%">
<img src='https://user-images.githubusercontent.com/42920754/200461558-bf7aed18-8f7d-4f57-9f8b-7ab80b57c564.PNG' width='25%' heigth="25%">
<p/>


## :bulb: Ferramentas utilizadas:
- **Koin**: Para injeção de dependência.
- **Retrofit**: Utilizada para facilitar o consumo de serviços web, recebendo uma lista de dados.
- **LiveData**: Foi utilizada para observar a lista de Url's, até que o retroit recebesse os dados.
- **Binding**: Utilizado para vincular os dados da View.
- **Coroutine**: Auxiliou o retrofi no recebimento dos dados, de modo a não interromper o funcionamento da aplicação.
- **Glide**: Recurso usado para obter a imagem vinculada ao URL e converter para bitmap.
- **Glide Transformations**: Sendo uma extenção do Glide, foi usado para que as imagens se mantivessem em um tamanho padrão.
- **Pallet**: Foi utilizado para selecionar a cor dominante da imagem.

### :mag_right: Ferramentas utilizadas - Testes:
- **Expresso**
- **Mockito**
