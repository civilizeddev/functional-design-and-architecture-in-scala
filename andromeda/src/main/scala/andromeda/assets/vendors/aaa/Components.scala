package andromeda.assets.vendors.aaa

import andromeda.assets.vendors.aaa.Common.aaaInc
import andromeda.hardware.Common.ComponentClass.{Controllers, Sensors}
import andromeda.hardware.Common.Parameter.{Pressure, Temperature}
import andromeda.hardware.Common.{ComponentName, ComponentPassport, PhysicalGuid}

object Components {
  val aaaTemperature25Name: ComponentName = ComponentName("AAA-T-25")
  val aaaPressure02Name: ComponentName    = ComponentName("AAA-З-02")
  val aaaController86Name: ComponentName  = ComponentName("AAA-C-86")

  val guid1: PhysicalGuid = PhysicalGuid("guid1")
  val guid2: PhysicalGuid = PhysicalGuid("guid2")
  val guid3: PhysicalGuid = PhysicalGuid("guid3")

  val aaaTemperature25Passport: ComponentPassport = ComponentPassport(Sensors(Temperature), aaaTemperature25Name, guid2, aaaInc)
  val aaaPressure02Passport: ComponentPassport    = ComponentPassport(Sensors(Pressure), aaaPressure02Name, guid1, aaaInc)
  val aaaController86Passport: ComponentPassport  = ComponentPassport(Controllers, aaaController86Name, guid3, aaaInc)
}
