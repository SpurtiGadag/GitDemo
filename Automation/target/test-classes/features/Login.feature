Feature: Application Login

Scenario: Home page default Login
Given User is on landing page
When User login into application with username and password
Then home page is populated 
And Cards are displayed