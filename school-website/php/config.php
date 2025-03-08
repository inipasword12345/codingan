<?php
$servername = "localhost";
$username = "root"; // Default username XAMPP/MAMP
$password = ""; // Default password XAMPP/MAMP
$dbname = "school_db";

// Buat koneksi
$conn = new mysqli($servername, $username, $password, $dbname);

// Cek koneksi
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
?>