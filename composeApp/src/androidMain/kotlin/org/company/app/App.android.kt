
package org.company.app

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

private var appContext: Context? = null

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContext(this)
        setContent { App() }
    }
}

@Preview
@Composable
fun AppPreview() { App() }

internal actual fun showNativeDialog(message: String)  {
    appContext ?:  throw IllegalArgumentException("Expected a Context instance")
    val builder = AlertDialog.Builder(appContext)
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