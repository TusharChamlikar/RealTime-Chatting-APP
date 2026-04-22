import SockJS from "sockjs-client";
import { Client } from "@stomp/stompjs";

let stompClient = null;

export const connectSocket = (onMessage, username) => {
    if (!username) {
        console.log("❌ No user, skipping socket");
        return;
    }

    const token = localStorage.getItem("token");

    const socket = new SockJS(
        `http://localhost:9096/chat?token=${token}`
    );

    stompClient = new Client({
        webSocketFactory: () => socket,
        reconnectDelay: 5000,
        debug: () => {},

        onConnect: () => {
            console.log("✅ Connected as", username);

            stompClient.subscribe(`/topic/${username}`, (msg) => {
                onMessage(JSON.parse(msg.body));
            });

            stompClient.publish({
                destination: "/app/private",
                body: JSON.stringify({
                    type: "JOIN"
                })
            });
        }
    });

    stompClient.activate();
};

export const sendMessage = (msg) => {
    if (!stompClient || !stompClient.connected) {
        console.log("❌ STOMP not connected");
        return;
    }

    stompClient.publish({
        destination: "/app/private",
        body: JSON.stringify(msg)
    });
};