import scala.annotation.tailrec

def pascal(row: Int, col: Int): Int = {
    if row == 1 && col == 1 then 1
    else if row > 0 && col > 0 then {
      if row < col then 0
      else pascal(row - 1, col) + pascal(row, col - 1)
    } else 0
  }

  def pascalCascadeF(num:Int):List[Int] = {
    if num <= 0 then throw new Exception("Error num provided")
    else {
      def help(c: Int): List[Int] = {
        if c <= num then pascal(num, c) :: help(c + 1)
        else Nil
      }

      help(1);
    }
}

pascalCascadeF(0)
pascalCascadeF(1)
pascalCascadeF(2)
pascalCascadeF(3)
pascalCascadeF(4)
pascalCascadeF(5)
pascalCascadeF(6)





