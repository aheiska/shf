

add1 :: [Integer] -> [Integer]
add1 [] = []
add1 (h : t) = (h + 1) : (add1 t)

