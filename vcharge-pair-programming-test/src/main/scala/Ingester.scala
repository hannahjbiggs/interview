trait Ingester {
  def receive(value: Double): Unit
}

class TelemetryIngester(repo: Repo) extends Ingester {

  override def receive(value: Double): Unit = repo add value
}
