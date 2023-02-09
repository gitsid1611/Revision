// you can write your js code here

document.querySelector("form").addEventListener("submit",gete);

let arr=JSON.parse(localStorage.getItem("book-list")) || [];

function gete(){
    event.preventDefault();
    obj={
        name:document.querySelector("#name").value,
        author:document.querySelector("#author").value,
        desc:document.querySelector('#desc').value,
        dat:document.querySelector('#added').value,
        cat:document.querySelector('#category').value, 
        price:document.querySelector('#price').value,
    }
    arr.push(obj);

    localStorage.setItem("book-list",JSON.stringify(arr));
}