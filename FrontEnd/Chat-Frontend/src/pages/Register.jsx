import { useState } from "react";
import API from "../services/api";

export default function Register({ setUser }) {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [email, setEmail] = useState("");

    const register = async () => {
        if (!username || !password || !email) {
            alert("Fill all fields");
            return;
        }

        try {
            const res = await API.post("/users/register", {
                username,
                password,
                email
            });

            console.log("REGISTER RESPONSE:", res.data);

            // 🔥 auto login after register (optional)
            const loginRes = await API.post("/auth/login", {
                username,
                password
            });

            const token = loginRes.data;

            localStorage.setItem("token", token);
            localStorage.setItem("user", username.trim());

            setUser(username.trim());

        } catch (err) {
            console.log("Register failed", err);
            alert("Registration failed");
        }
    };

    return (
        <div>
            <h2>Register</h2>

            <input
                placeholder="username"
                onChange={(e) => setUsername(e.target.value)}
            />

            <input
                placeholder="email"
                onChange={(e) => setEmail(e.target.value)}
            />

            <input
                type="password"
                placeholder="password"
                onChange={(e) => setPassword(e.target.value)}
            />

            <button onClick={register}>Register</button>
        </div>
    );
}