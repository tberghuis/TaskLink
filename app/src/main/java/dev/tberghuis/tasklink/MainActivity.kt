package dev.tberghuis.tasklink

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
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

    processIntentData(this)


    finish()
//    Handler(Looper.getMainLooper()).post {
//      finish()
//    }
//    window.decorView.post {
//      finish()
//    }

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
  val data: Uri? = mainActivity.intent?.data
  if (data == null) {
    return
  }
  // uri tasklink://tasklink/?task_name=xxx
  val task = data.getQueryParameter("task_name")
  if (task.isNullOrEmpty()) {
    return
  }
  logd("task $task")

  val intent = Intent("net.dinglisch.android.tasker.ACTION_TASK").apply {
    putExtra("task_name", task)
//    setPackage("com.example.snippets")
  }
  context.sendBroadcast(intent)


//  mainActivity.finishAndRemoveTask()

}