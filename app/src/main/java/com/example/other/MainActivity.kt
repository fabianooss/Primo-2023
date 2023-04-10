package com.example.other

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.other.ui.theme.OtherTheme
@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OtherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PrimoScreen()
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

@Composable
@ExperimentalMaterial3Api
fun PrimoScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        ConteudoPrimo()
    }

}

@Composable
@ExperimentalMaterial3Api
fun ConteudoPrimo() {
    val numeroPrimo = remember {
        mutableStateOf("")
    }
    Image(
        painter = painterResource(id = R.drawable.dois) ,
        contentDescription = "",
        modifier = Modifier.size(200.dp)
        )
    Text(
        text = stringResource(id = R.string.primos),
        style = MaterialTheme.typography.titleLarge,
        // MaterialTheme.typography.h4
        textAlign = TextAlign.Center
    )
    OutlinedTextField(
        value = numeroPrimo.value,
        onValueChange = {
            numeroPrimo.value = it
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
    )
    Button(onClick = {  }) {
        Text(text = stringResource(R.string.verificar_se_primo))
    }
    Text(text = numeroPrimo.value)

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
@ExperimentalMaterial3Api
fun GreetingPreview() {
    OtherTheme {
        PrimoScreen()
    }
}