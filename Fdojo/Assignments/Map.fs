namespace Assignments

module Map =
    let rec add1 xs = 
        match xs with
        | [] -> []
        | h :: t -> h+1 :: add1 t

    let rec double xs = 
        match xs with
        | [] -> []
        | h :: t -> h*2 :: double t

    let rec lens (xs : List<string>) = 
        match xs with
        | [] -> []
        | h :: t -> h.Length :: lens t

    let rec map' xs f = 
        match xs with
        | [] -> []
        | h :: t -> f h :: map' t f
