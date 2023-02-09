let sumProd xs = List.fold_left (fun (s,p) h -> (s+h,p*h))(0,1) xs;;

sumProd [1;2;3;4;5];;
sumProd [2;4;6;8;10];;
