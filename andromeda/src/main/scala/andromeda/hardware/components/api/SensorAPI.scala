package andromeda.hardware.components.api

import andromeda.hardware.Common.Measurement
import andromeda.hardware.Common.Period
import zio.*

trait SensorAPI {
  def reset: UIO[Unit]
  def readMeasurement: UIO[Measurement]
  def setCallback(period: Period, callback: UIO[Measurement]): UIO[Unit]
}
