Feature: Test Loggin to IS

Scenario: Login with Valid credentials
  Given Open browser
  When Enter Valid Username and Password
 Then Verify logout button is visible