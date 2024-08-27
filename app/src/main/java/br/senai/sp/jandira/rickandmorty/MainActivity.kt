package br.senai.sp.jandira.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.rickandmorty.model.Character
import br.senai.sp.jandira.rickandmorty.service.RetrofitFactory
import br.senai.sp.jandira.rickandmorty.ui.theme.RickAndMortyTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            RickAndMortyTheme {
                GetCharacter()

            }
        }
    }
}

@Composable
fun GetCharacter(modifier: Modifier = Modifier) {

    var id by remember {
        mutableStateOf("")
    }



    var character by remember {
        mutableStateOf("")
    }

    Column(modifier = modifier.padding(16.dp)){

        OutlinedTextField(
            value = id,
            onValueChange = {id = it},
            label = {
                Text(text = "Digite o nome do personagem")
            }
        )
        Button(onClick = {

            val callCharacter = RetrofitFactory().getCharacterService().getCharacterById(id.toInt())
           callCharacter.enqueue(object : Callback<Character>{
               override fun onResponse(p0: Call<Character>, p1: Response<Character>) {


                   character = response.body()!!
               //character = response.body()!!
               }

               override fun onFailure(p0: Call<Character>, p1: Throwable) {
                   TODO("Not yet implemented")
               }


           })
        }) {
            Text(text = "Buscar personagem")

        }

        Text(text = "nome ${character.name}")
        Text(text = "status ${character.name}")
        Text(text = "especie ${character.species}")
        Text(text = "origem ${character.origin?.name}")
        Text(text = "Location ${character.Location}")
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
    RickAndMortyTheme {
        Greeting("Android")
    }
}