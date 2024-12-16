package andromeda.assets.vendors.bbb

import andromeda.assets.vendors.bbb.Components.{bbbController86Name, bbbPressure02Name, bbbTemperature25Name}
import andromeda.hardware.Common
import andromeda.hardware.Common.*
import andromeda.hardware.Common.Parameter.Temperature
import andromeda.hardware.impl.Component.{ControllerAPI, SensorAPI}
import zio.*

object ComponentsAPI {
  val bbbTemperature25Handler: SensorAPI    = new SensorAPI {
    def reset: UIO[Unit]                                                   = Console.printLine(s"$bbbTemperature25Name reset.").orDie
    def readMeasurement: UIO[Measurement]                                  = ZIO.succeed(Measurement(Temperature, 100.0)) // dummy
    def setCallback(period: Period, callback: UIO[Measurement]): UIO[Unit] = callback *> Console.printLine(s"$bbbTemperature25Name callback.").orDie
  }
  val bbbPressure02Handler: SensorAPI       = new SensorAPI {
    def reset: UIO[Unit]                                                   = Console.printLine(s"$bbbPressure02Name reset.").orDie
    def readMeasurement: UIO[Measurement]                                  = ZIO.succeed(Measurement(Temperature, 100.0)) // dummy
    def setCallback(period: Period, callback: UIO[Measurement]): UIO[Unit] = callback *> Console.printLine(s"$bbbPressure02Name callback.").orDie
  }
  val bbbController86Handler: ControllerAPI = new ControllerAPI {
    def reboot: UIO[Unit]            = Console.printLine(s"$bbbController86Name reset.").orDie
    def turnOff: UIO[Unit]           = Console.printLine(s"$bbbController86Name turn off.").orDie
    def eval(cmd: String): UIO[Unit] = Console.printLine(s"$bbbController86Name eval cmd: $cmd").orDie
    def doSomethingElse: UIO[Unit]   = Console.printLine(s"$bbbController86Name do something else").orDie
  }
}
