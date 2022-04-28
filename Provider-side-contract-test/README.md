# Provider-side-contract-test

## Verifying the pact in the Pact Broker

Refresh the Pact Broker webpage at the http://localhost:9292/ URL to verify that a new entry exists. 
The last verified column doesn’t show a timestamp because the system microservice hasn’t verified the pact yet.

## Implementing pact testing in the system service
Open another command-line session and navigate to the start/system directory.

Start Open Liberty in dev mode for the system microservice:

`mvn liberty:dev`
After you see the following message, your application server in dev mode is ready:

**************************************************************
***    Liberty is running in dev mode.**

* The connection information for the Pact Broker is provided with the @PactBroker annotation.
* The dependency also provides a JUnit5 Invocation Context Provider with the pactVerificationTestTemplate() method to generate a test for each of the interactions.
* The pact.verifier.publishResults property is set to true so that the results are sent to the Pact Broker after the tests are completed.
* The test target is defined in the PactVerificationContext context to point to the running endpoint of the system microservice.
* The @State annotation must match the given() parameter that was provided in the inventory test class so that Pact can identify which test case to run against which endpoint.

Run the test cases.
`mvn test -Dtest=SystemBrokerIT`