# Consumer-side-contract-test

## Starting the Pact Broker
Run the following command to start the Pact Broker:

`docker-compose -f "pact-broker/docker-compose.yml" up -d --build`
When the Pact Broker is running, you’ll see the following output:

**Creating pact-broker_postgres_1 ... done
Creating pact-broker_pact-broker_1 ... done**
Go to the http://localhost:9292/ URL to confirm that you can access the user interface (UI) of the Pact Broker.

## Navigate to the start/inventory directory to begin.

Create the InventoryPactIT class file.
`inventory/src/test/java/io/openliberty/guides/inventory/InventoryPactIT.java
InventoryPactIT.java`

When completed, you’ll see a similar output to the following example:

[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running io.openliberty.guides.inventory.InventoryPactIT
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.631 s - in io.openliberty.guides.inventory.InventoryPactIT
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0

**The generated pact file is named Inventory-System.json and is located in the inventory/target/pacts directory. The pact file contains the defined interactions in JSON format:**

`{
...
"interactions": [
{
"description": "a request for server name",
"request": {
"method": "GET",
"path": "/system/properties/key/wlp.server.name"
},
"response": {
"status": 200,
"headers": {
"Content-Type": "application/json"
},
"body": [
{
"wlp.server.name": "defaultServer"
}
]
},
"providerStates": [
{
"name": "wlp.server.name is defaultServer"
}
]
}
...
]
}`
Open a new command-line session and navigate to the start/inventory directory.

Publish the generated pact file to the Pact Broker by running the following command:

`mvn pact:publish`
After the file is published, you’ll see a similar output to the following example:

--- maven:4.1.21:publish (default-cli) @ inventory ---
Publishing 'Inventory-System.json' with tags 'open-liberty-pact' ... OK