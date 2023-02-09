sealed trait Factory
case class LastMachine(time:Int) extends Factory
case class Machine (time:Int, next:List[Factory]) extends Factory

//Wyszukiwanie czasu dla przevhodzenia whszystkimi ścieżkami
def timesFromDifRoutes (factory:List[Factory], time:Int): List[Int] =
{
  factory match
    case LastMachine(t)::tail => time+t::timesFromDifRoutes(tail, time)
    case Machine(t, nmc)::tail => timesFromDifRoutes(nmc, time+t) ::: timesFromDifRoutes(tail, time)
    case _ => Nil
}



def productionTime (factory: List[Factory]) = timesFromDifRoutes(factory, 0).max



//TESTY
val test1 = List(Machine(1,
                          List(Machine(2,
                                          List(LastMachine(6))),
                                Machine(3,
                                          List(LastMachine(6))),
                                Machine(4,
                                          List(LastMachine(6))),
                                Machine(5,
                                          List(LastMachine(6))))))

val test2 = List(Machine(1,
                          List(Machine(2,
                                        List(Machine(3,
                                                      List(Machine(5,
                                                                    List(LastMachine(7))))),
                                              Machine(4,
                                                      List(Machine(6,
                                                                    List(LastMachine(7))))))))))
val test3 = List(Machine(1,
                          List(Machine(2,
                                        List(Machine(3,
                                                      List(Machine(6,
                                                                    List(LastMachine(8))))),
                                              Machine(4,
                                                      List(Machine(6,
                                                                     List(LastMachine(8))),
                                                            Machine(7,
                                                                      List(LastMachine(8))))),
                                              Machine(5,
                                                      List(Machine(7,
                                                                      List(LastMachine(8))))))))))
val test4 = List(Machine(1,
              List(Machine(2,
                List(LastMachine(3))))))
val test5 = List(LastMachine(1))


val res1 = productionTime(test1)
val res2 = productionTime(test2)
val res3 = productionTime(test3)
val res4 = productionTime(test4)
val res5 = productionTime(test5)