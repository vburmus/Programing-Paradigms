val CONSTANT_ZERO_INDEX = 0
def differences[A](l1: List[A], l2: List[A]) : List[Int] = {

  def differenceIndexAdd[A](index: Int,l1: List[A], l2: List[A]) : List[Int] = {
    if(l1 == Nil && l2 == Nil) Nil
    else if(l1 == Nil)
      index :: differenceIndexAdd(index+1, l1,l2.tail)
    else if(l2 == Nil)
      index :: differenceIndexAdd( index+1,l1.tail,l2)
    else if(l1.head != l2.head)
      index :: differenceIndexAdd( index+1,l1.tail,l2.tail)
    else differenceIndexAdd( index+1,l1.tail,l2.tail)
  }

    differenceIndexAdd(CONSTANT_ZERO_INDEX,l1,l2);
}


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

