package performanceTests.halkKatilim.accountList

import com.intuit.karate.gatling.KarateProtocol
import com.intuit.karate.gatling.PreDef.karateProtocol
import io.gatling.core.Predef.{Simulation, constantUsersPerSec, openInjectionProfileFactory, rampUsersPerSec}
import utils.ConfigurationReader
import utils.scenarios.AccountListScenarios

import scala.concurrent.duration._

class AccountListRampupLoadTest extends Simulation {
  val constantUsers: Int = Integer.parseInt(ConfigurationReader.getProperty("constantUsers"))
  val loadTestDuration: FiniteDuration = Integer.parseInt(ConfigurationReader.getProperty("loadTestDuration")).seconds
  val rampUpDuration: FiniteDuration = Integer.parseInt(ConfigurationReader.getProperty("rampUpDuration")).seconds
  val protocol: KarateProtocol = {
    karateProtocol()
  }
  val scenarios = new AccountListScenarios
  setUp(
    scenarios.accountListScenarios.inject(
        rampUsersPerSec(1) to constantUsers during rampUpDuration,
        constantUsersPerSec(constantUsers) during loadTestDuration,
        rampUsersPerSec(constantUsers) to 1 during rampUpDuration
      )
      .protocols(protocol))
}

