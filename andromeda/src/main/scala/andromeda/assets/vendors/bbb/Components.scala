package andromeda.assets.vendors.bbb

import andromeda.assets.vendors.bbb.Common.bbbInc
import andromeda.assets.vendors.bbb.ComponentsAPI.{bbbController86Handler, bbbPressure02Handler, bbbTemperature25Handler}
import andromeda.hardware.Common.ComponentClass.{Controllers, Sensors}
import andromeda.hardware.Common.Parameter.{Pressure, Temperature}
import andromeda.hardware.Common.{ComponentName, ComponentPassport, PhysicalGuid}
import andromeda.hardware.impl.Component.VendorComponent.{VendoredController, VendoredSensor}
import andromeda.hardware.impl.Component.VendorComponents

object Components {
  val bbbTemperature25Name: ComponentName = ComponentName("BBB-T-25")
  val bbbPressure02Name: ComponentName    = ComponentName("BBB-З-02")
  val bbbController86Name: ComponentName  = ComponentName("BBB-C-86")

  val guid1: PhysicalGuid = PhysicalGuid("bbb_guid1")
  val guid2: PhysicalGuid = PhysicalGuid("bbb_guid2")
  val guid3: PhysicalGuid = PhysicalGuid("bbb_guid3")

  val bbbTemperature25Passport: ComponentPassport = ComponentPassport(Sensors(Temperature), bbbTemperature25Name, guid2, bbbInc)
  val bbbPressure02Passport: ComponentPassport    = ComponentPassport(Sensors(Pressure), bbbPressure02Name, guid1, bbbInc)
  val bbbController86Passport: ComponentPassport  = ComponentPassport(Controllers, bbbController86Name, guid3, bbbInc)

  val bbbVendorComponents: VendorComponents =
    Map(
      bbbTemperature25Name -> VendoredSensor(bbbTemperature25Passport, bbbTemperature25Handler),
      bbbPressure02Name    -> VendoredSensor(bbbPressure02Passport, bbbPressure02Handler),
      bbbController86Name  -> VendoredController(bbbController86Passport, bbbController86Handler)
    )
}
