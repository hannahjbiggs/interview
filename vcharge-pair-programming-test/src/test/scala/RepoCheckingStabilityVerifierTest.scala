import org.scalatest.mockito.MockitoSugar
import org.mockito.Mockito._
import org.scalatest.{FlatSpec, Matchers}

class RepoCheckingStabilityVerifierTest extends FlatSpec with Matchers with MockitoSugar {

  private val repo = mock[Repo]
  private val numberOfValuesRequiredToProveInstability = 2
  private val stabilityVerifier = new RepoCheckingStabilityVerifier(repo, numberOfValuesRequiredToProveInstability, 50.0)

  "HasInstability" should "return false if the repo does not have a current value" in {
    when (repo valuesForLast numberOfValuesRequiredToProveInstability) thenReturn Seq()

    stabilityVerifier.hasInstability shouldBe false
  }

  "HasInstability" should "return false if the repo does not have a previous value" in {
    when (repo valuesForLast numberOfValuesRequiredToProveInstability) thenReturn Seq(1.0)

    stabilityVerifier.hasInstability shouldBe false
  }

  "HasInstability" should "return false if the repo current and previous values are not both above or below 50" in {
    when (repo valuesForLast numberOfValuesRequiredToProveInstability) thenReturn Seq(51.0, 49.0)

    stabilityVerifier.hasInstability shouldBe false
  }

  "HasInstability" should "return true if the repo current and previous values are both above 50" in {
    when (repo valuesForLast numberOfValuesRequiredToProveInstability) thenReturn Seq(51.0, 52.0)

    stabilityVerifier.hasInstability shouldBe true
  }

  "HasInstability" should "return true if the repo current and previous values are both below 50" in {
    when (repo valuesForLast numberOfValuesRequiredToProveInstability) thenReturn Seq(49.0, 48.0)

    stabilityVerifier.hasInstability shouldBe true
  }
}
