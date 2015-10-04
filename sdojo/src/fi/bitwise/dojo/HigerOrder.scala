package fi.bitwise.dojo

object HigerOrder {
  
  // haskell:n syntaksi toimii tässä vaan niin paljon paremmin...
  // Tästä ei tehtävää? Vain demona, että ho-funktio voi myös palauttaa funktion
  
  def add(i: Int)(j: Int) = i + j
  
  def add1 = x => add(1)(x) // tai add(1)_
  def createAdder(v: Int) = x => add(v)(x)
  val add2 = x => add(2)(x)
  
}