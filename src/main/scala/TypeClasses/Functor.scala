package scat
/**
 * Functor
 * 
 * A functor F[_] map one category A to another category F[A] 
 * and maps arrows A -> B to  F[A] -> F[B]
 */
trait Functor[F[_]] {
  def mapf[A,B](f: A => B): F[A]=>F[B] //map arrows
  def map[A,B](functorA: F[A])(f: A => B):F[B] = mapf(f)(functorA)
}

object Functor{
  def apply[F[_]](implicit functor: Functor[F]) =
    functor
}