package andromeda.common

enum Value:
  case BoolValue(value: Boolean)
  case IntValue(value: Int)
  case FloatValue(value: Float)
  case StringValue(value: String)

object Value {
  def boolValue(value: Boolean): Value  = Value.BoolValue(value)
  def intValue(value: Int): Value       = Value.IntValue(value)
  def floatValue(value: Float): Value   = Value.FloatValue(value)
  def stringValue(value: String): Value = Value.StringValue(value)
}
