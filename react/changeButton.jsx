import React, { useState } from "react";

export default function ToggleButton() {
    const labels = ["Start", "Processing...", "Done!", "Reset"];
    const [index, setIndex] = useState(0);


    const handleClick = () => {
        setIndex((prev) => (prev + 1) % labels.length);
    };

    return (
        <button onClick={handleClick}>
            {labels[index]}
        </button>
    );
}