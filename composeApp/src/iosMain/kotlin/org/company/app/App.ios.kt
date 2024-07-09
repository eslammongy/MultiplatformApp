package org.company.app


import platform.UIKit.UIAlertAction
import platform.UIKit.UIAlertActionStyleDefault
import platform.UIKit.UIAlertController
import platform.UIKit.UIAlertControllerStyleAlert
import platform.UIKit.UIApplication
import platform.UIKit.UIApplicationMain

internal actual fun showNativeDialog(message: String) {

    val alert = UIAlertController.alertControllerWithTitle(
        title = "IOS",
        message = message,
        preferredStyle = UIAlertControllerStyleAlert
    )
    alert.addAction(
        UIAlertAction.actionWithTitle(
            title = "OK",
            style = UIAlertActionStyleDefault,
            handler = null
        )
    )
    UIApplication.sharedApplication.keyWindow?.rootViewController?.presentViewController(
        alert,
        animated = true,
        completion = null
    )
}