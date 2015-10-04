module Map where
  
add1 :: [Integer] -> [Integer]
add1 [] = []
add1 (x : xs) = x+1 : add1 xs

double :: [Integer] -> [Integer]
double [] = []
double (x : xs) = x+x : double xs

lens :: [String] -> [Int]
lens [] = []
lens (x : xs) = length x : lens xs

map' :: (a -> b) -> [a] -> [b]
map' _ [] = []
map' f (x : xs) = f x : map f xs 

