
package scat
import FunctorLaws._
import org.scalacheck.Prop.forAll
import org.scalacheck.Properties
import org.scalacheck.Arbitrary
import org.scalacheck.Gen
//import scala.reflect._

import FunctorInstances._
object optionFuntorSpec extends FunctorSpec[List, Int, Boolean, String, Int]
abstract class FunctorSpec[F[_], A, B, C, D](implicit functor: Functor[F], arbF: Arbitrary[F[A]], arbf: Arbitrary[A => B], arbg: Arbitrary[B => C], arbh: Arbitrary[C => D]) extends Properties("Functor") {

  property("identity") = forAll { ftr: F[A] =>
    identity(ftr)

  }
  property("composition") = forAll { (ftr: F[A], f: A => B, g: B => C) =>
    composition(ftr, f, g)
  }
  property("associativity") = forAll { (ftr: F[A], f: A => B, g: B => C, h: C => D) =>
    associative(ftr, f, g, h)
  }

}
