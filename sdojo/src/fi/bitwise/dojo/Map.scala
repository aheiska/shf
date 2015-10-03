package fi.bitwise.dojo

object Map {
  //
  // map
  //
  // kalvoilla
  def add1(l: List[Int]) : List[Int] = l match {
    case Nil => Nil
    case h :: t => h + 1 :: add1(t)
  }
  
  // tehtävä
  def double(l: List[Int]) : List[Int] = l match {
    case Nil => Nil
    case h :: t => h+h :: double(t)
  }
  
  // tehtävä 
  def lens(l: List[String]) : List[Int] = l match {
    case Nil => Nil
    case h :: t => h.size :: lens(t)
  }
  
  // Nämäkin ovat aika samanlaisia...
  // Tosin Lista voi olla List[String] sisään tullessa ja List[Int] ulos
  // yritetään DRY:ta

  def map1(l: List[Int], f: Int => Int) : List[Int] = l match {
    case Nil => Nil
    case h :: t => f(h) :: map(t, f)
  }
  
  def map[T,V](l: List[T], f: T => V) : List[V] = l match {
    case Nil => Nil
    case h :: t => f(h) :: map(t, f)
  }
  

}