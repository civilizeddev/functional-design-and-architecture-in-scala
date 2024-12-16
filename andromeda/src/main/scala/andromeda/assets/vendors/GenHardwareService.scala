package andromeda.assets.vendors

import andromeda.assets.vendors.aaa.Components.aaaVendorComponents
import andromeda.assets.vendors.bbb.Components.bbbVendorComponents
import andromeda.hardware.impl.Component.VendorComponents
import andromeda.hardware.impl.Device as D
import andromeda.hardware.impl.Service.HardwareService
import andromeda.hardware.impl.device.Types.{Device, DevicePart}
import andromeda.hardware.language.Hdl.{ComponentIndex, Hdl}
import zio.*

object GenHardwareService {
  val allComponents: VendorComponents =
    aaaVendorComponents ++ bbbVendorComponents

  val genHardwareService: HardwareService = new HardwareService {
    override def makeDevice(hdl: Hdl): UIO[Device]                                           = ZIO.succeed(D.makeDevice(allComponents, hdl))
    override def getBlankDevice: UIO[Device]                                                 = ZIO.succeed(D.blankDevice)
    override def getDevicePart(idx: ComponentIndex, device: Device): UIO[Option[DevicePart]] = ZIO.succeed(D.getDevicePart(idx, device))
  }
}
