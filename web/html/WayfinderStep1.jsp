<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/14/2016
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="..\css\qq.css" rel="stylesheet" type="text/css">
    <link href="..\css\style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript">
        function openAlpha(x, y) {
            document.getElementById(x).style.display = 'block';
            document.getElementById(y).style.display = 'none';
        }
        function openBravo(x, y){
            document.getElementById(x).style.display = 'none';
            document.getElementById(y).style.display = 'block';
        }
        $(document).ready(function(){
            openAlpha('alphaList', 'bravoList');
        });
    </script>
    <%
        session.setAttribute("current", 0);
    %>
</head>
<body>

<div class="navbar navbar-default navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand"><span>Wayfinder</span></a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-ex-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="">
                    <a href="#">Home</a>
                </li>
                <li class="active">
                    <a href="WayfinderLanding.jsp">Wayfinder</a>
                </li>
                <li>
                    <a href="#">Diabetes Monitor</a>
                </li>
                <li>
                    <a href="login.jsp">Virtual Chat</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1 class="text-center">Step 1: Set your sights</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <p class="text-center">Select the type of Location that you want to find.</p>
            </div>
        </div>
    </div>
</div>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-xs-6 text-center">
                <a href="WayfinderStep1Dept.jsp"><img src="../img/pic1.jpg" class="img-responsive"></a>
                <a class="btn btn-primary">Hospital Depts</a>
            </div>
            <div class="col-xs-6 text-center">
                <a href="WayfinderStep1Ward.jsp"><img src="../img/pic2.jpg" class="img-responsive"></a>
                <a href="WayfinderStep1Ward.jsp" class="btn btn-primary">Wards/Consltn Rooms</a>
            </div>
        </div>
    </div>
</div>
<div class="section">
    <div class="container text-center">
        <div class="row">
            <div class="col-xs-3 text-center"></div>
            <div class="col-xs-6 text-center">
                <a href="WayfinderStep1Land.jsp"><img src="../img/pic3.jpg" class="img-responsive"></a>
                <a class="btn btn-primary">Landmarks</a>
            </div>
            <div class="col-xs-3 text-center"></div>
        </div>
    </div>
</div>


</body>
</html>
