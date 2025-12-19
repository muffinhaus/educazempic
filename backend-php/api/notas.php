<?php
header("Content-Type: application/json");

$host = "localhost";
$db = "gestion_notas";
$user = "root";
$pass = "cmadrid";

try {
    $pdo = new PDO(
        "mysql:host=$host;dbname=$db;charset=utf8",
        $user,
        $pass
    );
} catch (PDOException $e) {
    echo json_encode(["error" => "DB error"]);
    exit;
}

$stmt = $pdo->query("SELECT id, titulo, contenido FROM notas");
$notas = $stmt->fetchAll(PDO::FETCH_ASSOC);

echo json_encode($notas);
