package andromeda.hardware

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

  enum Parameter {
    case Temperature, Pressure
  }

  enum ComponentClass {
    case Sensors, Controllers
  }

  opaque type Vendor = String
  object Vendor {
    def apply(value: String): Vendor = value
  }

  case class ComponentPassport(cls: ComponentClass, name: ComponentName, guid: PhysicalGuid, vendor: Vendor)

  case class Measurement(parameter: Parameter, value: Float)

  enum Period {
    case Secondly
  }
}
