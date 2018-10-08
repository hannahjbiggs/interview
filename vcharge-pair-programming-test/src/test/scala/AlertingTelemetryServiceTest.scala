import org.mockito.Mockito.{verify, when}
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FlatSpec, Matchers}

class AlertingTelemetryServiceTest extends FlatSpec with Matchers with MockitoSugar {

  private val ingester = mock[Ingester]
  private val stats = mock[Stats]
  private val stabilityVerifier = mock[StabilityVerifier]
  private val dispatcher = mock[Dispatcher]
  private val alertingTelemetryService = new AlertingTelemetryService(ingester, stats, stabilityVerifier, dispatcher)

  "AlerterTelemetryService" should "receive telemetry and pass it to the ingester" in {
    alertingTelemetryService receive 1.0

    verify (ingester) receive 1.0
  }

  "AlerterTelemetryService" should "tell the dispatcher to send an alert if the stabilityVerifier says that there is instability" in {
    when (stabilityVerifier.hasInstability) thenReturn true

    alertingTelemetryService receive 1.0

    verify (dispatcher) sendAlert()
  }
}