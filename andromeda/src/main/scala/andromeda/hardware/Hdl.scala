package andromeda.hardware

import andromeda.hardware.Common.*
import andromeda.hardware.Common.ComponentClass.{Controllers, Sensors}

object Hdl {
  opaque type ComponentIndex = String
  object ComponentIndex {
    def apply(value: String): ComponentIndex = value
  }

  enum ComponentDef {
    case Sensor(passport: ComponentPassport, idx: ComponentIndex, param: Parameter)
    case Controller(passport: ComponentPassport, idx: ComponentIndex)
  }

  type Hdl = List[ComponentDef]

  def sensor(guid: PhysicalGuid, vendor: Vendor, name: ComponentName, idx: ComponentIndex, param: Parameter): ComponentDef = {
    ComponentDef.Sensor(ComponentPassport(Sensors, name, guid, vendor), idx, param)
  }

  def controller(guid: PhysicalGuid, vendor: Vendor, name: ComponentName, idx: ComponentIndex): ComponentDef = {
    ComponentDef.Controller(ComponentPassport(Controllers, name, guid, vendor), idx)
  }
}
