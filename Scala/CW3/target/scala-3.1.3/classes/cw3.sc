//zad1
/*
  a) let f1 x = x 2 2;;
f1: a -> b
widzimy, że x jest funkcją, która zwraca C (typ wyniku funkcji x)
b = C,
a = int -> int -> C
let f1: (int -> int -> ‘a) -> ‘a = <fun>
  b) let f2 x y z = x (y^z);;
  f2: a -> b -> c -> d
  widzimy, że x jest funkcją, która zwraca C (typ wyniku funkcji x)
  widzimy, że y, z mają typ string, bo ^ to jest operand do string
  d = C
  c = string
  b = string
  wynikiem y^z będzie string
  a = string -> C
  let f2: (string -> ‘a) -> string -> string -> ‘a = <fun>*/
//zad3
def sumProd (xs:List[Int]):(Int,Int) =
  (xs foldLeft (0  ,1))((acc,h) => (acc._1+h,acc._2*h))

sumProd(List(1,2,3,4,5))
sumProd(List(2,4,6,8,10))
//zad 4
/*

  a) Funkcja wywołuje Stack.Overflow z powodu tego, że zawsze sortujemy jedną listą
(powinno być: let small = List.filter (fun y -> y < List.hd xs ) List.tl xs
  and large = List.filter (fun y -> y >= List.hd xs ) List.tl xs)
b) Funkcja nie powtarza element, jeżeli ten występuje w liście więcej niż jeden raz i zwraca go tylko
raz. (trzeba użyć <= lub >=

*/

