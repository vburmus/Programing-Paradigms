def find [A](list:List[A])(x:A):Int = {
  list match
    case Nil => 0
    case h :: t if h == x => 1 + find(t)(x)
    case _ => find(list.tail)(x)
}
val find123 = find(List(1,2,3,1,2))
find123(1)
find123(3)

val findBOOL = find(List(true,false,true))
findBOOL(true)
findBOOL(false)

val findABCD = find (List('a','b','c','a'))
findABCD('a')
findABCD('b')

val findString = find (List("Ala","ma","kota","Ala"))
findString("Ala")
findString("ma")

val findNil = find(List())
findNil(Nil)