import scala.annotation.tailrec;

def split3Rec[A](list:List[A]):(List[A],List[A],List[A]) = {
  list match
    case x1 :: x2 :: x3 :: t =>
      val (l1,l2,l3) = split3Rec(t)
      (x1 :: l1, x2 :: l2, x3 :: l3)
    case _ => (Nil, Nil, Nil)
}

def split3Tail[A](list:List[A])= {
  @tailrec
  def split(list:List[A],l1:List[A],l2:List[A],l3:List[A]):(List[A],List[A],List[A]) ={
    list match
      case x1 :: x2 :: x3 :: t =>  split(t,x1 :: l1, x2 :: l2, x3 :: l3)
      case _ => (l1, l2, l3)
  }
  split(list,Nil,Nil,Nil)
}
//rowny podzial
val list1 = List(1,2,3,4,5,6)
split3Rec(list1)
split3Tail(list1)

val list2 = List(true,true,false)
split3Rec(list2)
split3Tail(list2)

val list3 = List("ABC","DEF","GHE")
split3Rec(list3)
split3Tail(list3)

val list4 = List('a','b','c','d','f','g')
split3Rec(list4)
split3Tail(list4)

val list5 = List()
split3Rec(list5)
split3Tail(list5)
//nierowny podzial

val list6 = List(1,2,3,4,5)
split3Rec(list6)
split3Tail(list6)

val list7 = List(true,true,false,true)
split3Rec(list7)
split3Tail(list7)

val list8 = List("ABC","DEF","GHE","ADDS","Asdf")
split3Rec(list8)
split3Tail(list8)

val list9 = List('a','b','c','d','f')
split3Rec(list9)
split3Tail(list9)