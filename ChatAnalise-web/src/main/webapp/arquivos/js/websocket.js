var socket;
var $dataHora, $nomeUsuario, $texto;
var $janelaDoChat;

function conectarAoServidor() {
    socket = new WebSocket("ws://localhost:8080/ChatAnalise-web/chat");
    socket.onmessage = receberMensagem;
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

