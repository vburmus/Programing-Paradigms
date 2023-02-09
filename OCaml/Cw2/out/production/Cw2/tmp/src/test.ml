(*let sigma f m =
let rec suma (i,s)=
if i=m then s else suma(i+1, s +. f(i+1))
in suma(0, f 0)
;;
sigma (fun k -> float(k*k*k)) 3;;*)
(*let curry f x y = f (x, y);;
let plus (x,y) = x+y;;
let add = curry plus;;
add 1 2;;*)




