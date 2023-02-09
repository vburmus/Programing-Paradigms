(*Napisać funkcję differences przyjmującą dwie listy i zliczającą na ilu pozycjach
są one różne. *);;
let rec differences (l1,l2) =
if l1 = []  && l2 = [] then 0
else if l1 = []  then 1 + differences(l1,List.tl l2)
else if l2 = [] then 1 + differences(List.tl l1,l2)
else if not (List.hd l1 = List.hd l2) then 1 + differences(List.tl l1, List.tl l2)
else differences(List.tl l1, List.tl l2);;

(*1 krotsza*)
let list1 = 1::2::3::4::[];;
let list2 = 1::2::3::4::4::5::5::[];;
(*jednakowe*)
let list3 = 'a'::'l'::'a'::'m'::[];;
let list4 = 'a'::'l'::'a'::'m'::[];;
(*2 krotsza*)
let list5 = 3::2::3::4::4::5::5::[];;
let list6 = 3::2::3::4::[];;
(*rozne*)
let list7 = 4::4::5::[];;
let list8 = 3::2::3::[];;
differences (list1, list2);;
differences (list3, list4);;
differences (list5, list6);;
differences (list7, list8);;

