package andromeda.hardware.components.api

import zio.*

trait ControllerAPI {
  def reboot: UIO[Unit]
  def turnOff: UIO[Unit]
  def eval(value: String): UIO[Unit]
  def doSomethingElse: UIO[Unit]
}
