[![Build Status](https://travis-ci.org/luizgustavocosta/junit-5-how-to.svg?branch=master)](https://travis-ci.org/luizgustavocosta/junit-5-how-to)

# Project title 
:vertical_traffic_light: junit-5-how-to :vertical_traffic_light:

This is an example of JUnit-5 with Spring :high_brightness:

# Assumptions

* This is a sandbox to test JUnit 5 not a real project,
* There is a small part of DDD (Domain Drive Design) and CQRS (Command Query Responsibility Segregation) inside as well.

# Getting started

# Class diagram

[![](https://mermaid.ink/img/eyJjb2RlIjoic2VxdWVuY2VEaWFncmFtXG5DbGllbnQtPj4rUmVzdC9DTEk6IEhlbGxvIEpvaG4sIGhvdyBhcmUgeW91P1xuUmVzdC9DTEktPj4rSGFuZGxlcjogSm9obiwgY2FuIHlvdSBoZWFyIG1lP1xuUmVzdC9DTEktLT4-LUhhbmRsZXI6IEhpIEFsaWNlLCBJIGNhbiBoZWFyIHlvdSFcbkhhbmRsZXItLT4-LUFkYXB0ZXI6IEkgZmVlbCBncmVhdCFcbkFkYXB0ZXItLT4-K1NlcnZpY2U6IHNhdmVcblNlcnZpY2UtLT4-K1JlcG9zaXRvcnk6IEkgZmVlbCBncmVhdCBfKCFcblJlcG9zaXRvcnktLT4-K0RhdGFiYXNlOiBJIGZlZWwgZ3JlYXQgXyghXG4gIFxuXHRcdFx0XHRcdCIsIm1lcm1haWQiOnsidGhlbWUiOiJkYXJrIn19)](https://mermaid-js.github.io/mermaid-live-editor/#/edit/eyJjb2RlIjoic2VxdWVuY2VEaWFncmFtXG5DbGllbnQtPj4rUmVzdC9DTEk6IEhlbGxvIEpvaG4sIGhvdyBhcmUgeW91P1xuUmVzdC9DTEktPj4rSGFuZGxlcjogSm9obiwgY2FuIHlvdSBoZWFyIG1lP1xuUmVzdC9DTEktLT4-LUhhbmRsZXI6IEhpIEFsaWNlLCBJIGNhbiBoZWFyIHlvdSFcbkhhbmRsZXItLT4-LUFkYXB0ZXI6IEkgZmVlbCBncmVhdCFcbkFkYXB0ZXItLT4-K1NlcnZpY2U6IHNhdmVcblNlcnZpY2UtLT4-K1JlcG9zaXRvcnk6IEkgZmVlbCBncmVhdCBfKCFcblJlcG9zaXRvcnktLT4-K0RhdGFiYXNlOiBJIGZlZWwgZ3JlYXQgXyghXG4gIFxuXHRcdFx0XHRcdCIsIm1lcm1haWQiOnsidGhlbWUiOiJkYXJrIn19)
  
					

# How to run

* The project is using SpringBoot thus is possible to iterate using an endpoint or command line interface.

## User interface

* By endpoint there are several ways let's cover two:
  ##### CURL
  * GET
    - hello
        ``curl http://host:port/hello``
    - products 
        ``curl http://host:port/products``
  * POST
  ``curl -d '{"title":"my product title", "price":"10"}' -H "Content-Type: application/json" -X POST http://host:port/products``
  
  ##### Browser
  * GET
    - hello
        ``curl http://host:port/hello``
    - products 
        ``curl http://host:port/products``

## CLI (Command Line Interface)

* After the project starts a dirty menu will show and press 1 key to create a random product or 2 key to list all products. 
````console
******** CLI MENU **************
* 1 - Create a random product  *
* 2 - Print all products       *
* exit - Turn off CLI MENU     *
********************************
1
2
Product{id='5cac3c8f-342f-4c50-ac30-b404ef755e3a', title='4057b5da-2', price=7}
````

# Author

Luiz Gustavo Costa

# Acknowledgments
### Java, Maven, JUnit 5, Spring, DDD, CQRS
