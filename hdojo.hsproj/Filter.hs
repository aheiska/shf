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
    
filter' :: (a -> Bool) -> [a] -> [a]
filter' _ [] = []
filter' f (x : xs) 
  | f x       = x : filter' f xs
  | otherwise = filter' f xs
