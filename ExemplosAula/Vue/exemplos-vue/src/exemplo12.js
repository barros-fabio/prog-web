// Pagina 1 Component
var Pagina1 = Vue.extend({
    template: `
    	<div class="foo">
      		<h5>Estamos em {{ propriedade }}!</h5>
      		<a v-link="{path: 'pagina1/teste'}">Teste de Sub-Rota</a>
      		<router-view :propriedade="propriedade"></router-view> 
    	</div>
    `, 
    props: ['propriedade'],
    ready: function(){
    	this.propriedade = 'Página A';
    }, 
})

var Teste = Vue.extend({
    template: '<h5>Estou em Sub-Rota de Pagina 1</h5>', 
})

// Pagina 2 Component
var Pagina2 = Vue.extend({
    template: "<p>Estou na {{propriedade}} | parametros: {{ parametros }}</p>",
    // Configurações de rota de acordo com o plugin vue-router
    route: {
    	// Aqui é possível receber a data da rota
    	data: function (data) {
    		// Apenas mostra no console os dados.
    		console.log(data.to.params);
    		// Outra maneira de pegar os dados. Uso no ready ou outro método
    		this.parametros = this.$route.params.id;
    	},
    	// Evento após a rota ser ativada
        activate: function(){ 
            console.log("Pagina 2 ativadA!");
        }, 
        // Verifica se a rota pode ser ativivada
        canActivate: function(transition){
        	// Se o parametro for = 125, não deixa ativar
        	if( transition.to.params.id == 125 ){
        		transition.abort();
        		alert("Erro!!!");
        	}
        	// Caso contrario deixa ativar a rota.
        	else 
        		transition.next();
        }
    },
    // Dados do componente
    data: function() {
    	return {
    		parametros: ''
    	}
    },
    // Propriedades que queremos sincronizar
    // Neste caso sincronizamos 'propriedade' com 'teste' no main
    props: ['propriedade'],
    // Função ready que muda o valor de propriedade no Loading
    ready: function(){
    	this.propriedade = "Página B";
    }
})

// Componente Base, é o root da APP (Vue Instância)
var App = Vue.extend({
    data: function(){
        return {
            titulo: 'Página Inicial'
        }
    }
})

// Gera um novo Router (Global)
var router = new VueRouter({hashbang: false})

// Mapeia as rotas aos componentes
router.map({
    '/pagina1': {
        component: Pagina1, 
        subRoutes: {
	    	'/teste': {
	        	// Teste será renderizado dentro de Pagina1 no <router-view>
	        	// quando /pagina1/teste está na URL
	        	component: Teste,
	      	},
	    }
    },
    '/pagina2/:id': {
    	name: 'pagina2',
        component: Pagina2
    }
})

// Start the app
router.start(App, '#app')