<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 1/31/2017
  Time: 6:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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

<div class="section text-center">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1>Step 4: Wayfinding</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <p>Follow the map!</p>
            </div>
        </div>
    </div>
</div>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-xs-12"></div>
        </div>
        <div class="row">
            <div class="col-xs-12 text-center">
                <br>
                <a class="btn btn-primary">Scan QR Code</a>
            </div>
        </div>
    </div>
</div>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <h2>On Route</h2>
                <h3>From:</h3>
                <h3>To:</h3>
                <p>Please take note of your surroundings and follow the directions given
                    on the map!</p>
                <a class="btn btn-primary">Previous Waypoint</a>
            </div>
        </div>
    </div>
</div>
</body>

</html>
