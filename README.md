# Bookstore
Assignment For Tech assessment

SQL COMMANDS TO CREATE TABLES

CREATE TABLE [dbo].[Book](
	[ID] [bigint] IDENTITY(1,1) NOT NULL,
	ISBN [varchar](255) NOT NULL,
	TITLE [varchar](255) NOT NULL,
	AUTHORS [varchar](255) NOT NULL,
	YEAR [varchar](255) NOT NULL,
	PRICE [varchar](255) NOT NULL, 
	GENRE [varchar](255) NOT NULL);

CREATE TABLE [dbo].[Author](
	[ID] [bigint] IDENTITY(1,1) NOT NULL,
	NAME [varchar](255) NOT NULL,
	BIRTHDAY datetime NOT NULL,
)





cURL commands for example


API KEY REQUIRED FOR ACCESS TO API;
"normal" - for general access
"SA" - for deletion
 
ADD BOOK
curl --request POST \
  --url http://localhost:5555/book/add \
  --header 'Content-Type: application/json' \
  --header 'X-API-KEY: normal' \
  --data '{"name": "test", "author": ["TestAuth", "Auth"], "isbn": 2, "genre": "horro", "price": "4", "year" : "1999"}'

UPDATE BOOK
curl --request POST \
  --url http://localhost:5555/book/update \
  --header 'Content-Type: application/json' \
  --header 'X-API-KEY: normal' \
  --data '{"isbn": "2","data": {"name": "Loof", "author": ["TestAuth", "Auth"], "isbn": 2, "genre": "fuc", "price": "4", "year" : "1999"}}'

FIND BOOK
curl --request GET \
  --url 'http://localhost:5555/book/find?title=fool&%3Fauthor=Auth' \
  --header 'X-API-KEY: normal'

UPDATE BOOK2
  curl --request POST \
  --url http://localhost:5555/book/update \
  --header 'Content-Type: application/json' \
  --header 'X-API-KEY: normal' \
  --data '{"isbn": "2","data": {"year" : "1999"}}'

  DELETE BOOK
  curl --request DELETE \
  --url 'http://localhost:5555/book/delete?isbn=2' \
  --header 'X-API-KEY: SA'

  ADD AUTHOR
  curl --request POST \
  --url http://localhost:5555/author/add \
  --header 'Content-Type: application/json' \
  --header 'X-API-KEY: normal' \
  --data '{"name": "Auth", "birthday": "2023-11-12"}
'

