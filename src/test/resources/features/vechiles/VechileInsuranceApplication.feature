#/**
# * Autor: Fernando Lisboa
# * Empresa: Teste Técnico
# * Data: 22/12/2020
Feature: Vehicle Insurance Application
  
  Fill out vehicle insurance request and send for evaluation

  Background: 
    Given I'm on the sampleApp website
    
@vechile
  Scenario Outline: <ID_FERRAMENTA_CI_CD> - Fill out vehicle insurance request and send for evaluation <scenario>
    When filling out the form of vechile data
    And filling out the form of insurant data
    And filling out the form of product data
    And filling out the form of select price options
    And filling out the form of send quotes "<user>", "<password>"
    Then I must validate the message of success

    Examples: 
      | ID_FERRAMENTA_CI_CD | scenario           | user           | password   |
      |               00001 | successful filling | testeAutomation | Teste@2020|
