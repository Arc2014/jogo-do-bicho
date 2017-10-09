var podeLimparCampo = false;

function copiarValorPrimeiraAposta(id) {
    $(id).val($("#primeiroPremio").val());
    podeLimparCampo = true;
}

function limparCampo(id) {
    $(id).keydown(function (e) {
        if(e.keyCode !== 9 && podeLimparCampo) {// Limpa se diferente de tecla Tab
            podeLimparCampo = false;
            $(this).val("");
        }
    });
}

function setFocoNumero() {
    $( "#numero" ).focus();
}

function configurarMoeda() {
    $(".moeda").maskMoney(
        {
            thousands: '',
            decimal:'.',
            affixesStay: false
        }
    );
}

$(document).ready(function() {
    configurarMoeda();
    setFocoNumero();
    limparCampo();
});