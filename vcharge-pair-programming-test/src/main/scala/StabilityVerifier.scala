trait StabilityVerifier {
  def hasInstability: Boolean
}

class RepoCheckingStabilityVerifier(repo: Repo,
                                    numberOfValuesRequiredToProveInstability: Int,
                                    stableValue: Double) extends StabilityVerifier {

  override def hasInstability: Boolean = {
    val values = repo valuesForLast numberOfValuesRequiredToProveInstability

    values.size == numberOfValuesRequiredToProveInstability &&
      (values.forall(_ > stableValue) || values.forall(_ < stableValue))
  }
}
