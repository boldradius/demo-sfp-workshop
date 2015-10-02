package misc

import org.scalatest.{FreeSpec, MustMatchers, NonImplicitAssertions, FlatSpec}

class EqualOpsSpec extends FreeSpec with MustMatchers with NonImplicitAssertions {

  import misc.EqualOps._

  /*
  "Testing the simple === operator" - {
    "Should test true for two values of the same type and value" in {
      1 === 1 mustBe true
    }
    "Should test false for two values of the same type and diff. value" in {
      "a" === "b" mustBe false
    }
    "Should fail to compile comparing two incompatible types" in {
      """
      |1 === "1"
      """.stripMargin mustNot compile
    }
  }
  */

}
