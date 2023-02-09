def replicate[A](x:A,n:Int): List[A] =
  if n == 0 then Nil
  else x :: replicate(x,n-1)

replicate(1,4)
replicate(1,1)
replicate("a",0)
replicate("a",3)