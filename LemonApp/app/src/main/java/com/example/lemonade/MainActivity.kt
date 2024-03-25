package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                Lemonade()
            }
        }
    }
}

@Composable
@Preview
fun Lemonade(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {}
    LemonadeApp(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}
@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    var result by remember { mutableIntStateOf(1) }
    var squeezeCount by remember { mutableIntStateOf(0) }
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        when (result) {
            1 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Image(painter = painterResource(id = R.drawable.lemon_tree),
                        contentDescription = "",
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                result = 2
                                squeezeCount = (2..4).random()
                            }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Tap the lemon tree to select a lemon",
                        textAlign = TextAlign.Justify
                    )
                }
            }

            2 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Image(painter = painterResource(id = R.drawable.lemon_squeeze),
                        contentDescription = "",
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                squeezeCount--
                                if (squeezeCount == 0) {
                                    result = 3
                                }
                            }
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        text = "Keep tapping the lemon to squeeze",
                        textAlign = TextAlign.Justify
                    )
                }
            }

            3 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Image(painter = painterResource(id = R.drawable.lemon_drink),
                        contentDescription = "",
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable { result = 4 }
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        text = "Tap the lemonade to drink it",
                        textAlign = TextAlign.Justify
                    )
                }
            }
            4 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Image(painter = painterResource(id = R.drawable.lemon_restart),
                        contentDescription = "",
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable { result = 1 }
                        )
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        text = "Tap the empty glass to restart again",
                        textAlign = TextAlign.Justify
                    )
                }
            }
        }
    }
}