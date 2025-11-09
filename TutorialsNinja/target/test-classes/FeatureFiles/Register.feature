Feature: Registration functionality scenarios

  @Register @One
  Scenario: Verify whether the user able to register into the application by providing all the details
    Given I launch the application
    And I navigate to Account Registration page
    When I provide all the below valid details
    And I select the Privacy Policy
    And I click on Continue Button
    Then I should see that the User account has successfully created

  @Register @Two
  Scenario: Verify  whether the user is not allowed to register on skipping mandatory fields
    Given I launch the application
    And I navigate to Account Registration page
    When I click on Continue Button
    Then I should see that the User account is not created
    And I should see the error message informing the user to fill the mandatory fields

  @Register @Three
  Scenario: Verify whether the user is able to register into application by opting for Newsletter subscription
    Given I launch the application
    And  I navigate to Account Registration page
    When I provide all the below valid details
    And I subscribe to Newsletter
    And I select the Privacy Policy
    And I click on Continue Button
    Then I should see that the User account has successfully created

  @Register @Four
  Scenario: Verify whether the user is restricted from creating a duplicate account
    Given I launch the application
    And  I navigate to Account Registration page
    When I provide all the below valid details with an existing email
    And I select the Privacy Policy
    And I click on Continue Button
    Then I should see that the User is restricted from creating duplicate account

