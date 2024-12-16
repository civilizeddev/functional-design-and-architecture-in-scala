package andromeda.hardware.impl.device

import andromeda.hardware.impl.Component.VendorComponent.{VendoredController, VendoredSensor}
import andromeda.hardware.impl.Component.{ControllerAPI, SensorAPI, VendorComponent}
import andromeda.hardware.language.Hdl.ComponentIndex

object Types {
  opaque type DeviceName = String
  object DeviceName {
    def apply(value: String): DeviceName = value
  }

  case class DevicePart(component: VendorComponent)
  case class Device(name: DeviceName, parts: Map[ComponentIndex, DevicePart])

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
