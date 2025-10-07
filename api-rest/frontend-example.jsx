import React, { useEffect, useState } from "react";

export default function ProductList() {
    const [products, setProducts] = useState([]);
    const [cart, setCart] = useState([]);

    //fetch products from API
    useEffect(() => {
        fetch("https://storeapi.com/products")
            .then(res => res.json())
            .then(date => setProducts(data))
            .catch(err => console.err("Error fetching products: ", err));
    }, []);

    const addToCart = (product) => {
        setCart(prev => {
            const existing = prev.find(item => item.id === product.id);
            if (existing) {
                return prev.map(item =>
                    item.id === product.id ? { ...item, quantity: item.quantity + 1 } : item
                );
            } else {
                return [...prev, { ...product, quantity: 1 }];
            }
        });
    };

    const removeFromCart = (productId) => {
        setCart(prev =>
            prev
                .map(item =>
                    item.id === productId ? { ...item, quantity: item.quantity - 1 } : item
                )
                .filter(item => item.quantity > 0) // eliminar si cantidad = 0
        );
    };

    const total = cart.reduce((sum, item) => sum + item.price * item.quantity, 0);

    return (
        <div style={{ padding: 20 }}>
            <h2> Product List </h2>
            <ul>
                {products.map(product => (
                    <li key={product.id} style={{ marginBottom: 10 }}>
                        <strong>{product.title}</strong> - ${product.price}
                        <button
                            onClick={() => addToCart(product)}
                            style={{ marginLeft: 10 }}
                        >
                            Add to cart
                        </button>
                    </li>
                ))}
            </ul>

            <h2> Cart </h2>
            {cart.length === 0 ? (
                <p>Your cart is empty</p>
            ) : (
                <ul>
                    {cart.map(item => (
                        <li key={item.id} style={{ marginBottom: 10 }}>
                            {item.title} — ${item.price.toFixed(2)} x {item.quantity} = $
                            {(item.price * item.quantity).toFixed(2)}
                            <button
                                onClick={() => removeFromCart(item.id)}
                                style={{ marginLeft: 10 }}
                            >
                                Remove
                            </button>
                        </li>
                    ))}
                </ul>
            )}
            <h3>Total: ${total.toFixed(2)}</h3>

        </div>
    );
}


/*I used useState to store the products and cart, and useEffect to fetch the product data once when the component mounts.
For the cart, I maintain quantity per item and update state immutably using map and the spread operator.
Removing a product decreases its quantity and filters it out if it reaches zero.
Totals are calculated dynamically with reduce.
This way the UI always reflects the current state in a reactive manner.
*/