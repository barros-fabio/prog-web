new Vue({
  el: '#app',
  
  data: {
  	url: 'http://content.guardianapis.com/search?section=business&api-key=test', 
  	noticias: []
  }, 

  methods: {
  	load: function(){
      	this.$http.get(this.url).then(
      		function(response) {
      			this.noticias = response.data.response.results;
      		}, 
      		function(error){
      			console.log('Ocorreu um erro!');
      		}
      	);
  	}
  }
})


