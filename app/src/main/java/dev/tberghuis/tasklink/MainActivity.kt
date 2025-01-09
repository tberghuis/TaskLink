package dev.tberghuis.tasklink

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    processIntentData(this)
    finish()
  }
}

fun processIntentData(mainActivity: MainActivity) {
  val context: Context = mainActivity
  val dataUri: Uri = mainActivity.intent?.data ?: return
  // uri tasklink://tasklink/?task_name=xxx
  val task = dataUri.getQueryParameter("task_name")
  if (task.isNullOrEmpty()) {
    return
  }
  logd("task $task")

//  val intent = Intent("net.dinglisch.android.tasker.ACTION_TASK").apply {
//    putExtra("task_name", task)
//  }
//  context.sendBroadcast(intent)

  val intent = Intent(Intent.ACTION_VIEW).apply {
    data = Uri.parse("tasker://assistantactions?task=$task")
  }

  context.startActivity(intent)
}