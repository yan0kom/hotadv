### Тестовое задание

Задача в файле task.txt

Запуск MySQL и Wildfly  
`docker-compose up -d --build`  

База данных инициализирована скриптами из папки db/docker-entrypoint-initdb.d  
В Wildfly добавлен драйвер MySQL

Сборка и разворачивание ear-приложения  
`./gradlew :ear:redeploy`

UI доступен по адресам:  
http://localhost:8080  
https://localhost:8443  
