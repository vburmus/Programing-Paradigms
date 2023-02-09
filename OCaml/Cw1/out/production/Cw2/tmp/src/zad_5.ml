let palindrome xs =
   if xs =[] then false
   else xs = List.rev xs;;

 palindrome[1;2;1];;
 palindrome['a';'l';'a'];;
 palindrome[1;2;3;1];;
 palindrome[];;
 (*O(n)*)