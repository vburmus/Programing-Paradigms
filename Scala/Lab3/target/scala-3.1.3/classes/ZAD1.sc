import scala.annotation.tailrec
import scala.math.{sin, sqrt};
def decode[A](fs:List[A => A])(x:A):List[A] =
{
    fs match
      case Nil => Nil
      case _::t =>
        val h::_ = for(f<-fs) yield f(x)
        h::decode(t)(h)
}
val iDiv2 = (a:Int) => a/2
val iSqr = (b:Int) => b*b
val iDouble = (c:Int) => c+c
val int_list = List(iDiv2,iSqr,iDouble)

val test_1  = decode(int_list)
val res_1_1 = test_1(1)
val res_1_2 = test_1(5)
val res_1_3 = test_1(10)
val res_1_4 = test_1(2000)

val fMod3 = (a:Double) => a%3
val fSqrt = (b:Double) => sqrt(b)
val fDouble = (c:Double) => c+c
val double_list = List(fSqrt,fMod3,fDouble)

val test_2  = decode(double_list)
val res_2_1 = test_2(100)
val res_2_2 = test_2(5)
val res_2_3 = test_2(43)
val res_2_4 = test_2(233323)

val sConcat = (a:String) => a.repeat(2)
val sKot = (b:String) => b + " kota"
val sUpper = (c:String) => c.toUpperCase()
val sReverse = (c:String) => c.reverse
val string_list = List(sKot,sConcat,sReverse,sUpper)

val test_3  = decode(string_list)
val res_3_1 = test_3("asdfg")
val res_3_2 = test_3("qwerty")
val res_3_3 = test_3("")
val res_3_4 = test_3(" ala ma ")

val test_4 = decode(List())
val res4_1 = test_4(9999999)
