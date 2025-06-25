function getConfig() {
    const StatusObjects = Java.type('utils.StatusObjects');
    const AgreementsText = Java.type('halkKatilim.agreements.AgreementsText');
    const ConfigurationReader = Java.type('utils.ConfigurationReader');

    return {
        base_url: ConfigurationReader.getProperty('url'),
        jSessionID: ConfigurationReader.getProperty('jSessionId'),
        authorization: ConfigurationReader.getProperty('authorization'),
        xAppLanguage: ConfigurationReader.getProperty('xAppLanguage'),
        contentType: ConfigurationReader.getProperty('contentType'),
        agreementsParams: AgreementsText.AGREEMENTS_PATH_PARAM,
        agreementsPlatform: AgreementsText.AGREEMENTS_QUERY_PARAM,
        agreementsNumber: AgreementsText.AGREEMENTS_NUMBER,
        firstAgreementType: AgreementsText.FIRST_AGREEMENT_TYPE,
        secondAgreementType: AgreementsText.SECOND_AGREEMENT_TYPE,
        thirdAgreementType: AgreementsText.THIRD_AGREEMENT_TYPE,
        fourthAgreementType: AgreementsText.FOURTH_AGREEMENT_TYPE,
        firstAgreementMandatoryStatus: AgreementsText.FIRST_AGREEMENT_MANDATORY_STATUS,
        secondAgreementMandatoryStatus: AgreementsText.SECOND_AGREEMENT_MANDATORY_STATUS,
        thirdAgreementMandatoryStatus: AgreementsText.THIRD_AGREEMENT_MANDATORY_STATUS,
        fourthAgreementMandatoryStatus: AgreementsText.FOURTH_AGREEMENT_MANDATORY_STATUS,
        successStatusObject: StatusObjects.SUCCESS_STATUS
    };
}
