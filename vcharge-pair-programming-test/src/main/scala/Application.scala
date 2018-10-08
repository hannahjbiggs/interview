object Application {

  private val numberOfValuesRequiredToProveInstability = 2
  private val stableValue = 50.0

  private val repo = new InMemoryRepo
  private val stabilityVerifier = new RepoCheckingStabilityVerifier(repo, numberOfValuesRequiredToProveInstability, stableValue)
  private val dispatcher = new ConsoleDispatcher
  private val ingester = new TelemetryIngester(repo)
  private val stats = new TelemetryStats(repo)
  private val telemetryService = new AlertingTelemetryService(ingester, stats, stabilityVerifier, dispatcher)

  def main(args: Array[String]): Unit = {

    def send(value: Double): Unit = {
      println(s"Sending $value")
      telemetryService receive value
    }

    send(50.0)
    send(51.0)
    send(52.0)
    send(49.0)
    send(49.0)

    println(s"Average for last 4 = ${telemetryService getAverageForLast 4}")
  }
}
