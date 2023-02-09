//Zadanie 5
def initSegment[A](xs: List[A],ys:List[A]):Boolean =
  (xs,ys) match
    case (Nil, _) => true
    case (_, Nil) => false
    case (hx :: tx, hy :: ty) =>  if hx == hy then initSegment(tx, ty) else false



initSegment(List(1,2,3,4), List(1,2,3,4,5,6,7,8,9)) == true
initSegment(List('a','b','c','d'),List('a','b','c','d','e')) == true
initSegment(List(),List(1,2,3,4)) == true
initSegment(List(1,2,3),List(1,2,3)) == true
initSegment(List(2,3,4),List(5,6,7,8)) == false


