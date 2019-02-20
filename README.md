# Product+Discounts

### (a.k.a. Chumlee)

> A multi-application service that manages Products and customised Discounts for different Users.

  * [Structure](#structure)
  * [Discounts Server](#discounts-server)
    + [DiscountRule](#discountrule)
      - [*Why this format?*](#-why-this-format--)
  * [Products Server](#products-server)
    + [Why SQL?](#why-sql-)
    + [Why gRPC?](#why-grpc-)
  * [Running](#running)
  * [Testing](#testing)
  * [How can this project be improved?](#how-can-this-project-be-improved-)
  * [Trivia](#trivia)

----------

## Structure

This project is structured as two microservices. I have used a shared database at this point but as the project grows a better database structure would necessary. I tried to use a DDD-like project structure, but it is not strictly DDD.

  

![Overall Request Flow ](https://i.imgur.com/bulZWEu.png)

  

## Discounts Server

Built with Node and connects with the MariaDB/MySQL database.

It basically fetches data that could be used on the Discount Rules logics and uses them to infer the final discount.

### DiscountRule

A DiscountRule has the following format:

```

type DiscountType = 'DISCOUNT | 'MAX_DISCOUNT'

  

type Discount = {

id: Number,

externalId: String,

name: String,

rule: String,

type: DiscountType

}

```

  

`rule` is a Javascript snippet that will be ran in a sandbox with access only to the relevant data (like the `user`, the `product`, etc.).

  

```

new DiscountRule({

id: 1,

externalId: "RUL-BBBBBBBBBBBB",

name: "5% discount in January",

rule: "if(now.getMonth() == 0) percentage = 0.05",

type: 'DISCOUNT'

})

```

#### *Why this format?*

The most obvious approach would be to add the discount ruels to the code itself, but that isn't scalable _at all_. Whenever a new rule were to be added, the code would have to be updated and soon the code would be unbearable. Instead, I decided to make it as generic as possible, so that the rule creation would happen outside of the scope of this project (e.g. by someone in Customer Management, perhaps?).

Ideally, creating a rule shouldn't depend on coding JS, but this was the simplest approach that would be "good enough" for a proof of concept.

  

## Products Server

This server was built with Kotlin and Spark Framework + Koin for Dependency Injection. I used this as an opportunity to test out Kotlin without Spring Boot, which I have been using lately.

It connects to MariaDB to fetch the products and keeps them in memory while it asks the Discounts Server to calculate the discounts for each product and for the user (received by this server via request HEADER)

It only has one route, `/products`, which centers all of its functionality.

  

### Why SQL?

Although at this early stage it doesn't seem like so, looking ahead for more discount rules to be added you can see a relational structure might arise. For example, new Discount rules in the future might be added depending on a Products Category, be linked to a User's account or something related. Thus, starting with a relation mindset makes sense from an architectural point of view.

  

### Why gRPC?

It was a project requirement I received for this, and also it was a great opportunity to learn something new.

  

## Running

You can run this project easily with Docker-Compose. Rename `discounts/.env.example` to `.env`, and then run `docker-compose up --build` and both services will be started alongside the database. The `env` file will have the default database credentials and environment variables.

  

## Testing

```

curl -X GET \

http://localhost:5000/products \

-H 'USER_ID: USR-AAAAAAAAAAAA'

```

`USR-AAAAAAAAAAAA` is set to have the birthday set for the current date on database creation, so you can use that to test the Birthday related rule already seeded on the database. Otherwise, use `USR-BBBBBBBBBBBB` or `USR-CCCCCCCCCCCC`.

  

To test the failure to connect with the discounts server, run

`docker-compose stop discounts` and `curl` the command again. The default prices will be shown when the service fails to contact the other via gRPC.

  

## How can this project be improved?

It is lacking tests. TONS OF TESTS. I didn't have much time to work on it, and it took me about two weeks to get enough hours to finish it. I spent about ~15 hours total building it (I started with the simplest version and iterated over it). Although there is some test coverage, it is not very complete.

Another thing is that the database is accessed too often, and sometimes with repeated data (for instance products are fetched twice).

An improvement would be to send the product data itself on the request to Discounts Server (thus separating it from the `products` domain and having it concerned only with the calculation).

I didn't do it because the project requirements said that the Discounts Server should only received the User Id and the Product Ids.

  

Now just speculating, I think another improvement could be having the gRPC communication being done over streams and asynchronously, responding to the Products Server as soon as that product's discount calculation was done. This would allow the Products Server to get the discounts for some products even if some network problems stopped it from getting the rest of the responses. I didn't explore this idea further because I'm very new to gRPC, but it seems like a possibility.

  
  

## Trivia

Chumlee is the son of Rick, from Pawn Stars, a show where people bring items and they try to buy it for a cheape/fair price or they ask for help of a specialist when they don't know how much it should be.

![](https://i.imgur.com/dvA8rEa.jpg)
