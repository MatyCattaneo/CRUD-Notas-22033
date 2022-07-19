document.getElementById("borrar").addEventListener("click", function(e){
  console.log(e);
})

/*function borrar(){
    console.log("Borrando tarjeta");
}

function editar(){
    console.log("Editando tarjeta");
}*/

function agregar(){
    console.log("Añadiendo tarjeta");
}

const on = (element, event, selector, handler) => {
  element.addEventListener(event, e => {
    if (e.target.closest(selector)) {
        handler(e)
    }
  })
}

/*alertify.confirm("This is a confirm dialog.",
  function borrar(){
    alertify.success('Ok');
  },
  function editar(){
    alertify.error('Cancel');
  });*/ 