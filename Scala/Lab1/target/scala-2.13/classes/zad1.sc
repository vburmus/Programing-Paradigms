//Napisać funkcję reverse4 odwracającą kolejność elementów podanej krotki
//czteroelementowej. (OCaml i Scala) (10pkt.)

def rev[A,B,C,D](k:(A,B,C,D)) : (D,C,B,A) = (k._4,k._3,k._2,k._1)
rev((1,"asdf",'c',2.2))
rev((1,2,1,0))




