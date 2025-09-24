package com.example.juegoclicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.internal.rememberComposableLambdaN
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.juegoclicker.ui.theme.JuegoClickerTheme
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JuegoClickerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding),

                    )
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    var estado by remember { mutableStateOf(1) };
    var contador by remember { mutableStateOf(0) }


    val (imgId, titulo) = when (estado) {
        1 -> Pair(R.drawable.principal, stringResource(R.string.title1));
        2 -> Pair(R.drawable.bulder,stringResource(R.string.title2 ));
        3 -> Pair(R.drawable.everest, stringResource(R.string.title5));
        4 -> Pair(R.drawable.tienda, stringResource(R.string.title4));
        5 -> Pair(R.drawable.desplome, stringResource(R.string.title3));
        else -> Pair(R.drawable.principal, stringResource(R.string.title1));
    }

    // Cambiar "Contraste" texto presentación puntos.

    ArrancarApp(
        imgId = imgId,
        titulo = titulo,
        estado = estado,
        contar = contador,
        onBotonClick = {
            val nuevoEstado = (1..5).random();
            estado = nuevoEstado;

            if(estado == 4){
                contador++
            }
        },

    )
}

@Composable
fun ArrancarApp(
    imgId: Int,
    onBotonClick: () -> Unit,
    estado: Int,
    contar: Int,
    titulo: String,
){
    var img = painterResource(imgId);

    Surface(
        color = MaterialTheme.colorScheme.background,
    ) {
        // Imagen de fondo
        Image(
            painter = img,
            contentDescription = "Img Principal",
            contentScale = ContentScale.Crop,

            //modifier = Modifier.fillMaxHeight().fillMaxWidth(),
            modifier = Modifier.fillMaxSize(),
            )


            // Contenido encima de la imagen
            Column(
               horizontalAlignment = Alignment.CenterHorizontally,
               modifier = Modifier.fillMaxHeight(),
            ) {
                Text(
                    text = titulo,
                    color = colorResource(id = R.color.miColor),

                    modifier = Modifier
                        .fillMaxWidth(0.65f)
                        .align(Alignment.End)
                        .padding(top = 35.dp, end = 10.dp),


                    lineHeight = 50.sp,
                    fontSize = 50.sp,
                    textAlign = TextAlign.Right,

                    style = TextStyle(
                        shadow = Shadow(
                            color = Color.Blue,
                            offset = Offset(4f, 4f),
                            blurRadius = 6f,
                        )
                    )
                )

                // Esta interesante pero me hecha el Row hasta abajo del todo:
               // Spacer( modifier = Modifier.weight(0.5f) )

                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ){
                    Button(
                        onClick = onBotonClick,
                        modifier = Modifier.padding(top = 600.dp),
                    ) {
                        Text(
                            text = stringResource(R.string.btnStart),
                            fontSize = 35.sp,

                        )
                    } // END Button

                } // END Row
                Text(
                    // Falta cambiar el color del texto respecto a imagen/por contrastes.
                    color = colorResource(R.color.miColor),
                    text = "Pntalla número: $estado | Imagenes repetidas: $contar", 
                    fontSize = 18.sp,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(top = 18.dp, start = 15.dp),
                )
            }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JuegoClickerTheme {
        Greeting("Android")
    }

}