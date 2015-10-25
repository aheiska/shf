namespace Assignments

module Reduce =

    let rec sum xs =
        match xs with
        | []    -> 0
        | y::ys -> y + sum ys

    let rec mult xs =
        match xs with
        | [] -> 1
        | y :: ys -> y * mult ys

    let rec lens xs =
        match xs with
        | [] -> 0
        | s :: ss -> String.length(s) + lens ss

    let double x = x+x

    let rec sumDoubles xs =
        match xs with
        | [] -> 0
        | y :: ys -> double y + sumDoubles ys

    let rec reduce f xs =
        match xs with
        | [] -> invalidArg "reduce for empty list"
        | y :: [] -> y
        | y :: ys -> f y (reduce f ys)

