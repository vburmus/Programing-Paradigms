
package figure


class Box(private val a: Double, private val b: Double, private val c: Double) extends Figure {
  require(a > 0 && b > 0 && c > 0, "Invalid dimensions for figure.Box")
  def this(a:Double) = this(a,a,a)
  override def volume:Double = a*b*c

}





