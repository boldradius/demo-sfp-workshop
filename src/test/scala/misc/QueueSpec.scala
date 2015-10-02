package misc

import org.scalatest.{FreeSpec, MustMatchers}

class QueueSpec extends FreeSpec with MustMatchers {

  "Using the basics of a Queue" - {
    "toString works as expected" in {
      val q = Queue(Vector(1, 2, 3, 4, 5))
      q.toString mustEqual "Queue(1,2,3,4,5)"
    }
    "hashCode delegates to elements" in {
      val numbers = 1 to 100
      val q = Queue(numbers)
      q.hashCode mustEqual numbers.hashCode
    }
    "comparing two queues" - {
      "should succeed with same queue" in {
        val nums1 = 1 to 100
        val nums2 = 1 to 100
        Queue(nums1) mustEqual Queue(nums2)
      }
      "should fail with different queue" in {
        val nums1 = 1 to 100
        val nums2 = 1 to 200
        Queue(nums1) mustNot equal(Queue(nums2))
      }
      "should fail with different types" in {
        val nums = 1 to 100
        val words = Seq("Brendan", "McAdams", "Andrew", "Mohrland")
        Queue(nums) mustNot equal(Queue(words))
      }
    }
  }

}
