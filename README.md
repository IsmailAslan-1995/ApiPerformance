### Test Execution Commands

To run tests in the project, you can use the following Maven commands:

1. **Clean Command:**

    ```sh
    mvn clean
    ```

   This command deletes any previously generated reports in the project.

2. **Test Execution Command:**

    ```sh
    mvn test -P{testProfile} -DtestType={testType} -DperformanceTestValue={boolean}
    ```

   #### Parameters and Usage:

   a) **-P{testProfile}:**
    - `-Papi-tests`: To run API tests.
    - `-Pperformance-tests`: To run performance tests.

   b) **-DtestType={testType}:**
   Specify the tag for the tests to be run:
    - `smoke`: To run all tests.
    - `agreements`: Agreement tests.
    - `authorization`: Authorization tests.
    - `companyAdvantages`: Company advantages tests.
    - `countries`: Country tests.
    - `discountCode`: Discount code tests.
    - `employee`: Employee tests.
    - `mobileCatalogContents`: Mobile catalog content tests.
    - `otp`: OTP tests.
    - `pointOfService`: Point of service tests.
    - `solutionCenter`: Solution center tests.
    - `transaction`: Transaction tests.
    - `user`: User tests.

   c) **-DperformanceTestValue={boolean}:**
    - `true`: If performance tests are to be run.
    - `false`: If API tests are to be run.

   #### Example Usage:

    ```sh
    mvn clean
    mvn test -Pperformance-tests -DtestType=user -DperformanceTestValue=true
    ```

   This command runs performance tests for the tests tagged with "user".

3. mvn test -Pperformance-tests -DtestType=performans -Dgatling.simulationClass=performanceTests.halkKatilim.agreements.HalkKatilimAgreementsLoadTest
4. docker build -t my-karate-tests .
5. docker run --rm -e MAVEN_ARGS='-Pperformance-tests -DtestType=performans -Dgatling.simulationClass=performanceTests.halkKatilim.agreements.HalkKatilimAgreementsLoadTest' my-karate-tests 
6. docker run --rm -e MAVEN_ARGS="-Papi-tests -DtestType=api" my-karate-tests
