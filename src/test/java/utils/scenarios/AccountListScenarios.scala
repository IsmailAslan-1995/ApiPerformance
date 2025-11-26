package utils.scenarios

import com.intuit.karate.gatling.PreDef.karateFeature
import io.gatling.core.Predef.scenario
import io.gatling.core.structure.ScenarioBuilder
import utils.paths.AccountListPath

class AccountListScenarios {
  private val accountList = scenario("Halk Katilim Account List").exec(karateFeature(AccountListPath.ACCOUNT_LIST))
  val accountListScenarios: ScenarioBuilder = accountList

}
