
![Java CI with Maven](https://github.com/luizgustavocosta/junit-5-how-to/workflows/Java%20CI%20with%20Maven/badge.svg?branch=master)


[![Travis CI - Build Status](https://travis-ci.org/luizgustavocosta/junit-5-how-to.svg?branch=master)](https://travis-ci.org/luizgustavocosta/junit-5-how-to)

[![codecov](https://codecov.io/gh/luizgustavocosta/junit-5-how-to/branch/master/graph/badge.svg)](https://codecov.io/gh/luizgustavocosta/junit-5-how-to)

# Project title 
:vertical_traffic_light: junit-5-how-to :vertical_traffic_light:

This is an example of JUnit-5 with Spring :high_brightness:

# Assumptions

* This is a sandbox to test JUnit 5 not a real project,
* There is a small part of DDD (Domain Drive Design) and CQRS (Command Query Responsibility Segregation) inside as well.

# Getting started

# Class diagram

[![](https://mermaid.ink/img/eyJjb2RlIjoic2VxdWVuY2VEaWFncmFtXG5DbGllbnQtPj4rUmVzdC9DTEk6IFNlbmQgYSBjb21tYW5kL1F1ZXJ5XG5Ob3RlIHJpZ2h0IG9mIFJlc3QvQ0xJOiBUd28gZW50cnkgcG9pbnQgPGJyLz4gc3VwcG9ydGVkXG5SZXN0L0NMSS0-PitIYW5kbGVyOiBleGVjdXRlXG5IYW5kbGVyLT4-K1NlcnZpY2U6IGV4ZWN1dGVcbk5vdGUgcmlnaHQgb2YgSGFuZGxlcjogT25lIGhhbmRsZXIgZm9yIDxici8-IGNvbW1hbmQvcXVlcnlcblNlcnZpY2UtPj4rUmVwb3NpdG9yeTogYWRkL2ZpbmRcbk5vdGUgcmlnaHQgb2YgU2VydmljZTogU2VydmljZSBmb3IgZG9tYWluZFxuUmVwb3NpdG9yeS0-PitEQjogc2F2ZS9zZWxlY3Rcbk5vdGUgcmlnaHQgb2YgUmVwb3NpdG9yeTogSW1wbGVtZW50YXRpb24gb2YgPGJyLz5yZXBvc2l0b3J5IG1vZGVsIDwvYnI-aW50ZXJmYWNlXG4gIFxuXHRcdFx0XHRcdCIsIm1lcm1haWQiOnsidGhlbWUiOiJuZXV0cmFsIn0sInVwZGF0ZUVkaXRvciI6ZmFsc2V9)](https://mermaid-js.github.io/mermaid-live-editor/#/edit/eyJjb2RlIjoic2VxdWVuY2VEaWFncmFtXG5DbGllbnQtPj4rUmVzdC9DTEk6IFNlbmQgYSBjb21tYW5kL1F1ZXJ5XG5Ob3RlIHJpZ2h0IG9mIFJlc3QvQ0xJOiBUd28gZW50cnkgcG9pbnQgPGJyLz4gc3VwcG9ydGVkXG5SZXN0L0NMSS0-PitIYW5kbGVyOiBleGVjdXRlXG5IYW5kbGVyLT4-K1NlcnZpY2U6IGV4ZWN1dGVcbk5vdGUgcmlnaHQgb2YgSGFuZGxlcjogT25lIGhhbmRsZXIgZm9yIDxici8-IGNvbW1hbmQvcXVlcnlcblNlcnZpY2UtPj4rUmVwb3NpdG9yeTogYWRkL2ZpbmRcbk5vdGUgcmlnaHQgb2YgU2VydmljZTogU2VydmljZSBmb3IgZG9tYWluZFxuUmVwb3NpdG9yeS0-PitEQjogc2F2ZS9zZWxlY3Rcbk5vdGUgcmlnaHQgb2YgUmVwb3NpdG9yeTogSW1wbGVtZW50YXRpb24gb2YgPGJyLz5yZXBvc2l0b3J5IG1vZGVsIDwvYnI-aW50ZXJmYWNlXG4gIFxuXHRcdFx0XHRcdCIsIm1lcm1haWQiOnsidGhlbWUiOiJuZXV0cmFsIn0sInVwZGF0ZUVkaXRvciI6ZmFsc2V9)
  
# How to run

* The project is using SpringBoot thus is possible to iterate using an endpoint or command line interface.

## Using java -jar

  * Let's cover 3 ways to interact with the application
  #### CURL
  * GET
    - hello
        ``curl http://host:port/hello``
    - products 
        ``curl http://host:port/products``
  * POST
  ``curl -d '{"title":"my product title", "price":"10"}' -H "Content-Type: application/json" -X POST http://host:port/products``
  
  For any doubt, check out the video
  [![asciicast](https://asciinema.org/a/346856.svg)](https://asciinema.org/a/346856?t=15)
  
  #### Browser
  * GET
    - hello
        ``curl http://host:port/hello``
    - products 
        ``curl http://host:port/products``

  #### CLI (Command Line Interface)

    * After the application starts a dirty menu will show and press 1 key to create a random product or 2 key to list all products. 
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

## DOCKER 

* Go to the project folder and execute the following commands:

```mvn clean verify```

``docker build -t junit-5-how-to/with-spring .`` 

``docker run -it -p 8080:8080 junit-5-how-to/with-spring``

If you have any issue with the port, change it.

Follow the video below for any doubt.

[![asciicast](https://asciinema.org/a/346854.svg)](https://asciinema.org/a/346854)

# Author

Luiz Gustavo Costa

## Tags
### Java, Maven, JUnit 5, Spring, DDD, CQRS, Docker
