package dev.tberghuis.tasklink

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.tberghuis.tasklink.ui.theme.TaskLinkTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
//    enableEdgeToEdge()
//    setContent {
//      TaskLinkTheme {
//        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//          Text("hello")
//        }
//      }
//    }
  }
}


fun processIntentData(mainActivity: MainActivity) {
  val context: Context = mainActivity
  // ...


  val intent = Intent("net.dinglisch.android.tasker.ACTION_TASK").apply {
    putExtra("task_name", "studio")
//    setPackage("com.example.snippets")
  }
  context.sendBroadcast(intent)


}

