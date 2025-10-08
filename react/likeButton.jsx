import React, { useEffect, useState } from "react";

export default function Button() {
    const [likes, setLikes] = useState(0);
    const [dislikes, setDislikes] = useState(0);
    const [reaction, setReaction] = useState(null);

    const handleLike = () => {
        if (reaction === "like") { //si habia dado like, lo quita
            setLikes((prev) => prev - 1);
            setReaction(null);
        } else {
            if (reaction === "dislike") { //cambia de dislike a like
                setDislikes((prev) => prev - 1);
            }
            setLikes((prev) => prev + 1);
            setReaction("like");
        }
    };

    const handleDislike = () => {
        if (reaction === "dislike") { //si habia dado dislike, lo quita
            setDislikes((prev) => prev - 1);
            setReaction(null);
        } else {
            if (reaction === "like") { //cambia de like a dislike
                setLikes((prev) => prev - 1);
            }
            setDislikes((prev) => prev + 1);
            setReaction("dislike");
        }
    };

    return (
        <div>
            <button
                onClick={handleLike}
                style={{
                    color: reaction === "like" ? "green" : "black"
                }}
            >
                Like ({likes})
            </button>

            <button
                onClick={handleDislike}
                style={{
                    color: reaction === "dislike" ? "red" : "black"
                }}
            >
                Dislike ({dislikes})
            </button>
        </div>
    )
}

// User can react only once, either liking or dislikin (but not both)