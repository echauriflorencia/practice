
// JavaScript puro
async function getProductsByCategory(category) {
    try {
        const response = await fetch(`https://fakestoreapi.com/products/category/${category}`);
        if (!response.ok) {
            throw new Error(`HTTP error: ${response.status}`);
        }
        const data = await response.json();
        console.log(`Products in category '${category}':`, data);
        return data;
    } catch (error) {
        console.error("Error fetching products:", error.message);
    }
}

// React
import React, { useState, useEffect } from "react";

export default function ProductListByCategory({ category }) {
    const [products, setProducts] = seState([]);
    const [error, setError] = useState("");

    useEffect(() => {
        async function fetchData() {
            try {
                const res = await fetch(`https://fakestoreapi.com/products/category/${category}`);
                if (!res.ok) throw new Error("Failed to fetch");
                const data = await res.json();
                setProducts(data);
            } catch (err) {
                setError(err.message);
            }
        }
        fetchData();
    }, [category]);

    if (error) return <p>Error: {error}</p>;

    return (
        <div>
            <h3>Products in category: {category}</h3>
            <ul>
                {products.map(p => (
                    <li key={p.id}>{p.title}</li>
                ))}
            </ul>
        </div>
    )
}