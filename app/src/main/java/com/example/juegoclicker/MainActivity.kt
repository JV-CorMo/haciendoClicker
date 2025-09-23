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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.juegoclicker.ui.theme.JuegoClickerTheme

import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

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
    Surface(
        color = MaterialTheme.colorScheme.background,
    ) {
        // Imagen de fondo
        Image(
            painter = img1,
            contentDescription = "Img Principal",
            contentScale = ContentScale.FillBounds,
            //modifier = Modifier.height(300.dp),
            modifier = Modifier.height(300.dp),

            )


            // Contenido encima de la imagen
            Column(
               horizontalAlignment = Alignment.CenterHorizontally,
               // modifier = Modifier.width(250.dp),
                modifier = Modifier.width(200.dp),
            ) {
                Text(
                    text = stringResource(R.string.saludo),
                    color = colorResource(id = R.color.miColor),

                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .align(Alignment.End)
                        .padding(0.dp),

                    textAlign = TextAlign.Center,
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