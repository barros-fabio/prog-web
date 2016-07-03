new Vue({

	el: 'body',

	data: {
		url: 'http://content.guardianapis.com/search?api-key=test',
		sectionUrl: 'http://content.guardianapis.com/sections?api-key=test',
		paginaAtual: 1,
		radio: 'radio',
		selectedSection: 'padrao',
		currentSection: '',
		news: [],
		sections: [],
		sectionsId: []
		
	},

	watch: {
		radio: function(){
			this.$http.get('http://content.guardianapis.com/search?section='+this.radio+'&api-key=test').then(
				function(response){
					this.news = response.data.response.results; 
				},

				function(error){
					console.log("Ocorreu um erro!");
				}
		)

		},

		selectedSection: function(){

			this.$http.get('http://content.guardianapis.com/search?section='+this.selectedSection.toLowerCase()+'&api-key=test').then(

				function(response){
					this.news = response.data.response.results; 
					
				},

				function(error){
					console.log("Ocorreu um erro!");
				}
			)

		},

		nextP: function(){
			console.log("Selecionado "+this.selectedSection);
			console.log("Selecionado radio "+this.radio);
		},

		previousP: function(){
			console.log("Selecionado "+this.selectedSection);
			console.log("Selecionado radio "+this.radio);
		},

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
			
			if(this.radio!="radio" && this.selectedSection=="padrao"){
				this.$http.get('http://content.guardianapis.com/search?section='+this.radio+'&page='+this.paginaAtual+'&api-key=test').then(
					function(response){
						this.news = response.data.response.results; 
					},

					function(error){
						console.log("Ocorreu um erro!");
					}
				)			
			}else if(this.selectedSection!="padrao" && this.radio=="radio"){
				this.$http.get('http://content.guardianapis.com/search?section='+this.selectedSection+'&page='+this.paginaAtual+'&api-key=test').then(
					function(response){
						this.news = response.data.response.results; 

					},

					function(error){
						console.log("Ocorreu um erro!");
					}
				)
			}else if(this.selectedSection!="padrao" && this.radio!="radio"){
				this.$http.get('http://content.guardianapis.com/search?section='+this.radio+'&page='+this.paginaAtual+'&api-key=test').then(
					function(response){
						this.news = response.data.response.results; 
					},

					function(error){
						console.log("Ocorreu um erro!");
					}
				)
			}else if(this.radio=="radio" && this.selectedSection=="padrao"){
				this.$http.get('http://content.guardianapis.com/search?page='+this.paginaAtual+'&api-key=test').then(
					function(response){
						this.news = response.data.response.results; 

						console.log("Selecionado "+this.selectedSection);
						console.log("Selecionado radio "+this.radio);
					},

					function(error){
						console.log("Ocorreu um erro!");
					}
				)	
			}
						
		},


		previousPage: function(){
			this.paginaAtual-=1;
			
			if(this.radio!="radio" && this.selectedSection=="padrao"){
				this.$http.get('http://content.guardianapis.com/search?section='+this.radio+'&page='+this.paginaAtual+'&api-key=test').then(
					function(response){
						this.news = response.data.response.results; 
					},

					function(error){
						console.log("Ocorreu um erro!");
					}
				)			
			}else if(this.selectedSection!="padrao" && this.radio=="radio"){
				this.$http.get('http://content.guardianapis.com/search?section='+this.selectedSection+'&page='+this.paginaAtual+'&api-key=test').then(
					function(response){
						this.news = response.data.response.results; 

					},

					function(error){
						console.log("Ocorreu um erro!");
					}
				)
			}else if(this.selectedSection!="padrao" && this.radio!="radio"){
				this.$http.get('http://content.guardianapis.com/search?section='+this.radio+'&page='+this.paginaAtual+'&api-key=test').then(
					function(response){
						this.news = response.data.response.results; 
					},

					function(error){
						console.log("Ocorreu um erro!");
					}
				)
			}else if(this.radio=="radio" && this.selectedSection=="padrao"){
				this.$http.get('http://content.guardianapis.com/search?page='+this.paginaAtual+'&api-key=test').then(
					function(response){
						this.news = response.data.response.results; 

						console.log("Selecionado "+this.selectedSection);
						console.log("Selecionado radio "+this.radio);
					},

					function(error){
						console.log("Ocorreu um erro!");
					}
				)	
			}
		}
		
	},

	ready: function(){ // Executado ao carregar a aplicação
		this.load();
		this.loadSections();
		
	}

})