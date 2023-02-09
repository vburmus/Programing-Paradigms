let rec find list x =
    match list with
        | [] -> 0
        | h::t when h = x -> 1 + find t x
        | h::t -> find t x ;;

        let find123 = find [1;2;3;1;2];;
                find123 1;;
                find123 3;;
        let findBOOL = find [true;false;true];;
                findBOOL true;;
                findBOOL false;;
        let findABCD = find ['a';'b';'c';'a'];;
                findABCD 'a';;
                findABCD 'b';;
        let findString = find ["Ala";"ma";"kota";"Ala"];;
                findString "Ala";;
                findString "ma";;

        let findNil = find [];;
        findNil 1;;
