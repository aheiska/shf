package fi.bitwise.dojo

import Filter._
import Map._
import Reduce._
//import Fold._

object SDojoTester {
	
	map[Int, Int](List(1,2,3))(_ + 1)         //> res0: List[Int] = List(2, 3, 4)
	
	map(List(1,2,3))((i: Int) => i + 1)       //> res1: List[Int] = List(2, 3, 4)
	map(List(1,2,3))(i => i + 1)              //> res2: List[Int] = List(2, 3, 4)
		
	Fold.fold[Int, List[Int]](List(1,2,3), (x, y) => x :: y, Nil)
                                                  //> res3: List[Int] = List(1, 2, 3)
	
	// Type-inferenfe ei selviä tästä
	//Fold.fold(List(1,2,3), (x, y) => x :: y, List[Int]())
	
	// eikä tästä: Nil: List[Nothing]
	//Fold.foldRight(List(1,2,3), Nil)((x, y) => x :: y)
	
	// mutta selvää tästä, kiitos erillisen parametrilistan
	Fold.foldRight(List(1,2,3), List[Int]())((x, y) => x :: y)
                                                  //> res4: List[Int] = List(1, 2, 3)
  
  val l = List[Int](4)                            //> l  : List[Int] = List(4)
  l.reduce((a, b) => a + b)                       //> res5: Int = 4
  
  //reduce_std(List[Int]())((x,y) => x+y)
  
  
}