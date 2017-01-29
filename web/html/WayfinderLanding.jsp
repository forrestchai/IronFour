<%@ page import="WayfinderDBController.RouteDA" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="WayfinderModel.Route" %>
<%@ page import="WayfinderDBController.WaypointDA" %>
<%@ page import="WayfinderModel.Waypoint" %>

<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/14/2016
  Time: 12:14 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

//    RouteDA rda = new RouteDA();
//    ArrayList<String> routeIDList = RouteDA.getDummyRoute1();
//    ArrayList<Route> routeList = rda.getRouteList(routeIDList);
//    ArrayList<String> waypointIDList = WaypointDA.getDummyWaypoint1();
//    ArrayList<Waypoint> waypointList = WaypointDA.getWaypointList(waypointIDList);
//
//    session.setAttribute("routeList", routeList);
//    session.setAttribute("waypointList", waypointList);
//
//    session.setAttribute("startPoint", waypointList.get(0));
//    session.setAttribute("endPoint", waypointList.get(waypointList.size()-1));
//    ArrayList<Route> allRouteList = RouteDA.getAllRoute();
//    ArrayList<Waypoint> allWaypointList = WaypointDA.getAllWaypoint();
//
//    session.setAttribute("allRouteList", allRouteList);
//    session.setAttribute("allWaypointList", allWaypointList);

    ArrayList<Waypoint> allWaypointList = WaypointDA.getAllWaypoint();

    session.setAttribute("allWaypointList", allWaypointList);

%>
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="..\css\qq.css" rel="stylesheet" type="text/css">
    <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">
</head><body>
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
                    <a href="#">Wayfinder</a>
                </li>
                <li>
                    <a href="#">Diabetes Monitor</a>
                </li>
                <li>
                    <a href="#">Virtual Chat</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="cover">
    <div class="cover-image" style="background-image : url('https://unsplash.imgix.net/photo-1422728221357-57980993ea99?w=1024&amp;q=50&amp;fm=jpg&amp;s=b4a34018d745e33048bcfc326cb9907b')"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center">
                <h1 class="text-inverse" contenteditable="true">Wayfindr</h1>
                <p class="text-inverse">Find your own way.</p>
                <br>
                <br>
                <a class="btn btn-lg btn-primary" href="WayfinderStep1.jsp">Begin Your Journey<br></a>
            </div>
        </div>
    </div>
</div>


</body></html>