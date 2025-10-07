import React, {useEffect, useState } from "react";

export default function ProductList() {
    const [products, setProducts] = useState([]);
    const [cartCount, setCartCount] = useState(0);

    //fetch products from API
    useEffect(() => {
        fetch("https://storeapi.com/products")
        .then(res => res.json())
        .then(date => setProducts(data))
        .catch(err => console.err("Error fetching products: ", err));
    }, []);

    const handleAddToCart = () => {
        setCartCount(prev => prev + 1);
    }

    return (
        <div style={{ padding: 20 }}>
            <h2> Product List </h2>
            <p> Items in cart: {cartCount} </p>
            <ul>
                {products.map(product => (
                    <li key={product.id} style={{ marginBottom: 10 }}>
                        <strong>{product.title}</strong> - ${product.price}
                        <button
                            onClick={handleAddToCart}
                            style={{ marginLeft: 10}}
                        >
                            Add to cart
                        </button>
                    </li>
                ))}
            </ul>
        </div>
    );
}


/* I’m fetching product data from a REST API using the fetch API inside useEffect, so it only runs once when the component mounts.
I store the list in a state variable and render it dynamically using .map().
Each product has an ‘Add to cart’ button that updates another piece of state (cartCount).
In a real-world scenario, I would manage the cart in a global store (e.g., Context API or Redux) and persist it in the backend.
*/