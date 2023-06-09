<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en"><head>
    <meta charset="utf-8">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/jumbotron/">

    <meta http-equiv="Content-Type" content="text/html; charset=windows-1251 /">

    <title>Moscow Bus</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css">

</head>
<body>

<main>
<div class="container">
        <div class="row row-cols-1 row-cols-md-2 g-4">
            <div class="col">
                <div class="card">
                    <img src="downloadImages/loadFiles/cv2_detected_object/${file_yolo_cv2}.jpg" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Результат работы модуль 1 - yolo</h5>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card">
                    <img src="downloadImages/loadFiles/yolo_detectedImages/${file_yolo_detected}" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Обрезал Ваше изображение, чтобы я мог определить маршрут</h5>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card">
                    <img src="downloadImages/loadFiles/yolo_detectedImages/${ocr_invent}" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Инвертировали изображени для нахождения символов</h5>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card">
                    <img src="downloadImages/loadFiles/yolo_detectedImages/${ocr_detected}" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Применили Ocr</h5>
                    </div>
                </div>
            </div>
        </div>
        </div>
        <footer class="pt-3 mt-4 text-muted border-top">
            © 2022 РУТ МИИТ
        </footer>
</main>

</body>
</html>