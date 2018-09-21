
package scat

/** Monoid
 * 
 */
trait Monoid[A]{
  def identity: A
  def compose(x : A, y: A): A
}
object Monoid {
  def apply[A](implicit monoid: Monoid[A]) =
    monoid
}

