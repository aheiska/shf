
module Viite where

digits :: Integer -> [Integer]
digits n
  | n <= 9 = [n]
  | otherwise = (n `mod` 10) : digits (n `div` 10)

mul :: [Integer] -> [Integer]
mul ns = zipWith (*) ns multipliers where
  multipliers = cycle [7, 3, 1]

nextTen :: Integer -> Integer
nextTen n = ((n + 10) `div` 10) * 10

cc :: Integer -> Integer
cc n = (nextTen x - x) `mod` 10 where
  x = (sum . mul . digits) n

main :: IO ()
main = print (cc 2345987)
