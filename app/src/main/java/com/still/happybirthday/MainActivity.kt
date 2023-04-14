package com.still.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.still.happybirthday.ui.theme.HappyBirthDayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthDayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthDayGreetingWithImage(
                        message = stringResource(R.string.happy_birth_day_text), from = getString(
                            R.string.signature_text
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun BirthDayGreetingWithText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = message,
            fontSize = 36.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = from,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(top = 16.dp, end = 16.dp)
                .align(Alignment.End)
        )
    }
}

@Composable
fun BirthDayGreetingWithImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.androidparty)
    Box {
        Image(painter = image, contentDescription = null, contentScale = ContentScale.Crop)
        BirthDayGreetingWithText(message = message, from = from)
    }
}

@Preview(showBackground = true)
@Composable
fun BirthDayCardPreview() {
    HappyBirthDayTheme {
        BirthDayGreetingWithImage(
            message = stringResource(R.string.happy_birth_day_text), from = stringResource(
                id = R.string.signature_text
            )
        )
    }
}

