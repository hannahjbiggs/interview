import org.scalatest.{FlatSpec, Matchers}

class InMemoryRepoTest extends FlatSpec with Matchers {

  "The repo" should "add and retrieve a value" in {
    val repo = new InMemoryRepo
    repo add 1.0
    repo valuesForLast 1 shouldBe Seq(1.0)
  }

  "The repo" should "return an empty sequence if the repo is empty" in {
    val repo = new InMemoryRepo
    repo valuesForLast 1 shouldBe Seq()
  }

  "The repo" should "return an empty sequence if the last 0 values are requested" in {
    val repo = new InMemoryRepo
    repo add 1.0
    repo valuesForLast 0 shouldBe Seq()
  }

  "The repo" should "return the last x values" in {
    val repo = new InMemoryRepo
    repo add 1.0
    repo add 2.0
    repo add 3.0
    repo valuesForLast 2 shouldBe Seq(3.0, 2.0)
  }

  "The repo" should "return all of the values if requested more than the total number of values" in {
    val repo = new InMemoryRepo
    repo add 1.0
    repo valuesForLast 2 shouldBe Seq(1.0)
  }
}
