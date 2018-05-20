var    hashCode = function(str){
        var hash = 0;
        if (str.length == 0) return hash;
        for (i = 0; i < str.length; i++) {
            char = str.charCodeAt(i);
            hash = ((hash<<5)-hash)+char;
            hash = hash & hash; // Convert to 32bit integer
        }
        return hash;
    }

var  Redirect = function(page){
	if(page=="billGenerator")
	location="form.html";	
	}


var BillControllerModule = (function(){
	
	var sendInfo = function(){
		axios.post('/sesion/bills', {
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

	var sendCredentials = function(){
		var passwd = hashCode(document.getElementById('passwd').value);
		axios.post('/sesion',{
								"userName":document.getElementById('userName').value,
								"passwd":passwd
		})
		.then(function(){
			callback();
			console.log("Response status: "+ response.status);
		})
		.catch(function(error){
			console.log(error);
			
		});
	
		var callback=function(){
			axios.get('/sesion/type')
			.then(function(response){
				Redirect(response.data);
			})
			.catch(function(error){
				console.log(error);
			});
		}
	}

	return {
		sendInfo: sendInfo,
		sendCredentials: sendCredentials
	};

	
})();