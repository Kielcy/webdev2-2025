const apiBase = "http://localhost:8000/api/products"

document.addEventListener("DOMContentLoaded", fetchProducts)

function fetchProducts() {
    fetch(apiBase)
        .then(res => res.json())
        .then(products => {
            const body = document.getElementById("productTableBody")
            body.innerHTML = ""
            var counter = 0;
            products.forEach(product => {
                body.innerHTML += `
              <tr class="text-center">
                <td class="border p-2">${++counter}</td>
                <td class="border p-2">${product.name}</td>
                <td class="border p-2">${product.brand}</td>
                <td class="border p-2">$${parseFloat(product.price).toFixed(2)}</td>
                <td class="border p-2">${product.category}</td>
                <td class="border p-2">
                  <button onclick="openEditModal(${product.id}, '${product.name.replace(/'/g, "\\'")}', '${product.brand.replace(/'/g, "\\'")}', ${product.price}, '${product.category.replace(/'/g, "\\'")}')" class="bg-yellow-500 text-white px-3 py-1 rounded hover:bg-yellow-600">Edit</button>
                  <button onclick="deleteProduct(${product.id})" class="bg-red-500 text-white px-3 py-1 rounded hover:bg-red-600">Delete</button>
                </td>
              </tr>`
            })
        })
        .catch(err => console.error(err))
}

function openCreateModal() {
    document.getElementById("productForm").reset()
    document.getElementById("productId").value = ""
    document.getElementById("modalTitle").innerText = "Add Product"
    document.getElementById("productModal").classList.remove("hidden")
}

function openEditModal(id, name, brand, price, category) {
    document.getElementById("productId").value = id
    document.getElementById("productName").value = name
    document.getElementById("productBrand").value = brand
    document.getElementById("productPrice").value = price
    document.getElementById("productCategory").value = category
    document.getElementById("modalTitle").innerText = "Edit Product"
    document.getElementById("productModal").classList.remove("hidden")
}

function closeModal() {
    document.getElementById("productModal").classList.add("hidden")
}

function saveProduct(e) {
    e.preventDefault()
    const id = document.getElementById("productId").value
    const name = document.getElementById("productName").value
    const brand = document.getElementById("productBrand").value
    const price = parseFloat(document.getElementById("productPrice").value)
    const category = document.getElementById("productCategory").value

    const product = { name, brand, price, category }
    const method = id ? "PUT" : "POST"
    const url = id ? `${apiBase}/${id}` : apiBase

    fetch(url, {
        method,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(product)
    })
        .then(res => res.json())
        .then(() => {
            closeModal()
            fetchProducts()
        })
        .catch(err => console.error(err))
}

function deleteProduct(id) {
    if (!confirm("Delete this product?")) return
    fetch(`${apiBase}/${id}`, { method: "DELETE" })
        .then(() => fetchProducts())
        .catch(err => console.error(err))
}
