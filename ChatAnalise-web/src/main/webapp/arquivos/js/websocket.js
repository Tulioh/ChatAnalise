var socket;
var $nomeUsuario, $conteudoMensagem, $tipoMensagem, $janelaDoChat;

$(document).ready(function() {
    $nomeUsuario = $("#nome");
    $conteudoMensagem = $("#conteudoMensagem");
    $janelaDoChat = $("#janelaChat");
});

$("#entrar").click(function() {
    $("#entrando").hide();
    $("#chat").show();
    conectarAoServidor();
});

function conectarAoServidor() {
    socket = new WebSocket("ws://localhost:8080/chat");
    
    socket.onopen = function() {
        socket.onmessage = receberMensagem;
    };
}

function enviarMensagem() {
    var tipoMensagem = $("#chat input[type='radio']:checked").val();
    
    var msg = '{ "dataHora":"' + new Date().getTime() + '", ' +
                '"nomeUsuario":"' + $nomeUsuario.val() + '", ' +
                '"conteudoMensagem":"' + $conteudoMensagem.val() + '", ' +
                '"tipoMensagem":"' + tipoMensagem + '" }';
    socket.send( msg );
    $conteudoMensagem.val("").focus();
}

function receberMensagem(evt) {
    var msg = JSON.parse( evt.data );
    var $linhaMensagem = $('<tr><td class="received">' + msg.dataHora
				+ '</td><td class="user label label-info">' + msg.nomeUsuario
				+ '</td><td class="message badge">' + msg.conteudoMensagem
				+ '</td></tr>');
    $janelaDoChat.append( $linhaMensagem );
}
