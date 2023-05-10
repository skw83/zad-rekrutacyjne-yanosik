This repository contains two projects. One of them is a server, second is a client.

Server application responsibility:
- create socket to connect with a client application
- connect with a database (MySQL)
- retrieving data about insurance offers that match to user vehicles
- sending data to the client

Client application responsibility:
- getting the id number from the user
- sending the id number to the server application
- reading the data sent by the server and presenting it to the user

Testing application:
- download the library with the driver for the MySQL database for the server application project
- running server and client application in separate IDE instances
