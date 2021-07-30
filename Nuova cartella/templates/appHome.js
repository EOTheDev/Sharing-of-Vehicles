let slidePosition = 0;
const slides = document.getElementsByClassName('carousel slide');
const totalSlides = slides.length;

var classi=[]
  classi.push(document.getElementsByClassName('carousel-control-next')) 
 classi.forEach(element => {
     element.onclick=moveToNextSlide
     console.log('classi')
    /* element.addEventListener("click", function() {

        moveToNextSlide();
    })*/
 });
 
var avanti = document.getElementById('bottoneAvanti')
avanti.addEventListener('click', function(){
    moveToPreviousSlide();

})
/*
document.getElementsByClassName('carousel-control-prev').addEventListener("click", function() {
    moveToPreviousSlide();
})
*/
var classiprecedenti=[]
  classiprecedenti.push(document.getElementsByClassName('carousel-control-prev')) 
 classiprecedenti.forEach(element => {
    
     element.onclick=moveToPreviousSlide;
     console.log('classi')
    /* element.addEventListener("click", function() {

        moveToNextSlide();
    })*/
 });
 

/*controlla bene i tag*/
function updateSlidePosition () {
   var carosello = document.getElementById('caroselloCentrale')
   carosello.innerHTML=slides[slidePosition]




}

function moveToNextSlide() {
    console.log('nextslide')
    if(slidePosition == totalSlides - 1) {
        slidePosition = 0;
    } else {
        slidePosition++;
    }
    updateSlidePosition();
}

function moveToPreviousSlide() {
    
    if(slidePosition == 0) {
        slidePosition = slides.length;
    } else {
        slidePosition--;
    }
    updateSlidePosition();
}