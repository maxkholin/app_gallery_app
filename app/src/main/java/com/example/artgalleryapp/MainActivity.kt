package com.example.artgalleryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artgalleryapp.data.DataProvider
import com.example.artgalleryapp.ui.theme.ArtGalleryAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtGalleryAppTheme(darkTheme = false) {
                ArtGalleryApp()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArtGalleryApp() {
    var index by remember { mutableIntStateOf(0) }

    val artObjectsList = remember { DataProvider.createListOfArtObjects() }

    val numberOfPictures = artObjectsList.size

    val onPreviousButtonClick: () -> Unit = {
        if (index == 0) {
            index = numberOfPictures - 1
        } else {
            index--
        }
    }

    val onNextButtonClick: () -> Unit = {
        if (index == numberOfPictures - 1) {
            index = 0
        } else {
            index++
        }
    }

    val artObject = artObjectsList[index]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        AppName()
        ArtworkWall(artObject.imageId)
        ArtworkDescription(
            imageDescription = artObject.imageDescriptionId,
            author = artObject.authorId,
            year = artObject.year
        )
        DisplayController(onPreviousButtonClick, onNextButtonClick)
    }
}

@Composable
fun AppName() {
    Text(
        text = stringResource(R.string.app_name),
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            textDecoration = TextDecoration.LineThrough
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(96.dp)
            .padding(top = 32.dp)
    )
}

@Composable
fun ArtworkWall(imageId: Int) {
    Surface(shadowElevation = 16.dp) {
        Image(
            painter = painterResource(imageId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.6f)
                .padding(24.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ArtworkDescription(imageDescription: Int, author: Int, year: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(fraction = 0.6f)
            .padding(start = 36.dp, end = 36.dp, bottom = 24.dp, top = 64.dp)
            .background(Color.LightGray)
    ) {
        Text(
            text = stringResource(imageDescription),
            fontSize = 24.sp,
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp, start = 8.dp)
        )
        Text(
            text = "${stringResource(author)} ($year)",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 8.dp)
        )
    }
}

@Composable
fun DisplayController(
    onPreviousButtonClick: () -> Unit,
    onNextButtonClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, bottom = 32.dp, top = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = onPreviousButtonClick,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = stringResource(R.string.previous_button)
            )
        }
        Spacer(modifier = Modifier.weight(0.5f))
        Button(
            onClick = onNextButtonClick,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = stringResource(R.string.next_button)
            )
        }
    }
}