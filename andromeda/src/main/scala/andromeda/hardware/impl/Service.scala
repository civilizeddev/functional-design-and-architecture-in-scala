package andromeda.hardware.impl

import andromeda.hardware.impl.device.Types.{Device, DevicePart}
import andromeda.hardware.language.Hdl.{ComponentIndex, Hdl}
import zio.*

object Service {
  trait HardwareService {
    def makeDevice(hdl: Hdl): UIO[Device]
    def getBlankDevice: UIO[Device]
    def getDevicePart(idx: ComponentIndex, device: Device): UIO[Option[DevicePart]]
  }
}
