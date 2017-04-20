const speakersApiUrl = "/api/ticket/speakers";
const pricesApiUrl = "/api/ticket/prices";
const discountsApiUrl = "/api/ticket/discounts";
const registerApiUrl = "/api/ticket/register";
const permittedCreditCardsApiUrl = "/api/ticket/allowed/creditCards";
const permittedDebitCardsApiUrl = "/api/ticket/allowed/debitCards";
const iyzcioApiBinQueryUrl = "/api/iyzico/binQuery";


const iyzicoApp = new Vue({
         el: '#iyzico-app',
         data: {
        	 searchSpeakers: '',
        	 message : '',
        	 ticket : {
        		 nameOnTheCard : '',
        		 email : '',
        		 selectedTicketType : '',
        		 isValidDiscountCode : false,
        		 discountCodeMessage: '',
        		 discountCode: '',
        		 discountAmount: '',
        		 totalPrice: '',
        		 usedDiscountCode : {},
        		 binNumber : {},
        		 binQueryHasError : false,
        	 },
             agree : false,
             speakers: [],
             prices:[],
             discounts:[],
             permittedCreditCards : [],
             permittedDebitCards : []
             
         },
         created: function(){
            this.$http.get(speakersApiUrl)
              .then(function(response){
                this.speakers = response.data;
              });
            this.$http.get(pricesApiUrl)
            .then(function(response){
              this.prices = response.data;
            });
            this.$http.get(discountsApiUrl)
            .then(function(response){
              this.discounts = response.data;
            });
            this.$http.get(permittedCreditCardsApiUrl)
            .then(function(response){
              this.permittedCreditCards = response.data;
            });
            this.$http.get(permittedDebitCardsApiUrl)
            .then(function(response){
              this.permittedDebitCards = response.data;
            });
         },
         methods :{
        	 isNumber: function(evt) {
        	      evt = (evt) ? evt : window.event;
        	      var charCode = (evt.which) ? evt.which : evt.keyCode;
        	      if ((charCode > 31 && (charCode < 48 || charCode > 57)) && charCode !== 46) {
        	        evt.preventDefault();
        	      } else {
        	        return true;
        	      }
        	 },
        	 calculateRemaininDay: function(){
        		//Get 1 day in milliseconds
        		var oneDay=1000*60*60*24;
        		// Convert both dates to milliseconds
        		var conferenceDateMs = new Date(this.conference.conferenceDate).getTime();
        		var remainingDay = new Date().getTime();
        		
        		var differenceMs = conferenceDateMs - remainingDay;
        		
        		// Convert back to days and return
        		this.conference.reaminingDay = Math.round(differenceMs/oneDay); 
        	 },
        	 processDiscountCode: function(discountCode){
        		 this.ticket.discountCodeMessage = '';
        		 
        		 if(this.ticket.selectedTicketType == ''){
        			 this.message = "You must choose any ticket type!";
        			 $('#messageModal').modal('show');
        		 }else{
        			 var isValid = false;
        			 for(index in this.discounts){
        				 var discount = this.discounts[index];
        				 if(discount.code == discountCode){
        					 isValid = true;
        					 this.ticket.usedDiscountCode = discount;
        				 } 
        			 }
        			 
        			 this.ticket.isValidDiscountCode = isValid;
        			 if(isValid){
        				 this.ticket.discountCodeMessage = 'You can use a %' + this.ticket.usedDiscountCode.rate + ' discount.'
        			 }else{
        				 this.ticket.discountCodeMessage = 'Invalid discount code!';
        			 }
        			 
        			 this.onChangeTicketType();
        			 
        		 }
        	 },
        	 onChangeTicketType : function() {
				if(this.ticket.isValidDiscountCode){
					this.ticket.discountAmount = _.toNumber(this.ticket.selectedTicketType) * _.toNumber(this.ticket.usedDiscountCode.rate) / 100;
					this.ticket.totalPrice = this.ticket.selectedTicketType - this.ticket.discountAmount; 
				}else{
					this.ticket.totalPrice = _.toNumber(this.ticket.selectedTicketType);
				}
			},
			iyzicoBinQuery: function(event){
				event.preventDefault();
				this.message = '';
				
				if(this.ticket.cardNumber.length == 16){
					this.$http.get(iyzcioApiBinQueryUrl + "/" + this.ticket.cardNumber.substring(0,6))
					.then(function(response){
						this.ticket.binNumber = response.data;
						if(this.ticket.binNumber.status == "success"){
							this.ticket.binNumber = response.data;
							if(this.ticket.binNumber.cardType == "CREDIT_CARD"){
								if(this.permittedCreditCards.includes(this.ticket.binNumber.bankName)){
									this.message = "Congratulations! Your ticket has been registered.";
									this.ticket.binQueryHasError = false;
								}else{
									this.message = "Unsupported Bank. Please use the another one!";
									this.ticket.binQueryHasError = true;
								}
							}else if(this.ticket.binNumber.cardType == "DEBIT_CARD"){
								if(this.permittedDebitCards.includes(this.ticket.binNumber.bankName)){
									this.message = "Congratulations! Your ticket has been registered.";
									this.ticket.binQueryHasError = false;
								}else{
									this.message = "Unsupported Debit Card. You can use the only 'Halk Bankası'!";
									this.ticket.binQueryHasError = true;
								}
							}
						}else{
							this.message = "Hata detayı : " + this.ticket.binNumber.errorMessage + " Hata kodu : " + this.ticket.binNumber.errorCode;
							this.ticket.binQueryHasError = true;
						}
					});
				}else{
					this.message = "Please use the valid card!";
					this.ticket.binQueryHasError = true;
				}

				// hata yok ve işlem tamamlandı ise modal'ı da kapatalım.
				if(!this.ticket.binQueryHasError){
					if(this.ticket.isValidDiscountCode == false){
						//code yazıldı ama kullanılmadı ise register edilen bean içerisinde code gitmesin.
						this.ticket.discountCode = '';
					}
					this.$http.post(registerApiUrl, this.ticket)
						.then(function(response){
							var isTicketRegistered = Boolean(response.data);
							
							if(isTicketRegistered){
								$('#registerModal').modal('hide');
							}else{
								this.ticket.binQueryHasError = true;
								this.message = "Ticket could't be registered yet. Please try later :(";
							}
						});
				}
				$('#messageModal').modal('show');
			},
			checkIfRegistered: function(){
				
				if(!this.ticket.binQueryHasError){
					 this.ticket = {
		        		 nameOnTheCard : '',
		        		 selectedTicketType : '',
		        		 isValidDiscountCode : false,
		        		 discountCodeMessage: '',
		        		 discountCode: '',
		        		 totalPrice: '',
		        		 usedDiscountCode : {},
		        		 binNumber : {},
		        		 binQueryHasError : false,
		        	 };
					 location.reload();
				}
				
			},
			deleteDiscount: function(){
				this.ticket.isValidDiscountCode = false;
				this.ticket.discountCodeMessage = '';
				
				this.onChangeTicketType();
			}
         },
         computed: {
             filteredSpeakers(){
                 return this.speakers.filter((speaker) => {
                    return speaker.firstName.toLowerCase().includes(this.searchSpeakers.toLowerCase()); 
                 });
             }
         },
         watch: {
        	 'ticket.selectedTicketType' : { 
        		 handler: function(newVal, oldVal){
        			 this.onChangeTicketType();
        		 }
        	 },
        	 'ticket.totalPrice' : { 
        		 handler: function(newVal, oldVal){
        			 this.onChangeTicketType();
        		 }
        	 }
         }
})