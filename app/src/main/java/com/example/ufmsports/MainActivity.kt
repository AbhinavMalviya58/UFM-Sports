package com.example.ufmsports

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.BorderStroke
import androidx.annotation.DrawableRes
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.clickable

// --- Toolbar Imports ---
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.MoreVert // For a three-dot menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults


@OptIn(ExperimentalMaterial3Api::class) // Required for TopAppBar and Scaffold in M3
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // Scaffold provides slots for TopAppBar, BottomBar, FAB, etc.
                Scaffold(
                    topBar = {
                        MyTopAppBar(
                            onNavigationIconClick = {
                                // Handle navigation icon click (e.g., open drawer)
                                Log.d("TopAppBar", "Navigation icon clicked")
                            },
                            onSearchClick = {
                                // Handle search icon click
                                Log.d("TopAppBar", "Search icon clicked")
                            }
                        )
                    }
                ) { innerPadding ->
                    // The content of your screen goes here.
                    // innerPadding contains the padding values consumed by the TopAppBar (and other Scaffold elements).
                    // You MUST apply this padding to your main content's root composable.
                    DoctorCardList(
                        modifier = Modifier
                            .padding(innerPadding) // Apply the padding from Scaffold
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    onNavigationIconClick: () -> Unit,
    onSearchClick: () -> Unit
) {
    val context = LocalContext.current // For Toasts if needed
    TopAppBar(
        title = {
            Text(text = "UFM Sports")
        },
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Toggle drawer"
                )
            }
        },
        actions = {
            IconButton(onClick = onSearchClick) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search"
                )
            }
            IconButton(onClick = {
                Toast.makeText(context, "More options clicked", Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "More options"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    )
}


// DoctorCard composable remains the same
@Composable
fun DoctorCard(
    modifier: Modifier = Modifier,
    title: String,
    @DrawableRes imageRes: Int,
    backgroundColor: Color,
    strokeColor: Color,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(vertical = 4.dp, horizontal = 8.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, strokeColor),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = title,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

// DoctorCardList composable needs to accept a Modifier
@Composable
fun DoctorCardList(modifier: Modifier = Modifier) { // <<< Added modifier parameter
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier // Apply the passed modifier here (which includes padding from Scaffold)
            // .fillMaxSize() // This should be applied on the modifier passed in, or on the Scaffold content
            .verticalScroll(scrollState)
            .padding(horizontal = 8.dp, vertical = 8.dp), // Additional padding if needed for list items
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // ... (DoctorCard instances remain the same)
        val orthopedicTitle = "Orthopedic"
        DoctorCard(
            title = orthopedicTitle,
            imageRes = R.drawable.versus,
            backgroundColor = Color(0xFFE1F5FE),
            strokeColor = Color(0xFF4FC3F7),
            onClick = {
                Log.d("DoctorCardClick", "$orthopedicTitle card clicked!")
                Toast.makeText(context, "Clicked: $orthopedicTitle", Toast.LENGTH_SHORT).show()
            }
        )

        val ophthalmologistTitle = "Ophthalmologist"
        DoctorCard(
            title = ophthalmologistTitle,
            imageRes = R.drawable.versus,
            backgroundColor = Color(0xFFE1F5FE),
            strokeColor = Color(0xFF4FC3F7),
            onClick = {
                Log.d("DoctorCardClick", "$ophthalmologistTitle card clicked!")
                Toast.makeText(context, "Clicked: $ophthalmologistTitle", Toast.LENGTH_SHORT).show()
            }
        )
        // ... add other cards
    }
}