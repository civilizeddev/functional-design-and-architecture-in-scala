package andromeda.hardware

import cats.*
import cats.derived.*

object Common {

  /**
   * Every physical instance of a component has its own GUID
   */
  opaque type PhysicalGuid = String
  object PhysicalGuid {
    def apply(value: String): PhysicalGuid = value
  }

  /**
   * Components are grouped by name, for example, temperature sensors AAA-T-25
   */
  opaque type ComponentName = String
  object ComponentName {
    def apply(value: String): ComponentName = value
  }

  enum Parameter derives Show, Eq, Order {
    case Temperature, Pressure
  }

  enum ComponentClass derives Show, Eq, Order {
    case Sensors(parameter: Parameter)
    case Controllers
  }

  opaque type Vendor = String
  object Vendor {
    def apply(value: String): Vendor = value
  }

  case class ComponentPassport(cls: ComponentClass, name: ComponentName, guid: PhysicalGuid, vendor: Vendor) derives Show, Eq, Order

  case class Measurement(parameter: Parameter, value: Float) derives Show, Eq, Order

  enum Period derives Show, Eq, Order {
    case Secondly
  }
}
