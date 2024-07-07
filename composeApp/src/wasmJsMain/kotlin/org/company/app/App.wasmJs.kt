package org.company.app

import androidx.compose.ui.window.DialogProperties
import kotlinx.browser.window

internal actual fun openUrl(url: String?) {
    url?.let { window.open(it) }
}

internal actual fun showNativeDialog(message: String) {
    window.alert("$message Web browser")
}