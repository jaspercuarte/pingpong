@echo off
echo ####################
echo   RUNNING_PINGPONG
echo ####################

if not exist bin mkdir bin

echo [1/3] Compiling sources...
javac -d bin src\*.java src\sound\*.java
if errorlevel 1 (
    echo Compilation failed!
    pause
    exit /b
)

echo [2/3] Copying resources...
xcopy sfx bin\sfx /E /I /Y >nul

echo [3/3] Starting game...
echo.
java -cp bin Main

echo ####################
echo    GAME_FINISHED
echo ####################
pause
