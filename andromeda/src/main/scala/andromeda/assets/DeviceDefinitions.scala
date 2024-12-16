package andromeda.assets

import andromeda.assets.vendors.aaa.Components.{aaaController86Passport, aaaPressure02Passport, aaaTemperature25Passport}
import andromeda.hardware.language.Hdl.{ComponentDef, ComponentIndex, Hdl}

object DeviceDefinitions {
  val boostersDef: Hdl = List(
    ComponentDef(ComponentIndex("nozzle1-t"), aaaTemperature25Passport),
    ComponentDef(ComponentIndex("nozzle1-p"), aaaPressure02Passport),
    ComponentDef(ComponentIndex("nozzle2-t"), aaaTemperature25Passport),
    ComponentDef(ComponentIndex("nozzle2-p"), aaaPressure02Passport),
    ComponentDef(ComponentIndex("controller"), aaaController86Passport)
  )
}
