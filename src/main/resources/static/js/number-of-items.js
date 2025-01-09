function getnumberOfEntities() {
    let cart = JSON.parse(localStorage.getItem('cart')) || [];
    let input = document.getElementById('inputItems');
    input.value = parseInt(cart.length);
}

function submitForm() {
    getnumberOfEntities();
    var form = document.getElementById("myForm");
    form.submit();
}