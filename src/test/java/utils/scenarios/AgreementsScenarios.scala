package utils.scenarios

import com.intuit.karate.gatling.PreDef.karateFeature
import io.gatling.core.Predef.scenario
import io.gatling.core.structure.ScenarioBuilder
import utils.paths.AgreementsPath

class AgreementsScenarios{
   private val agreements = scenario("Halk Katilim Agreements").exec(karateFeature(AgreementsPath.AGREEMENTS))
   val agreementsScenarios: ScenarioBuilder =agreements

}
