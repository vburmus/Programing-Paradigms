let rec replicate (x,n) =
  if n=0 then []
  else x :: replicate(x,n-1);;

replicate(1,4);;
replicate(1,1);;
replicate('a',0);;
replicate('a',3);;