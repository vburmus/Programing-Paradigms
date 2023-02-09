def palindrome[A](xs:List[A]): Boolean =
  if xs == Nil then false
  else xs == xs.reverse

palindrome(List(1,2,1))
palindrome(List("a","l","a"))
palindrome(List())
palindrome(List(1,2,3,1))