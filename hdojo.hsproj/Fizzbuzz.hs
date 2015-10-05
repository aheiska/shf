
module FizzBuzz where

  fizzes   = cycle ["", "", "fizz"]
  buzzes   = cycle ["", "", "", "", "buzz"]
  pattern  = zipWith (++) fizzes buzzes
  fizzbuzz = zipWith combine pattern [1..] where
    combine word number = if null word
                          then show number
                          else word


  main :: IO ()
  main = putStrLn "Hello World"
