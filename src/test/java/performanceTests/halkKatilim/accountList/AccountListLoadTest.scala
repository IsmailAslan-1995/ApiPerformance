package performanceTests.halkKatilim.accountList

import com.intuit.karate.gatling.KarateProtocol
import com.intuit.karate.gatling.PreDef.karateProtocol
import io.gatling.core.Predef.{Simulation, constantUsersPerSec, openInjectionProfileFactory}
import utils.ConfigurationReader
import utils.scenarios.AccountListScenarios

import scala.concurrent.duration._

class AccountListLoadTest extends Simulation {
  val constantUsersCount: Int = Integer.parseInt(ConfigurationReader.getProperty("constantUsers"))
  val testDuration: FiniteDuration = Integer.parseInt(ConfigurationReader.getProperty("loadTestDuration")).seconds

  val protocol: KarateProtocol = {
    karateProtocol()
  }
  val scenarios = new AccountListScenarios

  setUp(
    scenarios.accountListScenarios.inject(constantUsersPerSec(constantUsersCount) during (testDuration))
  )
    .protocols(protocol)

}
