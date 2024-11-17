package andromeda.hardware

import andromeda.hardware.Common.*

object Hdl {
  opaque type ComponentIndex = String
  object ComponentIndex {
    def apply(value: String): ComponentIndex = value
  }

  enum ComponentDef {
    case Sensor(passport: ComponentPassport, index: ComponentIndex, parameter: Parameter)
    case Controller(passport: ComponentPassport, index: ComponentIndex)
  }

  type Hdl = List[ComponentDef]
}
