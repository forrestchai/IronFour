<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 1/29/2017
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>HTML5 Demo: getUserMedia (Treehouse Blog)</title>
    <link rel="stylesheet" href="style.css">

    <style>
        body {
            background: #F7F7F7;
            margin: 0;
            padding: 0;
        }

        #video-container {
            margin: 2em auto 0;
            width: 500px;
            padding: 2em;
            background: white;
            -webkit-box-shadow: 0 1px 10px #D9D9D9;
            -moz-box-shadow: 0 1px 10px #D9D9D9;
            -ms-box-shadow: 0 1px 10px #D9D9D9;
            -o-box-shadow: 0 1px 10px #D9D9D9;
            box-shadow: 0 1px 10px #D9D9D9;
        }
    </style>

    <script>
        window.onload = function() {

            // Normalize the various vendor prefixed versions of getUserMedia.
            navigator.getUserMedia = (navigator.getUserMedia ||
            navigator.webkitGetUserMedia ||
            navigator.mozGetUserMedia ||
            navigator.msGetUserMedia);

            if (navigator.getUserMedia) {
                // Request the camera.
                navigator.getUserMedia(
                    // Constraints
                    {
                        video: true
                    },

                    // Success Callback
                    function(localMediaStream) {
                        // Get a reference to the video element on the page.
                        var vid = document.getElementById('camera-stream');

                        // Create an object URL for the video stream and use this
                        // to set the video source.
                        vid.src = window.URL.createObjectURL(localMediaStream)
                    },

                    // Error Callback
                    function(err) {
                        // Log the error to the console.
                        console.log('The following error occurred when trying to use getUserMedia: ' + err);
                    }
                );

            } else {
                alert('Sorry, your browser does not support getUserMedia');
            }


        }
    </script>

</head>
<body>
<div id="video-container">
    <video id="camera-stream" width="500" autoplay></video>
</div>
<script src="script.js"></script>
</body>
</html>