package scat

object MonadLaws{
  //left unit law
  //unit(x)flatMap(f) = unit(f(x)
  def leftUnit[M[_],A,B](x:A,f: A=>M[B])(implicit monad:Monad[M]):Boolean =
  {
    def unit(x:A) = monad.unit(x)
    monad.flatMap(unit(x))(f) == f(x)
    
  }
  //right unit law
  //m.flatmap(unit) == m
  def rightUnit[M[_],A](m:M[A])(implicit monad:Monad[M]):Boolean =
  {
    def unit(x:A) = monad.unit(x)
    monad.flatMap(m)(unit) == m
    
  }
}