namespace Assignments

module Filter =
    let rec alle5 xs = 
        match xs with
        | [] -> []
        | h :: t -> if h < 5 then h :: alle5 t else alle5 t

    let rec alle5' xs =
        match xs with
        | [] -> []
        | h :: t when h < 5 -> h :: alle5 t
        | h :: t -> alle5 t

    let alle5'' xs = [for x in xs do if x < 5 then yield x ]

    let parilliset xs = [for x in xs do if x % 2 = 0 then yield x]

    let parillisetIndeksit xs = [for (x,i) in List.zip xs [0 .. List.length xs] do if i % 2 = 0 then yield x]

    let parillisetIndeksit' xs = 
        let rec pi l i = 
            match (l, i) with
            | ([], _) -> []
            | (h :: t, i) when i % 2 = 0 -> h :: pi t (i+1)
            | (h :: t, i) -> pi t (i+1)
        pi xs 0

    let rec filter f xs = 
        match xs with
        | [] -> []
        | h :: t when f h -> h :: filter f t
        | _ :: t -> filter f t

    let filter' f xs = [for x in xs do if f x then yield x]



