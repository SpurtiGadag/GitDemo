Feature: Login to IS
@tag2
Scenario Outline: Login to IS
Given : Login to Integration Server using <url>, <isusername>, <ispassword>
 Examples: 
      | url                  | isusername  | ispassword |
      | http://vmiotspro98:5555/ |Administrator|manage|
