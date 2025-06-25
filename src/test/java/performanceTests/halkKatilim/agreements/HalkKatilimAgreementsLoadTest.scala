package performanceTests.halkKatilim.agreements

import com.intuit.karate.gatling.KarateProtocol
import com.intuit.karate.gatling.PreDef.karateProtocol
import io.gatling.core.Predef.{Simulation, constantUsersPerSec, openInjectionProfileFactory}
import utils.ConfigurationReader
import utils.scenarios.AgreementsScenarios

import scala.concurrent.duration._

class HalkKatilimAgreementsLoadTest extends Simulation{
  val constantUsersCount: Int = Integer.parseInt(ConfigurationReader.getProperty("constantUsers"))
  val testDuration: FiniteDuration = Integer.parseInt(ConfigurationReader.getProperty("loadTestDuration")).seconds

  val protocol: KarateProtocol = {
    karateProtocol()
  }
  val scenarios = new AgreementsScenarios

  setUp(
    scenarios.agreementsScenarios.inject(constantUsersPerSec(constantUsersCount) during (testDuration))
  )
    .protocols(protocol)
}
