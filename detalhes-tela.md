# Entrega 1 - Telas

### O projeto possui até o momento 5 telas sendo elas
- [Explorar](app/src/main/java/com/example/serraapp/ui/screens/ExploreScreen.kt)
  - Essa tela mostra um card com temperatura e nome da cidade, mostrando logo abaixo uns cards com pontos turísticos, esses dados usados estão mocados localizados em [Arquivo de dados](app/src/main/java/com/example/serraapp/data/FakeData.kt), ícone de busca presente, mas apenas ilustrativo no topBar. Além disso, possui um botão flutuante de adicionar mais  pontos.
- [Tela de Detalhes](app/src/main/java/com/example/serraapp/ui/screens/DetailScreen.kt)
  - Essa tela posso abrir tanto pela tela de explorar, quanto pela tela de favoritos, mostrando imagem maior, titulo e descrição do local selecionado, botão de voltar presente
- [Favoritos](app/src/main/java/com/example/serraapp/ui/screens/FavoritesScreen.kt)
  - Essa tela lista favoritos fixos dois dos pontos que estão mocados, abrindo também a tela de detalhes que posso abrir no explorar
- [Tela de Roteiros](app/src/main/java/com/example/serraapp/ui/screens/ItineraryScreen.kt)
  - Tela ainda com rascunho bem breve para futura implementação
- [Tela de Perfil](app/src/main/java/com/example/serraapp/ui/screens/ProfileScreen.kt)
  - Essa tela possui apenas um rascunho para possível implementação, só adicionei para dar mais estética ao app

### Componentes das telas:
- [Top Bar](app/src/main/java/com/example/serraapp/ui/components/SerraTopBar.kt)
- [Bottom Bar](app/src/main/java/com/example/serraapp/ui/components/BottomBar.kt)
- [Card na tela Explorar](app/src/main/java/com/example/serraapp/ui/components/WeatherCard.kt) - De temperatura e nome da cidade
- [Card de lugares que aparece na tela Explorar](app/src/main/java/com/example/serraapp/ui/components/PlaceCard.kt)


### A navegação dessas telas é controlada no [Navigation](app/src/main/java/com/example/serraapp/ui/navigation/Navigation.kt), A tela de ínicio do app é a Explorar
