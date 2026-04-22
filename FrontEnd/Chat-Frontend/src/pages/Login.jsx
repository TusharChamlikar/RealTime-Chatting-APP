import { useState } from "react";
import API from "../services/api";

export default function Login({ setUser }) {
    const [username, setUsernameInput] = useState("");
    const [password, setPassword] = useState("");

   
   
   
   
   
   
    const login = async () => {
    try {
        const res = await API.post("/auth/login", {
            username,
            password
        });

        const token = res.data; // ✅ correct

        console.log("TOKEN RECEIVED:", token);

        localStorage.setItem("token", token);

        const cleanUser = username.trim();
        localStorage.setItem("user", cleanUser);

        setUser(cleanUser);

    } catch (err) {
        console.log("Login failed", err);
    }
};

    return (
        <div>
            <h2>Login</h2>

            <input
                placeholder="username"
                onChange={(e) => setUsernameInput(e.target.value)}
            />
            <input
                type="password"
                placeholder="password"
                onChange={(e) => setPassword(e.target.value)}
            />

            <button onClick={login}>Login</button>
        </div>
    );
}