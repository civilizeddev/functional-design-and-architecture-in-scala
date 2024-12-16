package andromeda.assets.vendors.aaa

import andromeda.assets.vendors.aaa.Components.aaaVendorComponents
import andromeda.hardware.impl.{Device => D}
import andromeda.hardware.impl.Service.HardwareService
import andromeda.hardware.impl.device.Types.{Device, DevicePart}
import andromeda.hardware.language.Hdl.{ComponentIndex, Hdl}
import zio.*

object HardwareService {
  val aaaHardwareService: HardwareService = new HardwareService {
    override def makeDevice(hdl: Hdl): UIO[Device]                                           = ZIO.succeed(D.makeDevice(aaaVendorComponents, hdl))
    override def getBlankDevice: UIO[Device]                                                 = ZIO.succeed(D.blankDevice)
    override def getDevicePart(idx: ComponentIndex, device: Device): UIO[Option[DevicePart]] = ZIO.succeed(D.getDevicePart(idx, device))
  }
}
