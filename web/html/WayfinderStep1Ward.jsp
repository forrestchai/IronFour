<%@ page import="WayfinderModel.Waypoint" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="WayfinderDBController.WaypointDA" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="..\css\qq.css" rel="stylesheet" type="text/css">
    <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">
    <style>

        #myInput {
            background-image: url('/css/searchicon.png'); /* Add a search icon to input */
            background-position: 10px 12px; /* Position the search icon */
            background-repeat: no-repeat; /* Do not repeat the icon image */
            width: 100%; /* Full-width */
            font-size: 16px; /* Increase font-size */
            padding: 12px 20px 12px 40px; /* Add some padding */
            border: 1px solid #ddd; /* Add a grey border */
            margin-bottom: 12px; /* Add some space below the input */
        }

        #myUL {
            /* Remove default list styling */
            list-style-type: none;
            padding: 0;
            margin: 0;
        }

        #myUL li a {
            border: 1px solid #ddd; /* Add a border to all links */
            margin-top: -1px; /* Prevent double borders */
            background-color: #f6f6f6; /* Grey background color */
            padding: 12px; /* Add some padding */
            text-decoration: none; /* Remove default text underline */
            font-size: 18px; /* Increase the font-size */
            color: black; /* Add a black text color */
            display: block; /* Make it into a block element to fill the whole list */
        }

        #myUL li a.header {
            background-color: #e2e2e2; /* Add a darker background color for headers */
            cursor: default; /* Change cursor style */
        }

        #myUL li a:hover:not(.header) {
            background-color: #eee; /* Add a hover effect to all links, except for headers */
        }

    </style>
    <%
        ArrayList<Waypoint> allWaypointList = WaypointDA.getAllWaypoint();

        session.setAttribute("allWaypointList", allWaypointList);
        ArrayList<String>waypointNames = new ArrayList<String>();
        ArrayList<String>waypointId = new ArrayList<String>();

        for(int i=0; i<3; i++){
            waypointNames.add(allWaypointList.get(i).getName());
            waypointId.add(allWaypointList.get(i).getId());
        }

    %>

    <script type="text/javascript">

        window.setTimeout(function() {
            window.alert(5 + 6);
            document.write(5 + 6);
            alert("hello world");
        }, 0);

        $(document).ready(function() {
            $("#myUL").append('<li><a href="/user/messages"><span class="tab">Message Center</span></a></li>');
            var ul = document.getElementById("myUL");
            var li = document.createElement("li");
            li.appendChild(document.createTextNode("<%= waypointNames.get(0)%>"));
            ul.appendChild(li);
            alert("hello world");
        });

        function addLocation() {

            var ul = document.getElementById("myUL");
            var li = document.createElement("li");
            li.appendChild(document.createTextNode("<%= waypointNames.get(0)%>"));
            ul.appendChild(li);
            alert("hello world");
            <%--li.removeChild(li.childNodes[0]);--%>
            <%--li.appendChild(document.createTextNode("<%= waypointNames.get(1)%>"));--%>
            <%--ul.appendChild(li);--%>
            <%--li.removeChild(li.childNodes[0]);--%>
            <%--li.appendChild(document.createTextNode("<%= waypointNames.get(2)%>"));--%>
            <%--ul.appendChild(li);--%>
            <%--li.removeChild(li.childNodes[0]);--%>


            for (i = 0; i < 3; i++) {
                var array = [];
                array.push(<%=allWaypointList.get(1)%>);
            }

            for (i = 0; i < 3; i++) {

            }
        }

        function displayFilter() {
            document.write(5 + 10);
            var input, filter, ul, li, a, i;
            input = document.getElementById('myInput');
            filter = input.value.toUpperCase();
            ul = document.getElementById("myUL");
            li = ul.getElementsByTagName('li');

            for (i = 0; i < li.length; i++) {
                a = li[i].getElementsByTagName("a")[0];
                if (a.innerHTML.toUpperCase().indexOf(filter) > -1) {
                    li[i].style.display = "";
                } else {
                    li[i].style.display = "none";
                }
            }
        }
    </script>

</head>
<body onload="addLocation();">

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
                <h3 class="text-center">Wards / Consultation rooms</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <p class="text-center">Search for a ward or a room that you know</p>
            </div>
        </div>
    </div>
</div>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <input type="text" id="myInput" onkeyup="displayFilter()" placeholder="Search for wards/rooms..">
                <ul id="myUL">
                    <li>asdas</li>
                    <li>asdas</li>
                    <li>asdas</li>
                    <li>asdas</li>
                </ul>
            </div>
        </div>
    </div>
</div>





</body>
</html>