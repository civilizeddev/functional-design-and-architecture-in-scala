package andromeda.hardware.impl

import andromeda.hardware.Common.{ComponentName, ComponentPassport, Measurement, Period}
import zio.*

object Component {
  trait SensorAPI {
    def reset: UIO[Unit]
    def readMeasurement: UIO[Measurement]
    def setCallback(period: Period, callback: UIO[Measurement]): UIO[Unit]
  }

  trait ControllerAPI {
    def reboot: UIO[Unit]
    def turnOff: UIO[Unit]
    def eval(cmd: String): UIO[Unit]
    def doSomethingElse: UIO[Unit]
  }

  enum VendorComponent {
    case VendoredSensor(passport: ComponentPassport, handler: SensorAPI)
    case VendoredController(passport: ComponentPassport, handler: ControllerAPI)
  }

  type VendorComponents = Map[ComponentName, VendorComponent]
}
