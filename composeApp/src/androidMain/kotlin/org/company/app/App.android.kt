package org.company.app

import android.app.AlertDialog
import android.app.Application
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.supervisorScope

class AndroidApp : Application() {
    companion object {
        lateinit var INSTANCE: AndroidApp
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
        setContext(this)
    }
}

internal actual fun openUrl(url: String?) {
    val uri = url?.let { Uri.parse(it) } ?: return
    val intent = Intent().apply {
        action = Intent.ACTION_VIEW
        data = uri
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    AndroidApp.INSTANCE.startActivity(intent)
}

private var appContext: Context? = null
internal actual fun showNativeDialog(message: String) {
    val context = appContext ?:  throw IllegalArgumentException("Expected a Context instance")
    val builder = AlertDialog.Builder(context)
    builder.setTitle("Native Android Dialog")
    builder.setMessage("This is a native Android dialog.")
    builder.setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
    builder.create().show()
}

fun setContext(context: Any) {

    if (context is Context) {
        appContext = context
    } else {
        throw IllegalArgumentException("Expected a Context instance")
    }
}
