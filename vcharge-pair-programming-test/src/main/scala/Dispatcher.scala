trait Dispatcher {
  def sendAlert(): Unit
}

class ConsoleDispatcher extends Dispatcher {
  override def sendAlert(): Unit = println("Alert")
}