var BillControllerModule = (function(){
	
	var sendInfo = function(){
		axios.post('/bills', {"id":document.getElementById('idFactura').value})
		.then(function(response){
			console.log("Response status: "+ response.status);
			document.getElementById("botonDescarga").style.visibility = "visible";
		})
		.catch(function(error){
			console.log(error);
		});
		
		var formContainer = document.getElementById("mainContainer");
		formContainer.removeChild(document.getElementById("billForm"));
		
		
		document.getElementById("tituloPrincipal").innerHTML = "Factura generada";
		document.getElementById("instruccionesPagina").innerHTML = "Para descargar de clic en el siguiente link";
	}
	

	return {
		sendInfo: sendInfo
	};
})();