package andromeda.hardware

import andromeda.hardware.Common.ComponentPassport
import andromeda.hardware.Hdl.ComponentIndex
import andromeda.hardware.components.api.{ControllerAPI, SensorAPI}

object Device {
  enum DevicePart {
    case SensorImpl(passport: ComponentPassport, api: SensorAPI)
    case ControllerImpl(passport: ComponentPassport, api: ControllerAPI)
  }
  type DeviceParts = Map[ComponentIndex, DevicePart]

}

case class Device()
