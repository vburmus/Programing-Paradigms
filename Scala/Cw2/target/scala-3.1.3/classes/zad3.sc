def root3M(a:Double):Double =
  def root3Tail(a:Double,x:Double,i:Int):Double =
    i match{
      case (0) if a>1 => root3Tail(a,a/3,i+1)
      case (0) => root3Tail(a,a,i+1)
      case _ if Math.abs(Math.pow(x,3)-a) <= Math.pow(10,-15)*Math.abs(a) => x
      case _ => root3Tail(a,x+((a/Math.pow(x,2) - x )/ 3),i+1)
    }
  root3Tail(a,0,0)


root3M(9) == 2.080083823051904
root3M(27) == 3.0


val root3F = (a:Double) =>
  def root3Tail(a:Double,x:Double,i:Int):Double =
    i match{
      case (0) if a>1 => root3Tail(a,a/3,i+1)
      case (0) => root3Tail(a,a,i+1)
      case _ if Math.abs(Math.pow(x,3)-a) <= Math.pow(10,-15)*Math.abs(a) => x
      case _ => root3Tail(a,x+((a/Math.pow(x,2) - x ) / 3),i+1)
    }
  root3Tail(a,0,0)


root3F(9) == 2.080083823051904
root3F(27) == 3.0