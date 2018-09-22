package scat
object MonadInstances{// type class instances
  implicit val listMonad = new Monad[List]{
    override def unit[A](x:A):List[A] = List(x)
    override def flatMap[A,B](monadA:List[A])(f: A => List[B]):List[B] = monadA.flatMap(f) 
  }
  implicit val optionMonad = new Monad[Option]{
    override def unit[A](x:A):Option[A] = Some(x)
    override def flatMap[A,B](monadA:Option[A])(f: A => Option[B]):Option[B] = monadA.flatMap(f) 
  }
  
}