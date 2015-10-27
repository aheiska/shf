package fi.bitwise.dojo

object Filter {
  //
  // filter
  //
  def alle5(l: List[Int]): List[Int] = l match {
    case Nil => Nil
    case h :: t => if (h < 5) h :: alle5(t) else alle5(t)
  }

  def alle5_2(l: List[Int]): List[Int] = l match {
    case Nil => Nil
    case h :: t if h < 5 => h :: alle5_2(t)
    case _ :: t => alle5_2(t)
  }

  def parilliset(l: List[Int]) : List[Int] = l match {
    case Nil => Nil
    case h :: t if h % 2 == 0 => h :: parilliset(t)
    case _ :: t => parilliset(t)
  }

  def posFst(l: List[(Int, String)]) : List[(Int, String)] = l match {
    case Nil                   => Nil
    case (i, s) :: t  if i > 0 => (i, s) :: posFst(t)
    case h :: t                => posFst(t)
  }

  def parillisetIndeksit(l: List[Int]) : List[Int] = {
    def pi(l: List[Int], i: Int) : List[Int] = (l, i) match {
      case (Nil, _) => Nil
      case (h :: t, i) if i % 2 == 0 => h :: pi(t, i+1)
      case (h :: t, i) => pi(t, i+1)
    }
    pi(l, 0)
  }

  def parillisetIndeksit_2(l: List[Int]) : List[Int] = {
    def pi2(ip : List[(Int, Int)]) : List[Int] = ip match {
      case Nil => Nil
      case (v, i) :: t if i % 2 == 0 => v :: pi2(t)
      case _ :: t => pi2(t)
    }
    pi2(l.zipWithIndex)
  }

  def filter[T](l: List[T], f: T => Boolean) : List[T] = l match {
    case Nil => Nil
    case h :: t if f(h) => h :: filter(t, f)
    case _ :: t => filter(t, f)
  }

  def filter[T](l: List[T], f: T => Boolean) : List[T] = l match {
    case Nil    => Nil
    case h :: t =>  if (f(h)) h :: filter(t, f) else filter(t, f)
  }

  // ok, indeksi on FP:ssä aika usein epämielenkiintoinen, mutta miten toteuttaisit:
  // def filterIndex[T](???) : ???
  def filterIndex[T](l: List[T])(p: Int => Boolean) : List[T] = {
    def filter(ip : List[(T, Int)]) : List[T] = ip match {
      case Nil => Nil
      case (v, i) :: t if p(i) => v :: filter(t)
      case _ :: t => filter(t)
    }
    filter(l.zipWithIndex)
  }

}
