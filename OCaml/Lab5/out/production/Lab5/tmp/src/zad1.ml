type 'a lmbt = LEmpty
                        | Node of 'a * 'a lmbt * 'a lmbt
                        | NodeLL of 'a * (unit -> 'a lmbt) * 'a lmbt
                        | NodeLR of 'a * 'a lmbt * (unit -> 'a lmbt)
                        | NodeLF of 'a * (unit -> 'a lmbt) * (unit -> 'a lmbt)
                        | LNode of (unit -> 'a) * (unit -> 'a lmbt) * (unit -> 'a lmbt) ;;
type 'a lList = LNil | LConst of 'a * (unit -> 'a lList);;
type direction = Left | Right;;


let rec lFrom n = LNode ((function()-> n), (function() -> (lFrom(n-1))), (function()-> (lFrom(n+1))));;

let rec toLazyList xs =
    match xs with
          [] -> LNil
        | h::t -> LConst (h, function() -> toLazyList t)
;;
let rec lTake (lTree, lDir) =
    match (lTree, lDir) with
                | (LNode(c, l,  r), LConst(h,t))      -> if(h == Right) then c()::lTake(r(), t())  else c()::lTake(l(), t())
                | (NodeLF(c, l, r), LConst(h,t))      -> if(h == Right) then  c::lTake(r(), t())  else c::lTake(l(), t())
                | (NodeLR(c, l, r), LConst(h,t))      -> if(h == Right) then c::lTake(r(), t()) else c::lTake(l  , t())
                | (NodeLL(c, l, r), LConst(h,t))      -> if(h == Right) then c::lTake(r  , t()) else c::lTake(l(), t())
                | (Node(c, l, r), LConst(h,t))        -> if(h == Right) then  c::lTake(r  , t()) else c::lTake(l  , t())
                | (_, _)                              -> []
;;
let rec forceNodes (lTree, lDir) =
    match (lTree, lDir) with
                | (LNode(c, l,  r), LConst(h,t))      -> if(h == Right) then NodeLL(c(),  l, (forceNodes(r(), t())))  else NodeLR(c(), (forceNodes(l(), t())),  r)
                | (NodeLF(c, l, r), LConst(h,t))      -> if(h == Right) then  NodeLL (c, l, forceNodes(r(), t()))  else NodeLR (c, forceNodes(l(),t()), r)
                | (NodeLR(c, l, r), LConst(h,t))      -> if(h == Right) then Node(c, l, forceNodes(r(), t())) else NodeLR (c, forceNodes(l,t()), r)
                | (NodeLL(c, l, r), LConst(h,t))      -> if(h == Right) then NodeLL (c, l, forceNodes(r, t())) else Node(c, forceNodes(l(),t()), r)
                | (Node(c, l, r), LConst(h,t))        -> if(h == Right) then  Node(c, l, forceNodes(r, t())) else Node(c, forceNodes(l,t()), r)
                | (_, _)                              -> LEmpty
;;


let goAhead lTree lDir =
    (lTake(lTree,toLazyList lDir),forceNodes(lTree,toLazyList lDir));;

let rec lmap f lxs =
    match lxs with
        LNil -> LNil
       | LConst(x, xf) -> LConst(f x, function () -> lmap f (xf()) )
;;
let rec ltMap f lTree =
    match lTree with
        LEmpty -> LEmpty
       | Node(c,l,r) -> Node(f(c),  ltMap f(l), ltMap f(r))
       | NodeLL(c,l,r) -> NodeLL(f(c), (function() -> ltMap f(l())), ltMap f(r))
       | NodeLR(c,l,r) -> NodeLR(f(c), ltMap f(l), (function() -> ltMap f(r())))
       | NodeLF(c,l,r) -> NodeLF(f(c), (function() -> ltMap f(l())),(function() -> ltMap f(r())))
       | LNode(c,l,r) -> LNode((function() -> f(c()) ), (function() -> ltMap f(l())),(function() -> ltMap f(r())))
       ;;
let t = lFrom 10;;
let a = [];;
let b = [Left];;
let c = [Left;Right];;
let d = [Left;Right;Left;Left;Left];;
let e = [Left;Right;Left;Left;Left;Right;Right];;
let test = goAhead t;;
test a;;
test b;;
test c;;
test d;;
test e;;
let div2 = ltMap (function x -> x/2);;
let tree2 = div2 t;;
let test2 = goAhead tree2;;
test2 e;;

(*
type 'a lmbt = LEmpty | LNode of (unit -> 'a) * (unit -> 'a lmbt) * (unit -> 'a lmbt)| Node of 'a *(unit -> 'a lmbt) * (unit -> 'a lmbt);;
type direction = Left | Right;;
type 'a llist = LNil | LConst of 'a * (unit -> 'a llist);;



let rec ltfrom k = LNode ((function()-> k), (function() -> (ltfrom(k-1))), (function()-> (ltfrom(k+1))));;


let rec findPath (ltree,dirlist) =
    match (ltree, dirlist) with
          (LEmpty, _) -> ([],LEmpty)
        | (LNode(c, l, r), LNil) -> ([c()],Node(c(),l,r))
        | (LNode(c,l,_), LConst(Left, dt)) ->
                let (xs,x) = findPath(l(),dt())
                in (c()::xs,x)
        | (LNode(c,_,r), LConst(Right, dt)) ->
                let (xs,x) = findPath(r(),dt())
                in (c()::xs,x)
;;
let getNext node dir =
   match node with
        (LEmpty,_) -> LEmpty
    | (LNode(_,l,r),Right) -> l()
    | (LNode(_,l,r),Left) -> r()

;;
let rec toLazyList l =
    match l with
          [] -> LNil
        | hd::tl -> LConst (hd, function() -> toLazyList tl)
;;

let testTree = ltfrom 10;;
testTree;;
let path = [Left];;
let lpath = toLazyList path;;
lpath;;
let x= findPath(testTree, lpath);;
let y = (snd x);;
let z = getNext (snd x);;



*)


