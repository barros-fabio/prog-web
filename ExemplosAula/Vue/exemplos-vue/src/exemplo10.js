// Criamos um componente global, de nome like
Vue.component('like', {
	// Adicionamos um template
	template: `
		<button class="btn btn-{{tipo}}" @click="contador">
			{{ texto }} ({{ likes }})
		</button>
	`,
	// Então adicionamos a data. Para reusar, retornamos o valor
	data: function() {
		return { likes: 0 }
	},
	// E podemos adicionar propriedades (atributos)
	props: ['texto', 'tipo'], 
	// E metodos específicos do componente
	methods: {
		contador: function(){
			this.likes += 1;
		}
	}
});

new Vue({
  el: '#app',
  data: {
  	ok: 'primary'
  }
})


