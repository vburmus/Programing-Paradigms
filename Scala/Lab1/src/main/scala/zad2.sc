def differences[A](l1: List[A], l2: List[A]) : Int =
  if(l1 == Nil && l2 == Nil) 0
  else if(l1 == Nil) 1 + differences(l1,l2.tail)
  else if(l2 == Nil) 1 + differences(l1.tail,l2)
  else if(!(l1.head ==l2.head)) 1 + differences(l1.tail,l2.tail)
  else differences(l1.tail,l2.tail)


//1 krotsza
val list1 = 1::2::3::4::Nil
val list2 = 1::2::3::4::4::5::5::Nil
//jednakowe
val list3 = 'a'::'l'::'a'::'m'::Nil
val list4 = 'a'::'l'::'a'::'m'::Nil
//2 krotsza
val list5 = 3::2::3::4::4::5::5::Nil
val list6 = 3::2::3::4::Nil
//rozne
val list7 = 4::4::5::Nil
val list8 = 3::2::3::Nil
differences (list1, list2)
differences (list3, list4)
differences (list5, list6)
differences (list7, list8)

