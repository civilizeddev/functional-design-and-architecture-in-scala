package andromeda.hardware.language

import andromeda.hardware.Common.ComponentPassport

object Hdl {
  opaque type ComponentIndex = String
  object ComponentIndex {
    def apply(value: String): ComponentIndex = value
  }

  case class ComponentDef(idx: ComponentIndex, passport: ComponentPassport)

  type Hdl = List[ComponentDef]
}
