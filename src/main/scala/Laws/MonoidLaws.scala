package scat

object MonoidLaws {
  //identity law
  def identiyLaw[A](x:A)(implicit m:Monoid[A]):Boolean ={
    m.compose(x, m.identity) == m.compose(m.identity, x)
  }
  //composition law
  def compositionLaw[A](x:A,y:A)(implicit m:Monoid[A]):Boolean ={
    m.compose(x, y).isInstanceOf[A]
  }
  //associative law
  def associativeLaw[A](x: A, y:A, z:A)(implicit m: Monoid[A]): Boolean = {
    m.compose(x, m.compose(y, z)) == m.compose(m.compose(x, y),z)
  }
}