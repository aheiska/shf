module Fold where


fold :: [a] -> (a -> b -> b) -> b -> b
fold [] _ z       = z
fold (x : xs) f z = f x (fold xs f z)

-- std allekirjoitus
foldr' :: (a -> b -> b) -> b -> [a] -> b
foldr' _ z []       = z
foldr' f z (x : xs) = f x (fold xs f z)

-- häntärekursiosta lienee turha puhua
foldl' :: (a -> b -> a) -> a -> [b] -> a
foldl' _ z []       = z
foldl' f z (x : xs) = foldl' f (f z x) xs

mapf :: (a -> b) -> [a] -> [b]
mapf f xs = foldr' (\x acc -> f x : acc) ([] :: [b]) xs

reducef :: (a -> a -> a) -> [a] -> a
reducef f (x : xs) = foldr' f x xs

filterf :: (a -> Bool) -> [a] -> [a]
filterf f xs = foldr' lf ([] :: [a]) xs where
--  lf = \x acc -> if f x then x : acc else acc
  lf x acc
    | f x       = x : acc
    | otherwise = acc

-- mitä näistä huomataan?
-- fold[rl] on rekursion yleistys!
