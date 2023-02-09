def sqrList1(xs:List[Int]): List[Int] =
  if xs == Nil then Nil
  else (xs.head*xs.head) :: sqrList1(xs.tail)

sqrList1(List(2,4,5,6))
sqrList1(List())
sqrList1(List(-3,1,0))