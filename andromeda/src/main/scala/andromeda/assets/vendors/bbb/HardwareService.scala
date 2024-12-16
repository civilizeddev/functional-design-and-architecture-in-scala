package andromeda.assets.vendors.bbb

import andromeda.assets.vendors.bbb.Components.bbbVendorComponents
import andromeda.hardware.impl.Device as D
import andromeda.hardware.impl.device.Types.{Device, DevicePart}
import andromeda.hardware.impl.Service.HardwareService
import andromeda.hardware.language.Hdl.{ComponentIndex, Hdl}
import andromeda.hardware.impl.device.Types.{Device, DevicePart}
import zio.*

object HardwareService {
  val bbbHardwareService: HardwareService = new HardwareService {
    override def makeDevice(hdl: Hdl): UIO[Device]                                           = ZIO.succeed(D.makeDevice(bbbVendorComponents, hdl))
    override def getBlankDevice: UIO[Device]                                                 = ZIO.succeed(D.blankDevice)
    override def getDevicePart(idx: ComponentIndex, device: Device): UIO[Option[DevicePart]] = ZIO.succeed(D.getDevicePart(idx, device))
  }
}
