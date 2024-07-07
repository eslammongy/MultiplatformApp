package org.company.app

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.AlertDialog
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.application
import java.awt.Desktop
import java.net.URI

internal actual fun openUrl(url: String?) {
    val uri = url?.let { URI.create(it) } ?: return
    Desktop.getDesktop().browse(uri)
}

internal actual fun showNativeDialog(message: String) {
    application {
        var isDialogOpen by remember { mutableStateOf(true) }
        if (isDialogOpen) {
            AlertDialog(
                onDismissRequest = { isDialogOpen = false },
                title = { Text("Alert") },
                text = { Text(message) },
                confirmButton = {
                    Button(onClick = { isDialogOpen = false }) {
                        Text("OK")
                    }
                }
            )
        }

    }
}