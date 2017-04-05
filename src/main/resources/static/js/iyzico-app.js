const vue = new Vue({
         el: '#iyzico-app',
         data: {
             search: '',
             speakers: [],
             prices:[]
         },
         created: function(){
            this.$http.get("/api/speakers")
              .then(function(response){
                this.speakers = response.data;
              });
            this.$http.get("/api/prices")
            .then(function(response){
              this.prices = response.data;
            })
         }   
})