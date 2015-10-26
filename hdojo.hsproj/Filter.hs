module Filter where

alle5 :: [Int] -> [Int]
alle5 [] = []
alle5 (x : xs) = if x < 5 then x : alle5 xs else alle5 xs

alle5' :: [Int] -> [Int]
alle5' [] = []
alle5' (x : xs)
  | x < 5     = x : alle5' xs
  | otherwise = alle5' xs

alle5'' :: [Int] -> [Int]
alle5'' xs = [ x | x <- xs, x < 5]

parilliset :: [Int] -> [Int]
parilliset xs = [ x | x <- xs, even x]

foo :: [(Int, String)] -> Int -> [(Int, String)]
foo [] _           = []
foo ((a, b) : t) v = if a == v then (a, b) : foo t v else foo t v

evenIndex :: [a] -> [a]
evenIndex as = map fst l where
  l = filter (even . snd) (zip as [0..])

evenIndex' :: [a] -> [a]
evenIndex' xx = ei xx 0 where
  ei :: [a] -> Int -> [a]
  ei [] _ = []
  ei (x : xs) i
    | even i    = x : ei xs (i+1)
    | otherwise = ei xs (i+1)

evenIndex'' :: [a] -> [a]
evenIndex'' xs = [x | (x, i) <- zip xs [0..], i `mod` 2 == 0]

filter0 :: (a -> Bool) -> [a] -> [a]
filter0 _ [] = []
filter0 f (x : xs) = if f x then x : filter0 f xs else filter0 f xs

filter' :: (a -> Bool) -> [a] -> [a]
filter' _ [] = []
filter' f (x : xs)
  | f x       = x : filter' f xs
  | otherwise = filter' f xs

filter'' :: (a -> Bool) -> [a] -> [a]
filter'' f xs = [x | x <- xs, f x]
