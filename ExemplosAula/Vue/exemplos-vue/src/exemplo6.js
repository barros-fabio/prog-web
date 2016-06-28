new Vue({
  el: '#app',
  data: {
    todos: [
      { text: 'Learn JavaScript' },
      { text: 'Learn Vue.js' },
      { text: 'Build Something Awesome' }
    ]
  }, 

  methods: {
  	adicionar: function(){
  		this.todos.push({ text: this.tarefa });
  		this.tarefa = ''
  	}, 
  	remover: function(index){
  		this.todos.pop(index);
  	}
  }
})


