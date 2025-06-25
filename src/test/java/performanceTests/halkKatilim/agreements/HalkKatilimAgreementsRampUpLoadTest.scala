package performanceTests.halkKatilim.agreements

import com.intuit.karate.gatling.KarateProtocol
import com.intuit.karate.gatling.PreDef.karateProtocol
import io.gatling.core.Predef.{Simulation, constantUsersPerSec, openInjectionProfileFactory, rampUsersPerSec}
import utils.ConfigurationReader
import utils.scenarios.AgreementsScenarios

import scala.concurrent.duration._


class HalkKatilimAgreementsRampUpLoadTest extends Simulation{
  val constantUsers: Int = Integer.parseInt(ConfigurationReader.getProperty("constantUsers"))
  val loadTestDuration: FiniteDuration = Integer.parseInt(ConfigurationReader.getProperty("loadTestDuration")).seconds
  val rampUpDuration: FiniteDuration = Integer.parseInt(ConfigurationReader.getProperty("rampUpDuration")).seconds
  val protocol: KarateProtocol = {
    karateProtocol()
  }
  val scenarios = new AgreementsScenarios
  setUp(
    scenarios.agreementsScenarios.inject(
      rampUsersPerSec(1) to constantUsers during (rampUpDuration),   // Ramp-up from 1 to constantUsers users over rampUpDuration
      constantUsersPerSec(constantUsers) during ( loadTestDuration),   // Keep constantUsers users constant for loadTestDuration
      rampUsersPerSec(constantUsers) to 1 during (rampUpDuration)    // Ramp-down from rampUpMaxUsers to 1 user over rampUpDurationl
    )
      .protocols(protocol))
}
