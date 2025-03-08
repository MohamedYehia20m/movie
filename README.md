# Movie Application

A Spring Boot application that manages movie information with secure authentication.

## Features

- User authentication and authorization
- Movie information management
- Movie search functionality
- Detailed movie data storage including:
  - Basic movie details (title, year, director, ...etc)
  - Ratings from different sources
  - Technical information (runtime, genre)
  - Box office and production details

## Technical Stack

- Java
- Spring Boot
- Spring Security
- JPA/Hibernate
- Maven
- MySQL (Database)

## Project Structure

- `controller`: REST controllers for authentication and movie operations
- `service`: Service classes for business logic
- `repository`: JPA repositories for database operations
- `model`: Contains entity classes (Movie)
- `utils`: Utility classes for search ,response and ratings


## Setup

1. Clone the repository
```bash
    git clone https://github.com/MohamedYehia20m/movie.git
```
2. Configure application properties in `application.properties`
3. Run `mvn clean install`
4. Start the application using `mvn spring-boot:run`

## API Endpoints

### API Endpoints Documentation

#### Authentication Endpoints
```http
POST /login
Content-Type: application/json

{
    "username": "string",
    "password": "string",
    "role": "string"
}
```
#### User Endpoints

```http
# Get all users
GET /api/users

# Get user by ID
GET /api/users/{id}

# Create new user
POST /api/users
Content-Type: application/json

{
    "username": "string",
    "password": "string",
    "roles": "string"
}

# Update user
PUT /api/users/{id}
Content-Type: application/json

{
    "username": "string",
    "password": "string",
    "roles": "string"
}

# Delete user
DELETE /api/users/{id}
```

#### Movie Endpoints

```http
# Get all movies from database
GET /api/movies

# Get movie from database by IMDB ID
GET /api/movies/db/{imdbID}

# Get movie from database by title and year
GET /api/movies/db/{title}/{year}

# Search movies in OMDB by title
GET /api/movies/omdb/search/{title}

# Get movie from OMDB by IMDB ID
GET /api/movies/omdb/{imdbID}

# Get movie from OMDB by title and year
GET /api/movies/omdb/{title}/{year}

# Add movie by IMDB ID
POST /api/movies/{imdbID}

# Add movie by title and year
POST /api/movies/{title}/{year}

# Delete movie
DELETE /api/movies/{imdbID}
```