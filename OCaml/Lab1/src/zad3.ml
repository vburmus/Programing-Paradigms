let rec insert(list,newElement, pos) =
if pos <= 0 then newElement::list
else if list = [] then newElement::list
else List.hd list::insert(List.tl list,newElement,pos-1);;



let list1 = ['a';'s';'d';'f'];;
let list2 = [true;true;true;true];;
let list3 = [];;

(*za zakresem*)
insert(list1, '9', 20);;
insert(list1, '9', -20);;
insert(list2, false, 20);;
insert(list2, false, -20);;

(*w zakresie char*)
insert(list1, '9', 0);;
insert(list1, '9', 2);;
insert(list1, '9', 4);;

insert(list2, false, 0);;
insert(list2, false, 2);;
insert(list2, false, 4);;

(*lista pusta*)
insert(list3, false, 4);;
insert(list3, '1', 4);;


