<%@ page import="java.util.ArrayList" %>
<%@ page import="WayfinderDBController.WaypointDA" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 1/31/2017
  Time: 6:03 PM
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



    <style>
        #map-canvas
        {
            margin-left: auto;
            margin-right: auto;
            width: 500px;
            height: 500px;
            border: 2px;
            border-color: #0f0f0f;
            display: block;
        }
        @media (min-width:350px)
        {
            #map-canvas
            {
                margin-left: auto;
                margin-right: auto;
                width: 350px;
                height: 350px;
                border: 2px;
                display: block;
            }
        }
        @media (min-width:1000px)
        {
            #map-canvas
            {
                margin-left: auto;
                margin-right: auto;
                width: 500px;
                height: 500px;
                border: 2px;
                display: block;
            }
        }
    </style>

    <%
        session.setAttribute("usage", "map");
        int x = (Integer) session.getAttribute("nextPoint");
        ArrayList<String> waypointIdList = (ArrayList<String>) session.getAttribute("selectedRoute");
        String org = WaypointDA.getWaypoint(waypointIdList.get(x)).getName();
        String dest = WaypointDA.getWaypoint(waypointIdList.get(x+1)).getName();
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
            <div class="col-xs-12">
                <img id="map-canvas" src="../img/generatedMap.png">
                <%--<canvas id="map-canvas"></canvas>--%>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12 text-center">
                <br>
                <a class="btn btn-primary" href="WayfinderQR.jsp">Scan QR Code</a>
            </div>
        </div>
    </div>
</div>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <h2>On Route</h2>
                <h3>From: <%=org%></h3>
                <h3>To: <%=dest%></h3>
                <p>Please take note of your surroundings and follow the directions given
                    on the map!</p>
                <a class="btn btn-primary" href="javascript:history.back()">Previous Waypoint</a>
            </div>
        </div>
    </div>
</div>
</body>

</html>
