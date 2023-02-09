let rec split3Rec(list) =
 match list with
    | x1::x2::x3::t -> let (l1,l2,l3) = split3Rec(t) in (x1::l1,x2::l2,x3::l3)
    | _ -> ([],[],[])
    ;;

let split3Tail(list)  =
    let rec split(list,l1,l2,l3) =
      match list with
          | x1::x2::x3::t -> split(t,x1::l1,x2::l2,x3::l3)
          | _ -> (l1,l2,l3)
      in split(list, [],[],[]);;
(*rowny podzial*)
let list1 = [1;2;3;4;5;6];;
    split3Rec(list1);;
    split3Tail(list1);;
(*
let list2 = [true;true;false];;
    split3Rec(list2);;
    split3Tail(list2);;
let list3 = ["ABC";"DEF";"GHE"];;
    split3Rec(list3);;
    split3Tail(list3);;
let list4 = ['a';'b';'c';'d';'f';'g'];;
    split3Rec(list4);;
    split3Tail(list4);;
let list5 = [];;
    split3Rec(list5);;
    split3Tail(list5);;
(*nierowny podzial*)
let list6 = [1;2;3;4;5];;
    split3Rec(list6);;
    split3Tail(list6);;
let list7 = [true;true;false;true];;
    split3Rec(list7);;
    split3Tail(list7);;
let list8 = ["ABC";"DEF";"GHE";"ADDS";"Asdf"];;
    split3Rec(list8);;
    split3Tail(list8);;
let list9 = ['a';'b';'c';'d';'f'];;
    split3Rec(list9);;
    split3Tail(list9);;*)
