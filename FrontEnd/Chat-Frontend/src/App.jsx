import { useState } from "react";
import Login from "./pages/Login";
import Register from "./pages/Register";
import Chat from "./pages/Chat";

function App() {
  const [user, setUser] = useState(() => {
    const token = localStorage.getItem("token");
    const user = localStorage.getItem("user");

    return token && user ? user : null;
  });

  const [isRegister, setIsRegister] = useState(false); // 🔥 NEW

  console.log("Current user:", user);

  if (user) {
    return <Chat user={user} />;
  }

  return (
    <div>
      {isRegister ? (
        <>
          <Register setUser={setUser} />
          <p>
            Already have an account?{" "}
            <button onClick={() => setIsRegister(false)}>
              Login
            </button>
          </p>
        </>
      ) : (
        <>
          <Login setUser={setUser} />
          <p>
            New user?{" "}
            <button onClick={() => setIsRegister(true)}>
              Register
            </button>
          </p>
        </>
      )}
    </div>
  );
}

export default App;