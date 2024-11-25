package andromeda.hardware

import andromeda.hardware.Common.{ComponentName, ComponentPassport, Measurement, Parameter, Period}
import andromeda.hardware.Device.Device.DeviceImpl
import andromeda.hardware.Hdl.{ComponentDef, ComponentIndex, Hdl}
import andromeda.hardware.components.api.{ControllerAPI, SensorAPI}
import andromeda.vendors.AAA.{p02Handler, p02SensorName, t25Handler, t25SensorName}
import zio.UIO

import scala.annotation.tailrec

object Device {
  enum DevicePart {
    case SensorImpl(passport: ComponentPassport, api: SensorAPI)
    case ControllerImpl(passport: ComponentPassport, api: ControllerAPI)
  }
  type DeviceParts = Map[ComponentIndex, DevicePart]

  enum Device {
    case DeviceImpl(parts: DeviceParts)
  }

  val blankDevice: Device = DeviceImpl(Map.empty)

  def makeDevice(hdl: Hdl): Device = {
    @tailrec
    def makeDevice_(remaining: List[ComponentDef], device: Device): Device =
      remaining match {
        case Nil     => device
        case c :: cs => makeDevice_(cs, add_(c, device))
      }

    // Creating a specific device part (implementation)
    // by its definition and adding into the Device type
    def add_(c: ComponentDef, device: Device): Device =
      c match {
        case ComponentDef.Sensor(c, idx, p)  => addSensor(idx, p, c, device)
        case ComponentDef.Controller(p, idx) => ???
      }

    makeDevice_(hdl, blankDevice)
  }

  // This is a sample of a bad design.
  // The code knows about specific components and manufacturers.
  def addSensor(idx: ComponentIndex, param: Parameter, passport: ComponentPassport, device: Device): Device = {
    DevicePart.SensorImpl(passport, ???)
    ???
  }

  def getHandler(cName: ComponentName): SensorAPI = cName match {
    case cName if cName == t25SensorName => t25Handler
    case cName if cName == p02SensorName => p02Handler
    case _                               => throw new IllegalArgumentException("unknown component")
  }
}
