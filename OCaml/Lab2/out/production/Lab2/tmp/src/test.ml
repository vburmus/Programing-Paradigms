let rec fold_right f l accu=
    match l with
        [] -> accu
       | a::l ->  f a(fold_right f l accu) ;;
       let add x = x+ x;;
       let f x y z = x z (y x);;

