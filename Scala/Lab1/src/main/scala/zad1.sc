//Napisać funkcję reverse4 odwracającą kolejność elementów podanej krotki
//czteroelementowej. (OCaml i Scala) (10pkt.)

def rev[A,B,C,D](k:(A,B,C,D)) : (D,C,B,A) = (k._4,k._3,k._2,k._1)
rev(1,2,3,4)
rev(1.0,2.0,3.0,4.0)
rev((1,2),(3,4),(5,6),(7,8))




