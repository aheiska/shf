module Fold where


fold :: [a] -> (a -> b -> b) -> b -> b
fold [] _ z       = z
fold (x : xs) f z = f x (fold xs f z)

-- Tässä on virhe! b -> a -> b aiheuttaa parametreista b:n evaluoinnin ennen a:ta
-- jolloin rekursio lähtee purkautumaan vasemmalle -> fold2 (++) ["1", "2", "3"] == "321"
fold2 :: (b -> a -> b) -> [a] -> b -> b
fold2 _ [] z       = z
fold2 f (x : xs) z = f (fold2 f xs z) x

fold3 :: (a -> b -> b) -> [a] -> b -> b
fold3 f []       z = z
fold3 f (x : xs) z = f x (fold3 f xs z)


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
