import React, { useEffect, useState } from "react";

export function ProductsList({ prods }) {

    const [search, setSearch] = useState("");

    const filtered = prods.filter(p =>
        p.name.toLowerCase().includes(search.toLowerCase())
    );

    return (
        <div>
            <input
                type="text"
                placeholder="Search product"
                value={search}
                onChange={(e) => setSearch(e.target.value)}
            />

            <ul>
                {filtered.map(p => (
                    <li key={p.id}>{p.name}</li>
                ))}
            </ul>
        </div>
    )
}