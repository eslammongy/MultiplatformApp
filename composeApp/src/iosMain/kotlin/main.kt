import androidx.compose.ui.window.ComposeUIViewController
import org.company.app.App
import platform.Foundation.NSString
import platform.Foundation.stringWithFormat
import platform.UIKit.UIAlertAction
import platform.UIKit.UIAlertActionStyleDefault
import platform.UIKit.UIAlertController
import platform.UIKit.UIAlertControllerStyleAlert
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }




