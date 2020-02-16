<?php
    $ip = $_SERVER['SERVER_ADDR'];
?>
<html>
<head>
<title>Saludador - UNDAV - Programación Distribuida II - <?= $ip ?></title>
<link rel="icon" href="data:;base64,iVBORw0KGgo=">
</head>
<body>
<?php

echo "Hola!<br><br>Hoy es: ".date("d/m/Y h:i");

echo "<br>";
echo "Server IP: $ip<br>";
echo "<br>Headers<br><br>";

foreach (getallheaders() as $nombre => $valor) {
    echo "$nombre: $valor<br>";
}

?>

</body>
</html>




