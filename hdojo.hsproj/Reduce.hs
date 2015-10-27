
module Reduce where

sum' :: [Integer] -> Integer
sum' [] = 0
sum' (h : t) = h + sum' t

mult' :: [Integer] -> Integer
mult' [] = 1
mult' (h : t) = h * mult' t


cat' :: [String] -> String
cat' [] = ""
cat' (h : t) = h ++ cat' t

lens' :: [String] -> Int
lens' [] = 0
lens' (h : t) = length h + lens' t

double n = n * 2

sumDoubles :: [Integer] -> Integer
sumDoubles [] = 0
sumDoubles (h : t) = double h + sum t

reduce :: [Integer] -> (Integer -> Integer -> Integer) -> Integer
reduce [] f = error "reduce on empty list"
reduce [h] f = h
reduce (h : t) f = f h (reduce t f)

reduce' :: (Integer -> Integer -> Integer) -> [Integer] -> Integer
reduce' f (x : xs)
  | null xs    = x
  | otherwise  = f x (reduce' f xs)

reduce'' :: (a -> a -> a) -> [a] -> a
reduce'' f (x : xs)
  | null xs    = x
  | otherwise  = f x (reduce'' f xs)


reduce''' :: (a -> a -> a) -> [a] -> a
reduce''' f xs = case xs of
  [x] -> x
  (x : xs) -> f x (reduce''' f xs)

reduceSlides :: (a -> a -> a) -> a -> [a] -> a
reduceSlides f z [] = z
reduceSlides f z (h : t) = f h (reduceSlides f z t)
