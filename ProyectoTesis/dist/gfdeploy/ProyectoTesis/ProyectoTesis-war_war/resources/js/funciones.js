/*JQuery para deshabilitar enter*/
$(document).keypress(
  function(event){
    if (event.which == '13') {
      event.preventDefault();
    }
});

function fn_ingresar_letras(valor){
    valor = valor.replace(/[^A-Za-z ]/g, '');
    valor = valor.toUpperCase();
    return valor;
}

function fn_ingresar_numeros(valor){
    valor = valor.replace(/[^0-9]/g, '');
    return valor;        
}
function fn_ingresar_numeros_letras(valor){
    valor = valor.replace(/[^A-Za-z0-9 ]/g, '');
    valor = valor.toUpperCase();
    return valor;
}
