const btnRemonter = document.querySelector('.remonter');

btnRemonter.addEventListener('click', () =>{
    window.scrollTo({
        top:0,
        left:0,
        behavior: "smooth"
    })
})

const btnDescendre = document.querySelector('.descendre');

btnDescendre.addEventListener('click', () =>{
    window.scrollTo({
        top:5000,
        left:0,
        behavior: "smooth"
    })
})

const contact = document.querySelector('.contact');

contact.addEventListener('click', () =>{
    window.scrollTo({
        top:5000,
        left:0,
        behavior: "smooth"
    })
})