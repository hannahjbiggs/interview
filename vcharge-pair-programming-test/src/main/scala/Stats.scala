trait Stats {
  def averageForLast(x: Int): Double
}

class TelemetryStats(repo: Repo) extends Stats {

  def averageForLast(x: Int): Double = {
    val lastValues = repo valuesForLast x

    if (lastValues.isEmpty) 0 else lastValues.sum / lastValues.size
  }
}
