package com.example.taskcompletedscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.taskcompletedscreen.ui.theme.TaskCompletedScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskCompletedScreenTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color= MaterialTheme.colorScheme.background) {
                    TaskCompletedScreen()
                }
            }
        }
    }
}

@Composable
fun TaskCompletedScreen() {
    Column(
        modifier= Modifier.background(Color.White)
            .fillMaxSize()
            .fillMaxHeight(),
        verticalArrangement=Arrangement.Center,
        horizontalAlignment= Alignment.CenterHorizontally
    ) {
        RoundShape()
       /* val image= painterResource(R.drawable.ic_task_completed)
        Image(
            painter=image,
            contentDescription=null
        )*/ // ye yha pe islie comment kia agr hm niche round sahpe bnaya h to si kam k lie bnyaa right tick sath green gola use yha call krege agr nhi krte to yhaye ata use hta dete hm or yha ysi trh ki imgae download krke tb ye krte
        Text(
            text= stringResource(R.string.all_task_completed),
            modifier= Modifier.padding(top=24.dp, bottom=8.dp),
            fontWeight=FontWeight.Bold,
            fontSize=38.sp
        )
        Text(
            text= stringResource(R.string.nice_work),
            fontSize=30.sp
        )
    }
}
@Composable
fun RoundShape() {
    Box(
        modifier = Modifier
            .size(260.dp)
            .background(color=Color(0xFF4CD964),shape= CircleShape),
        contentAlignment = Alignment.Center
    ){
        Icon(
            painter = painterResource(id = R.drawable.ic_task_completed),
            contentDescription = null,
            tint = Color(0xFF2979FF),
            modifier = Modifier.size(120.dp)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskCompletedScreenTheme {
        TaskCompletedScreen()
    }
}