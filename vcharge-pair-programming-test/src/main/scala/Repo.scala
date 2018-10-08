trait Repo {
  def add(value: Double)
  def valuesForLast(x: Int): Seq[Double]
}

class InMemoryRepo extends Repo {
  private var state = Seq[Double]()

  override def add(value: Double): Unit = state = value +: state

  override def valuesForLast(x: Int): Seq[Double] = state dropRight (state.size - x)
}