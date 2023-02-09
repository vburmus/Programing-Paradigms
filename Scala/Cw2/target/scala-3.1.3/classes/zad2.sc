//a)
val fib:Int => Int = (n:Int) =>
  n match
    case (0) => 0
    case (1) => 1
    case _ if n>0 => fib(n-2) + fib(n-1)
    case _ => throw new Exception(s"ujemny argument: $n")


fib(42) == 267914296


//b)
val fibTail = (n:Int) =>
  def fibTailHelp(n:Int,n0:Int,n1:Int):Int = {
    n match
      case (0) => n0
      case (1) => n1
      case _ if n>0 => fibTailHelp(n-1,n1,n0 + n1)
      case _ => throw new Exception(s"ujemny argument: $n")
  }
  fibTailHelp(n,0,1)


fibTail(42) == 267914296