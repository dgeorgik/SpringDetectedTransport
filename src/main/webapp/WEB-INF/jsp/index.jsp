<!DOCTYPE HTML>
<html>
<head>
<%--    <meta charset="UTF-8" />--%>
<%--    <meta content="text/html; charset=utf-8" >--%>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">



    <title>Welcome</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css"
<%--          href="${pageContext.request.contextPath}/css/style.css"/>--%>
</head>
<body>
<div class="card overflow-hidden border-0 rounded-0 text-center">
    <img src="images/main_logo_schem.png" class="card-img rounded-0" alt="...">
    <div class="card-img-overlay d-flex flex-column justify-content-center">
<%--        <a class="stretched-link" href="${pageContext.request.contextPath}/personList">Распознать фотографию</a>--%>
            <div class="caption">
            <h1 class="card-title text-uppercase">
<%--                <font style="background-color: white">Классификационная модель общественного транспорта</font>--%>
            </h1>

                <form method="POST" action="uploadFile" enctype="multipart/form-data" style="color: white">
                    File to upload: <input type="file" name="file" style="color: white"><br />

                    <input type="submit" value="Upload">Press here to upload the file!

                </form>
            </div>
    </div>
</div>
</body>

</html>