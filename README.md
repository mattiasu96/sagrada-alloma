# ing-sw-2018-Prosseda-Surricchio-Tiraboschi
Progetto di ingegneria del software, a.a. 2018

********************************************************

_NETWORK + CLI_: **Lorenzo Prosseda** [@procsiab](https://github.com/Procsiab)

_GUI_: **Mattia Surricchio** [@mattiasu96](https://github.com/mattiasu96)

_SERVER + TESTS_: **Alberto Tiraboschi** [@bertox94](https://github.com/Bertox94)

********************************************************

## 1.Introduction

We proudly present a full working software version of the well-known table-game: SAGRADA (https://boardgamegeek.com/boardgame/199561/sagrada).

_What do I need to know?_ -The packages are split in three: Server, Client, Shared. You will need to have either Server or Client and Shared on each host. If you want to play over LAN then you first need to run the `sagrada_server.jar`, e.g.
```
java -jar sagrada_server.jar
```
This way, the server will be started on the local machine, printing its LAN IP address. To connect with the client, you just need to run the `sagrada_client.jar` file, specifying the server's IP address, e.g.
```
java -jar sagrada_client.jar "server_ip"
```
Note that by omitting this argument for the client, it will run assuming that the server is on localhost. To play over WAN, is it necessary to specify the DNS or WAN IP address as command line argument for the `sagrada_server.jar` file, e.g
```
java -jar sagrada_server.jar "my.server.com"
```
the same should be done with the client's JAR. **Note** that it is only possible to play over WAN by using the socket connection method, and by setting up port forwarding and firewall whitelisting on the server machine's network.

## 2.Test Coverage

Server coverage (91%)
![Server Coverage](https://github.com/Procsiab/ing-sw-2018-Prosseda-Surricchio-Tiraboschi/blob/master/test%20server.jpg)

Total coverage (75%)
![Total Coverage](https://github.com/Procsiab/ing-sw-2018-Prosseda-Surricchio-Tiraboschi/blob/master/test%20totale.jpg)

## 3.UML Class Diagrams

Initial Class DIagram
![Initial Class DIagram](https://github.com/Procsiab/ing-sw-2018-Prosseda-Surricchio-Tiraboschi/blob/master/uml1.jpg)

Server Class Diagram
![Server Class Diagram](https://github.com/Procsiab/ing-sw-2018-Prosseda-Surricchio-Tiraboschi/blob/master/umls.jpg)

Network Class Diagram
![Network Class Diagram](https://github.com/Procsiab/ing-sw-2018-Prosseda-Surricchio-Tiraboschi/blob/master/umln.png)

Client Class Diagram
![Client Class Diagram](https://github.com/Procsiab/ing-sw-2018-Prosseda-Surricchio-Tiraboschi/blob/master/umlg.png)

## 4.Features

_Basic_
- [x] CLI
- [x] RMI
- [x] Socket
- [x] GUI
- [x] Advanced rules

_Advanced_
- [x] Multiple matches
- [ ] Persistance
- [ ] Dynamic cards
- [ ] Single player


`7/2018`

`Polytechnic of Milan, Italy`
