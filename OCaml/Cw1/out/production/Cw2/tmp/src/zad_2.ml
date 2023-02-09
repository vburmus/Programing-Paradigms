let rec count (x,xs) =
  if xs = [] then 0
  else if x = List.hd xs then 1 + count(x,List.tl xs)
  else 0 + count(x,List.tl xs);;


count(1,[1;2;3;4;1;4;5;1]);;
count('s',['s';'w';'e';'s']);;
count(1,[2;3;4;5;6]);;