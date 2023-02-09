(*let rec getMachines machine =
    match machine with
          Machine(_,arr) -> arr
         |LastMachine(_) -> []
;;
let rec getTime machine =
    match machine with
          Machine(t,_) -> t
         |LastMachine(t) -> t
;;
let rec getTimes (machines,list,n) =
    match machines with
          h::t -> if n!= List.length machines then getTimes(t,(n*h)::list,n+1) else list
          | _ ->[]
;;

let timesFrom fact =
    let rec calc (times,mList, listRest, firstMachineTime) =
        match mList with
              [] -> []
            | Machine(t, ms)::r ->  calc(List.tl times, List.hd times+t, ms, firstMachineTime)
            |LastMachine(t)::r -> time+t::calc(firstMachineTime, listRest, r, [], firstMachineTime)
    in calc (0, fact, [], [], getTime(List.hd (fact)))
;;

let productionTime fact = max (timesFromDifRoutes fact);;*)

type factory = LastMachine of int | Machine of int * factory list;;
(*Szukanie maxa z listy*)
let largestTime list = List.fold_left max 0 list
(*Wyszukiwanie czasu dla przevhodzenia whszystkimi ścieżkami*)
let rec roadsTimes (factory, time) =
    match factory with
          LastMachine(t)::tail -> time+t::roadsTimes(tail, time)
        | Machine(t, nmc)::tail -> roadsTimes(nmc, time+t) @ roadsTimes(tail,time)
        | _ -> []
;;

let productionTime factory = largestTime (roadsTimes (factory, 0));;


(*TESTY*)
let test1 = [Machine (1,
                        [Machine (2,
                                    [LastMachine(6)]);
                        Machine (3,
                                    [LastMachine(6)]);
                        Machine (4,
                                    [LastMachine(6)]);
                        Machine (5,
                                    [LastMachine(6)])])];;
let test2 = [Machine (1,
                        [Machine(2,
                                    [Machine(3,
                                                [Machine(5,
                                                            [LastMachine(7)])]);
                                     Machine(4,
                                                [Machine(6,
                                                            [LastMachine(7)])])])])];;
let test3 = [Machine(1,
                        [Machine(2,
                                    [Machine(3,
                                                [Machine(6,
                                                            [LastMachine(8)])]);
                                     Machine(4,
                                                [Machine(6,
                                                            [LastMachine(8)]);
                                                 Machine(7,
                                                            [LastMachine(8)])]);
                                     Machine(5,
                                                [Machine(7,
                                                            [LastMachine(8)])])])])];;

let test4 = [Machine(1, [Machine(2,[LastMachine(3)])])];;
let test5= [LastMachine(1)];;

let res1 = productionTime test1;;
let res2 = productionTime test2;;
let res3 = productionTime test3;;
let res4 = productionTime test4;;
let res5 = productionTime test5;;




