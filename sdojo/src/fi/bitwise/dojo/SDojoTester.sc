package fi.bitwise.dojo

import Filter._
import Map._
import Reduce._
//import Fold._

object SDojoTester {
	
	reduce[Int](List(1,2,3), (x, y) => x * y, 1)
                                                  //> res0: Int = 6
	
	Fold.fold[Int, List[Int]](List(1,2,3), (x, y) => x :: y, Nil)
                                                  //> res1: List[Int] = List(1, 2, 3)
}