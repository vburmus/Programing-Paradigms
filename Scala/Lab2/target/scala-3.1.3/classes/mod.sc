/*
def insert [A](l1:List [A], x:A, n:Int) : List[A] =
  if (n<=0) x::l1
  else if (l1 == Nil) x::Nil
  else l1.head::insert(l1.tail, x, n-1)

*/

def insert[A](lista:List[A]) (elem:A) (index:Int):List[A] =
lista match
  case Nil =>elem::Nil
  case _ if index<=0 => elem::lista
  case h::t => h::insert(t)(elem)(index-1)

insert(List(1,2,3))(0)(0)
insert(List(1,2,3))(0)(1)
insert(List(1,2,3))(0)(2)
insert(List(1,2,3))(0)(3)

insert(List(1,2,3))(0)(-999)
insert(List(1,2,3))(0)(999)

insert(List('a','b'))('c')(0)
insert(List(true,true))(false)(1)

insert(List())(false)(1)
insert(List())('c')(-999)


