let root3 a =
  let rec root3Tail (a,x,i) =
    match i with
      0 -> if a>1.0 then root3Tail(a,a /. 3.0,i+1)
                        else root3Tail(a,a,i+1)
    | _ -> if abs_float(x ** 3. -. a)<= 10.0  ** 15. *. abs_float a then x
           else root3Tail(a, x +. ((a /. x ** 2.) -. x) /. 3.0, i+1)
  in root3Tail(a,0.0,0);;


root3 9.0 = 2.0800838230519041;;
root3 27.0 = 3.0;;