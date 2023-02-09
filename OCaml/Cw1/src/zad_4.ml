let rec sqrList xs =
  if xs = [] then []
  else (List.hd xs * List.hd xs) :: sqrList(List.tl xs);;

sqrList[2;3;4;6];;
sqrList[-3;-4;0];;
sqrList[];;