<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Teacher Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<%@ include file="/views/shared/userNavbar.jsp" %>

    <div class="container mt-5">
        <div class="row h-100">
            <div class="col-md-4">
                <div class="card h-100">
                    <div class="card-body">
                        <h5 class="card-title">Create Test</h5>
                        <p class="card-text">Create a new test for your students.</p>
                        <a href="#" class="btn btn-primary">Create</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card h-100">
                    <div class="card-body">
                        <h5 class="card-title">Assign Created Test</h5>
                        <p class="card-text">Assign a created test to your students.</p>
                        <a href="#" class="btn btn-primary">Assign</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card h-100">
                    <div class="card-body">
                        <h5 class="card-title">View Previous Test Results</h5>
                        <p class="card-text">View results of tests previously taken by students.</p>
                        <a href="#" class="btn btn-primary">View Results</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
