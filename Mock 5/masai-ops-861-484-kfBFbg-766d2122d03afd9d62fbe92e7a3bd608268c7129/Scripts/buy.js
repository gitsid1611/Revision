// you can write your js code here

let data=JSON.parse(localStorage.getItem("buy-list"))||[];

display(data);

function display(data){
      

    document.querySelector("tbody").innerHTML=null;

    data.forEach(function(element,index){

        let row=document.createElement("tr");

        let td1=document.createElement("td");
        td1.innerText=element.name;

        let td2=document.createElement("td");
        td2.innerText=element.author;

        let td3=document.createElement("td");
        td3.innerText=element.desc;

        let td4=document.createElement("td");
        td4.innerText=element.dat;


        let td5=document.createElement("td");
        td5.innerText=element.cat;

        let td6=document.createElement("td");
        td6.innerText=element.price;
      
        row.append(td1,td2,td3,td4,td5,td6);
        document.querySelector("tbody").append(row);
    })
  
   
}