# cardio-phonegap
Phonegap plugin for card.io


# How to use

```javascript

function scanCard(){
    	window.plugins.CardIOPlugin.scan(this.onChargeCardCardIOComplete, 
    		function(){
    			console.log("card.io scan cancelled");
    		}
    	);
  }
  
  //If OS is iOS
  function onChargeCardCardIOComplete(response){
    		cardNumber=response['card_number'];

    		if(typeof response['expiry_month'] != 'undefined' && response['expiry_month']!=null){
    			validMonthresponse['expiry_month'];
    		}

    		if(typeof response['expiry_year'] != 'undefined' && response['expiry_year']!=null){
    			validYear=response['expiry_year'];
    		}

    		if(typeof response['cvv'] != 'undefined' && response['cvv']!=null){
    			cvcCode=response['cvv'];
    		}
    }
    
    //If OS is Android
    function onChargeCardCardIOComplete(response){
    		cardNumber= response[0].card_number;
    		
    		if(typeof response[0].expiry_month != 'undefined' && response[0].expiry_month!=null){
    			validMonth=response[0].expiry_month;
    		}

    		if(typeof response[0].expiry_year != 'undefined' && response[0].expiry_year!=null){
    			validYear=response[0].expiry_year;
    		}

    		if(typeof response[0].cvv != 'undefined' && response[0].cvv!=null){
    			cvcCode=response[0].cvv;
    		}
    }
```
