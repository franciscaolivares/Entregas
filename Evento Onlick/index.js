let btnInicio = document.querySelector(".inicio");

btnInicio.addEventListener("click",()=>{
    if(btnInicio.textContent == "Iniciar sesión"){
        btnInicio.textContent = "Cerrar sesión";
    }else {
        btnInicio.textContent = "Iniciar sesión";
    }
});


let btnoDefinicion = document.querySelector(".definicion");
btnoDefinicion.addEventListener("click",function(){
    this.remove();
});


let botonesLike = document.querySelectorAll(".like");
botonesLike.forEach(function(boton) {
    boton.addEventListener("click", function() {
        let titulo = this.closest("div").querySelector("h3").textContent;
        alert(`Te gustó la definición: ${titulo}`);
        let textoBoton = this.textContent;           
        let numeroActual = parseInt(textoBoton); 
        let nuevoNumero = numeroActual + 1;
        this.textContent = `${nuevoNumero} me gusta`;
    });
});