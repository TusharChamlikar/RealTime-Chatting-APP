import { useEffect, useState } from "react";
import { connectSocket, sendMessage } from "../services/socket";
import API from "../services/api";

export default function Chat({ user }) {
    const [receiver, setReceiver] = useState("");
    const [message, setMessage] = useState("");
    const [messages, setMessages] = useState([]);

   useEffect(() => {
    if (!user) return;

    let connected = false;

    connectSocket((msg) => {
        setMessages((prev) => [...prev, msg]);
    }, user);

    connected = true;

    return () => {
        if (connected) {
            console.log("cleanup");
        }
    };

}, [user]);// 🔥 depend on user

    const loadHistory = async () => {
        if (!receiver) return;

        const res = await API.get(
            `/messages/chat?u1=${user}&u2=${receiver}`
        );
        setMessages(res.data);
    };

    const send = () => {
        if (!receiver || !message) return;

        sendMessage({
            receiver,
            content: message
        });
        setMessage("");
    };

    return (
        <div>
            <h2>Chat: {user}</h2>

            <button onClick={() => {
                localStorage.clear();
                window.location.reload();
            }}>
                Logout
            </button>

            <br /><br />

            <input
                placeholder="receiver"
                onChange={(e) => setReceiver(e.target.value)}
            />
            <button onClick={loadHistory}>Load History</button>

            <div>
                {messages.map((m, i) => (
                    <div key={i}>
                        {m.sender} → {m.receiver}: {m.content}
                    </div>
                ))}
            </div>

            <input
                value={message}
                onChange={(e) => setMessage(e.target.value)}
            />

            <button onClick={send}>Send</button>
        </div>
    );
}