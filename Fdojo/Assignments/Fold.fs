namespace Assignments

module Fold =
    let rec fold l f z =
        match l with
        | [] -> z
        | h :: t -> f h (fold t f z)

    let rec fold' (l : 'a list) (f : 'a -> 'b -> 'b) (z : 'b) =
        match l with
        | [] -> z
        | h :: t -> f h (fold' t f z)
