def flatten1[A](xss: List[List[A]]):List[A] =
  if xss == Nil then Nil
  else xss.head ::: flatten1(xss.tail)

flatten1(List(List(1,2,3),List(4,5,6),List(7,8)))
flatten1(List(Nil))
flatten1(List(List("a","b","c"),List("d","e","f")))