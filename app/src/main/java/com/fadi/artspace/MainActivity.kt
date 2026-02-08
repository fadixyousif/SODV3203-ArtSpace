package com.fadi.artspace

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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fadi.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                GenerateArtSpace()
            }
        }
    }
}

@Composable
fun CreateImage() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .shadow(12.dp, RoundedCornerShape(8.dp))
            .border(1.dp, Color.Blue, RoundedCornerShape(8.dp))
            .background(Color(0xFFfefbff))
            .padding(50.dp),
    ) {
        Image(
            painter = painterResource(R.drawable.Improvisation_31), // Improvisation 31 (Sea Battle) By Wassily Kandinsky (1913)
            contentDescription = null
        )
    }
}

@Composable
fun CreateDescription() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 20.dp)
            .border(1.dp, Color.Blue, RoundedCornerShape(8.dp))
            .background(
                Color(0xFFecebf4)
            )
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.Start) {
            Text(
                text = "Still Life of BLue and Other Flowers",
                fontSize = 28.sp,
                fontWeight = FontWeight.Light,
                lineHeight = 28.sp
            )

            Row() {
                Text(
                    text = "Owen Scott",
                    fontWeight = FontWeight.Bold
                )

                Text(text = " (2021)")
            }
        }
    }
}

@Composable
fun CreateButtons() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(
                horizontal = 32.dp,
                vertical = 16.dp
            )
            .fillMaxWidth()
    ) {
        Button(
            onClick = {},
            modifier = Modifier.size(width = 125.dp, height = 40.dp)
        ) {
            Text(
                text = "Previous",
            )
        }
        Button(
            onClick = {},
            modifier = Modifier.size(width = 125.dp, height = 40.dp)
        ) {
            Text("Next")
        }
    }
}

@Composable
fun GenerateArtSpace() {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color(0xFF))
            //.padding(bottom = 16.dp)
            .fillMaxSize()

    ) {
        Spacer(modifier = Modifier.weight(1f))
        CreateImage()
        Spacer(modifier = Modifier.weight(1f))
        CreateDescription()
        CreateButtons()
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        GenerateArtSpace()
    }
}