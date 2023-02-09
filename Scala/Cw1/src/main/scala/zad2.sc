def count[A](x:A,xs:List[A]): Int =
  if xs == Nil then 0
  else if x == xs.head then 1 + count(x,xs.tail)
  else 0 + count(x,xs.tail)

count(1,List(1,2,3,4,1,4,5,1))
count("s",List("s","w","e","s"))
count(1,List(2,3,4,5,6))