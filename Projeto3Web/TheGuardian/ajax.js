new Vue({

	el: 'body',

	data: {
		url: 'http://content.guardianapis.com/search?api-key=test',
		sectionUrl: 'http://content.guardianapis.com/sections?api-key=test',
		paginaAtual: 1,
		news: [],
		sections: []
	},

	methods: {
		load: function(){
			this.$http.get(this.url).then(
				function(response){
					this.news = response.data.response.results; 
				},

				function(error){
					console.log("Ocorreu um erro!");
				}
			)
		},

		loadSections: function(){
			this.$http.get(this.sectionUrl).then(
				function(response){
					this.sections = response.data.response.results; 
				},

				function(error){
					console.log("Ocorreu um erro!");
				}
			)

		},

		nextPage: function(){
			this.paginaAtual +=1;
			this.$http.get('http://content.guardianapis.com/search?page='+this.paginaAtual+'&api-key=test').then(
				function(response){
					this.news = response.data.response.results; 
				},

				function(error){
					console.log("Ocorreu um erro!");
				}
			)			
		},


		previousPage: function(){
			this.paginaAtual-=1;
			this.$http.get('http://content.guardianapis.com/search?page='+this.paginaAtual+'&api-key=test').then(
				function(response){
					this.news = response.data.response.results; 
				},

				function(error){
					console.log("Ocorreu um erro!");
				}
			)			
		}
		
	},

	ready: function(){ // Executado ao carregar a aplicação
		this.load();
		this.loadSections();
	}

})