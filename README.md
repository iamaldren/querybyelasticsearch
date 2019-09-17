# Query by Elasticsearch

This is a sample project that uses the below stack:
- Spring Boot
- jOOQ
- Elasticsearch
- MariaDB

## Prerequisites

Running instance of the below:
- Elasticsearch
- MariaDB

Either use Docker, or manually install.

## Configuration

1. Update the __aplication.yml__ file with the correct configuration for Elasticsearch and MariaDB.
2. Create the tables in the database by using the script in __src/main/resources/data/migration__
3. Run the script in __src/main/resources/db/data__

## Running the program

1. Clone the repository
2. Open a command prompt, and cd to the %PROJECT_HOME%
3. Execute the command below:

`
 java -jar target/query-by-elasticsearch-1.0-SNAPSHOT.jar
`

### API Endpoints

The service has 3 API Endpoints

1. GET /api/pokemon/{id}
- Gets the specific Pokemon record for the given ID.
- The data is getting queried only from Elasticsearch, and not in the database

2. POST /api/pokemon
- Adds the data to the Pokemon index in Elasticsearch
- Adds the data in the Database
- Data sample as below:

`
{
	"id": 1,
	"name": "Bulbausar",
	"species": "Seed",
	"type": [
		"Grass",
		"Poison"
	]
}
`

3. DELETE /api/pokemon/{id}
- Removes the record from Elasticsearch
- Deletes the record from the database
