@echo off
SET dir=0
SET userDir=%cd%

SET count=0
FOR %%i IN (%*) DO (
    if %i NEQ "" (
        SET /A count=count+1
        )
    )

if %dir%==0 (
    echo [!] Error : Invalid path
    echo [!] Fix : You must run the install.bat file before using this executable
    echo.
    echo Try :
    echo install.bat
    timeout /t 5
    QUIT /B
    )

cd %dir%/Console/class
java -jar zen.jar
cd %userDir%
