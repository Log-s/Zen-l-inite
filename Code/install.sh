#! /bin/bash

# compiles and renders two jar files (console and graphical version)
# renders an executable file, that can be moved, and can lauch both versions

dir=`pwd`
mkdir saves

#---------------------------------------------------------------------------------------------------------------------------------------#

cd Console/ws
rm -rf ../class/*
javac -d ../class ../src/Launcher.java ../src/model/*.java ../src/util/*.java ../src/control/*.java #compiling console version
echo "[+] console version compiled"

cd ../class
mkdir META-INF
echo "Main-Class: Launcher" > META-INF/MANIFEST.MF  #creating the lauching manifest
jar cmf META-INF/MANIFEST.MF zen.jar control/*.class model/*.class util/*.class Launcher.class #creating the jar file in the class folder
echo "[+] console jar generated"

#---------------------------------------------------------------------------------------------------------------------------------------#

cd $dir

#---------------------------------------------------------------------------------------------------------------------------------------#

cd GUI/ws
rm -rf ../class/*
javac -d ../class ../src/Launcher.java ../src/model/*.java ../src/util/*.java ../src/view/*.java #compiling GUI version
echo "[+] GUI version compiled"

cd ../class
mkdir META-INF
echo "Main-Class: Launcher" > META-INF/MANIFEST.MF  #creating the lauching manifest
jar cmf META-INF/MANIFEST.MF zen.jar view/*.class model/*.class util/*.class Launcher.class  #creating the jar file in the class folder
echo "[+] GUI jar generated"

#---------------------------------------------------------------------------------------------------------------------------------------#

cd $dir

#---------------------------------------------------------------------------------------------------------------------------------------#

sed -i '1d' zen.sh #removes the first line of the executable
echo 'dir='$dir | cat - zen.sh > temp && mv temp zen.sh #adds the path to the project folder
chmod +x zen.sh #makes it executable
echo "[+] zen.sh usable"

echo ""

echo "[+] Done"
echo "[+] You can now move the zen.sh executable around, it will still work"
