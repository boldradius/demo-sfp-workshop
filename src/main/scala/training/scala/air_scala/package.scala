package training.scala

import scala.util.Try

package object air_scala {

  object ValidInt {
    def unapply(str: String): Boolean =
      Try(str.toInt).isSuccess
  }


  def isIncreasing[A <: Ordered[A]](items: Seq[A]): Boolean = {
    items.sliding(2).forall {
      case Seq(f1, f2) => f1 < f2
      //case f1 +: f2 +: _ => f1 < f2
      case _ => true
    }
  }

}
