package fi.bitwise.dojo

object Fold {
  //
  // fold
  //

  // Kun katsotaan reducen, mapin ja filterin toteutusta ne ovat aika samanlaiset:
  def reduce[T](l: List[T], f: (T, T) => T, z: T) : T = l match {
    case Nil => z
    case h :: t => f(h, reduce(t, f, z))
  }

  def map[T,V](l: List[T], f: T => V) : List[V] = l match {
    case Nil => Nil
    case h :: t => f(h) :: map(t, f)
  }

  def filter[T](l: List[T], f: T => Boolean) : List[T] = l match {
    case Nil => Nil
    case h :: t if f(h) => h :: filter(t, f)
    case _ :: t => filter(t, f)
  }

  // voiko näitä vielä yleistää?
  // etsitään yhteiset osat

  def fold0[T, V](l: List[T], f: (T, V) => V, z: V) : V = l match {
    case Nil => z
    case h :: t => fold(t, f, z) // typechecks, does not work
  }

  def fold[T, V](l: List[T], f: (T, V) => V, z: V) : V = l match {
    case Nil => z
    case h :: t => f(h, fold(t, f, z))
  }

  //^^^ tuo on oikeasti foldRight

  def foldRight[T, V](l: List[T], z: V)(f: (T, V) => V) : V = l match {
    case Nil => z
    case h :: t => f(h, fold(t, f, z))
  }

  @annotation.tailrec
  def foldLeft[T, V](l: List[T], z: V)(f: (T, V) => V) : V = l match {
    case Nil => z
    case h :: t => foldLeft(t, f(h, z))(f)
  }


  // harjoitus, kirjoita reduce, map, filter ja length käyttämällä fold:ia

  def reducef[T](l: List[T])(f: (T, T) => T) = foldRight(l.tail, l.head)(f)

	// ärsyttävyys, pitää List[V]() Nil:n sijaan
  def mapf[T, V](l: List[T])(f: T => V) = foldRight(l, List[V]()) { (v, l) => f(v) :: l }

  def filterf[T](l: List[T])(f: T => Boolean) = foldRight(l, List[T]()) { (v, l) =>
    if (f(v)) v :: l else l
  }

  def length[T](l: List[T]) = foldRight(l, 0) { (_, i) => i+1 }

}
