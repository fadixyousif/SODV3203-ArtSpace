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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fadi.artspace.data.DataSource
import com.fadi.artspace.model.ArtSpace
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
fun CreateImage(art: ArtSpace) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .shadow(12.dp, RoundedCornerShape(8.dp))
            .border(1.dp, Color.White, RoundedCornerShape(8.dp))
            .background(Color(0xFFfefbff))
            .height(450.dp)
    ) {
        Image(
            painter = painterResource(art.imageId),
            contentDescription = stringResource(art.titleId),
            modifier = Modifier
                .padding(32.dp)
                .fillMaxSize(),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun CreateDescription(art: ArtSpace) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .height(150.dp)
            .border(1.dp, Color.White, RoundedCornerShape(8.dp))
            .background(Color(0xFFecebf4))
            .padding(20.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = stringResource(art.titleId),
                fontSize = 28.sp,
                fontWeight = FontWeight.Light,
                lineHeight = 32.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Row {
                Text(
                    text = stringResource(art.authorId),
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = " (${stringResource(art.yearId)})",
                )
            }
        }
    }
}

@Composable
fun CreateButtons(
    onPrevious: () -> Unit,
    onNext: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(
                horizontal = 32.dp,
                vertical = 25.dp
            )
            .fillMaxWidth()
    ) {
        Button(
            onClick = onPrevious,
            modifier = Modifier.size(width = 125.dp, height = 40.dp)
        ) {
            Text(
                text = "Previous",
            )
        }
        Button(
            onClick = onNext,
            modifier = Modifier.size(width = 125.dp, height = 40.dp)
        ) {
            Text("Next")
        }
    }
}

@Composable
fun GenerateArtSpace() {
    var currentArtIndex by remember { mutableIntStateOf(0) }

    val arts = DataSource().loadArt()
    val art = arts[currentArtIndex]

    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color(0xFF))
            .fillMaxSize()

    ) {
        Spacer(modifier = Modifier.weight(1f))
        CreateImage(art)
        Spacer(modifier = Modifier.weight(1f))
        CreateDescription(art)
        CreateButtons(
            onPrevious = {
                if (currentArtIndex > 0) currentArtIndex--
            },
            onNext = {
                if (currentArtIndex < (arts.size - 1)) currentArtIndex++
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        GenerateArtSpace()
    }
}