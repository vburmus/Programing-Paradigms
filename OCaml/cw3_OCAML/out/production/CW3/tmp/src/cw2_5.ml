(*Zadanie 5*)
let rec initSegment (xs,ys) =
  match (xs,ys) with
    ([],_) -> true
  | (_,[]) -> false
  | (hx::tx, hy::ty) -> if hx = hy then initSegment(tx,ty) else false;;


initSegment([1;2;3;4],[1;2;3;4;5;6;7]) = true;;
initSegment(['a';'b';'c'],['a';'b';'c';'d']) = true;;
initSegment([1;2;3],[1;2;3]) = true;;
initSegment([],[1;2;3]) = true;;
initSegment([2;3;4],[1;2;3;4]) = false;;
