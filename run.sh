echo 'Please give the path and classname of the file that you want to compile and execute.'
read -p "Enter directory: " directory
read -p "Enter class name: " classname
cd $directory
find . -name "*.java" -print | xargs javac
java $classname
