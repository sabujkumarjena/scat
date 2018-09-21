package scat

import org.scalacheck.Prop.forAll
import org.scalacheck.Properties
import org.scalacheck.Arbitrary
import org.scalacheck.Gen
//import scala.reflect._
import MonadInstances._
object listMonoidSpec extends MonadSpec[List,Int,String,Int]
abstract class MonadSpec[M[_],A,B,C](implicit monad:Monad[M], 
    arbA: Arbitrary[A],
    arbf:Arbitrary[A=>M[B]],
    arbg:Arbitrary[B=>M[C]],
    arbmA:Arbitrary[M[A]],
    arbmB:Arbitrary[M[B]],
    arbmC:Arbitrary[M[C]]) extends Properties("Monad"){
  
  property("left unit")= forAll{ (x:A,f: A=>M[B]) =>
    monad.flatMap(monad.unit(x))(f) == f(x)
    
  }
  property("right unit")= forAll{ m:M[A] =>
    monad.flatMap(m)(monad.unit) == m
    
  }
  
  property("associativityOfflatMap") =forAll {(m:M[A],f: A=>M[B],g: B=>M[C]) =>
    
   
   monad.flatMap(monad.flatMap(m)(f))(g) == monad.flatMap(m)((x:A) => monad.flatMap(f(x))(g))
  }
  
}