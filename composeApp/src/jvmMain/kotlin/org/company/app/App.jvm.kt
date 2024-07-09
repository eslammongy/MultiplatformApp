package org.company.app

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.application

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