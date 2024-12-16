package andromeda.assets.vendors.aaa

import andromeda.assets.vendors.aaa.Components.{aaaController86Name, aaaPressure02Name, aaaTemperature25Name}
import andromeda.hardware.Common
import andromeda.hardware.Common.*
import andromeda.hardware.Common.ComponentClass.{Controllers, Sensors}
import andromeda.hardware.Common.Parameter.Temperature
import andromeda.hardware.impl.Component.{ControllerAPI, SensorAPI}
import zio.*

object ComponentsAPI {
  val aaaTemperature25Handler: SensorAPI    = new SensorAPI {
    def reset: UIO[Unit]                                                   = Console.printLine(s"$aaaTemperature25Name reset.").orDie
    def readMeasurement: UIO[Measurement]                                  = ZIO.succeed(Measurement(Temperature, 100.0)) // dummy
    def setCallback(period: Period, callback: UIO[Measurement]): UIO[Unit] = callback *> Console.printLine(s"$aaaTemperature25Name callback.").orDie
  }
  val aaaPressure02Handler: SensorAPI       = new SensorAPI {
    def reset: UIO[Unit]                                                   = Console.printLine(s"$aaaPressure02Name reset.").orDie
    def readMeasurement: UIO[Measurement]                                  = ZIO.succeed(Measurement(Temperature, 100.0)) // dummy
    def setCallback(period: Period, callback: UIO[Measurement]): UIO[Unit] = callback *> Console.printLine(s"$aaaPressure02Name callback.").orDie
  }
  val aaaController86Handler: ControllerAPI = new ControllerAPI {
    def reboot: UIO[Unit]            = Console.printLine(s"$aaaController86Name reset.").orDie
    def turnOff: UIO[Unit]           = Console.printLine(s"$aaaController86Name turn off.").orDie
    def eval(cmd: String): UIO[Unit] = Console.printLine(s"$aaaController86Name eval cmd: $cmd").orDie
    def doSomethingElse: UIO[Unit]   = Console.printLine(s"$aaaController86Name do something else").orDie
  }
}
