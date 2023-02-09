def differences[A,B](l1: List[A], l2: List[B]) : Int =
  if(l1 == Nil && l2 == Nil){
    0
  }else if(l1 == Nil){
    1 + differences(l1,l2.tail)
  }else if(l2 == Nil){
    1 + differences(l1.tail,l2)
  }else if(!(l1.head ==l2.head)){
    1 + differences(l1.tail,l2.tail)
  }else{
    differences(l1.tail,l2.tail)
  }


val list1 = 1::2::3::4::Nil;;
val list2 = 3::2::3::4::4::5::5::Nil;;
differences (list1, list2);;

