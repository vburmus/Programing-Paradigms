/*def sublistsL[A](lazyList: LazyList[A]): LazyList[List[A]] =

  def makeList(lazyList: LazyList[A], count: Int): List[A] =
    (lazyList, count) match
      case (LazyList(), _) => Nil
      case (h #:: _, 1) => List(h)
      case (h #:: t, _) => h :: makeList(t, count - 1)

  def sublists(lazyList: LazyList[A], lazyReduced: LazyList[A], counter: Int): LazyList[List[A]] =
    (lazyList, lazyReduced, counter) match
      case (_ #:: _, _ #:: t, n) => makeList(lazyList, n) #:: sublists(lazyList, t, n + 1)
      case (_, _, _) => LazyList()

  sublists(lazyList, lazyList, 1)

 /*
 nie dziala dla niskonczonej
 def sublists(lazyList: LazyList[A], lazyReduced: Int, counter: Int): LazyList[List[A]] =
    (lazyList, lazyReduced, counter) match
      case (_, 0, _) => LazyList()
      case (_ #:: _, c, n) =>  makeList(lazyList, n) #:: sublists(lazyList, c-1, n + 1)

  sublists(lazyList, lazyList.length, 1)
*/
sublistsL(LazyList())
sublistsL(LazyList(1, 2, 3)).force
(sublistsL(LazyList.from(0)).take(4)).force*/
def pascal(c: Int, r: Int): Int = {
  if (c < 0 || r < 0 || c > r) throw new IllegalArgumentException("Column and row numbers must be 0 or greater. Column length must be lower than row length") else{
    if (c == 0 || c == r) 1 else {
      pascal(c - 1, r - 1) + pascal(c, r - 1)
    }
  }
}
pascal(10,10)
