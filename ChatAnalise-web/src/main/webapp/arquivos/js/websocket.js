var socket;
var $nomeUsuario, $texto;
var $janelaDoChat;

$(document).ready(function() {
    $nomeUsuario = $("#nome");
});

$("#entrar").click(function() {
    conectarAoServidor( $nomeUsuario.val() );
});

function conectarAoServidor( nomeUsuario ) {
    socket = new WebSocket("ws://localhost:8080/ChatAnalise-web/chat/" + nomeUsuario);
    
    socket.onopen = function() {
        socket.onmessage = receberMensagem;
        enviarMensagem();
    };
}

function enviarMensagem() {
    var msg = '{ "dataHora":"' + new Date().getTime() + '", ' +
                '"nomeUsuario":"' + $nomeUsuario.val() + '", ' +
                '"texto":"teste 01" }';
                //'"mensagem":"' + $message.val() + '" }';
    socket.send( msg );
    console.log("mensagem enviada")
    //$message.val("").focus();
}

function receberMensagem(evt) {
    var msg = JSON.parse( evt.data );
    $("#mensagemRetorno").text( msg.texto );
}
