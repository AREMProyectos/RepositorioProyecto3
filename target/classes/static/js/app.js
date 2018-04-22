var BillControllerModule = (function(){
	
	var sendInfo = function(){
		axios.post('/bills', {
								"nameEmployee":document.getElementById('nameEmployee').value,
								"idEmployee":document.getElementById('idEmployee').value,
								"companysNit":document.getElementById('companysNit').value,
								"companysPhone":document.getElementById('companysPhone').value,
								"consumerName":document.getElementById('consumerName').value,
								"consumerId":document.getElementById('consumerId').value,
								"consumerPhone":document.getElementById('consumerPhone').value,
								"consumerEmail":document.getElementById('consumerEmail').value,
								"purchasePrice":document.getElementById('purchasePrice').value
								
							})
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