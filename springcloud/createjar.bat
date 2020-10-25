@echo off
echo start
mvn package
pause

::本项目测试类加public,否则打包false,why?