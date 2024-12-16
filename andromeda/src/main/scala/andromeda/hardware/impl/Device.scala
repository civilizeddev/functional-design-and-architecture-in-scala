package andromeda.hardware.impl

import andromeda.hardware.Common.ComponentPassport
import andromeda.hardware.impl.Component.VendorComponent.{VendoredController, VendoredSensor}
import andromeda.hardware.impl.Component.{ControllerAPI, SensorAPI, VendorComponent, VendorComponents}
import andromeda.hardware.language.Hdl.{ComponentDef, ComponentIndex, Hdl}

import scala.annotation.tailrec

object Device {
  case class DevicePart(component: VendorComponent)
  case class Device(parts: Map[ComponentIndex, DevicePart])

  val blankDevice: Device = Device(Map.empty)

  def makeDevice(components: VendorComponents, hdl: Hdl): Device = {
    @tailrec
    def makeDevice_(remaining: List[ComponentDef], device: Device): Device =
      remaining match {
        case Nil     => device
        case c :: cs => makeDevice_(cs, add_(c, device))
      }

    // Creating a specific device part (implementation)
    // by its definition and adding into the Device type
    def add_(c: ComponentDef, device: Device): Device =
      validateComponent(components, c.passport) match {
        case Left(err)   => ???
        case Right(part) => addComponent(c.idx, part, device)
      }

    makeDevice_(hdl, blankDevice)
  }

  def addComponent(idx: ComponentIndex, part: DevicePart, device: Device): Device =
    Device(device.parts.updated(idx, part))

  def validateComponent(components: VendorComponents, passport: ComponentPassport): Either[String, DevicePart] =
    components.get(passport.name) match {
      case None            => Left(s"component not found: ${passport.vendor} ${passport.name}")
      case Some(component) => Right(DevicePart(component))
    }

  def getDevicePart(idx: ComponentIndex, device: Device): Option[DevicePart] = {
    device.parts.get(idx)
  }

  trait WithHandler[HandlerAPI] {
    def withHandler(devicePart: DevicePart)(f: HandlerAPI => Unit): Unit
  }

  given WithHandler[SensorAPI] with {
    override def withHandler(devicePart: DevicePart)(f: SensorAPI => Unit): Unit = devicePart match {
      case DevicePart(VendoredSensor(_, handler)) => f(handler)
      case _                                      => throw new IllegalArgumentException("Invalid part API handler")
    }
  }

  given WithHandler[ControllerAPI] with {
    override def withHandler(devicePart: DevicePart)(f: ControllerAPI => Unit): Unit = devicePart match {
      case DevicePart(VendoredController(_, handler)) => f(handler)
      case _                                          => throw new IllegalArgumentException("Invalid part API handler")
    }
  }
}
