(*dodawanie*)
let (+%) (x1,x2) (y1,y2) = (x1 +. y1, x2 +. y2);;

(*odejmowanie*)
let (-%) (x1,x2) (y1,y2) = (x1 -. y1, x2 -. y2);;

(*mnozenie*)
let ( *% ) (x1,x2) (y1,y2) = ((x1 *. y1) -. (x2 *. y2) , (x1 *. y2) +. (x2 *. y1));;

(*negacja(sprzezenie)*)
let (~%) (x1,x2) = (x1, x2*.(-1.));;

(*modulus*)
let (!%) (x1,x2) = (sqrt (x1 ** 2. +. x2 ** 2.));;

(*argument*)
(*https://en.wikipedia.org/wiki/Argument_(complex_analysis)*)
let (?%) (a,b) =
    if (a > 0.) then atan (b /. a)
    else if (a < 0.) then atan (b /. a) +. Float.pi
    else
        if (b > 0.) then Float.pi /. 2.
        else if (b < 0.) then Float.pi /. -2.
        else raise (Failure "Undefined argument")


let roots (x, y) n =
    let rec root (x, y, n, index) =
        match index with
            | -1. -> []
            (*https://pl.wikipedia.org/wiki/Wz%C3%B3r_de_Moivre%E2%80%99a*)
            |  _  -> (((!% (x,y)) ** (1. /. n)) *. cos(((?% (x, y)) +. 2. *. Float.pi *. index) /. n),  ((!% (x,y)) ** (1. /. n)) *. sin(((?% (x, y)) +. 2. *. Float.pi *. index) /. n))::root(x, y, n, index -. 1.)
    in root(x, y, n, n -. 1.)
;;

(*potega*)
let (%%) (x, y) n =
  (let modul = !% (x,y) and arg = ?% (x, y) in
    ((modul**n) *. cos(n *. arg),  (modul ** n) *. sin(n *. arg))
    );;




let add = (1.,3.) +% (2.,7.);;

let min = (5.,3.) -% (1.,6.);;

let multiply = (1., 2.) *% (8.,-7.);;

let neg = ~% (2.,-1.);;

let modulus = !% (1., 4.);;

let arg = ?% (1.,6.);;
(*undef*)
?% (0.,0.);;



roots (0., 1.) 4.;;
(*https://www.emathhelp.net/calculators/algebra-2/nth-roots-of-complex-number-calculator/?i=1i&n=4*)
let potega =  (1.,1.) %% 2.;;