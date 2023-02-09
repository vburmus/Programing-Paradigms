def insert [A](l1:List [A], x:A, n:Int) : List[A] =
  if (n<=0) x::l1
  else if (l1 == Nil) x::Nil
  else l1.head::insert(l1.tail, x, n-1)



val list1 = List('a','s','d','f');;
val list2 = List (true,true,true,true);;
val list3 = List();;


//za zakresem
insert(list1, '9', 20);;
insert(list1, '9', -20);;
insert(list2, false, 20);;
insert(list2, false, -20);;
//w zakresie char
insert(list1, '9', 0);;
insert(list1, '9', 2);;
insert(list1, '9', 4);;
//w zakresie boolean
insert(list2, false, 0);;
insert(list2, false, 2);;
insert(list2, false, 4);;
//lista pusta
insert(list3, false, 4);;
insert(list3, '1', 4);;