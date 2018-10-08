import org.scalatest.mockito.MockitoSugar
import org.mockito.Mockito._
import org.scalatest.{FlatSpec, Matchers}

class TelemetryStatsTest extends FlatSpec with Matchers with MockitoSugar {

  private val repo = mock[Repo]
  private val telemetryStats = new TelemetryStats(repo)

  "AverageForLast" should "return 0 if the repo has no values" in {
    when (repo valuesForLast 1) thenReturn Seq()

    telemetryStats averageForLast 1 shouldBe 0
  }

  "AverageForLast" should "return the average of a sequence of values from the repo" in {
    when (repo valuesForLast 4) thenReturn Seq(2.0, 4.0, 6.0, 8.0)

    telemetryStats averageForLast 4 shouldBe 5.0
  }
}
