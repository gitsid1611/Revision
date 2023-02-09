// you can write your js code here

let data=JSON.parse(localStorage.getItem("book-list"))||[];

let showBuy=JSON.parse(localStorage.getItem("buy-list"))||[];

let showBookmark=JSON.parse(localStorage.getItem("bookmark-list"))||[];



display(data);


let purc=[];
let addd=[];

function display(data){
    let elements=document.querySelector("#book-count");
    console.log(elements);
elements.innerText=data.length;
   
    document.querySelector("tbody").innerHTML="";
    data.forEach(function(elem,index){
        let row=document.createElement("tr");

        let td1=document.createElement("td");
        td1.innerText=elem.name;

        let td2=document.createElement("td");
        td2.innerText=elem.author;

        let td3=document.createElement("td");
        td3.innerText=elem.desc;

        let td4=document.createElement("td");
        td4.innerText=elem.dat;

        let td5=document.createElement("td");
        td5.innerText=elem.cat;
       
        let td6=document.createElement("td");
        td6.innerText="Buy";

        td6.addEventListener("click",function(){
            purc.push(elem);
            localStorage.setItem("buy-list",JSON.stringify(purc));

            deleteAdd(index);
           })


        let td7=document.createElement("td");
        td7.innerText="Add";


        td7.addEventListener("click",function(){
            addd.push(elem);
            localStorage.setItem("bookmark-list",JSON.stringify(addd));

            deleteAdd(index);
           })




        let td8=document.createElement("td");
        td8.innerText=elem.price;

       

       

        row.append(td1,td2,td3,td4,td5,td6,td7,td8);
        document.querySelector("tbody").append(row);
       
    })
  
    function deleteAdd(index){
        data.splice(index,1);

        localStorage.setItem("book-list",JSON.stringify(data));
        display(data);

    }
}