package andromeda.common.assets

import andromeda.hardware.Common.ComponentClass.{Controllers, Sensors}
import andromeda.hardware.Common.Parameter.{Pressure, Temperature}
import andromeda.hardware.Common.{ComponentPassport, PhysicalGuid}
import andromeda.hardware.Hdl
import andromeda.hardware.Hdl.ComponentDef.{Controller, Sensor}
import andromeda.hardware.Hdl.{ComponentDef, ComponentIndex, Hdl}
import andromeda.vendors.AAA.{aaaIncVendor, c86ControllerName, p02SensorName, t25SensorName}

object DeviceDefinitions {
  val guid1: PhysicalGuid = PhysicalGuid("guid1")
  val guid2: PhysicalGuid = PhysicalGuid("guid2")
  val guid3: PhysicalGuid = PhysicalGuid("guid3")

  val aaa_p_02: ComponentPassport = ComponentPassport(Sensors, p02SensorName, guid1, aaaIncVendor)
  val aaa_t_25: ComponentPassport = ComponentPassport(Sensors, t25SensorName, guid2, aaaIncVendor)
  val aaa_c_86: ComponentPassport = ComponentPassport(Controllers, c86ControllerName, guid3, aaaIncVendor)

  val boostersDef: Hdl = List(
    Sensor(aaa_t_25, ComponentIndex("nozzle1-t"), Temperature),
    Sensor(aaa_p_02, ComponentIndex("nozzle1-p"), Pressure),
    Sensor(aaa_t_25, ComponentIndex("nozzle2-t"), Temperature),
    Sensor(aaa_p_02, ComponentIndex("nozzle2-p"), Pressure),
    Controller(aaa_c_86, ComponentIndex("controller"))
  )

  val validComponent: ComponentDef   = Sensor(aaa_t_25, ComponentIndex("nozzle1-t"), Temperature)
  val invalidComponent: ComponentDef = Controller(aaa_t_25, ComponentIndex("central controller"))
}
