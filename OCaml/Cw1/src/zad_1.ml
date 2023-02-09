let rec flatten1 xss =
  if xss = [] then []
  else List.hd xss @ flatten1(List.tl xss);;

flatten1[[1;2;3];[4;5;6];[7;8]];;
flatten1[];;
flatten1[['a';'b';'c'];['d';'e';'f']];;