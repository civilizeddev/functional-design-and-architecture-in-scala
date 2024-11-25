package andromeda.hardware

import andromeda.hardware.Common.{ComponentName, ComponentPassport, Parameter}
import andromeda.hardware.Device.Device.DeviceImpl
import andromeda.hardware.Device.DevicePart.SensorImpl
import andromeda.hardware.Hdl.ComponentDef.{Controller, Sensor}
import andromeda.hardware.Hdl.{ComponentDef, ComponentIndex, Hdl}
import andromeda.hardware.components.api.{ControllerAPI, SensorAPI}
import andromeda.vendors.AAA.{p02Handler, p02SensorName, t25Handler, t25SensorName}

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
    def add_(c: ComponentDef, d: Device): Device =
      c match {
        case Sensor(c, idx, p)  => addSensor(idx, p, c)(d)
        case Controller(c, idx) => addController(idx, c)(d)
      }

    makeDevice_(hdl, blankDevice)
  }

  // This is a sample of a bad design.
  // The code knows about specific components and manufacturers.
  private def addSensor(idx: ComponentIndex, p: Parameter, defn: ComponentPassport)(device: Device): Device =
    device match {
      case DeviceImpl(components) =>
        val ComponentPassport(_, cName, _, _) = defn
        val handler                           = getHandler(cName)
        val sensor                            = SensorImpl(defn, handler)
        DeviceImpl(components + (idx -> sensor))
    }

  private def getHandler(cName: ComponentName): SensorAPI = cName match {
    case cName if cName == t25SensorName => t25Handler
    case cName if cName == p02SensorName => p02Handler
    case _                               => throw new IllegalArgumentException("unknown component")
  }

  private def addController(idx: ComponentIndex, defn: ComponentPassport)(device: Device): Device = ???
}
