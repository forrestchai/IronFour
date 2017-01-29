<%@ page import="java.util.ArrayList" %>
<%@ page import="WayfinderDBController.RouteDA" %>
<%@ page import="WayfinderModel.Route" %>
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
    ArrayList<Route> routeList = (ArrayList) session.getAttribute("routeList");
    ArrayList<Waypoint> waypointList = (ArrayList) session.getAttribute("waypointList");
    System.out.println(session.getAttribute("current"));
%>
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script type="text/javascript">

        var counter = <%=session.getAttribute("current")%>;
        var listSize = <%=routeList.size()%>;
        function scanFunction(){

            counter++;
            var i;
            for(i = 1; i <= counter; i++)
            {
                $("li.list-group-item:nth-child("+i+")").css({
                    "background-color" : "grey",
                    "color" : "white"
                });
            }

            document.getElementById("numbercounter").innerHTML = listSize - counter;


        };

        if(listSize == 3)
        {
            $("#fourth").slideUp();
        }

            </script>
            <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
            <link href="..\css\qq.css" rel="stylesheet" type="text/css">
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
                        <h1>Step 4: Set Sail</h1>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <p>Scan the NFC tags when you see them! &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
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
                        <h2 class="text-left">Locations Remaining:<p style="display:inline-block" id="numbercounter"><%=routeList.size() - Integer.parseInt(session.getAttribute("current").toString())%>
                    <br>
                </h2>
            </div>
        </div>
        <div class="row text-left">
            <div class="col-md-6 col-md-offset-3 text-left">
                <ul class="list-group">
                    <li class="list-group-item" id="first-accordion"><p><%=waypointList.get(0).getName()%></p><p><%=routeList.get(0).getDescription()%></p></li>
                    <li class="list-group-item nf"><p><%=waypointList.get(1).getName()%></p><p><%=routeList.get(1).getDescription()%></p></li>
                    <li class="list-group-item nf"><p><%=waypointList.get(2).getName()%></p><p><%=routeList.get(2).getDescription()%></p></li>
                    <li class="list-group-item nf" id="fourth"><p><%=waypointList.size() == 4 ? waypointList.get(3).getName(): ""%></p><p><%=routeList.size() == 4 ? routeList.get(3).getDescription() : ""%></p></li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <a class="btn btn-primary" id="button-scan" onclick="scanFunction()">Scan NFC tag<br></a>
            </div>
            <div class="col-md-6">
                <a class="btn btn-primary" href="WayfinderFeedback.jsp">Feedback on location</a>
            </div>
        </div>
    </div>
</div>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <a class="btn btn-primary" href="WayfinderLanding.jsp">Back<br></a>
            </div>
        </div>
    </div>
</div>


</body></html>
