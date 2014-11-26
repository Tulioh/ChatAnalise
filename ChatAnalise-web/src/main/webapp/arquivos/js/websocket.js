var socket;
var $dataHora, $nomeUsuario, $texto;
var $janelaDoChat;

function conectarAoServidor(  ) {
    socket = new WebSocket("ws://0.0.0.0:8080/analise/chat");
    socket.onmessage = onMessageReceived;
}

function enviarMensagem() {
    var msg = '{ "dataHora":"' + $dataHora.val() + '", ' +
                '"nomeUsuario":"' + $nomeUsuario.val() + '", ' +
                '"mensagem":"' + $message.val() + '" }';
    socket.send( msg );
    $message.val("").focus();
}

function receberMensagem(evt) {
    var msg = JSON.parse( evt.data );
    var $linhaMensagem = $('');
}

