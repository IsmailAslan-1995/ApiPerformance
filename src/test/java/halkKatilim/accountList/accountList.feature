Feature: Mobile Branch Login & Account Flow

  Background:
    * url 'http://172.31.3.17/BOA.Integration.MobileBranch'
    * header Content-Type = 'application/json'
    * def customerId = '1005'
    * def deviceId = '9216acd1fc8a194b'

  Scenario: Initial Login → OTP Login Complete → Account List

    #############################################
    # 1) INITIAL LOGIN
    #############################################

    Given path 'BOA.Integration.Authentication/AuthenticationService.svc/InitialLogin'
    And request
      """
      {
        "CustomerId": "1005",
        "DeviceId": "9216acd1fc8a194b",
        "DeviceModel": "macos postman",
        "IsDeviceRooted": false,
        "IsMigrationEnable": false,
        "IsPwfEnable": true,
        "IsStsEnable": false,
        "IsPinValidate": true,
        "IsStsLogin": false,
        "LoginType": 2,
        "Password": "121212",
        "GSMNumber" : "902124440123",
        "Version": "1.0",
        "AppName": "Mobil Sube Android",
        "ExtUPassword" : "kxv1+pGlhnivmXWFA+qV4+8sehnfbcdaFhE++RXqXp4=",
        "ExtUName" : "MobilePrivateTest",
        "LanguageId": 1,
        "MainResourceCode": "MOBRMAINPG",
        "MainResourceId": 8955,
        "SmsContentType": 0
      }
      """
    When method post
    Then status 200

    # POSTMAN environment variable çevirimi:
    * def sessionKey = response.SessionKey
    * def returnedCustomerId = response.CustomerId
    * def returnedUserName = response.WebUserName
    * def returnedUserId = response.UserId
    * def returnedPersonId = response.PersonId

    * print 'SessionKey:', sessionKey
    * print 'CustomerID:', returnedCustomerId
    * print 'UserID:', returnedUserId
    * print 'UserName:', returnedUserName
    * print 'PersonId:', returnedPersonId


    #############################################
    # 2) OTP LOGIN COMPLETE
    #############################################


    Given path 'BOA.Integration.Authentication/AuthenticationService.svc/OtpLoginComplete'
    And request
      """
      {
    "AppName": "Android",
    "DevideId": "9216acd1fc8a194b",
    "DeviceModel": "macos postman",
    "DeviceOSVersion": "5.0.1",
    "DeviceOSName": "Android",
    "IsDeviceRooted": false,
    "LanguageId": 1,
    "CustomerId": returnedCustomerId,
    "ExtUSessionKey": "#(sessionKey)",
    "UserName": "#(returnedUserName)",
    "OtpType": 10,
    "MainResourceCode": "MOBRMAINPG",
    "MainResourceId": 8955,
    "SmsContentType": 0
    }
    """
    When method post
    Then status 200

    * def extUSessionKey = response.ExtUSessionKey
    * print 'ExtUSessionKey:', extUSessionKey


    #############################################
    # 3) ACCOUNT LIST
    #############################################

    Given path 'BOA.Integration.MobileBanking.Account/AccountService.svc/AccountList'
    And request
      """
      {
        "AppName": "and1",
        "ExtUSessionKey": "#(extUSessionKey)",
        "LanguageId": 1,
        "DontShowInvestmentAccounts": false,
        "DontShowSalaryAndStockAccounts": false,
        "ListType": 2,
        "ShowAccountsWithAccountNumberList": false,
        "ShowAccountsWithNoBalance": false,
        "ShowDipBipDepositAccounts": false,
        "ShowOnlyAccountsHasAvailableBalance": true,
        "ShowOnlyAccountsHasNoAvailableBalance": false,
        "ShowOnlyCurrentAccounts": true,
        "ShowOnlyOpenAccounts": true,
        "ShowOnlyTLAccounts": false,
        "ShowSharedAccounts": false,
        "ShowSharedAccountsWithMultiSignature": true
      }
      """
    When method post
    Then status 200

    * print 'Account List Response:', response

