trait TelemetryService {
  def receive(telemetry: Double): Unit
  def getAverageForLast(x: Int): Double
}

class AlertingTelemetryService(ingester: Ingester,
                               stats: Stats,
                               stabilityVerifier: StabilityVerifier,
                               alerter: Alerter) extends TelemetryService {

  override def receive(telemetry: Double): Unit = {
    ingester receive telemetry

    if (stabilityVerifier.hasInstability) alerter.sendAlert()
  }

  override def getAverageForLast(x: Int): Double = stats averageForLast x
}
