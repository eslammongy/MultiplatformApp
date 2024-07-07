package org.company.app

import platform.Foundation.NSURL
import platform.UIKit.UIApplication

internal actual fun openUrl(url: String?) {
    val nsUrl = url?.let { NSURL.URLWithString(it) } ?: return
    UIApplication.sharedApplication.openURL(nsUrl)
}

internal actual fun showNativeDialog(message: String) {
    val alert = UIAlertController.alertControllerWithTitle(
        title = null,
        message = message,
        preferredStyle = UIAlertControllerStyleAlert
    )
    alert.addAction(
        UIAlertAction.actionWithTitle(
            title = NSString.stringWithFormat("%s", "OK"),
            style = UIAlertActionStyleDefault,
            handler = null
        )
    )
    viewController.presentViewController(alert, animated = true, completion = null)
}
