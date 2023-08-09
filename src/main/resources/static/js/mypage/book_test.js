


// setDisLike(bookId) {
//     let likeCount = -1;
    
//     $.ajax({
//         async: false,
//         type: "delete",
//         url: `http://localhost:8000/api/book/${bookId}/like`,
//         dataType: "json",
//         success: response => {
//             likeCount = response.data;
//         },
//         error: error => {
//             console.log(error);
//         }
//     });

//     return likeCount;
// }

// loadSearchBooks() {
//     const responseData = SearchApi.getInstance().searchBook();
//     const contentFlex = document.querySelector(".content-flex");
//     const principal = PrincipalApi.getInstance().getPrincipal();

//     const _bookButtons = document.querySelectorAll(".book-buttons");
//     const bookButtonsLength = _bookButtons == null ? 0 : _bookButtons.length;

//     console.log(responseData)
//     responseData.forEach((data, index) => {
//         contentFlex.innerHTML += `
//             <div class="info-container">
//                 <div class="book-desc">
//                     <div class="img-container">
//                         <img src="http://localhost:8000/image/book/${data.saveName != null ? data.saveName : "no_img.png"}" class="book-img">
//                     </div>
//                     <div class="like-info"><i class="fa-regular fa-thumbs-up"></i> <span class="like-count">${data.likeCount != null ? data.likeCount : 0}</span></div>
//                 </div>
                
//                 <div class="book-info">
//                     <input type="hidden" class="book-id" value="${data.bookId}">
//                     <div class="book-code">${data.bookCode}</div>
//                     <h3 class="book-name">${data.bookName}</h2>
//                     <div class="info-text book-author"><b>저자: </b>${data.author}</div>
//                     <div class="info-text book-publisher"><b>출판사: </b>${data.publisher}</div>
//                     <div class="info-text book-publicationdate"><b>출판일: </b>${data.publicationDate}</div>
//                     <div class="info-text book-category"><b>카테고리: </b>${data.category}</div>
//                     <div class="book-buttons">
                        
//                     </div>
//                 </div>
//             </div>
//         `;
   

// addClickEventCategoryCheckboxs() {
//     const checkboxs = document.querySelectorAll(".category-checkbox");

//     checkboxs.forEach(checkbox => {
//         checkbox.onclick = () => {
//             if(checkbox.checked) {
//                 searchObj.categories.push(checkbox.value);
//             }else {
//                 const index = searchObj.categories.indexOf(checkbox.value);
//                 searchObj.categories.splice(index, 1);
//             }
//             document.querySelector(".search-button").click();
//         }
//     });
// }



// addClickEventLikeButtons() {
//     const likeButtons = document.querySelectorAll(".like-buttons");
//     const bookIds = document.querySelectorAll(".book-id");
//     const likeCounts = document.querySelectorAll(".like-count");

//     likeButtons.forEach((button, index) => {
//         button.onclick = () => {
//             if(button.classList.contains("like-button")){
//                 const likeCount = SearchApi.getInstance().setLike(bookIds[index].value);
//                 if(likeCount != -1){
//                     likeCounts[index].textContent = likeCount;
//                     button.classList.remove("like-button");
//                     button.classList.add("dislike-button");
//                     button.textContent = "추천취소";
//                 }
                
//             }else {
//                 const likeCount = SearchApi.getInstance().setDisLike(bookIds[index].value);
//                 if(likeCount != -1){
//                     likeCounts[index].textContent = likeCount;
//                     button.classList.remove("dislike-button");
//                     button.classList.add("like-button");
//                     button.textContent = "추천";
//                 }
//             }
//         }
//     });
// }


// const likeButtons = document.querySelectorAll(".like-buttons");
// const bookIds = document.querySelectorAll(".book-id");
// const likeCounts = document.querySelectorAll(".like-count");

// likeButtons.forEach((button, index) => {
//     button.onclick = () => {
//         if(button.classList.contains("like-button")) {
//             let bookIdValues = bookIds[index].value;
//             let likeCount = -1;
                

//             if(likeCount != -1){
//                 likeCounts[index].textContent = likeCount;
//                 button.classList.remove("like-button");
//                 button.classList.add("dislike-button");
//                 button.textContent = "추천취소";
//             }
            
//         }
//         // else {
//         //     if(likeCount != -1){
//         //         likeCounts[index].textContent = likeCount;
//         //         button.classList.remove("dislike-button");
//         //         button.classList.add("like-button");
//         //         button.textContent = "추천";
//         //     }
//         // }

//     }

//     $.ajax({
//         type: "post",
//         url: "/like",
//         dataType: "json",
//         success : function(res) {
//             if(res.msg == "success") {
//                 alert("좋아요 성공.");
//                 location.reload();
//             }
//         },
//         error: error => {
//             console.log(error);
//         }
//     });

// });
