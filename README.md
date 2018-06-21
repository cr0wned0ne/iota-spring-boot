# iota-spring-boot
Spring Boot Iota client - minimal setup to connect to iota test net.


## Setup 
1. Clone this repository
2. Build the app using: mvn clean install
3. Run the resulting jar file using: java -jar iota-spring-boot-0.0.1-SNAPSHOT.jar
4. Open http://localhost:8111/nodeinfo to see the information of the connected node
5. AppTest.java contains additional hints on how to send transactions

## Sources
- Uses Jota https://github.com/iotaledger/iota.lib.java
- Connect to iri node https://github.com/iotaledger/iri
