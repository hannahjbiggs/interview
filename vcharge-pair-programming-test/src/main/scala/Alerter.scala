trait Alerter {
  def sendAlert(): Unit
}

class ConsoleAlerter extends Alerter {
  override def sendAlert(): Unit = println("Alert")
}
