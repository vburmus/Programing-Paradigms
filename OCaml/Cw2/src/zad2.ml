
(*Zadanie 2*)
(*a*)
let rec fib n =
  match n with
    0          -> 0
  | 1          -> 1
  | _ -> if n>0 then fib(n-2) + fib(n-1)
         else raise (Failure "ujemny argument");;


fib 42;;


(*b*)
let fibTail n =
  let rec fibTailHelp (n,n0,n1) =
    match n with
      0          -> n0
    | 1          -> n1
    | _ -> if n>0 then fibTailHelp(n-1,n1,n0+n1)
           else raise (Failure "ujemny argument")
  in fibTailHelp(n,0,1);;


fibTail 42;;