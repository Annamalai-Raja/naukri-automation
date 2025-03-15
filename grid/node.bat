
@echo off
REM Check if the IP_ADDRESS argument is provided

IF "%~1"=="" (
    echo Usage: %~nx0 ^<IP_ADDRESS^>
    exit /b 1
)

SET IP_ADDRESS=%1

REM Start Selenium Node with the specified IP_ADDRESS

java -jar selenium.jar node --selenium-manager true --publish-events tcp://%IP_ADDRESS%:4442 --subscribe-events tcp://%IP_ADDRESS%:4443

pause

