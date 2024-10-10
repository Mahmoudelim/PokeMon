package com.example.pokeman.DetailScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.Top
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.Coil
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.request.ImageRequest
import com.example.pokeman.data.remote.response.pokemon
import com.example.pokeman.util.Resource

@Composable
fun PokemonDetailScreen(
    dominantColor:Color ,
    pokemonName : String ,
    navController: NavController,
    topPadding:Dp =20.dp,
    pokemonImageSize:Dp =200.dp,
    viewModel: PokemonDetailViewModel= hiltViewModel()
) {
      val pokemonInfo = produceState <Resource<pokemon>>(initialValue = Resource.Loading() ) {
        value = viewModel.getPokemonInfo(pokemonName)
      }.value
    Box(modifier = Modifier
        .fillMaxSize()
        .background(dominantColor)
        .padding(bottom = 16.dp)
    ){
        PokemonDetailTopSection(navController = navController,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .align(TopCenter)
        )
        PokemonDetailStateWrapper(
            pokemonInfo = pokemonInfo ,
            modifier = Modifier
                .fillMaxSize()
                .padding(top= topPadding + pokemonImageSize/2f ,
                    start = 16.dp , end = 16.dp , bottom = 16.dp )
                .shadow(10.dp , RoundedCornerShape(10.dp) )
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colorScheme.surface)
                .padding(16.dp)
                .align(Alignment.BottomCenter)
        )
         Box (modifier = Modifier
             .fillMaxSize() , contentAlignment = Alignment.TopCenter ,
         ) {
                 if (pokemonInfo is Resource.Success)
                 {
                  pokemonInfo.data?.sprites?.let {

                      SubcomposeAsyncImage(
                          model = ImageRequest.Builder(LocalContext.current)
                              .data(it.front_default)
                              .crossfade(true)
                              .build(),
                          contentDescription = pokemonInfo.data.name,
                          modifier = Modifier
                              .size(pokemonImageSize)
                              .offset(y = topPadding),
                          loading = {
                          },
                      )

                  }
                 }
         }

    }
 
}
@Composable
fun PokemonDetailTopSection(
    navController: NavController ,
    modifier: Modifier = Modifier
)
{

    Box(
        contentAlignment = TopCenter ,
        modifier = modifier.background(

            Brush.verticalGradient(
                listOf(
                    Color.Black ,
                    Color.Transparent ,

                )
            )
        )
    )
    {
     Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null
     ,
         tint = Color.White ,
         modifier = Modifier
             .size(36.dp)
             .offset(16.dp, 16.dp)
             .clickable {
                 navController.popBackStack()
             }

     )

    }
}


@Composable
fun PokemonDetailStateWrapper(
    pokemonInfo:Resource<pokemon>,
    modifier: Modifier =Modifier ,
    loadingModifier: Modifier = Modifier

)
{
   when(pokemonInfo) {
    is Resource.Success -> {

    }
       is Resource.Error ->
       {
            Text(text = pokemonInfo.message!! ,
                color = Color.Red ,
                modifier = modifier
                )
       }
       is Resource.Loading ->
       {
           println("loading")
       }
}
}


