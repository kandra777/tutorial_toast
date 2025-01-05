package kmp.project.demo

import platform.Foundation.NSUUID
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    override val uuid: String
        get() = NSUUID().UUIDString()

}

actual fun getPlatform(): Platform = IOSPlatform()