/**
 * Created by PawandeepSingh on 13/12/16.
 */
// Compatibility shim
navigator.getUserMedia = navigator.getUserMedia || navigator.webkitGetUserMedia || navigator.mozGetUserMedia;


// PeerJS object
var peer = new Peer('12345',{ key: '3dlfqs1r2s79o1or', debug: 3});


peer.on('open', function()
{
    // display id to connect

    // alert(peer.id);

});

// Receiving a call
peer.on('call', function(call)
{
    // Answer the call automatically (instead of prompting user) for demo purposes
    call.answer(window.localStream);
    step3(call);
});

// Click handlers setup
$(function()
{
    //button clicked
    $('#make-call').click(function()
    {
        // Initiate a call!
        //id of person you are calling
        var call = peer.call($('#callto-id').val(), window.localStream);

        step3(call); // to set up call
    });

    //to end the call
    $('#end-call').click(function(){
        window.existingCall.close();
//                step2();
    });


//            // Retry if getUserMedia fails
//            $('#step1-retry').click(function(){
//                $('#step1-error').hide();
//                step1();
//            });

    // Get things started
    step1();
});


function step1 () {

    if(navigator.getUserMedia)
    {
        navigator.getUserMedia({audio: true, video: true}, function(stream)
        {


            // Set your video displays
            //id to your videocam



            $('#my-video').prop('src', URL.createObjectURL(stream));

            window.localStream = stream;


//                step2();
            //in case of error
        }, function(){ alert("Fail to Access Camera and mic , try again"); });
    }
    // Get audio/video stream

}

function step3 (call)
{
    // Hang up on an existing call if present
    //if already got call , hang up
    if (window.existingCall) {
        window.existingCall.close();
    }

    // Wait for stream on the call, then set peer video display
    call.on('stream', function(stream)
    {
        //person videocam you are calling to
        $('#their-video').prop('src', URL.createObjectURL(stream));
    });

    // UI stuff
    window.existingCall = call;
    $('#their-id').text(call.peer);


    // to end call , when either party ends it
    call.on('close', function()
    {
        alert("call ended");
    });
//            $('#step1, #step2').hide();
//            $('#step3').show();
}


