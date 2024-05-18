package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                ArtSpaceApp()

            }
        }
    }
}


@Composable
fun ArtLayout(modifier: Modifier) {

    var picNumber by remember {
        mutableStateOf(1)
    }

    val imageResource = when (picNumber) {
        1 -> R.drawable._662300388983169
        2 -> R.drawable.image
        3 -> R.drawable._685638555940910
        4 -> R.drawable._707147344234575
        else -> R.drawable._712308158510082
    }

    val title = when (picNumber) {
        1 -> R.string.pic1
        2 -> R.string.pic2
        3 -> R.string.pic3
        4 -> R.string.pic4
        else -> R.string.pic5
    }

    val year = when (picNumber) {
        1 -> R.string.year1
        2 -> R.string.year2
        3 -> R.string.year3
        4 -> R.string.year4
        else -> R.string.year5
    }

    val red = Color(0xffff0000)


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(MaterialTheme.colorScheme.tertiaryContainer),
        color = MaterialTheme.colorScheme.background
    ) {
        when (picNumber) {
            1 ->
                ArtSpaceTextAndImage(
                    picNumber = picNumber,
                    title = title,
                    year = year,
                    drawable = imageResource,
                    onButtonClick = {
                        picNumber = 2
                    },
                    onButtonClick2 = {}
                )


            2 ->
                ArtSpaceTextAndImage(
                    picNumber = picNumber,
                    title = title,
                    year = year,
                    drawable = imageResource,
                    onButtonClick = {
                        picNumber--
                    },
                    onButtonClick2 = {
                        picNumber++
                    }
                )

            3 ->
                ArtSpaceTextAndImage(
                    picNumber = picNumber,
                    title = title,
                    year = year,
                    drawable = imageResource,
                    onButtonClick = {
                        picNumber--
                    },
                    onButtonClick2 = {
                        picNumber++
                    }
                )

            4 ->
                ArtSpaceTextAndImage(
                    picNumber = picNumber,
                    title = title,
                    year = year,
                    drawable = imageResource,
                    onButtonClick = {
                        picNumber--
                    },
                    onButtonClick2 = {
                        picNumber++
                    }
                )


            else -> ArtSpaceTextAndImage(
                picNumber = picNumber,
                title = title,
                year = year,
                drawable = imageResource,
                onButtonClick = {
                    picNumber--
                },
                onButtonClick2 = {

                }
            )


        }


    }


}


@Composable
fun ArtSpaceTextAndImage(
    picNumber: Int,
    onButtonClick: () -> Unit,
    onButtonClick2: () -> Unit,
    title: Int,
    year: Int,
    drawable: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(50.dp))

        Column(modifier = Modifier
            .background(MaterialTheme.colorScheme.tertiaryContainer)
            .padding(start = 30.dp, end = 30.dp,top=15.dp, bottom = 15.dp)
            ,horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(id = title),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )

            Text(
                text = stringResource(id = year),
                fontSize = 20.sp

            )
        }

        Spacer(modifier = Modifier.height(100.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            if (picNumber == 1) {
                Button(
                    onClick = onButtonClick,
                    modifier = Modifier
                        .height(50.dp)
                        .width(140.dp)
                ) {
                    Text(stringResource(R.string.next), color = Color.White, fontSize = 15.sp)
                }
            } else if (picNumber == 5) {
                Button(
                    onClick = onButtonClick,
                    modifier = Modifier
                        .height(50.dp)
                        .width(140.dp)
                ) {
                    Text(stringResource(R.string.previous), color = Color.White, fontSize = 15.sp)
                }
            } else {
                Button(
                    onClick = onButtonClick,
                    modifier = Modifier
                        .height(50.dp)
                        .width(140.dp)
                ) {
                    Text(stringResource(R.string.previous), color = Color.White, fontSize = 15.sp)
                }
                Button(
                    onClick = onButtonClick2,
                    modifier = Modifier
                        .height(50.dp)
                        .width(140.dp)
                ) {
                    Text(stringResource(R.string.next), color = Color.White, fontSize = 15.sp)
                }

            }

        }

    }


}


@Preview(showBackground = true)
@Composable
fun ArtSpaceApp() {
    ArtLayout(Modifier.fillMaxSize())

}