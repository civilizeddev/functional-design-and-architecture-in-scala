package andromeda.hardware

import andromeda.hardware.Common.ComponentPassport
import andromeda.hardware.Device.Device.DeviceImpl
import andromeda.hardware.Hdl.{ComponentDef, ComponentIndex, Hdl}
import andromeda.hardware.components.api.{ControllerAPI, SensorAPI}

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
    def makeDevice_(remaining: List[ComponentDef], device: Device): Device = {
      remaining match {
        case Nil     => device
        case c :: cs => makeDevice_(cs, add_(c, device))
      }
    }

    def add_(c: ComponentDef, device: Device) = {
      c match {
        case ComponentDef.Sensor(p, idx, _)  => ???
        case ComponentDef.Controller(p, idx) => ???
      }
    }

    makeDevice_(hdl, blankDevice)
  }
}
