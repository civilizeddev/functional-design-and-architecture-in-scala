package andromeda.hardware.impl

import andromeda.hardware.Common.ComponentPassport
import andromeda.hardware.impl.Component.VendorComponent.{VendoredController, VendoredSensor}
import andromeda.hardware.impl.Component.{ControllerAPI, SensorAPI, VendorComponent, VendorComponents}
import andromeda.hardware.impl.device.Types
import andromeda.hardware.impl.device.Types.{DeviceName, DevicePart}
import andromeda.hardware.language.Hdl.{ComponentDef, ComponentIndex, Hdl}

import scala.annotation.tailrec

object Device {
  val blankDevice: Types.Device = Types.Device(DeviceName(""), Map.empty)

  def makeDevice(components: VendorComponents, hdl: Hdl): Types.Device = {
    @tailrec
    def makeDevice_(remaining: List[ComponentDef], device: Types.Device): Types.Device =
      remaining match {
        case Nil     => device
        case c :: cs => makeDevice_(cs, add_(c, device))
      }

    // Creating a specific device part (implementation)
    // by its definition and adding into the Device type
    def add_(c: ComponentDef, device: Types.Device): Types.Device =
      validateComponent(components, c.passport) match {
        case Left(err)   => ???
        case Right(part) => addComponent(c.idx, part, device)
      }

    makeDevice_(hdl, blankDevice)
  }

  def addComponent(idx: ComponentIndex, part: DevicePart, device: Types.Device): Types.Device =
    Types.Device(device.name, device.parts.updated(idx, part))

  def validateComponent(components: VendorComponents, passport: ComponentPassport): Either[String, DevicePart] =
    components.get(passport.name) match {
      case None            => Left(s"component not found: ${passport.vendor} ${passport.name}")
      case Some(component) => Right(DevicePart(component))
    }

  def getDevicePart(idx: ComponentIndex, device: Types.Device): Option[DevicePart] =
    device.parts.get(idx)
}
