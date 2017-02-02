<%@ page import="java.util.ArrayList" %>
<%@ page import="WayfinderModel.Path" %>
<%@ page import="WayfinderModel.Waypoint" %>
<%@ page import="WayfinderDBController.WaypointDA" %>
<%@ page import="WayfinderDBController.RouteDA" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/14/2016
  Time: 12:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Waypoint startPoint = (Waypoint) session.getAttribute("startPoint");
    Waypoint endPoint = (Waypoint) session.getAttribute("endPoint");

%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="..\css\qq.css" rel="stylesheet" type="text/css">
    <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">

    <script>
        function displayList(listName) {
            var i;
            var x = document.getElementsByClassName("city");
            for (i = 0; i < x.length; i++) {
                x[i].style.display = "none";
            }
            document.getElementById(listName).style.display = "block";
        }
    </script>

    <style>
        .routeLists{
            width: 95%;
            border-color: gainsboro;
        }
    </style>

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
                    <a href="#">Contacts</a>
                </li>
                <li>
                    <a href="#">Contacts</a>
                </li>
                <li>
                    <a href="#">Contacts</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1 class="text-center">Step 3: Confirmation</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <p class="text-center">Confirm your starting location and your ending location</p>
            </div>
        </div>
    </div>
</div>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-sm-4">
                <h4 class="text-center">From</h4>
                <h1 class="text-center"><%=session.getAttribute("orgName")%></h1>
            </div>
            <div class="col-sm-4">
            </div>
            <div class="col-sm-4">
                <h4 class="text-center">To</h4>
                <h1 class="text-center"><%=session.getAttribute("destName")%></h1>
            </div>
        </div>
    </div>
</div>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h3>Route Preference</h3>
                <hr>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <ul class="nav nav-justified nav-pills" style="border: 2px; border-color: gainsboro; margin-bottom: 10px;">
                    <li id="landmarks"><a href="#" onclick="displayList('bestRouteList')">Best Route</a></li>
                    <li id="wards"><a href="#" onclick="displayList('accessList')">Accessibility route</a></li>
                </ul>

                <div id="bestRouteList" class="city" >
                    <ul class="list-group">
                        <h2>Best Route</h2>
                        <p>The route is calcluated to be the most straightforward and least crowded based on past data.</p>
                        <%--<%--%>
                            <%--for (int i=0;i<waLa.size();i++) {--%>
                                <%--String name = (String) waLa.get(i).getName();--%>
                                <%--String id = (String) waLa.get(i).getId();--%>
                        <%--%>--%>
                        <%--<li class="list-group-item"><a href="http://localhost:8080/selectDestination?name=<%=name%>&id=<%=id%>"><%=name%></a></li>--%>
                        <%--<%}%>--%>
                    </ul>
                </div>

                <div id="accessList" class="city" style="display:none" >
                    <ul class="list-group">
                        <h2>Accessibility Route</h2>
                        <p>This route is designed to aid those with accessibilities to find their way with ease.</p>
                        <li class="list-group-item routeLists"><h4>Ward 6</h4><p>Adjoining Wards 5, 6, 7, 8</p></li>
                        <li class="list-group-item routeLists">Ward 7</li>
                        <li class="list-group-item routeLists">Ward 7</li>
                        <li class="list-group-item routeLists">Ward 7</li>
                        <%--<%--%>
                        <%--for (int i=0;i<waLa.size();i++) {--%>
                        <%--String name = (String) waLa.get(i).getName();--%>
                        <%--String id = (String) waLa.get(i).getId();--%>
                        <%--%>--%>
                        <%--<li class="list-group-item"><a href="http://localhost:8080/selectDestination?name=<%=name%>&id=<%=id%>"><%=name%></a></li>--%>
                        <%--<%}%>--%>
                    </ul>
                </div>

            </div>
        </div>
    </div>
</div>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 text-center"><a class="btn btn-primary">Confirm</a></div>
        </div>
    </div>
</div>



</body></html>