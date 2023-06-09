<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <meta content="text/html; charset=utf-8" >
    <title>Error</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<style>
    .center_div {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        text-align: center;
        min-height: 100vh;
    }
</style>
</head>
<body>
<div>
    <div class="center_div">
            <div class="card text-center">
                    <div class="card-header" style="background-color: red">
                    </div>
                            <div class="card-body">
                                <img src="/images/bad_bus.png" style="height: 150px; weight: 150px">
                                <h3 class="card-title">Oops...</h3>
                                <h5 class="card-text">Unfortunately, </h5>
                                <h5 class="card-text">i was unable to recognize due to an error that occurred</h5>
                            </div>
                <div class="card-footer text-body-secondary" style="background-color: red">
                </div>
                <br>
                <div class="card-footer text-body-secondary">
                    <h5>You will be redirected to the main page within 5 seconds...</h5>
                </div>
        </div>
    </div>
</div>
</body>

</html>