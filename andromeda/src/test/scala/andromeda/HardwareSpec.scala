package andromeda

import andromeda.hardware.Common.Measurement
import andromeda.hardware.Common.Parameter.Temperature
import andromeda.hardware.impl.Component.SensorAPI
import zio.test.*
import zio.{test as _, *}

object HardwareSpec extends ZIOSpecDefault {

  private def verifyTemperature(temp: Float, handler: SensorAPI): UIO[Unit] =
    for {
      measurement <- handler.readMeasurement
    } yield assertTrue(
      measurement == Measurement(Temperature, temp)
    )

  override def spec: Spec[TestEnvironment & Scope, Any] = suite("HardwareSpec")(
    suite("Hardware device components check")(
      test("") {
        assertTrue(true)
      }
    )
  )
}
