package fi.bitwise.dojo

object HigerOrder {
  
  // haskell:n syntaksi toimii tässä vaan niin paljon paremmin...
  
  def add(i: Int)(j: Int) = i + j
  
  def add1 = x => add(1)(x) // tai add(1)_
  
}