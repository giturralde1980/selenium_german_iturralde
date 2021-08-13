Feature: Custom Salesforce endpoint for enablig unmatching searches with ocr result


  Scenario: Find ocr results after a case creation in salesforce because of a mismatch between sf and ocr-hyperscience
    Given a case is created after a sumission ocr process finish with a mismatch
    When a request is done against salesforce to ocrresult given  previous case
    Then ocrresult is obtained and matches with case request

  Scenario: Find ocr results after a case creation in salesforce because of a mismatch between sf and ocr-hyperscience bad
    Given a case is created after a sumission ocr process finish with a mismatch
    When a request is done against salesforce to ocrresult given  previous case
    Then ocrresult is obtained and matches with case request two

  Scenario: Find ocr results given an existing case in salesforce
    Given a salesforce case id {string} is given
    When a request is done against salesforce to ocrresult given  previous case
    Then ocrresult is obtained and matches with case request two