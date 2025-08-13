let botones = document.querySelectorAll(".acciones button");
botones.forEach(function(boton){
    let likes = 0;
    boton.addEventListener("click", function(){
        likes++;
        let contador = boton.closest(".acciones").querySelector(".contador");
        contador.textContent = likes + "like(s)";
        let nombreAutor = boton.closest(".seg, .ter, .cuar").querySelector(".nombres").textContent.trim();
        alert("Te gustó la definición de " + nombreAutor);
    });
});