package scat

object FunctorInstances {
    
  implicit val listFunctor:Functor[List] = new Functor[List]{
    override def mapf[A,B](f:A => B):List[A] => List[B]={
      list => list map(f)
    }
  }
  implicit val optionFunctor:Functor[Option] = new Functor[Option]{
    override def mapf[A,B](f:A => B):Option[A] => Option[B]={
      opt => opt map(f)
    }
  }

}