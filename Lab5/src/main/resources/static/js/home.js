const prodDiv = document.getElementById("products");
const addProductButton = document.getElementById("addProductButton");
const deleteProductButton = document.getElementById("deleteProductButton");

refreshProducts();

function refreshProducts() {
    fetch('/api/v1/products/')
        .then(response => response.json())
        .then(data => showProducts(data));
}

function showProducts(products) {
    // Also, useful to see difference between imperative programming in Vanilla JS vs declarative in REACT
    prodDiv.innerHTML = "";
    for (let i = 0; i < products.length; i++) {
        let addedProd = document.createElement("div");
        addedProd.innerHTML = `${products[i].id} ${products[i].name} ${products[i].price}`
        prodDiv.appendChild(addedProd);
    }
}

addProductButton.onclick = () => {
    // create a product JSON from the inputs
    const product = {
        name: document.getElementById("name").value,
        price: document.getElementById("price").value
    }
    // post the product to the api
    fetch('/api/v1/products/', {
        method: "POST",
        body: JSON.stringify(product),
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then(response => response.json())
        .then(data => showProducts(data))
        .then(refreshProducts());
}
// TODO 5 FETCH POST request to api/v1/products/ containing the new product, then call refreshProducts

// TODO 6 delete product
deleteProductButton.onclick = () => {
    // post the product to the api
    const pid = document.getElementById("deleteID").value
    fetch('/api/v1/products/' + pid, {
        method: "DELETE",
        body: JSON.stringify(pid)
    })
        .then(refreshProducts());
}
// TODO 7 modify product

