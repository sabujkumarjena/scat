
package scat

import org.scalacheck.Prop.forAll
import MonoidLaws._
import org.scalacheck.Properties
import org.scalacheck.Arbitrary
import scala.reflect._

/*Specs for Monoid */
/*

*/

import MonoidInstances._
object IntMonoidSpec extends MonoidSpec[Int]
object StringMonoidSpec extends MonoidSpec[String]

abstract class MonoidSpec[A](implicit monoid: Monoid[A],arbA: Arbitrary[A])
  extends Properties(s"Monoid") { 
  
 
  // n o id == id o n == n
  property("identity") = forAll { n: A =>
    identiyLaw(n)
   }
  // forall x, y => x o y
  property("composition") = forAll { (x: A, y: A) =>
    compositionLaw(x, y)
  }
  property("associativity") = forAll { (x: A, y: A,z: A) =>
    associativeLaw(x, y, z)
  }
}
