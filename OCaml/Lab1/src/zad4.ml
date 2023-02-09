let polishTime(time) =
     if fst time > 23 || fst time < 0 ||
        snd time > 59 || snd time < 0
        then raise(Failure "You entered wrong time!")
     else if fst time == 0 && snd time == 0
           then "Polnoc"
     else if fst time < 5
           then string_of_int (fst time) ^ ":" ^ string_of_int (snd time) ^ " w nocy!"
     else if fst time < 12
           then string_of_int(fst time) ^ ":" ^ string_of_int (snd time) ^ " rano"
     else if fst time == 12 && snd time == 00
           then "Poludzien"
     else if fst time < 18
           then string_of_int(fst time - 12) ^ ":" ^ string_of_int (snd time) ^ " po poludniu"
           else string_of_int(fst time - 12) ^ ":" ^ string_of_int (snd time) ^ " wieczorem";;


        (*Failures*)
        polishTime((24,0));;
        polishTime((-1,0));;
        polishTime((0,-5));;
        polishTime((0,61));;
        polishTime((24,61));;
        polishTime((-5,-1));;
        (*Polnoc*)
        polishTime((0,0));;
        (*W nocy*)
        polishTime((3,55));;
        polishTime((2,0));;
        (*Rano*)
        polishTime((7,55));;
        polishTime((5,21));;
        (*Poludzien*)
        polishTime((12,0));;
        (*Po poludniu*)
        polishTime((12,55));;
        polishTime((15,21));;
        (*Wieczorem*)
        polishTime((19,55));;
        polishTime((20,21));;


