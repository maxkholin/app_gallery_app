package com.example.artgalleryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
            ArtGalleryAppTheme {
                ArtGalleryApp()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArtGalleryApp() {
    val artObjectsList = DataProvider.createListOfArtObjects()
    val numberOfPictures = artObjectsList.size

    val artObject = artObjectsList[0]

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
//        DisplayController()
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