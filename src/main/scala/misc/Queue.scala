package misc


object Queue {
  def apply[A](elements: A*): Queue[A] =
    new Queue(elements.toSeq)
}

class Queue[+A] private (private val elements: Seq[A]) {

  def dequeue(): (A, Queue[A]) =
    elements.head -> new Queue(elements.tail)

  def enqueue[B >: A](item: B): Queue[B] =
    Queue(elements :+ item: _*)

  override def equals(that: scala.Any): Boolean = that match {
    case q: Queue[A] => this.elements == q.elements
    case _ => false
  }

  override def hashCode(): Int = elements.hashCode()

  override def toString: String = elements.mkString("Queue(", ",", ")")
    //s"Queue(${elements.mkString(",")})"
}
