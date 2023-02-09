def listLength[A](xs:List[A]): Int =
  if xs == Nil then 0
  else 1 + listLength(xs.tail)

listLength(List(1,2,3))
listLength(List())
listLength(List(1))
listLength(List("a","s","d","q"))