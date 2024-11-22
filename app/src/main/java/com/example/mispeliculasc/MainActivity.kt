package com.example.mispeliculasc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mispeliculasc.ui.theme.MisPeliculasCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MisPeliculasCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Esquema(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Esquema(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row( //Fila 1
            modifier = Modifier
                .fillMaxWidth()
                /* weight(nf) en Android divide el espacio disponible en un LinearLayout proporcionalmente entre los elementos
                 según sus pesos. El espacio que ocupa cada elemento se calcula en base a su peso dividido entre la suma total
                  de pesos. Depende de la proporción asignada a cada elemento.
                 */
                .weight(1f), // Cada fila ocupa una proporción igual de la altura total
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Mis Películas",
                modifier = Modifier
                    /* El prefijo "0xFF" define la opacidad (alfa) del color en formato hexadecimal. "FF" significa 100% opaco (sin transparencia).
                    Si no se añade, el color puede no mostrarse correctamente. "DFE4FF" es el color en formato RGB (rojo, verde, azul).
                    "0xFFDFE4FF" incluye el canal alfa (FF), que es obligatorio en Compose.*/
                    .background(Color(0xFFDFE4FF)) // Fondo azul claro (DFE4FF)
                    .border(2.dp, Color(0xFF354699)) // Borde azul oscuro (354699) de 2dp
                    .padding(6.dp),
                fontSize = 50.sp,
                color = Color(0xFF354699) // Texto con el mismo azul oscuro (354699)
                //style = MaterialTheme.typography.h6 // Para cambiar el estilo del texto
            )
        }
        //Espacio entre la Fila 1 y la Fila 2
        /* Aquí Spacer no es útil porque:
           - Con el Column los Row se apilan verticalmente de arriba a abajo. Dentro de un Column,
             los hijos (como Row) se posicionan uno debajo del otro en el orden en el que se declaran.
           - Con weight(1f) nos aseguramos de asignar una fracción igual del espacio del Column a cada Row.
             Esto evita que se superpongan unos con otros.
         */
        // Spacer(modifier = Modifier.height(1.dp))
        Row( //Fila 2
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), // Cada fila ocupa una proporción igual de la altura total
        ) {
            //Columna 1 de la Fila 2
            Column(
                modifier = Modifier
                    .weight(1f) // La columna ocupa la mitad del espacio horizontal
                    .fillMaxHeight(), // Ocupa toda la altura del Row
                horizontalAlignment = Alignment.CenterHorizontally // Centra los elementos horizontalmente
                //verticalArrangement = Arrangement.Center // Centra los elementos verticalmente. No necesario en este caso dado el weight()
            ) {
                //Box nos permite superponer elementos (en este caso las imágenes)
                Box (
                    modifier = Modifier
                        .weight(4f) //La Box ocupa 4 partes del espacio vertical
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.el_florero),
                        contentDescription = "Imagen del florero",
                        modifier = Modifier
                            .fillMaxSize() // Ocupa todo el ancho disponible
                    )
                    Image(
                        painter = painterResource(id = R.drawable.play),
                        contentDescription = "Imagen superpuesta del play",
                        modifier = Modifier
                            .align(Alignment.Center) // Centrar la imagen superpuesta
                            .size(100.dp) // Tamaño ajustado de la imagen superpuesta
                        //colorFilter = ColorFilter.tint(Color.White.copy(alpha = 0.8f)) // Opción para aplicar transparencia
                    )
                }
                Text("El Florero")
            }
            //Espacio entre las columnas de la Fila 2
            Spacer(modifier = Modifier.width(8.dp))
            //Columna 2 de la Fila 2
            Column(//Imagen 2 y texto 2 de la Fila 2
                modifier = Modifier
                    .weight(1f) // La columna ocupa la mitad del espacio horizontal
                    .fillMaxHeight(), // Ocupa toda la altura del Row
                horizontalAlignment = Alignment.CenterHorizontally // Centra los elementos horizontalmente
            ) {
                Box (
                    modifier = Modifier
                        .weight(4f) //La Box ocupa 4 partes del espacio vertical
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.el_bosque),
                        contentDescription = "Imagen del bosque",
                        modifier = Modifier
                            .fillMaxSize() // Ocupa todo el ancho disponible
                    )
                    Image(
                        painter = painterResource(id = R.drawable.play),
                        contentDescription = "Imagen superpuesta del play",
                        modifier = Modifier
                            .align(Alignment.Center) // Centrar la imagen superpuesta
                            .size(100.dp) // Tamaño ajustado de la imagen superpuesta
                        //colorFilter = ColorFilter.tint(Color.White.copy(alpha = 0.8f)) // Opción para aplicar transparencia
                    )
                }
                Text("El Bosque")
            }
        }

        Row( //Fila 3
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f) // Ocupa la misma proporción que las demás filas
        ) {
            //Columna 1 de la Fila 3
            Column( //Imagen 1 y texto 1 de la Fila 3
                modifier = Modifier
                    .weight(1f) // La columna ocupa la mitad del espacio horizontal
                    .fillMaxHeight(), // Ocupa toda la altura del Row
                horizontalAlignment = Alignment.CenterHorizontally // Centra los elementos horizontalmente
            ) {
                Box (
                    modifier = Modifier
                        .weight(4f) //La Box ocupa 4 partes del espacio vertical
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.otro_bosque),
                        contentDescription = "Imagen del otro bosque",
                        modifier = Modifier
                            .fillMaxSize() // Ocupa todo el ancho disponible
                    )
                    Image(
                        painter = painterResource(id = R.drawable.play),
                        contentDescription = "Imagen superpuesta del play",
                        modifier = Modifier
                            .align(Alignment.Center) // Centrar la imagen superpuesta
                            .size(100.dp) // Tamaño ajustado de la imagen superpuesta
                        //colorFilter = ColorFilter.tint(Color.White.copy(alpha = 0.8f)) // Opción para aplicar transparencia
                    )
                }
                Text("Otro Bosque")
            }
            //Espacio entre las columnas de la Fila 3
            Spacer(modifier = Modifier.width(8.dp))
            //Columna 2 de la Fila 3
            Column(//Imagen 2 y texto 2 de la Fila 3
                modifier = Modifier
                    .weight(1f) // La columna ocupa la mitad del espacio horizontal
                    .fillMaxHeight(), // Ocupa toda la altura del Row
                horizontalAlignment = Alignment.CenterHorizontally // Centra los elementos horizontalmente
            ) {
                Box (
                    modifier = Modifier
                        .weight(4f) //La Box ocupa 4 partes del espacio vertical
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.tulipanes),
                        contentDescription = "Imagen de los tulipanes",
                        modifier = Modifier
                            .fillMaxSize() // Ocupa todo el ancho disponible
                    )
                    Image(
                        painter = painterResource(id = R.drawable.play),
                        contentDescription = "Imagen superpuesta del play",
                        modifier = Modifier
                            .align(Alignment.Center) // Centrar la imagen superpuesta
                            .size(100.dp) // Tamaño ajustado de la imagen superpuesta
                        //colorFilter = ColorFilter.tint(Color.White.copy(alpha = 0.8f)) // Opción para aplicar transparencia
                    )
                }
                Text("Tulipanes")
            }
        }

        Row( //Fila 4
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f) // Ocupa la misma proporción que las demás filas
        ) {
            //Columna 1 de la Fila 4
            Column( //Imagen 1 y texto 1 de la Fila 4
                modifier = Modifier
                    .weight(1f) // La columna ocupa la mitad del espacio horizontal
                    .fillMaxHeight(), // Ocupa toda la altura del Row
                horizontalAlignment = Alignment.CenterHorizontally // Centra los elementos horizontalmente
            ) {
                Box (
                    modifier = Modifier
                        .weight(4f) //La Box ocupa 4 partes del espacio vertical
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.clase),
                        contentDescription = "Imagen de la clase",
                        modifier = Modifier
                            .fillMaxSize() // Ocupa todo el ancho disponible
                    )
                    Image(
                        painter = painterResource(id = R.drawable.play),
                        contentDescription = "Imagen superpuesta del play",
                        modifier = Modifier
                            .align(Alignment.Center) // Centrar la imagen superpuesta
                            .size(100.dp) // Tamaño ajustado de la imagen superpuesta
                        //colorFilter = ColorFilter.tint(Color.White.copy(alpha = 0.8f)) // Opción para aplicar transparencia
                    )
                }
                Text("Clase")
            }
            //Espacio entre las columnas de la Fila 4
            Spacer(modifier = Modifier.width(8.dp))
            //Columna 2 de la Fila 4
            Column(//Imagen 2 y texto 2 de la Fila 4
                modifier = Modifier
                    .weight(1f) // La columna ocupa la mitad del espacio horizontal
                    .fillMaxHeight(), // Ocupa toda la altura del Row
                horizontalAlignment = Alignment.CenterHorizontally // Centra los elementos horizontalmente
            ) {
                Box (
                    modifier = Modifier
                        .weight(4f) //La Box ocupa 4 partes del espacio vertical
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.rugby),
                        contentDescription = "Imagen del rugby",
                        modifier = Modifier
                            .fillMaxSize() // Ocupa todo el ancho disponible
                    )
                    Image(
                        painter = painterResource(id = R.drawable.play),
                        contentDescription = "Imagen superpuesta del play",
                        modifier = Modifier
                            .align(Alignment.Center) // Centrar la imagen superpuesta
                            .size(100.dp) // Tamaño ajustado de la imagen superpuesta
                        //colorFilter = ColorFilter.tint(Color.White.copy(alpha = 0.8f)) // Opción para aplicar transparencia
                    )
                }
                Text("Rugby")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun MisPeliculasPreview() {
    MisPeliculasCTheme {
        Esquema()
    }
}