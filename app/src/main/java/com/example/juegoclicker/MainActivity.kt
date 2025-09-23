package com.example.juegoclicker

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
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
    val img1 = painterResource(R.drawable.principal);
    var puntos: Int = 0;
    Surface(
        color = MaterialTheme.colorScheme.background,
    ) {
        // Imagen de fondo
        Image(
            painter = img1,
            contentDescription = "Img Principal",
            contentScale = ContentScale.FillBounds,

            modifier = Modifier.fillMaxHeight().fillMaxWidth(),

            )


            // Contenido encima de la imagen
            Column(
               horizontalAlignment = Alignment.CenterHorizontally,
               modifier = Modifier.fillMaxHeight(),
            ) {
                Text(
                    text = stringResource(R.string.title),
                    color = colorResource(id = R.color.miColor),

                    modifier = Modifier
                        .fillMaxWidth(0.55f)
                        .align(Alignment.End)
                        .padding(top = 35.dp, end = 5.dp),


                    lineHeight = 50.sp,
                    fontSize = 50.sp,
                    textAlign = TextAlign.Center,

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
                        onClick = {puntos++},
                        modifier = Modifier.padding(top = 600.dp),
                    ) {
                        Text(
                            text = stringResource(R.string.btnStart),
                            fontSize = 35.sp,

                        )
                    } // END Button

                } // END Row
                Text(
                    color = colorResource(R.color.miColor),
                    text = "Los puntos que estas obteniendo son: $puntos", // RECUERDA $puntos- Tengo que poner variable del contador
                    fontSize = 18.sp,
                    modifier = Modifier.align(Alignment.Start).padding(top = 18.dp, start = 15.dp),
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