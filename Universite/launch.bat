@echo off

echo Lancement d'un serveur universitaire...

set /p universite= Nom de l'universite : 

set /p rectorat= Nom du rectorat : 

set /p nameService= Adresse ip du service de nommage : 

java -jar ./dist/Universite.jar "%universite%" "%rectorat%" "%nameService%"

pause