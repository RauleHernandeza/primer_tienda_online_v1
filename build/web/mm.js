const btn = document.querySelector('.toggle-btn');
var boton = document.getElementById("boton");
var boton2 = document.getElementById("boton2");
var boton3 = document.getElementById("boton3");
var boton4 = document.getElementById("boton4");
var boton5 = document.getElementById("boton5");
var t1=0;
var t2=0;
var t3=0;
var total=0;
var cont=true;
var cont2=true;
var cont3=true;

btn.addEventListener('click', function(){
    document.getElementById('sidebar').classList.toggle('pp');
});

boton3.addEventListener('click', function(){
    document.getElementById('as').classList.toggle('d');
    document.getElementById('ass').classList.toggle('d1');
    if(cont3){
       t3=1000;
       cont3=false;
       console.log(t3);
    }
    else{
        t3=0;
        cont3=true;
        console.log(t3);
    }
});

boton.addEventListener('click', function(){
    document.getElementById('ds').classList.toggle('k');
    document.getElementById('dss').classList.toggle('k1');
       if(cont){
       t1=1300;
       cont=false;
       console.log(t1);
    }
    else{
        t1=0;
        cont=true;
        console.log(t1);
    }
});

boton2.addEventListener('click', function(){
    document.getElementById('ps').classList.toggle('s');
    document.getElementById('pss').classList.toggle('s1');
       if(cont2){
       t2=1200;
       cont2=false;
       console.log(t2);
    }
    else{
        t2=0;
        cont2=true;
        console.log(t2);
    }
});

boton4.addEventListener('click', function(){
    document.getElementById('sidebar').classList.toggle('pp');
    total=t1+t2+t3;
    console.log(total);
});

boton5.addEventListener('click', function(){
    total=t1+t2+t3;
    console.log(total);
});
