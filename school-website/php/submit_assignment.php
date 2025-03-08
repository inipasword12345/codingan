<?php
include 'config.php';

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $name = $_POST['name'];
    $assignment = $_FILES['assignment'];

    $target_dir = "../uploads/";
    $target_file = $target_dir . basename($assignment["name"]);

    // Pindahkan file ke folder uploads
    if (move_uploaded_file($assignment["tmp_name"], $target_file)) {
        // Simpan data ke database
        $sql = "INSERT INTO assignments (name, file_path) VALUES ('$name', '$target_file')";
        if ($conn->query($sql) === TRUE) {
            echo "Assignment submitted successfully!";
        } else {
            echo "Error: " . $sql . "<br>" . $conn->error;
        }
    } else {
        echo "Sorry, there was an error uploading your file.";
    }
}

$conn->close();
?>