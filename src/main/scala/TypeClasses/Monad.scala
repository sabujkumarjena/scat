package scat

trait Monad[M[_]]{//Type class   ;  M[_] is a type constructor                                                   
  def unit[A](x:A):M[A]
  def flatMap[A,B](monadA: M[A])(f: A => M[B]):M[B]
}

object Monad{
  def apply[M[_]](implicit monad:Monad[M]) = 
    monad 
}