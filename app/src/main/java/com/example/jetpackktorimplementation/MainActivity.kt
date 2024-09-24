package com.example.jetpackktorimplementation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackktorimplementation.ui.theme.JetpackKtorImplementationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackKtorImplementationTheme {
                Appview()
            }
        }
    }
}

@Composable
fun Appview() {
    Column {
        showPostList()
    }
}


@Composable
fun showPostList() {
   var posts by remember {
       mutableStateOf(emptyList<Feed>())
   }
//Launched effect will be call only once.
    LaunchedEffect(Unit) {
        posts =ApiClient.getPost()
    }
    Column {
        LazyColumn {
            items(posts){post->
                PostListItemview(post)
            }
        }
    }
}

@Composable
fun PostListItemview(post: Feed) {

   /* Column(Modifier.fillMaxWidth().padding(16.dp)) {
        Text(text = post.title)
        Text(text = post.body)
    }*/

    Card (Modifier.fillMaxWidth().padding(16.dp)){
        Column {
            Text(text = post.title, style = TextStyle(fontSize = 20.sp), modifier = Modifier.padding(16.dp))
            Text(text = post.body, style = TextStyle(fontSize = 16.sp), modifier = Modifier.padding(16.dp))
        }
    }
}