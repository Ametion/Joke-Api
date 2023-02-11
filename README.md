# Joke API

### This project is clone of "JOKE API", created in Java and Spring Boot. 
### In this API you can get jokes by language and jokes types. 
### Admins can add languages, joke types, and jokes.

### Use mysql for database system

# Routes

# Joke Routes

## Get Joke Route

`POST /joke`

### This route will give you joke by presented parameters in body. Body example:

```
{
    "jokeTypes": [NUMBER, NUMBER],
    "language": NUMBER
}
```

#### Field "jokeTypes", contain array of joke types id's which must be in joke.
#### Field "language", contain id of language of joke.

## Add Joke Route

`POST /addJoke`

### This route will add new joke to database with data presented in body, Body example:

```
{
    "jokeTypes": [NUMBER, NUMBER],
    "languageId": NUMBER,
    "joke": "STRING"
}
```

#### Field "jokeTypes", contain array of joke types id's which must be in joke.
#### Field "language", contain id of language of joke.
#### Field "joke", contain joke

# Joke Type Routes

## Add Joke Type Route

`POST /jokeType`

### This route will add joke type to database with data presented in body, Body example:

```
{
    "jokeType": "STRING"
}
```

#### Field "jokeType", contain joke type which will save to database.

## Get All Joke Type Route

`GET /jokeTypes`

### This route will return array of all joke types from database. Response Example:

```
[
    {
        "jokeTypeId": 1,
        "jokeType": "Racism"
    },
    {
        "jokeTypeId": 2,
        "jokeType": "Sexist"
    }
]
```

# Language Routes

## Add Language Route

`POST /language`

### This route will add language to database with data presented in body, Body example:

```
{
    "abbreviation": "STRING",
    "language": "STRING"
}
```

#### Field "abbreviation", contain abbreviation for language, for example, for language "english" it will be - "en"
#### Field "language", contain name of language you add.

## Get All Languages Route

`GET /languages`

### This route will return array of all languages from database. Response Example:

```
[
    {
        "languageId": 1,
        "languageAbbreviation": "RU",
        "language": "Russian"
    },
    {
        "languageId": 3,
        "languageAbbreviation": "EN",
        "language": "English"
    }
]
```

# Best wishes from Yehor Kochetov :)