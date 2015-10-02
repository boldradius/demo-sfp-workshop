package misc

import scala.annotation.implicitNotFound

object EqualOps {

  // this is the TYPE CLASS
  @implicitNotFound("Could not find Type Class for Equal of ${A}, defining equality.")
  trait Equal[A] {
    def equal(left: A, right: A): Boolean
  }

  implicit val IntEquality = new Equal[Int] {
    override def equal(left: Int, right: Int): Boolean =
      left == right
  }

  implicit val FunkyStringEquality = new Equal[String] {
    override def equal(left: String, right: String): Boolean =
      left != right
  }

  def DefaultEquality[B] = new Equal[B] {
    override def equal(left: B, right: B): Boolean =
      left == right
  }

  implicit class Equality[A](private val left: A) extends AnyVal {
    def ===(right: A)(implicit instance: Equal[A] = DefaultEquality[A]): Boolean =
      instance.equal(left, right)
  }

}
