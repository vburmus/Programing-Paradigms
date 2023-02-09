let pascalCascadeI num =
    let array = ref (Array.make (num+1) 1) in
    for i = 0 to num-1 do
        for j = 1 to num-1 do
            !array.(j) <- !array.(j-1) + !array.(j)
            done;
        !array.(i+1)<- !array.(i)
        done;
        !array;;
    pascalCascadeI 0;;
    pascalCascadeI 1;;
    pascalCascadeI 2;;
    pascalCascadeI 3;;
    pascalCascadeI 4;;
    pascalCascadeI 5;;
    pascalCascadeI 6;;