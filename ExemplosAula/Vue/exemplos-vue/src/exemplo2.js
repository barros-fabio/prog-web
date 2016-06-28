new Vue({
	el: '.container', 
	
	data: {
		hello: 'Olá Mundo!'
	}, 

	// Ao carregar a página
	ready: function(){
		// Mostra o ID do elemento .container
		console.log(this.$el.id);
	}
});