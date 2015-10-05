
modude Iban where

import Data.Char

toNum :: Char -> Int
toNum c
  | isDigit c  = ord c - ord '0'
  | isAsciiUpper c  = (ord c - ord 'A') + 10
  | otherwise = error "invalid iban"

move :: String -> String
move s = drop 4 s ++ take 4 s

strip :: String -> String
strip = filter (/= ' ')

nums :: String -> [Int]
nums s = map toNum (move (strip s))

isValid :: [Int] -> Bool
isValid ns = (sum ns `mod` 97) == 1

main :: IO ()
main = print (isValid (nums "FI42 1234 1234 1232 12"))
--main = print (isValid (nums "FI42 9234 1478 1234 92"))
