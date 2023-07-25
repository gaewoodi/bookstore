const tabList = document.querySelectorAll('.tab-menu .list li');
        
for(let i = 0; i < tabList.length; i++){
    tabList[i].querySelector('.btn').addEventListener('click', function(e){
    e.preventDefault();
    for(let j = 0; j < tabList.length; j++){
        tabList[j].classList.remove('button1-wrap');
    }
    this.parentNode.classList.add('button1-wrap');
    });
}

for(let i=0; i<tabList.length; i++) {
    tabList[i].querySelector('.btn').addEventListener('click', function(e) {
        e.preventDefault();

        for(let j=0; j<tabList.length; j++) {
            tabList[j].classList.remove();
        } 
    });
}