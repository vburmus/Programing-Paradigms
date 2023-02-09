(*COMPARATOR*)
module type COMPARATOR = sig
type result = LT|EQ|GT
type t
val compare: t -> t -> result
end;;

module IntComparator : COMPARATOR with type t = int  =
struct
type result = LT | EQ | GT;;
type t = int
let compare x1 x2 = if x1 < x2 then LT
                    else if x1 > x2 then GT
                    else EQ
end;;

module StrComparator : COMPARATOR with type t = string =
struct
type result = LT | EQ | GT;;
type t = string
let compare s1 s2 = if s1 < s2 then LT
                    else if s1 > s2 then GT
                    else EQ
end;;

module type ORDER_LIST =
sig
type typ
type t
exception Empty of string
val create: unit -> t
val insert: t -> typ -> unit
val retrieve: t -> typ
val getList: t -> typ list
end;;


module OrderedListImpl(Order : COMPARATOR) =
struct
(*typ, pobrany z comparatora, przekazywany dalej liscie*)
type typ = Order.t
(*rekordowy typ, ktory zawiera w sobie liste*)
type t = {mutable l: typ  list}
(*blad*)
exception Empty of string
(*metoda dla tworzenia pustej tablicy*)
let create() = {l = [] }
(*metoda dla wstawiania elementu el w  *)
let  insert s el  =
        let rec add l el = if l= [] then [el]
                           else
                                let h = List.hd l and t = List.tl l in
                                    if Order.compare el h = Order.GT then h::add t el
                                    else el::h::t
       in s.l <- add s.l el;;
(*pobranie listy*)
let getList s = s.l;;
(*analog pop w liscie*)
let retrieve s = if (s.l=[]) then raise (Empty "module OrderedListImpl:retrieve")
                        else let pop = List.hd s.l
                        in begin
                         s.l <- List.tl s.l;
                         pop
                         end;;
end;;

(*TESTY*)
module OrderedList(Comp:COMPARATOR):ORDER_LIST with type typ = Comp.t = OrderedListImpl(Comp:COMPARATOR) ;;

module IntOrderedList = OrderedListImpl(IntComparator);;
let list = IntOrderedList.create();;

IntOrderedList.insert list 4;;
IntOrderedList.insert list 3;;
IntOrderedList.insert list 5;;
IntOrderedList.insert list 4;;
IntOrderedList.insert list 1;;
IntOrderedList.getList  list;;
IntOrderedList.retrieve list;;
IntOrderedList.getList  list;;
IntOrderedList.retrieve list;;
IntOrderedList.getList  list;;
IntOrderedList.retrieve list;;
IntOrderedList.retrieve list;;
IntOrderedList.retrieve list;;
IntOrderedList.retrieve list;;
IntOrderedList.getList  list;;

module StrOrderedList = OrderedList(StrComparator);;
let listStr = StrOrderedList.create();;
StrOrderedList.insert listStr "4";;
StrOrderedList.insert listStr "3";;
StrOrderedList.insert listStr "5";;
StrOrderedList.insert listStr "4";;
StrOrderedList.insert listStr "1";;
StrOrderedList.getList listStr;;
StrOrderedList.retrieve listStr;;
StrOrderedList.getList listStr;;
StrOrderedList.retrieve listStr;;
StrOrderedList.getList listStr;;
StrOrderedList.retrieve listStr;;
StrOrderedList.retrieve listStr;;
StrOrderedList.retrieve listStr;;
StrOrderedList.retrieve listStr;;
StrOrderedList.getList listStr;;


list;;







