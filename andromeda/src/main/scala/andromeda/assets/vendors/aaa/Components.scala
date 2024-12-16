package andromeda.assets.vendors.aaa

import andromeda.assets.vendors.aaa.Common.aaaInc
import andromeda.assets.vendors.aaa.ComponentsAPI.{aaaController86Handler, aaaPressure02Handler, aaaTemperature25Handler}
import andromeda.hardware.Common.ComponentClass.{Controllers, Sensors}
import andromeda.hardware.Common.Parameter.{Pressure, Temperature}
import andromeda.hardware.Common.{ComponentName, ComponentPassport, PhysicalGuid}
import andromeda.hardware.impl.Component.VendorComponent.{VendoredController, VendoredSensor}
import andromeda.hardware.impl.Component.VendorComponents

object Components {
  val aaaTemperature25Name: ComponentName = ComponentName("AAA-T-25")
  val aaaPressure02Name: ComponentName    = ComponentName("AAA-З-02")
  val aaaController86Name: ComponentName  = ComponentName("AAA-C-86")

  val guid1: PhysicalGuid = PhysicalGuid("some_guid1")
  val guid2: PhysicalGuid = PhysicalGuid("some_guid2")
  val guid3: PhysicalGuid = PhysicalGuid("some_guid3")

  val aaaTemperature25Passport: ComponentPassport = ComponentPassport(Sensors(Temperature), aaaTemperature25Name, guid2, aaaInc)
  val aaaPressure02Passport: ComponentPassport    = ComponentPassport(Sensors(Pressure), aaaPressure02Name, guid1, aaaInc)
  val aaaController86Passport: ComponentPassport  = ComponentPassport(Controllers, aaaController86Name, guid3, aaaInc)

  val aaaVendorComponents: VendorComponents =
    Map(
      aaaTemperature25Name -> VendoredSensor(aaaTemperature25Passport, aaaTemperature25Handler),
      aaaPressure02Name    -> VendoredSensor(aaaPressure02Passport, aaaPressure02Handler),
      aaaController86Name  -> VendoredController(aaaController86Passport, aaaController86Handler)
    )
}
