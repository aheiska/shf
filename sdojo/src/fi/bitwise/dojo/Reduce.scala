package fi.bitwise.dojo

object Reduce {
  //
  // reduce
  //
  // esimerkki
  def sum(l: List[Int]) : Int = l match {
    case Nil => 0
    case h :: t => h + sum(t)
  }
  
  // tehtävä 1
  def product(l: List[Int]) : Int = l match {
    case Nil => 1
    case h :: t => h * product(t)
  }
  
  // tehtävä 2
  def cat(l: List[String]) : String = l match {
    case Nil => ""
    case h :: t => h ++ cat(t)
  }
  
  def double(i: Int) = i + i
  def triple(i: Int) = 3 * i

  // kalvoilla T1 ja T2 jälkeen 
  // => Aika persiistä, että pitää kirjoittaa oma funktio jokaiselle toimenpiteelle
  def sumDoubles(l: List[Int]) : Int = l match {
    case Nil => 0
    case h :: t => double(h) + sumDoubles(t)
  }
  
  // kalvoilla, mikä vikana
  def reduce1(l: List[Int], f: (Int, Int) => Int) : Int = l match {
    case Nil => 0 // Bugi!
    case h :: t => f(h, reduce1(t, f))
  }
  
  // tehtävä 3
  def reduceInt(l: List[Int], f: (Int, Int) => Int, z: Int) : Int = l match {
    case Nil => z
    case h :: t => f(h, reduce(t, f, z))
  }
  
  // kalvoilla
  def reduce[T](l: List[T], f: (T, T) => T, z: T) : T = l match {
    case Nil => z
    case h :: t => f(h, reduce(t, f, z))
  }
    
}