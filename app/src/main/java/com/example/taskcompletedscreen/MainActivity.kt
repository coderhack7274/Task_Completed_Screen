package com.example.taskcompletedscreen

// Activity Lifecycle & Android Bundle imports
import android.os.Bundle // App state/data handle karne ke liye Bundle class
import androidx.activity.ComponentActivity // Compose supported base Android Activity class
import androidx.activity.compose.setContent // XML setContentView ki jagah Compose UI load karne ke liye
import androidx.activity.enableEdgeToEdge // App ko full screen (Status/Navigation bar ke piche) fill karne ke liye

// Jetpack Compose Layout Imports
import androidx.compose.foundation.layout.Column // Elements ko ek ke niche ek (Vertically) arrange karne ke liye
import androidx.compose.foundation.layout.fillMaxHeight // Screen ki full height lene ke liye
import androidx.compose.foundation.layout.fillMaxSize // Screen ki full width aur height lene ke liye
import androidx.compose.foundation.layout.padding // Components ke andar/bahar margin & spacing ke liye

// Jetpack Compose UI Components & Resources
import androidx.compose.material3.Text // Text display karne wala component
import androidx.compose.ui.unit.dp // Density-independent pixels (layout dimensions/size ke liye)
import androidx.compose.ui.res.stringResource // strings.xml file se text lene ke liye

import androidx.compose.ui.res.painterResource // res/drawable folder se image/icon resource lene ke liye
import androidx.compose.ui.unit.sp // Scalable pixels (font sizes ke liye)
import androidx.compose.foundation.Image // Image display karne ke liye
import androidx.compose.foundation.layout.Arrangement // Children components ki alignment & spacing arrange karne ke liye
import androidx.compose.ui.Alignment // Layout alignment (Center, Start, End etc.)
import androidx.compose.runtime.Composable // Marks function as Compose UI component
import androidx.compose.material3.MaterialTheme // App Material Design theme colors & typography
import androidx.compose.material3.Surface // Background container view / canvas
import androidx.compose.ui.Modifier // Custom styling, size, background & padding apply karne ke liye
import androidx.compose.ui.text.font.FontWeight // Font styling (Bold, Normal, Light etc.)
import androidx.compose.foundation.shape.CircleShape // Circular/Round shape define karne ke liye
import androidx.compose.foundation.layout.size // Fixed width & height define karne ke liye
import androidx.compose.foundation.background // Color ya shape background apply karne ke liye
import androidx.compose.foundation.layout.Box // Overlapping elements (ek ke upar ek) place karne ke liye
import androidx.compose.material3.Icon // Vector drawable / Icons display karne ke liye
import androidx.compose.ui.graphics.Color // Hex/RGB Colors define karne ke liye
import androidx.compose.ui.tooling.preview.Preview // Android Studio preview pane me UI dekhne ke liye
import com.example.taskcompletedscreen.ui.theme.TaskCompletedScreenTheme // Custom App Theme wrapper

// MainActivity class definition jo ComponentActivity se inherit karti hai
class MainActivity : ComponentActivity() {
    // onCreate: Activity launch hote hi sabse pehle ye function execute hota hai
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Parent ComponentActivity ka onCreate call karta hai

        // setContent: Activity me Compose UI hierarchy ko entry point deta hai
        setContent {
            // App theme apply kar rahe hain
            TaskCompletedScreenTheme {
                // Surface background container jo puri screen space fill karega
                Surface(
                    modifier = Modifier.fillMaxSize(), // Full screen size
                    color = MaterialTheme.colorScheme.background // Theme ka background color
                ) {
                    TaskCompletedScreen() // Main Screen Composable function yahan call kiya
                }
            }
        }
    }
}

// @Composable: Compiler ko batata hai ki ye function Compose UI component hai
@Composable
fun TaskCompletedScreen() {
    // Column layout: Items vertically center aligned rahengi
    Column(
        modifier = Modifier
            .background(Color.White) // Background White color
            .fillMaxSize() // Full width & height
            .fillMaxHeight(), // Extra safety for full height
        verticalArrangement = Arrangement.Center, // Vertically center me rakhega
        horizontalAlignment = Alignment.CenterHorizontally // Horizontally center me rakhega
    ) {
        // Green round circle jisme tick icon hai use render karega
        RoundShape()
        // Main heading text "All tasks completed"
        Text(
            text = stringResource(R.string.all_task_completed), // strings.xml se string load ho rahi hai
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp), // Top & Bottom spacing
            fontWeight = FontWeight.Bold, // Text bold hoga
            fontSize = 38.sp // Font size 38sp
        )
        // Subtitle text "Nice work!"
        Text(
            text = stringResource(R.string.nice_work), // strings.xml se sub-text load
            fontSize = 30.sp // Font size 30sp
        )
    }
}

// Custom Green Circle Shape jisme Icon Center aligned hai
@Composable
fun RoundShape() {
    // Box: Circular background aur center icon ko stack karne ke liye
    Box(
        modifier = Modifier
            .size(280.dp) // Box ki height & width 280dp
            .background(color = Color(0xFF4CD964), shape = CircleShape), // Green (#4CD964) color aur Round Circle Shape
        contentAlignment = Alignment.Center // Inside contents center aligned rahengi
    ) {
        // Task completed Checkmark Icon render ho raha hai
        Icon(
            painter = painterResource(id = R.drawable.ic_task_completed), // Vector icon load
            contentDescription = null, // Accessibility text (null default)
            tint = Color(0xFF2979FF), // Icon ka tint/color Blue (#2979FF)
            modifier = Modifier.size(140.dp) // Icon size 140dp
        )
    }
}
// Android Studio IDE me UI ka Preview dekhne ke liye
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TaskCompletedPreview() {
    TaskCompletedScreenTheme {
        TaskCompletedScreen() // Preview me screen render karega
    }
}
