@echo off

:: compiles and renders two jar files (console and graphical version)
:: renders an executable file, that can be moved, and can lauch both versions

SET dir="%cd%"

:: -----------------------------------------------------------------------------------------------::

cd Console\ws
RMDIR /S /Q %dir%\Console\class\
MKDIR %dir%\Console\class
javac -d ../class ../src/Launcher.java ../src/model/*.java ../src/util/*.java ../src/control/*.java
:: compiling console version
echo [+] console version compiled

cd ../class
MKDIR META-INF
echo Main-Class: Launcher > META-INF/MANIFEST.MF
:: creating the lauching manifest
jar cmf META-INF/MANIFEST.MF zen.jar control/*.class model/*.class util/*.class Launcher.class
:: creating the jar file in the class folder
echo [+] console jar generated

:: -----------------------------------------------------------------------------------------------::

cd %dir%

:: -----------------------------------------------------------------------------------------------::

cd GUI\ws
RMDIR /S /Q %dir%\GUI\class\
MKDIR %dir%\GUI\class
javac -d ../class ../src/Launcher.java ../src/model/*.java ../src/util/*.java ../src/view/*.java
:: compiling GUI version
echo [+] GUI version compiled

cd ../class
MKDIR META-INF
echo Main-Class: Launcher > META-INF/MANIFEST.MF
:: creating the lauching manifest
jar cmf META-INF/MANIFEST.MF zen.jar view/*.class model/*.class util/*.class Launcher.class
:: creating the jar file in the class folder
echo [+] GUI jar generated

:: -----------------------------------------------------------------------------------------------::

cd %dir%

:: -----------------------------------------------------------------------------------------------::

more +2 zenConsole.bat > tmp.txt
echo @echo off > zenConsole.bat
echo SET dir=%dir% >> zenConsole.bat
type tmp.txt >> zenConsole.bat
del tmp.txt

more +2 zenGUI.bat > tmp.txt
echo @echo off > zenGUI.bat
echo SET dir=%dir% >> zenGUI.bat
type tmp.txt >> zenGUI.bat
del tmp.txt

echo [+] Executable usable
echo.
echo [+] Done
echo [+] You can now move the executables around, it will still work

timeout /t 5
