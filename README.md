# CHUMLEE
> A multi-application service that manages Products and customised Discounts for different Users.


## Running

`docker-compose up mariadb`

`docker-compose up discounts`

`docker-compose up products`

## Architecture
I'm trying to build this project with a DDD-like mindset. With that said, I'm trying to isolate the different _bounded contexts_ for each microservice. 

