### ejemplo-rabbit-procesamiento

Para ejecutar los diferentes scripts/main classes podemos usar el plugin exec de Maven.

Por ejemplo, con la siguiente línea

    mvn exec:java -Dexec.mainClass="common.MessageSender" -Dexec.args="cola 15"

vamos a ejecutar el common.MessageSender y le pasamos dos parámetros de entrada: cola (qué es el nombre de la cola a usar) y 15 (que sería la cantidad de mensajes a enviar)
