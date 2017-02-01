<%@ page import="WayfinderDBController.WaypointDA" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="WayfinderModel.Waypoint" %>
<%@ page import="WayfinderDBController.RouteDA" %>
<%@ page import="WayfinderModel.Path" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/13/2016
  Time: 10:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

//    ArrayList<String> routeIDList = RouteDA.getDummyRoute2();
//    RouteDA rd = new RouteDA();
//    ArrayList<Path> pathList =rd.getRouteList(routeIDList);
//    ArrayList<String> waypointIDList = WaypointDA.getDummyWaypoint2();
//    ArrayList<Waypoint> waypointList = WaypointDA.getWaypointList(waypointIDList);
//
//    waypointList.add(3, new Waypoint("","","",false,false));
//
//
//    session.setAttribute("pathList", pathList);
//    session.setAttribute("waypointList", waypointList);
%>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="..\css\qq.css" rel="stylesheet" type="text/css">
    <script type="text/javascript">
        var x;
        function setAOC(x){
            if(x>1){
                document.getElementById('aoc').innerHTML = Waypoint;            }
            else{
                document.getElementById('aoc').innerHTML = Route;
            }
        }
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
                <h1 class="text-center">Feedback</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 text-center">
                <p class="text-center">Give us some feedback on the waypoint's issues that you have experienced.
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    <br>
                </p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <h2>Location:</h2>
                <h3>Cardiology Department</h3>
            </div>
        </div>
    </div>
</div>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-right">
                <h3 class="text-left">Inaccessible</h3>
                <p class="text-left">Was the area blocked, or the QR code inaccessible to you?</p>
                <a class="btn btn-primary">Send Feedback</a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 text-right">
                <h3 class="text-left">Area Busy</h3>
                <p class="text-left">Is the area around the QR code too busy and/or crowded?</p>
                <a class="btn btn-primary">Send Feedback</a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 text-right">
                <h3 class="text-left">Missing QR Code</h3>
                <p class="text-left">Is the QR code missing, damaged or lost?</p>
                <a class="btn btn-primary">Send Feedback</a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 text-right">
                <h3 class="text-left">Hard to find QR Code</h3>
                <p class="text-left">Have you experienced a hard time finding the QR code, is it placed in
                    an inconvenient location?</p>
                <a class="btn btn-primary">Send Feedback</a>
            </div>
        </div>
    </div>
</div>
</body>

</html>
