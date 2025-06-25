package utils.scenarios

import com.intuit.karate.gatling.PreDef.karateFeature
import io.gatling.core.Predef.{Simulation, scenario}
import io.gatling.core.structure.ScenarioBuilder
import utils.paths.AgreementsPath

class AgreementsScenarios extends Simulation{
   private val agreements = scenario("Halk Katilim Agreements").exec(karateFeature(AgreementsPath.AGREEMENTS))
   val agreementsScenarios: ScenarioBuilder =agreements

}
