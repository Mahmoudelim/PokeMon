package com.example.pokeman

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokeman.ui.theme.PokeManTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokeManTheme {
              val navController= rememberNavController()
                NavHost(navController = navController, startDestination = "PokeMon_listScreen") {

                    composable("PokeMon_listScreen"){

                }
                    composable("PokeMon_DetailsScreen/{dominantColor}/{pokemonName}"
                    ,
                        arguments = listOf(
                            navArgument("dominantColor"){
                                type= NavType.IntType
                            } ,
                            navArgument("pokemonName"){
                                type= NavType.StringType
                            }
                        )

                    ){
                        val dominantColor= remember {
                             val color = it.arguments?.getInt("dominantColor")
                             color?.let { Color(it)  } ?: Color.White
                        }
                        val pokemonName = remember {
                                it.arguments?.getString("pokemonName")
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PokeManTheme {
        Greeting("Android")
    }
}