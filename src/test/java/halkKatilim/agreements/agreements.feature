@smoke @agreements
Feature:Agreements Api Tests
  Background:

    * def configJS = read('classpath:halkKatilim/agreements/agreements-config.js')
    * def config = call configJS
    Given url config.base_url
    * configure ssl = true
    And cookie JSESSIONID = config.jSessionID

  Scenario: Get Agreements

    * header X-APP-LANGUAGE = config.xAppLanguage
    * header Authorization = config.authorization
    And path config.agreementsParams
    And param platform = config.agreementsPlatform
    When method GET
    Then status 200
    And match responseHeaders['Content-Type'] contains config.contentType
    And match response.status == config.successStatusObject
    And assert response.data.length == config.agreementsNumber
    * def mandatoryFields = karate.map(response.data, function(data) { return data.mandatory })
    * match mandatoryFields[0] == config.firstAgreementMandatoryStatus
    * match mandatoryFields[1] == config.secondAgreementMandatoryStatus
    * match mandatoryFields[2] == config.thirdAgreementMandatoryStatus
    * match mandatoryFields[3] == config.fourthAgreementMandatoryStatus
    * def platformFields = karate.map(response.data, function(data) { return data.platform })
    Then match each platformFields == config.agreementsPlatform
    And match response.data[0].type == config.firstAgreementType
    And match response.data[1].type == config.secondAgreementType
    And match response.data[2].type == config.thirdAgreementType
    And match response.data[3].type == config.fourthAgreementType
    * def descriptionFields = karate.map(response.data, function(data) { return data.description })
    Then match each descriptionFields != null
    * def contentFields = karate.map(response.data, function(data) { return data.content })
    Then match each contentFields != null


