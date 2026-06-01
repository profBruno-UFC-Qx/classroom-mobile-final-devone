# Entrega 1 - Telas

### O projeto possui até o momento 5 telas sendo elas
- [app/src/main/java/com/example/serraapp/ui/screens/ExploreScreen.kt](Explorar)
- - Essa tela mostra um card com temperatura e nome da cidade, mostrando logo abaixo uns cards com pontos turísticos, esses dados usados estão mocados localizados em [app/src/main/java/com/example/serraapp/data/FakeData.kt], ícone de busca presente, mas apenas ilustrativo no topBar. Além disso, possui um botão flutuante de adicionar mais  pontos.
- [app/src/main/java/com/example/serraapp/ui/screens/DetailScreen.kt](Tela de Detalhes)
- - Essa tela posso abrir tanto pela tela de explorar, quanto pela tela de favoritos, mostrando imagem maior, titulo e descrição do local selecionado, botão de voltar presente
- [app/src/main/java/com/example/serraapp/ui/screens/FavoritesScreen.kt](Favoritos)
- - Essa tela lista favoritos fixos dois dos pontos que estão mocados, abrindo também a tela de detalhes que posso abrir no explorar
- [app/src/main/java/com/example/serraapp/ui/screens/ItineraryScreen.kt](Tela de Roteiros)
- - Tela ainda com rascunho bem breve para futura implementação
- [app/src/main/java/com/example/serraapp/ui/screens/ProfileScreen.kt](Tela de Perfil)
- - Essa tela possui apenas um rascunho para possível implementação, só adicionei para dar mais estética ao app

### Componentes das telas:
- [app/src/main/java/com/example/serraapp/ui/components/SerraTopBar.kt](Top Bar)
- [app/src/main/java/com/example/serraapp/ui/components/BottomBar.kt](Bottom Bar)
- [app/src/main/java/com/example/serraapp/ui/components/WeatherCard.kt](Card na tela Explorar) - De temperatura e nome da cidade
- [app/src/main/java/com/example/serraapp/ui/components/PlaceCard.kt](Card de lugares que aparece na tela Explorar)


### A navegação dessas telas é controlada no [app/src/main/java/com/example/serraapp/ui/navigation/Navigation.kt](Navigation), A tela de ínicio do app é a Explorar