<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Message</title>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
    <script>
        Swal.fire({
            title: 'Login Failed!',
            text: 'Wrong username or password',
            icon: 'error',
        }).then((result) => {
            if (result.isConfirmed) {
                window.location.href = '../auth/login.jsp'; // Redirect after popup is closed
            }
        });
    </script>
</body>
</html>