package andromeda.vendors

import andromeda.hardware.Common
import andromeda.hardware.Common.ComponentClass.{Controllers, Sensors}
import andromeda.hardware.Common.Parameter.Temperature
import andromeda.hardware.Common.*
import andromeda.hardware.components.api.{ControllerAPI, SensorAPI}
import zio.*

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
  val t25Handler: SensorAPI            = new SensorAPI {
    def reset: UIO[Unit]                                                   = Console.printLine(s"$t25SensorName reset.").orDie
    def readMeasurement: UIO[Measurement]                                  = ZIO.succeed(Measurement(Temperature, 100.0)) // dummy
    def setCallback(period: Period, callback: UIO[Measurement]): UIO[Unit] = callback *> Console.printLine(s"$t25SensorName callback.").orDie
  }
  val p02Handler: SensorAPI            = new SensorAPI {
    def reset: UIO[Unit]                                                   = Console.printLine(s"$p02SensorName reset.").orDie
    def readMeasurement: UIO[Measurement]                                  = ZIO.succeed(Measurement(Temperature, 100.0)) // dummy
    def setCallback(period: Period, callback: UIO[Measurement]): UIO[Unit] = callback *> Console.printLine(s"$p02SensorName callback.").orDie
  }
  val c86Handler: ControllerAPI        = new ControllerAPI {
    def reboot: UIO[Unit]            = Console.printLine(s"$c86ControllerName reset.").orDie
    def turnOff: UIO[Unit]           = Console.printLine(s"$c86ControllerName turn off.").orDie
    def eval(cmd: String): UIO[Unit] = Console.printLine(s"$c86ControllerName eval cmd: $cmd").orDie
    def doSomethingElse: UIO[Unit]   = Console.printLine(s"$c86ControllerName do something else").orDie
  }
}
