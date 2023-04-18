# Client

## How to start

- Navigate to "ctrl-intelligence\application\web\source\ctrl-intelligence"
  > Run 'npm start'

## How to run Unit Tests

- Navigate to "ctrl-intelligence\application\web\source\ctrl-intelligence"
  > Run 'npm test'

## How to run Integration Tests

- Navigate to "ctrl-intelligence\application\web\test"
  > Run '.\gradlew clean {test suite}'

## Where to find requirements reports

- Navigate to "ctrl-intelligence\application\web\test\build\reports\coverage\requirements" for a list of all requirement reports

# Payment Service

## How to create jar file

- Navigate to "ctrl-intelligence\service\purchase\source"
  > Run "mvn clean package"

## How to start

- Navigate to "ctrl-intelligence\service\purchase\source"
  > Run "java -jar target/{jar file}"

## How to start Integration Tests

- Navigate to "ctrl-intelligence\service\purchase\test"
  > Run ".\gradlew clean {test suite}"

## Where to find requirements reports

- Navigate to "ctrl-intelligence\service\purchase\testbuild\reports\coverage\requirements" to find a list of all requirement reports

# Scripts

## Startup

- If using 'Windows Powershell Terminal' you can use the startup script to create new tabs with proper naming and file location for an easy startup

- At the root of the project run
  > .\startup.ps1

## Combine Client Requirements Reports

- This command will combine all requirements reports into 1 report under 'requirements-report-generator'called 'Full-Requirements-Report.rpt'

- At the root of the project run
  > .\generate-report.ps1
