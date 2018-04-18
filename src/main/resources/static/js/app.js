var BillControllerModule = (function(){
	
	var sendInfo = function(){
		/*axios({
			method: 'post',
			url: '/bills',
			data: {
				"id": document.getElementById('idFactura').value
			}
		})*/
		axios.post('/bills', {"id":document.getElementById('idFactura').value})
		.then(function(response){
			location.href='/response.html';
		})
		.catch(function(error){
			console.log(error);
		});
	}
	
	/*var loadResponse = function () {
		axios.get('/square?value='+window.location.search.substring(1).split('=')[1])
		.then(function(response){
			document.getElementById('response').innerHTML = response.data;
		})
		.catch(function(error){
			console.log(error);
		});
		
	} */

	return {
		sendInfo: sendInfo
	};
})();