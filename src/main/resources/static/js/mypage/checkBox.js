function selectAll() {
    const checkbox = document.getElementById("selectAll");
    const isChecked = checkbox.checked;
   
    if(isChecked) {
        AllCheck()

    }else {
        AllUnCheck()
    }
    
}

function checkboxClick() {

    const allCount = document.querySelectorAll(".check").length;
    const query = 'input[name="check"]:checked';
    const selectedElements = document.querySelectorAll(query);
    const selectedElementsCount = selectedElements.length;

    let result = '';


    selectedElements.forEach((el) => {
        result += el.value + ' ';
    });


    if(allCount == selectedElementsCount){
         document.getElementById('selectAll').checked = true;
    }

    else{
        document.getElementById('selectAll').checked = false;
    }
    

}

function AllCheck(){
    document.querySelectorAll(".check").forEach(function(v) {
        v.checked = true;
    });
}

function AllUnCheck(){
    document.querySelectorAll(".check").forEach(function(v) {
        v.checked = false;
    });
}