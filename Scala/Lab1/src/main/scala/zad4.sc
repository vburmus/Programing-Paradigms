def polishTime(time:(Int,Int)) : String =
  if(time._1 > 23 || time._1 < 0 || time._2 > 59 || time._2 < 0){
      throw new Exception("You entered wrong time!")

  }else if(time._1 == 0 && time._2 == 0){
    "Polnoc"
  }else if(time._1 < 5){
    time._1 + ":" + time._2 + " w nocy!"
  }else if(time._1 < 12){
    time._1 + ":" + time._2 + " rano!"
  }else if(time._1 == 12 && time._2 == 0){
    "Poldzien!"
  }else if(time._1 < 18){
    (time._1 - 12) + ":" + time._2 + " po poludniu!"
  }else {
    (time._1 - 12) + ":" + time._2 + " wieczorem!"
  }
//Polnoc
polishTime((0,0))
//W nocy
polishTime((3,55));;
polishTime((2,0));;
//Rano
polishTime((7,55))
polishTime((5,21))
//Poludzien
polishTime((12,0))
//Po poludniu
polishTime((12,55))
polishTime((15,21))
//Wieczorem
polishTime((19,55))
polishTime((20,21))
//Failures

polishTime((24, 0))
polishTime((-1,0))
polishTime((0,-5))
polishTime((0,61))
polishTime((24,61))
polishTime((-5,-1))
