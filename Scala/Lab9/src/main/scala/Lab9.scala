import Figure.counter

trait Figure:
  def volume: Double

  counter = counter + 1

  def getCounter: Int = counter
end Figure

object Figure:
  private var counter: Int = 0

end Figure

class Box(private val a: Double, private val b: Double, private val c: Double) extends Figure :
  require(a > 0 && b > 0 && c > 0, "Sides of box must be greater than zero, if not you are creating a black box")

  def this(a: Double) = this(a, a, a)

  override def volume: Double = a * b * c
end Box


class Ball(private val r: Double) extends Figure :
  require(r > 0, "Radius of ball must be greater than zero, if not you are creating a black hole")

  override def volume: Double = (4.0 / 3.0) * math.Pi * math.pow(r, 3)
end Ball

object Main:
  def main(args: Array[String]): Unit = {
    val box1 = new Box(3.0, 4.0, 5.0)
    println("Count = " + box1.getCounter)
    val cube1 = new Box(9.0)
    println("Count = " + cube1.getCounter)
    val ball1 = new Ball(1.0)
    println("Count = " + ball1.getCounter)
    val box2 = new Box(5.0, 2.0, 1.0)
    println("Count = " + box2.getCounter)
    val cube2 = new Box(1.0)
    println("Count = " + cube2.getCounter)
    val ball2 = new Ball(4.0)
    println("Count = " + ball2.getCounter)
    val array = Array(box1, box2, ball1, ball2, cube1, cube2)
    var i = 0
    while (i < array.length)
      println(s"Created: ---> " + array(i).getClass + "\n volume is: " + array(i).volume)
      i += 1
    end while




    /*new Box(1.0, -10, 1.0)
    new Box(-5)
    new Ball(-10)*/


  }

end Main




