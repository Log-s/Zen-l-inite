dir=/home/leo/Documents/Zen-l-initie/Code
userDir=`pwd`

if [ $dir == "null" ]; then
    echo "[!] Error : Invalid path"
    echo "[!] Fix : You must run the install.sh file before using this executable"
    echo ""
    echo "Try :"
    echo "chmod +x install.sh && ./install.sh"

elif [ "$#" -ne 1 ]; then
    echo "[!] Error : illegal number of arguments"
    echo "[!] Usage : ./zen.sh {-c|-g|-h}"

elif [ "$1" == "-c" ]; then
    cd $dir/Console/class/
    java -jar zen.jar
    cd $userDir

elif [ "$1" == "-g" ]; then
    cd $dir/GUI/class/
    java -jar zen.jar
    cd $userDir

elif [ "$1" == "-h" ]; then
    echo ""
    echo "ZEN Z'INITIE HELP PAGE"
    echo ""
    echo "  [¤] -c : to launch the console version of the app"
    echo "  [¤] -g : to launch the GUI version of the app"
    echo "  [¤] -h : diplays this help"
    echo ""
    echo "Usage : ./zen.sh {-c|-g|-h}"
    echo ""
    echo "The project is deisgned to be launched from anywhere on the machine using this executable"

else
    echo "[!] Error : illegal argument"
    echo "[!] Usage : ./zen.sh {-c|-g|-h}"
fi
