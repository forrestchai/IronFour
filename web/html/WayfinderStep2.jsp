<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/14/2016
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="..\css\qq.css" rel="stylesheet" type="text/css">
    <link href="..\css\style.css" rel="stylesheet" type="text/css">
    <title>Title</title>
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
                <h1>Step 2: Finding yourself</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <p>Tell us your location by choosing from the list, or scanning a nearby
                    NFC tag!
                    <br>
                </p>
            </div>
        </div>
    </div>
</div>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1 class="text-center">Search the WIHC
                    <br>
                </h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-offset-3 col-md-6">
                <div class="btn-group">
                    <a class="btn btn-primary dropdown-toggle" data-toggle="dropdown">Areas<span class="fa fa-caret-down"></span></a>
                    <ul class="dropdown-menu" role="menu" onchange="actionChanged()">
                        <li>
                            <a href="#" onClick="openAlpha('alphaList', 'bravoList')">Area A</a>
                        </li>
                        <li>
                            <a href="#" onClick="openBravo('alphaList', 'bravoList')">Area B</a>
                        </li>
                    </ul>
                </div>
                <ul class="list-group" id="alphaList" style="display:none">
                    <li class="list-group-item btnList">Pharmacy</li>
                    <li class="list-group-item btnList">Corridor A2</li>
                    <li class="list-group-item btnList">MRT station</li>
                    <li class="list-group-item btnList">Corridor A4</li>
                    <li class="list-group-item btnList">Atrium North Wall</li>
                </ul>
                <ul class="list-group" id="bravoList" style="display:none">
                    <li class="list-group-item btnList">MacDonalds</li>
                    <li class="list-group-item btnList">Atrium South Wall</li>
                    <li class="list-group-item btnList">Pharmacy Back entrance</li>
                    <li class="list-group-item btnList">Cardiology Main Counter</li>
                    <li class="list-group-item btnList"><a href="WayfinderStep3.jsp">Information Center</a></li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <a class="btn btn-primary">Scan NFC tag<br></a>
            </div>
        </div>
    </div>
</div>

</body>
</html>
