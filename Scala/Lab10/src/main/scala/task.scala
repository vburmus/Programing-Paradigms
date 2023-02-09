object Main1:
  def main(args: Array[String]): Unit = {
    /*W Scali, List - typ niezmienny i nie ma mozliwosci zmieniać elementy,
    dlatego -> jest kowariantna.
    Moglibysmy zmodyfikowac i dodac kowariancje, ale potrzebujemy napisac swojej klasy*/


    //AnyVal>:Int, wiec w kowariantnosc zachodzi, zas ----|
    //                                                    |
    /*
      val listL:List[AnyVal] = List(1L,2L) <--------------|
      val listI:List[Int] = listL
                            ^^^
                        NIE ZACHODZI!

    AnyVal >: {Double,Float,Long,Int,Short,Byte}

  */

    // Int jest podtypem AnyVal
    val listICo: List[Int] = List(1, 2, 3)
    val listLCo: List[AnyVal] = listICo

  }
end Main1


sealed trait Access

trait Low extends Access

trait High extends Low

trait Super extends High


trait User[R <: Access, W <: Access]:
  def secret: String

  def secret(s: String): Unit
end User

class LowAccessUser(var userSecret: String) extends User[Low, Low] :
  override def secret: String = userSecret

  override def secret(s: String) = userSecret = s
end LowAccessUser

class SuperAccessUser(var userSecret: String) extends User[Super, Super] :
  override def secret: String = userSecret

  override def secret(s: String) = userSecret = s
end SuperAccessUser

class HighAccessUser(var userSecret: String) extends User[High, High] :
  override def secret: String = userSecret

  override def secret(s: String) = userSecret = s
end HighAccessUser

class MixedDeveloperAccessUser(var userSecret: String) extends User[Low, Super] :
  override def secret: String = userSecret

  override def secret(s: String) = userSecret = s
end MixedDeveloperAccessUser

class MixedManagerAccessUser(var userSecret: String) extends User[High, Low] :
  override def secret: String = userSecret

  override def secret(s: String) = userSecret = s
end MixedManagerAccessUser

class Terminal[R <: Access, W <: Access](var secret: String):
  def read[RUA <: R](user: User[RUA, _]): Unit = user.secret(secret)

  def write[WUA <: W](user: User[_, WUA]): Unit = secret = user.secret
end Terminal


object Main2:
  def main(args: Array[String]): Unit = {
    val superUser = new SuperAccessUser("super")
    val lowUser = new LowAccessUser("low")
    val highUser = new HighAccessUser("high")
    val devUser = new MixedDeveloperAccessUser("low,super")
    val managerUser = new LowAccessUser("super,low")

    val highTerminal = new Terminal[High, High]("Jaki jezyk jest najczesciej uzywany przez programistow?\n\n -Wulgarny")
    val lowHighTerminal = new Terminal[Low, High]("Skąd informatyk pobiera wodę?\n\n- Z e-kranu.")
    val superTerminal = new Terminal[Super, Super]("Jak się nazywa facet, który mierzy Łódź od środka?\n\n- Włodzimierz.")

    highTerminal.read(superUser)
    println(superUser.secret eq highTerminal.secret)
    highTerminal.write(highUser)
    println(highTerminal.secret eq highUser.secret)
    //  nie dziala write
    //  lowHighTerminal.write(managerUser)
    // read natychmiast dziala
    lowHighTerminal.read(managerUser)
    println("terminal - > user =SECRET=>" + managerUser.secret)
    lowHighTerminal.write(devUser)
    println("terminal < - user =SECRET=>" + lowHighTerminal.secret)
    //nie ma dostepu
    /*
        superTerminal.write(lowUser)
        superTerminal.read(lowUser)

        superTerminal.write(managerUser)
        superTerminal.read(devUser)
    */
  }
end Main2


