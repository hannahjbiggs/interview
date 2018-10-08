import org.scalatest.mockito.MockitoSugar
import org.mockito.Mockito._
import org.scalatest.{FlatSpec, Matchers}

class TelemetryIngesterTest extends FlatSpec with Matchers with MockitoSugar {

  private val repo = mock[Repo]
  private val telemetryIngester = new TelemetryIngester(repo)

  "TelemetryIngester" should "add a value to the repo" in {
    telemetryIngester receive 1.0

    verify (repo) add 1.0
  }
}
