package scat
object FunctorLaws{
  //identity law
  //map(id)  == id
  def identity[F[_],A](ftr:F[A])(implicit functor: Functor[F]): Boolean = {
    val id: A => A = {(x:A)=>x}
    functor.map(ftr)(id)== ftr
    
  }
  //composition law
  // map(f andthen g) == (map f) andThen (map g)
  def composition[F[_],A,B,C](fA:F[A],f: A => B,g: B => C)(implicit functor: Functor[F]):Boolean = {
    functor.map(fA)(f andThen g) == functor.map(functor.map(fA)(f))(g)
    
  }
  //associative law
  // map(fg)map(h) == map(f)map(gh)
  def associative[F[_],A,B,C,D](fA:F[A],f: A => B,g: B => C, h:C => D)(implicit functor: Functor[F]):Boolean = {
    val fg = f andThen g
    val gh = g andThen h
    functor.map(functor.map(fA)(fg))(h)  == functor.map((functor.map(fA)(f)))(gh) 
    
  }
  
}