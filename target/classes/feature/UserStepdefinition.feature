Feature: User Management API

  Background:
    Given a request header of "Content-Type: application/json"
  

  Scenario: GET /users
    When a GET request is made to "/users"
    Then the response status code should be 200
    And the response body should be a list of users

  Scenario: GET /users/:id (existing user)
    Given a user with an ID of 1 exists in the database
    When a GET request is made to "/users/1"
    Then the response status code should be 200
    And the response body should be the user object with ID 1

  Scenario: GET /users/:id (non-existent user)
    Given no user with an ID of 100 exists in the database
    When a GET request is made to "/users/100"
    Then the response status code should be 404
    And the response body should be an error message

  Scenario: POST /users
    Given a user object with name "John" and email "john@example.com"
    When a POST request is made to "/users" with the user object
    Then the response status code should be 201
    And the response body should be the newly created user object

  Scenario: PUT /users/:id (existing user)
    Given a user with an ID of 2 exists in the database
    And a user object with name "Jane Smith" and email "jane@example.com"
    When a PUT request is made to "/users/2" with the updated user object
    Then the response status code should be 200
    And the response body should be the updated user object

  Scenario: PUT /users/:id (non-existent user)
    Given no user with an ID of 100 exists in the database
    And a user object with name "Joe" and email "joe@example.com"
    When a PUT request is made to "/users/100" with the updated user object
    Then the response status code should be 404
    And the response body should be an error message

  Scenario: DELETE /users/:id (existing user)
    Given a user with an ID of 2 exists in the database
    When a DELETE request is made to "/users/2"
    Then the response status code should be 204
    And the response body should be empty
    And the user with ID 2 should no longer exist in the database

  Scenario: DELETE /users/:id (non-existent user)
    Given no user with an ID of 100 exists in the database
    When a DELETE request is made to "/users/100"
    Then the response status code should be 404
    And the response body should be an error message

  Scenario: PATCH /users/:id (existing user)
    Given a user with an ID of 1 exists in the database
    And a partial user object with name "John Smith"
    When a PATCH request is made to "/users/1" with the partial user object
    Then the response status code should be 200
    And the response body should be the updated user object with name "John Smith"

 Scenario: PATCH /users/:id (non-existent user)
    Given no user with an ID of 100 exists in the database
    And a partial user object with name "Jane Doe"
    When a PATCH request is made to "/users/100" with the partial user object
    Then the response status code should be 404
    And the response body should be an error message

