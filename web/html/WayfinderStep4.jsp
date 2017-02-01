<%@ page import="java.util.ArrayList" %>
<%@ page import="WayfinderDBController.RouteDA" %>
<%@ page import="WayfinderModel.Path" %>
<%@ page import="WayfinderModel.Waypoint" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12/13/2016
  Time: 9:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Path> pathList = (ArrayList) session.getAttribute("pathList");
    ArrayList<Waypoint> waypointList = (ArrayList) session.getAttribute("waypointList");
    System.out.println(session.getAttribute("current"));
%>
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="..\css\qq.css" rel="stylesheet" type="text/css">

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
                <p>Review your current location or move on!
                    <br>
                </p>
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
                <a class="btn btn-primary">Continue</a>
            </div>
        </div>
    </div>
</div>
<div class="section" style="padding-top: 0;">
    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <h2>Waypoint Reached:</h2>
                <h3>Cardiology Department</h3>
                <br>
                <a class="btn btn-primary">Leave Feedback</a>
                <br>
                <br>
                <a class="btn btn-primary">Change Destination</a>
                <br>
                <br>
                <a class="btn btn-primary">End Wayfinding</a>
            </div>
        </div>
    </div>
</div>
</body>

</html>