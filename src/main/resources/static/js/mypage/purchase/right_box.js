let totalPrice = document.querySelector(".totalPrice");

totalPrice.textContent = 0 + "원"

function rightCheckbox() {
    const query = 'input[name="rightbox"]:checked';
    const selectedElements = document.querySelectorAll(query);
    
    let priceId = '';
    selectedElements.forEach((el) => {
        priceId += el.value + ' ';
    });
    
    console.log("priceId: " + priceId);

    const checkArray = [];

    $("input[name='rightbox']:checked").each(function(i) {
        // 체크된 것만 값을 뽑아서 배열에 push
        checkArray.push($(this).val());     
    });

    
 
    // ** 버튼 부분                                                                **//

    let minus = document.querySelector(".minus");
    let plus = document.querySelector(".plus");
    let resultElement = document.querySelector("#result");
    

    let quantity = 1;

    minus.addEventListener("click", () => {
        if(quantity > 0) {
            quantity--
            resultElement.textContent = quantity;

            for (let i = 0; i < checkArray.length; i++) {
                console.log("마이너스: " + checkArray[i]);
                let totalPriceNumber = quantity * checkArray[i];
                totalPrice.textContent = totalPriceNumber.toLocaleString() + "원";
            }
          
            // let totalPriceNumber = quantity * priceId;
            // totalPrice.textContent = totalPriceNumber.toLocaleString() + "원";

        }else {
            totalPrice.textContent = 0 + "원"
        }

    });

    plus.addEventListener("click", () => {
        quantity++
        resultElement.textContent = quantity;

        for (let i = 0; i < checkArray.length; i++) {
            console.log("플러스: " + checkArray[i]);
            let totalPriceNumber = quantity * checkArray[i];
            totalPrice.textContent = totalPriceNumber.toLocaleString() + "원";
        }

    });

    // plus.addEventListener("click", () => {
    //     quantity++
    //     resultElement.textContent = quantity;

    //     let totalPriceNumber = quantity * checkArray;
    //     totalPrice.textContent = totalPriceNumber.toLocaleString() + "원";

    // });
}
