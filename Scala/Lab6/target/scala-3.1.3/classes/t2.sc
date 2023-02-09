
def pascalCascadeI(num: Int): Array[Int] = {
 if num < 0 then throw new Exception("Error num provided")
 else {
   val array = Array.fill(num + 1)(1)
   var i = 0
   while i < num do
     var j = 1
     while j < num do
       array(j) = array(j - 1) + array(j)
       j += 1
     end while
     array(i + 1) = array(i)
     i += 1
   end while
   array
 }
}
pascalCascadeI(-1)
pascalCascadeI(0)
pascalCascadeI(1)
pascalCascadeI(2)
pascalCascadeI(3)
pascalCascadeI(4)
pascalCascadeI(5)
pascalCascadeI(6)
