package andromeda.vendors

import andromeda.hardware.Common.ComponentClass.{Controllers, Sensors}
import andromeda.hardware.Common.{ComponentName, ComponentPassport, PhysicalGuid, Vendor}

/**
 * import Native AAA sensors library here or do FFI
 */
object AAA {
  val aaaIncVendor: Vendor             = Vendor("AAA Inc.")
  val t25SensorName: ComponentName     = ComponentName("AAA-T-25")
  val p02SensorName: ComponentName     = ComponentName("AAA-З-02")
  val c86ControllerName: ComponentName = ComponentName("AAA-C-86")
  val t25Sensor: ComponentPassport     = ComponentPassport(Sensors, t25SensorName, PhysicalGuid("some_guid1"), aaaIncVendor)
  val p02Sensor: ComponentPassport     = ComponentPassport(Sensors, p02SensorName, PhysicalGuid("some_guid2"), aaaIncVendor)
  val c86Controller: ComponentPassport = ComponentPassport(Controllers, c86ControllerName, PhysicalGuid("some_guild3"), aaaIncVendor)
}
