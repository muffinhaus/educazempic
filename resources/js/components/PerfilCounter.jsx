import React, { useState } from 'react';

export default function PerfilCounter() {
    const [count, setCount] = useState(0);

    return (
        <div>
            <h2>Mini proyecto React: contador</h2>
            <p>Clicks: {count}</p>
            <button onClick={() => setCount(count + 1)}>Click me</button>
        </div>
    );
}